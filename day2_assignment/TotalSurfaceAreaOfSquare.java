package day2_assignment;

import java.util.Scanner;

public class TotalSurfaceAreaOfSquare {
	public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Side: ");
	double s=sc.nextDouble();
	double totalsurfacearea=6*Math.pow(s, 2);
	System.out.println("Perimeter : "+totalsurfacearea);
}

}
