package day2_assignment;

import java.util.Scanner;

public class ArmStrongNumber {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Number");
	int  n =sc.nextInt();
	int t =n;
	int sum =0;
	while(t>0) {
		int rem =t%10;
		t=t/10;
		sum=sum+(rem*rem*rem);
		
	}
	System.out.println(sum);
	if(sum==n) {
		System.out.println("ArmStrong Number");
	}else {
		System.out.println("not a ArmStrong Number");		
	}
	
	
	
}
}
