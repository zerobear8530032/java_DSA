package day2_assignment;

import java.util.Scanner;

public class PerimeterOfEquiTriangle {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Side : ");
		double s=sc.nextDouble();
		double perimeter=s*3;
		System.out.println("Perimeter : "+perimeter);
	}
}
