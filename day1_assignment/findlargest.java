package day1_assignment;

import java.util.Scanner;

public class findlargest {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number 1");
	int n1=sc.nextInt();
	System.out.println("Enter the number 2");
	int n2=sc.nextInt();
	if(n1>n2) {
		System.out.println("number 1 is greater "+n1);		
	}else {
		System.out.println("number 2 is greater "+n2);				
	}
}
}
