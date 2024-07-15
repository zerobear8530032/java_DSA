package day2_assignment;

import java.util.Scanner;

public class AreaOfEquilateralTriangle {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Side : ");
		double s=sc.nextDouble();
		double area =(Math.sqrt(3)/4)*Math.pow(s, 2);
		System.out.println("Area : "+area);
	}

}
