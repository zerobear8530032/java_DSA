package day1_assignment;

import java.util.Scanner;

public class NthFibonacci {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Nth Number");
	int n =sc.nextInt();
	int i =0;
	int f=0;
	int s=1;
	int next=0;
	while(i<n-2) {
		 next =f+s;
		f=s;
		s=next;
		
		i++;
	}
	System.out.println(n+"th Fibonacci Number :"+next);
	
}
}
