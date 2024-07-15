package day2_assignment;

import java.util.Scanner;

public class UserInputs {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a Number to sum :");
		System.out.println("Enter x to exit :");
		String c=sc.next();
		int sum =0;
		while(true) {
			if(c.equalsIgnoreCase("x")) {
				break;
			}
			sum=sum+Integer.parseInt(c);
		
			System.out.println(sum);
			c=sc.next();
		}
		System.out.println("exit");
		
	}
}
