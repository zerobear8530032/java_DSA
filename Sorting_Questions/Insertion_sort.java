package Sorting_Questions;
import java.util.*;

public class Insertion_sort {
	public static int counter=0;
public static void InsertionSort(int [] nums,boolean asc) {
	counter=0;
for(int i =0;i<=nums.length-2;i++) {
	for(int j=i+1;j>=1;j--) {			
			counter++;
		if(asc) {
			if(nums[j]<nums[j-1]) {
				int temp = nums[j];
				nums[j]=nums[j-1];
				nums[j-1]=temp;
			}else {break;}
		}else {
				if(nums[j]>nums[j-1]) {
					int temp = nums[j];
					nums[j]=nums[j-1];
					nums[j-1]=temp;
				}else {break;}
			}
		}
	}
}
public static void main(String[] args) {
	int arr1 []= {2,5,23,51,24,12};
	System.out.println("before sorting"+Arrays.toString(arr1));
	InsertionSort(arr1,true);
	System.out.println("After sorting"+Arrays.toString(arr1));
	System.out.println("number of iterations :"+counter);
	int arr2 []= {2,5,2,12,5,1,242,12,4,1,4,5,21,4,3};
	System.out.println("before sorting"+Arrays.toString(arr2));
	InsertionSort(arr2,true);
	System.out.println("After sorting"+Arrays.toString(arr2));
	System.out.println("number of iterations :"+counter);
	
//	completely desceding array Worst case : o(n*n)
	int arr3 []= {5,4,3,2,1};
	System.out.println("before sorting"+Arrays.toString(arr3));
	InsertionSort(arr3,true);
	System.out.println("After sorting"+Arrays.toString(arr3));
	System.out.println("number of iterations :"+counter);
//	already sorted array Best case : o(n*n)
	int arr4 []= {1,2,3,4,5};
	System.out.println("before sorting"+Arrays.toString(arr4));
	InsertionSort(arr4,true);
	System.out.println("After sorting"+Arrays.toString(arr4));
	System.out.println("number of iterations :"+counter);
	
	int arr5 []= {2,5,23,51,24,12};
	System.out.println("before sorting"+Arrays.toString(arr1));
	InsertionSort(arr1,false);
	System.out.println("After sorting in descending"+Arrays.toString(arr1));
	System.out.println("number of iterations :"+counter);
	int arr6 []= {2,5,2,12,5,1,242,12,4,1,4,5,21,4,3};
	System.out.println("before sorting"+Arrays.toString(arr6));
	InsertionSort(arr6,false);
	System.out.println("After sorting in descending"+Arrays.toString(arr6));
	System.out.println("number of iterations :"+counter);
	
//	ascending
	int arr7 []= {1,2,3,4,6};
	InsertionSort(arr7,true);
	System.out.println("After sorting in ascending"+Arrays.toString(arr7));
	System.out.println("number of iterations :"+counter);
//	descending:
	int arr8 []= {1,-2,-3,4,6};
	InsertionSort(arr8,false);
	System.out.println("After sorting in descending"+Arrays.toString(arr8));
	System.out.println("number of iterations :"+counter);

	
	
	
}
}
