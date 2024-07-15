package day2_assignment;
import java.util.Scanner;
public class PerimeterOfRombus {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the side: ");
	double s=sc.nextDouble();
	double perimeter=4*s;
	System.out.println("Perimeter : "+perimeter);
}
}
