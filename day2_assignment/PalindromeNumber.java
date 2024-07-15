package day2_assignment;

import java.util.Scanner;

public class PalindromeNumber {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Number");
	int n =sc.nextInt();
	int t =n;
	int rev=0;
	while(t>0) {
		int rem =t%10;
		t=t/10;
		rev=rev*10+rem;
	}
	
	if(rev==n) {
		System.out.println("palindrome number");
	}else {
		System.out.println("not a palindrome number");
	}
}
}
