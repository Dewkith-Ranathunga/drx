import java.util.*;

public class ArrayAll{
	
	public static void printArray(int[] A){
		
		int n=A.length;
		for(int i=0;i<n;i++){
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	public static boolean searchValue(int[] A,int target){
		
		int n = A.length;
		for(int 
		i=0;i<n;i++){
			if(A[i]==target){
				return true ;
			}
		}
		return false ;
	}
	
	public static void insertionSort(int[] A){
		int n=A.length;
		for(int i=1;i<n;i++){
			int key=A[i];
			int j=i-1;
			
			while((j>-1)&&(A[j]>key)){
				A[j+1]=A[j];
				j--;
			}
			A[j+1]=key;
		}
	}
	
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int[] Array = new int[10];
		int size = 5 ;
		
		System.out.println("\nInput values for Array");
		for(int i=0;i<size;i++){
			Array[i]=sc.nextInt();
		}
		
		System.out.print("\nInputed values of Array : ");
		printArray(Array);
		
		
		//Inserting a value for specific index
		
		System.out.print("\nInsert the value : ");
		int insertValue = sc.nextInt();
		
		System.out.print("\nIndex for inserting : ");
		int insertIndex = sc.nextInt();
		
		for(int i=size-1;i>=insertIndex;i--){
			Array[i+1]=Array[i];
		}
		Array[insertIndex]=insertValue ;
		size++;
		
		System.out.print("\nAfter inserting : ");
		printArray(Array) ;
		
		
		
		//Deleting a vlaue from specific index
		
		System.out.print("\nIndex for deleting : ");
		int deleteIndex = sc.nextInt();
		
		for(int i=deleteIndex;i<size;i++){
			Array[i]=Array[i+1] ;
		}
		size--;
		
		System.out.print("\nAfter deleting : ");
		printArray(Array) ;
		
		
		//Search a value
		
		boolean available = searchValue(Array,50);
		
		if(available){
			System.out.print("\nSearching value of 50 is available in the Array");
		}else{
			System.out.print("\nSearching value of 50 is not available in the Array");
		}
		
		System.out.print("\nAfter Sorting the Array : ");
		insertionSort(Array);
		printArray(Array);
		
		
	}
}