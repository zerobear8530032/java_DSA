package day2_assignment;

import java.util.Scanner;

public class VolumeOfPrism {
	public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the BaseArea: ");
	double ba=sc.nextDouble();
	System.out.println("Enter the height: ");
	double h=sc.nextDouble();
	double volume=ba*h;
	System.out.println("Perimeter : "+volume);
}

}
