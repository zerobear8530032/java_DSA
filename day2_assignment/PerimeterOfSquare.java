package day2_assignment;
import java.util.Scanner;
public class PerimeterOfSquare {
	public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Side: ");
	double s=sc.nextDouble();
	double perimeter=4*s;
	System.out.println("Perimeter : "+perimeter);
}
}
