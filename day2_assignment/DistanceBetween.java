package day2_assignment;

import java.util.Scanner;

public class DistanceBetween {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter x co-ordinate of  point 1 ");
	int x1 =sc.nextInt();
	
	System.out.println("Enter y co-ordinate of  point 1 ");
	int y1 =sc.nextInt();
	
	System.out.println("Enter x co-ordinate of  point 2 ");
	int x2 =sc.nextInt();
	
	System.out.println("Enter y co-ordinate of  point 2 ");
	int y2 =sc.nextInt();
	
	
	
	double distance = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
	System.out.println(distance);
	
	
	
}
}
