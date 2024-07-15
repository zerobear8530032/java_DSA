package Day4_video4;

import java.util.Arrays;

public class reversearray {

	static void swap(int []arr,int s , int e) {
	int t=arr[s];
	arr[s]=arr[e];
	arr[e]=t;
	}
	static void reverse(int []arr) {
		int start=0;
		int end =arr.length-1;
		while(start<end) {
			swap(arr,start,end);
			start++;
			end--;
		}
	}
	
public static void main(String[] args) {
	int [] arr = {1,2,3,4,5};
	System.out.println("original array :"+Arrays.toString(arr));
	reverse(arr);
	System.out.println("reverse array :"+Arrays.toString(arr));
	
}
}
