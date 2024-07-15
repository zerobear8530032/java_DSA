package day1_assignment;

import java.util.Scanner;

public class simpleinterest {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Principle");
	float p=sc.nextFloat();
	System.out.println("Enter the Rate");
	float r=sc.nextFloat();
	System.out.println("Enter the Time in (hrs)");
	float t=sc.nextFloat();
	float si=p*r*t;
	System.out.println("simple Interest "+si);
	
	
}
}
