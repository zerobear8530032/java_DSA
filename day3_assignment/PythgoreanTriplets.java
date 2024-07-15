package day3_assignment;

import java.util.Scanner;

public class PythgoreanTriplets {
	static boolean isPythgoreanTriplets (int h,int p,int b) {
		h=h*h;
		b=b*b;
		p=p*p;
		return (h==(b+p));
	}
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Hypotenius : ");
	int h=sc.nextInt();
	System.out.println("Enter the Base : ");
	int b=sc.nextInt();
	System.out.println("Enter the perpendicular : ");
	int p=sc.nextInt();
	System.out.println(isPythgoreanTriplets(h, p, b));
	
	}
}
