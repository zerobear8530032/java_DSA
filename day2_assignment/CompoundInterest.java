package day2_assignment;

import java.util.Scanner;

public class CompoundInterest {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the principal amount :");
		float p =sc.nextFloat();
		
		System.out.println("Enter the rate :");
		float r =sc.nextFloat();
		
		System.out.println("Enter the Time amout compounded:");
		int n =sc.nextInt();
		
		System.out.println("Enter the Time :");
		int t =sc.nextInt();
		
		double CI=p*Math.pow((1+(r/n)),n*t);
		System.out.println("Coumpound Intrest: "+CI);
	}
}
