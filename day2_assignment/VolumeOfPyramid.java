package day2_assignment;

import java.util.Scanner;

public class VolumeOfPyramid {
	public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the length: ");
	double l=sc.nextDouble();
	System.out.println("Enter the width: ");
	double w=sc.nextDouble();
	System.out.println("Enter the height: ");
	double h=sc.nextDouble();
	double volume=(l*w*h)/3;
	System.out.println("Perimeter : "+volume);
}

}
