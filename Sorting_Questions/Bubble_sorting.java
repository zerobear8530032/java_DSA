package Sorting_Questions;
import java.util.*;
public class Bubble_sorting {
	public static int counter = 0;
public static void bubblesort(int arr[],boolean asc ){
	counter = 0;
	for(int i =0;i<arr.length-1;i++) {
		boolean sorted =true;
		for(int j=1;j<arr.length-i;j++) {
			if(asc) {
				
			if(arr[j]<arr[j-1]) {
				int temp =arr[j];
				arr[j]=arr[j-1];
				arr[j-1]=temp;
				sorted=false;
			}
			counter++;
			}else {
//			descending sorted:
			if(arr[j]>arr[j-1]) {
				int temp =arr[j];
				arr[j]=arr[j-1];
				arr[j-1]=temp;
				sorted=false;
			}
			counter++;
			}
		}
		if(sorted) {
			break;
		}
	}
	
}
	
	
	
public static void main(String[] args) {
	int arr1 []= {2,5,23,51,24,12};
	System.out.println("before sorting"+Arrays.toString(arr1));
	bubblesort(arr1,false);
	System.out.println("After sorting"+Arrays.toString(arr1));
	System.out.println("number of iterations :"+counter);
	int arr2 []= {2,5,2,12,5,1,242,12,4,1,4,5,21,4,3};
	System.out.println("before sorting"+Arrays.toString(arr2));
	bubblesort(arr2,false);
	System.out.println("After sorting"+Arrays.toString(arr2));
	System.out.println("number of iterations :"+counter);
	
//	completely desceding array Worst case : o(n*n)
	int arr3 []= {5,4,3,2,1};
	System.out.println("before sorting"+Arrays.toString(arr3));
	bubblesort(arr3,true);
	System.out.println("After sorting"+Arrays.toString(arr3));
	System.out.println("number of iterations :"+counter);
//	already sorted array Best case : o(n)
	int arr4 []= {1,2,3,4,5};
	System.out.println("before sorting"+Arrays.toString(arr4));
	bubblesort(arr4,true);
	System.out.println("After sorting"+Arrays.toString(arr4));
	System.out.println("number of iterations :"+counter);
	
	int arr5 []= {2,5,23,51,24,12};
	System.out.println("before sorting"+Arrays.toString(arr1));
	bubblesort(arr1,false);
	System.out.println("After sorting in descending"+Arrays.toString(arr1));
	System.out.println("number of iterations :"+counter);
	int arr6 []= {2,5,2,12,5,1,242,12,4,1,4,5,21,4,3};
	System.out.println("before sorting"+Arrays.toString(arr2));
	bubblesort(arr2,false);
	System.out.println("After sorting in descending"+Arrays.toString(arr2));
	System.out.println("number of iterations :"+counter);
	
	
	
}
}
