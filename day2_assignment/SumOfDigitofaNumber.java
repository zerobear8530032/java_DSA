package day2_assignment;

import java.util.Scanner;

public class SumOfDigitofaNumber {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int sum =0;
		System.out.println("Enter the Number");
		int n=sc.nextInt();
		while(n>0){
			sum=sum+(n%10);
			n=n/10;
		}
		System.out.println(sum);	
	}

}
