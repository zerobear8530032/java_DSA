package day2_assignment;

import java.util.Scanner;

public class AreaOfRectangle {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Length: ");
		double l=sc.nextDouble();
		System.out.println("Enter the Width: ");
		double w=sc.nextDouble();
		double area= l*w;
		System.out.println("Area :"+area);
	}
}