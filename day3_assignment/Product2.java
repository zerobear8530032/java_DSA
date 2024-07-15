package day3_assignment;

import java.util.Scanner;
public class Product2 {
	static int product(int n1 ,int n2) {
		return n1*n2;
	}
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);

	System.out.println("Enter number 1");
	int n1 =sc.nextInt();
	System.out.println("Enter number 2");
	int n2 =sc.nextInt();
	System.out.println("product : "+product(n1,n2));
}
}
