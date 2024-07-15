package day2_assignment;

import java.util.Scanner;

public class futureInvestmentValue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Investment amount");
		float a =sc.nextFloat();
		
		System.out.println("Enter the rate :");
		float r=sc.nextFloat();
		System.out.println("Enter the time in years:");
		float t=sc.nextFloat();
		float fv=a*(1+r*t);
		System.out.println("future value :"+fv);
	}
}
