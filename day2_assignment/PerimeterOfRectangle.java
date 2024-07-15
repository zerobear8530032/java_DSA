package day2_assignment;

import java.util.Scanner;

public class PerimeterOfRectangle {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length: ");
		double l=sc.nextDouble();
		System.out.println("Enter the breadth: ");
		double b=sc.nextDouble();
		double perimeter=2*(l+b);
		System.out.println("Perimeter : "+perimeter);
	}

}
