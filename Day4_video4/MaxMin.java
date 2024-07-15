package Day4_video4;

import java.util.Scanner;

public class MaxMin {
	
	static int min(int [] arr) {
		int min = arr[0];
		for(int i =1;i<arr.length;i++) {
			if(arr[i]<min) {
				min=arr[i];
			}
		}
		return min;
	}
	static int max(int [] arr) {
		int max =arr[0];
		for(int i =1;i<arr.length;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		return max;
	}
	
	static int mininrange(int [] arr,int s,int e) {
		int min = arr[s];
		if(s<0 || e<0 ||s>=arr.length || e>arr.length) {
			System.out.println("invalid range");
				return -1;
			}
		for(int i =s;i<e;i++) {
			if(arr[i]<min) {
				min=arr[i];
			}
		}
		return min;
	}
	static int maxinrange(int [] arr,int s ,int e) {
		int max =arr[s];
		if(s<0 || e<0 ||s>=arr.length || e>arr.length) {
			System.out.println("invalid range");
				return -1;
			}
		
		for(int i =s;i<e;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		return max;
	}
	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int [] arr = {2,4,3,5,3,52,2,42,4,12,42};
	System.out.println("Min :"+min(arr));
	System.out.println("Max :"+max(arr));
	System.out.println("Enter the range starting index");
	int s =sc.nextInt();
	System.out.println("Enter the range Ending index");
	int e =sc.nextInt();
	System.out.println("Min :"+mininrange(arr,s,e));
	System.out.println("Max :"+maxinrange(arr,s,e));
	
}
}
