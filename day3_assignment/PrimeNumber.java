package day3_assignment;

import java.util.Scanner;

public  class PrimeNumber {
	static	boolean isPrime(int n) {
		boolean isPrime =false;
		
		if(n<=1) {
			return false;
		}
	for(int i =2;i*i<=n;i++) {
		
		if(n%i==0) {
			return isPrime;
		}
	}
		return true;
	}
	
	
	
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.println("Enter the Number");
int n =sc.nextInt();
System.out.println(isPrime(n));



}
}
