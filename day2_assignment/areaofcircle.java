package day2_assignment;
import java.util.Scanner;
public class areaofcircle {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Radius : ");
	double r=sc.nextDouble();
	double area= 2*Math.PI*r*r;
	System.out.println("Area :"+area);
}
}
