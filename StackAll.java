public class StackAll{
	
	int[] arr;
	int capacity;
	int top;
	
	StackAll(int size){
		arr=new int[size];
		capacity=size;
		top=-1;
	}
	
	boolean isFull(){
		return top+1==capacity;
	}
	
	boolean isEmpty(){
		return top==-1;
	}
	
	void push(int n){
		if(isFull()){
			System.out.println("Over flow");
		}
		else{
			top++;
			arr[top]=n;
			System.out.println("Insert "+n);
		}
	}
	
	void pop(){
		if(isEmpty()){
			System.out.println("Stack is Empty");
		}
		else{
			System.out.println("Delete "+arr[top]);
			top--;
		}
	}
	
	void printStack(){
		for(int i=0;i<=top;i++){
		System.out.println(arr[i]);	
		}
	}
	
	int getSize(){
		return top+1;	
	}
	
	public void sortDecending(){
		
		for(int i=1;i<=top;i++){
			int key=arr[i];
			int j=i-1;
			
			while((j>-1)&&(arr[j]>key)){
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;
		}
	}
	
	 void checkPalindrome() {
        
        boolean isPalindrome = true;
        
        int start = 0;
        int end = top;
        
        while (start < end) {
            if (arr[start] != arr[end]) {
                isPalindrome = false;
                break;
            }
            
            start++;
            end--;
        }
        
        if (isPalindrome) {
            System.out.println("Given input is a Palindrome");
        } else {
            System.out.println("Given input is not a palindrome");
        }
    }
    
	
	
	
	
	public static void main (String[] args){
		StackAll stk=new StackAll(5);
		
		stk.push(5);
		stk.push(10);
		stk.push(15);
		stk.push(10);
		stk.push(5);
		
		/*stk.pop();
		stk.pop();*/
		
		System.out.println("\nPrint Stack");	
		stk.printStack();
		
		System.out.println("\nSize of the stack is "+stk.getSize());
		
		/*System.out.println("\nSort the stack Dec");
		stk.sortDecending();
		stk.printStack();*/
		
		stk.checkPalindrome();
		
		
	}
}