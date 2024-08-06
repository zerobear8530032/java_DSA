package Sorting_Questions;
import java.util.*;
public class Selection_sorting {
public static  int counter=0;
// here in selection sort we take max element at each pass and put it to the its place
public static void selectionsort(int [] arr,boolean asc) {
		counter=0;
		
		for(int i =0;i<arr.length;i++) {
//			find max :
			if(asc) {				
			int lastindex=arr.length-1-i;
			int maxindex=0;
			for(int j =0;j<arr.length-i;j++) {
				if(arr[maxindex]<arr[j]) {
					maxindex=j;
				}
				counter++;
			}
			int temp = arr[maxindex];
			arr[maxindex]=arr[lastindex];
			arr[lastindex]=temp;
//			descending order
			}else {
				int firstindex=i;
//				herer the max index is i because we have the biggest element at starting so max cannot be at 0
				int maxindex=i;
				for(int j =i+1;j<arr.length;j++) {
					if(arr[maxindex]<arr[j]) {
						maxindex=j;
					}
					counter++;
				}
				int temp = arr[maxindex];
				arr[maxindex]=arr[firstindex];
				arr[firstindex]=temp;								
			}
		}
}
// here we will take min at each pass and put it to its place :
public static void reverseselectionsort(int [] arr,boolean asc) {
	counter=0;
	for(int i =0;i<arr.length;i++) {
//		find min ;
		if(asc) {
			
		int minindex =i;
		int first =i;
		for(int j =i+1;j<arr.length;j++) {
			if(arr[minindex]>arr[j]) {
				minindex=j;
			}
			counter++;
		}
//		swap:
		int temp = arr[minindex];
		arr[minindex]=arr[first];
		arr[first]=temp;	
//	descending:
		}else {
		int minindex =0;
		int last = arr.length-1-i;
		for(int j=0;j<arr.length-i;j++) {
			if(arr[minindex]>arr[j]) {
				minindex=j;
			}
			counter++;
		}
		int temp=arr[minindex];
		arr[minindex]=arr[last];
		arr[last]=temp;
	}
	}
}

	
	public static void main(String[] args) {
		int arr1 []= {2,5,23,51,24,12};
		System.out.println("before sorting"+Arrays.toString(arr1));
		selectionsort(arr1,true);
		System.out.println("After sorting"+Arrays.toString(arr1));
		System.out.println("number of iterations :"+counter);
		int arr2 []= {2,5,2,12,5,1,242,12,4,1,4,5,21,4,3};
		System.out.println("before sorting"+Arrays.toString(arr2));
		selectionsort(arr2,true);
		System.out.println("After sorting"+Arrays.toString(arr2));
		System.out.println("number of iterations :"+counter);
		
//		completely desceding array Worst case : o(n*n)
		int arr3 []= {5,4,3,2,1};
		System.out.println("before sorting"+Arrays.toString(arr3));
		selectionsort(arr3,true);
		System.out.println("After sorting"+Arrays.toString(arr3));
		System.out.println("number of iterations :"+counter);
//		already sorted array Best case : o(n*n)
		int arr4 []= {1,2,3,4,5};
		System.out.println("before sorting"+Arrays.toString(arr4));
		selectionsort(arr4,true);
		System.out.println("After sorting"+Arrays.toString(arr4));
		System.out.println("number of iterations :"+counter);
		
		int arr5 []= {2,5,23,51,24,12};
		System.out.println("before sorting"+Arrays.toString(arr1));
		selectionsort(arr1,false);
		System.out.println("After sorting in descending"+Arrays.toString(arr1));
		System.out.println("number of iterations :"+counter);
		int arr6 []= {2,5,2,12,5,1,242,12,4,1,4,5,21,4,3};
		System.out.println("before sorting"+Arrays.toString(arr2));
		selectionsort(arr2,false);
		System.out.println("After sorting in descending"+Arrays.toString(arr2));
		System.out.println("number of iterations :"+counter);
		
//		descending:
		int arr7 []= {1,2,3,4,6};
		reverseselectionsort(arr7,true);
		System.out.println("After sorting in ascending"+Arrays.toString(arr7));
		System.out.println("number of iterations :"+counter);
//		ascending
		int arr8 []= {1,-2,-3,4,6};
		reverseselectionsort(arr8,false);
		System.out.println("After sorting in descending"+Arrays.toString(arr8));
		System.out.println("number of iterations :"+counter);
		
	}
}
