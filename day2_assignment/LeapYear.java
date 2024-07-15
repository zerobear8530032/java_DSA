package day2_assignment;

import java.util.Scanner;

public class LeapYear {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Year");
		int year=sc.nextInt();

		if(year%4==0 && year%100!=0) {
			System.out.println("leap year");
		}else if(year%400==0 ) {
			System.out.println("leap year");			
		}else {
			System.out.println("not leap year");						
		}
		
	}

}
