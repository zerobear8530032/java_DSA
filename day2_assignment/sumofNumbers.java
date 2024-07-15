package day2_assignment;

import java.util.Scanner;

public class sumofNumbers {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int sumnegetive=0;
		int sumpositive=0;
		int sumpositiveodd=0;
		while(true) {
			
		
		System.out.println("Enter the Number");
		int n=sc.nextInt();		
		if(n<0) {
			sumnegetive=sumnegetive+n;
		}
		
		if(n>0) {
			sumpositive=sumpositive+n;
			if(n%2!=0) {
				sumpositiveodd=sumpositiveodd+n;
				
			}
			
		}
		
		
		if(n==0) {
			break;
		}

}
		System.out.println("Sum of Positive Numbers"+sumpositive);
		System.out.println("Sum of Positive Odd Numbers"+sumpositiveodd);
		System.out.println("Sum of Negative Numbers"+sumnegetive);
	}

}
