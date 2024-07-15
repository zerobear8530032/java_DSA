package Day4_video4;

import java.util.Arrays;
import java.util.Scanner;

public class swapinarray {
	static void swap(int arr[],int s, int e) {

		if(s<0 || e<0 ||s>=arr.length || e>=arr.length) {
			System.out.println("invalid index");
		}else {
			int t =arr[s];
			arr[s]=arr[e];
			arr[e]=t;
		}	
	}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int [] arr = {1,3,5,24,2,4};
	System.out.println("Enter the First index");
	int s=sc.nextInt();
	System.out.println("Enter the Second index");
	int e=sc.nextInt();
	
	System.out.println("Before swap"+Arrays.toString(arr));
	swap(arr,s,e);
	System.out.println("After swap"+Arrays.toString(arr));
}
}
