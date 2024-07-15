package day2_assignment;

import java.util.Scanner;
public class fibonacii {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Nth value :");
	int n =sc.nextInt();
	int i =2;
	int f=0;
	int s =1;
	System.out.print("Fibonaciic Series : "+f+" "+s);
	while(i<n) {		
	int next=f+s;
	f=s;
	s=next;	
	System.out.print(" "+next);
	i++;
	}
	
	
	
	
}

}
