package day2_assignment;

import java.util.Scanner;

public class ReverseString {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a String");
	String str =sc.next();
	String revstr ="";
	for(int i =str.length()-1;i>=0;i--) {
		revstr=revstr+str.charAt(i);
	}
	System.out.println("original String :"+str);
	System.out.println("Reverse String :"+revstr);
	
}
}
