package day2_assignment;

import java.util.Scanner;

public class AreaOfIsoceliustriangle {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Height: ");
		double h=sc.nextDouble();
		System.out.println("Enter the Base: ");
		double b=sc.nextDouble();
		double area= (b*h)/2;
		System.out.println("Area :"+area);
	}
	}