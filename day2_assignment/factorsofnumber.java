package day2_assignment;

import java.util.Scanner;

public class factorsofnumber {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a Number");
	int n=sc.nextInt();
	System.out.print("factors");			
	
	for(int i =1;i<=n;i++) {
		if(n%i==0) {
			System.out.print(" "+i);			
		}
	}
	
	
}
}
