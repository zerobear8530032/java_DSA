package day3_assignment;

import java.util.Scanner;

public class Circle {
static double Circumference(float rad) {
	
	return 2.f*Math.PI*rad*rad;
	
	
}
static double Area(float rad) {
	return 2.f*Math.PI*rad;
}
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the radius  :");
	float rad=sc.nextFloat();
	
	System.out.println(Circumference(rad));
	System.out.println(Area(rad));
			
	
}
}
