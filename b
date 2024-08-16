--LOAD DATA LOCAL INFILE “student.txt" INTO TABLE students;

SELECT VERSION();

SELECT CURDATE();

CREATE DATABASE Company;

USE Company;

CREATE TABLE Location (
	LocationID INT PRIMARY KEY,
	RegionalGroup VARCHAR(25)
);

CREATE TABLE Department (
	DepartmentID INT PRIMARY KEY,
	Name VARCHAR(20),
	LocationID INT,
	FOREIGN KEY(LocationID) REFERENCES Location(LocationID)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);

CREATE TABLE Job (
	JobID INT PRIMARY KEY,
	Function VARCHAR(25)
);

CREATE TABLE Employee (
	EmployeeID INT PRIMARY KEY,
	LastName VARCHAR(15),
	FirstName VARCHAR(15),
	MiddleName VARCHAR(15),
	JobID INT,
	ManagerID INT,
	HireDate DATE,
	Salary INT,
	Comission INT,
	DepartmentID INT,
	FOREIGN KEY(JobID) REFERENCES Job(JobID)
	ON DELETE CASCADE
	ON UPDATE CASCADE,
	FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);


INSERT INTO Location(LocationID,RegionalGroup)
VALUES
(122,'Trincomalee'),
(123,'Batticaloa'),
(124,'Ampara'),
(167,'Polonnaruwa');

INSERT INTO Department(DepartmentID,Name,LocationID)
VALUES
(10,'Accounting',122),
(20,'Research',124),
(30,'Sales',123),
(40,'Operations',167);

INSERT INTO Job(JobID,Function)
VALUES
(667,'Clerk'),
(668,'Staff'),
(669,'Analysis'),
(670,'Salesperson'),
(671,'Manager'),
(672,'President');

INSERT INTO Employee(EmployeeID,LastName,FirstName,MiddleName,JobID,ManagerID,HireDate,Salary,Comission,DepartmentID)
VALUES
(7369,'Smith','John','Q',667,7902,'2022-12-17',800,NULL,20),
(7499,'Alen','Kevin','J',670,7698,'2023-02-20',1600,300,30),
(7505,'Doyle','Jean','K',671,7839,'2023-04-04',2850,NULL,30),
(7506,'Dennis','Lynn','S',671,7839,'2023-05-15',2750,NULL,30),
(7507,'Backer','Leslie','D',671,7839,'2023-06-10',2200,NULL,40),
(7521,'Wark','Cynthia','D',670,7698,'2023-02-22',1250,500,30);

SELECT*FROM Employee;

SELECT
EmployeeID AS 'ID of the employee',
LastName AS 'Name of the employee',
DepartmentID AS 'department ID'
FROM Employee;

SELECT LastName AS '1000-2500 Salary range Employees'
FROM Employee
WHERE Salary BETWEEN 1000 AND 2500;

SELECT LastName AS 'whose last name length is 5 and START with "S"'
FROM Employee
WHERE LENGTH(LastName) AND LastName LIKE 'S%' ;

SELECT LastName AS 'Whose dont have Comission'
FROM Employee
WHERE Comission IS NULL;

 SELECT*FROM Employee
 ORDER BY LastName ASC,DepartmentID DESC;

SELECT
YEAR(HireDate) AS 'Year' ,
MONTH(HireDate) AS 'Month',
COUNT(*) AS 'EmployeeCount'
FROM Employee
GROUP BY YEAR(HireDate) , MONTH(HireDate)
ORDER BY YEAR(HireDate) ASC , MONTH(HireDate) ASC;


SELECT LastName 'Sales Department Employees'
FROM Employee
INNER JOIN Department
ON Employee.DepartmentID=Department.DepartmentID
WHERE Department.Name='Sales';

DELETE Employee FROM Employee
INNER JOIN Department
ON Employee.DepartmentID=Department.DepartmentID
WHERE Department.Name='Accounting';

SELECT E.EmployeeID, E.LastName, E.FirstName, E.Salary, E.DepartmentID
FROM Employee E
WHERE E.Salary > (
    SELECT MIN(E1.Salary)
    FROM Employee E1
    WHERE E1.DepartmentID = E.DepartmentID
);





1. Add a New Column:
ALTER TABLE table_name
ADD column_name datatype;

2. Modify an Existing Column:
ALTER TABLE table_name
MODIFY column_name new_datatype;

3. Rename a Column:
ALTER TABLE table_name
RENAME COLUMN old_name TO new_name;

4. Drop (Delete) a Column:
ALTER TABLE table_name
DROP COLUMN column_name;

5. Add a Constraint (e.g., UNIQUE, NOT NULL):
ALTER TABLE table_name
ADD CONSTRAINT constraint_name constraint_type(column_name);

6. Rename the Table:
ALTER TABLE old_table_name
RENAME TO new_table_name;


SELECT * FROM table_name;
SELECT column1, column2 FROM table_name;
SELECT column1, column2 FROM table_name WHERE condition;
SELECT column1, column2 FROM table_name ORDER BY column1 [ASC|DESC];
SELECT column1, COUNT(*), SUM(column2) FROM table_name GROUP BY column1;
SELECT column1, COUNT(*) FROM table_name GROUP BY column1 HAVING COUNT(*) > 1;
SELECT first_name, salary FROM employees WHERE salary > (SELECT AVG(salary) FROM employees);
SELECT DISTINCT department FROM employees;
SELECT TOP 5 first_name FROM employees;

UPDATE employees
SET salary = salary * 1.1
WHERE department = 'Sales' AND years_of_service > 5;

UPDATE employees
SET salary = salary * 1.05
WHERE department_id = (SELECT department_id FROM departments WHERE department_name = 'HR');

DELETE FROM employees
WHERE department_id = (SELECT department_id FROM departments WHERE department_name = 'HR');


SELECT COUNT(column_name)
FROM table_name
WHERE condition;

SELECT ProductID, ProductName, CategoryName
FROM Products
INNER JOIN Categories ON Products.CategoryID = Categories.CategoryID;

INSERT INTO NewTable
SELECT *
FROM OriginalTable;


