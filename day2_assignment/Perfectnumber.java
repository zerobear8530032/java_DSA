package day2_assignment;

import java.util.Scanner;

public class Perfectnumber {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int sum =0;
		System.out.println("Enter the Number");
		int n=sc.nextInt();
		for(int i =1;i<n;i++) {
			if(n%i==0) {
				sum=sum+i;
			}
		}
		System.out.println(sum);
		if(n==sum) {
			System.out.println("Perfect Number");
		}else {
			System.out.println("Not a Perfect Number");			
		}
		
	}

}
