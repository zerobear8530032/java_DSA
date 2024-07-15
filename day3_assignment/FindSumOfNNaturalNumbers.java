package day3_assignment;

import java.util.Scanner;

public class FindSumOfNNaturalNumbers {
static 	int sumNNumbers(int n) {
	int i =1;
	int sum=0;
	while(i<=n) {
		
		sum=sum+i;
		i++;
	}
	return sum;
	}
	
	
	
	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the N th Number :");
	int n =sc.nextInt();
	System.out.println(sumNNumbers(n));
	
}
}
