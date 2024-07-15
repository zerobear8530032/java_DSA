package day2_assignment;

import java.util.Scanner;

public class CommissionPercentage {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Sales ");
		float sale =sc.nextFloat();
		
		System.out.println("Enter the Commition %");
		float per=sc.nextFloat();
		float commition=(per/100)*sale;
		System.out.println("commition :"+commition);
	}

}
