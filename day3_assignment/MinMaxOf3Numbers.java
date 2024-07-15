package day3_assignment;

import java.util.Scanner;

public class MinMaxOf3Numbers {
static int max(int n1,int n2 ,int n3) {
	int max=n1;
	if(max<n2) {
		max=n2;
	}
	if(max<n3) {
		max=n3;
	}
	return max;
}
static int min(int n1 ,int n2 , int n3) {
	int min=n1;
	if(min>n2) {
		min=n2;
	}
	if(min>n3) {
		min=n3;
	}
	return min;
	
}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the N1");
		int n1 =sc.nextInt();
		System.out.println("Enter the N2");
		int n2 =sc.nextInt();
		System.out.println("Enter the N3");
		int n3 =sc.nextInt();
		System.out.println("Min : "+min(n1,n2,n3));
		System.out.println("Max : "+max(n1,n2,n3));
	}

}
