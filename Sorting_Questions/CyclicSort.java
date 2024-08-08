package Sorting_Questions;
import java.util.*;
public class CyclicSort {
// cyclic sort : it is a speacial type of sorting algo with which only wworks when the array elements are in range of 1 to n:
	
public static void cyclicsort(int [] arr) {
	int i =0;
	while(i<arr.length) {
		int correct = arr[i]-1;
//		swap:
		if(arr[correct]!=arr[i]) {
			int temp = arr[correct];
			arr[correct]=arr[i];
			arr[i]=temp;
		}else {
//			other wise nexxt element :
			i++;
		}
	}
}
public static void main(String[] args) {
	int [] arr = {3,5,2,1,4};
	System.out.println("Before sorting :"+Arrays.toString(arr));
	cyclicsort(arr);
	System.out.println("After sorting :"+Arrays.toString(arr));
	int [] arr2 = {1,2,3,4,5};
	System.out.println("before sorting :"+Arrays.toString(arr2));
	cyclicsort(arr2);
	System.out.println("After sorting :"+Arrays.toString(arr2));
	
	
}
}
