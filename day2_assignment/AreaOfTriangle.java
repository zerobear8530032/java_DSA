package day2_assignment;

import java.util.Scanner;

public class AreaOfTriangle {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Base : ");
		double b=sc.nextDouble();
		System.out.println("Enter the Height: ");
		double h=sc.nextDouble();
		double area= 0.5*b*h;
		System.out.println("Area :"+area);
	}
	}