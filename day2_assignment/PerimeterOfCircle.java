package day2_assignment;

import java.util.Scanner;

public class PerimeterOfCircle {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Radius: ");
		double r=sc.nextDouble();
		double perimeter =2*Math.PI*r;
		System.out.println("Perimeter : "+perimeter);
	}

}
