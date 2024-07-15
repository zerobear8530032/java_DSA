package day2_assignment;

import java.util.Scanner;

public class CalculateCGPA {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the CGPA");
	float cgpa=sc.nextFloat();
	System.out.println(" CGPA to percentage "+(cgpa*9.5));
	
}

}
