package day2_assignment;

import java.util.Scanner;

public class VolumeOfCyclinder {
	public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Radius: ");
	double r=sc.nextDouble();
	System.out.println("Enter the height: ");
	double h=sc.nextDouble();
	double volume=Math.PI*r*r*h;
	System.out.println("Perimeter : "+volume);
}

}
