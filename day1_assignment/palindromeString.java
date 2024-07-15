package day1_assignment;

import java.util.Scanner;

public class palindromeString {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the String :");
	String s =sc.next();
	
	int i =0;
	int j =s.length()-1;
	boolean ispalindrome=false;
	while(i<j) {
		if(!(s.charAt(i)==s.charAt(j))) {
			ispalindrome=false;
			
			break;
		}else {
			ispalindrome=true;
		}
		i++;
		j--;
	}
	if(ispalindrome) {
		System.out.println("String is a palindrome ");
	}else {
		System.out.println("String is not a palindrome ");
		
	}
	
}
}
