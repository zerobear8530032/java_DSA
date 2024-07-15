package day2_assignment;

import java.util.Scanner;

public class CalculateDiscountOfProduct {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Cost of Product");
	float cost =sc.nextFloat();
	
	System.out.println("Enter the Discout of Product (in %)");
	float per=sc.nextFloat();
	float discount=(per/100)*cost;
	
	System.out.println("discount : "+discount);
	System.out.println("total payment :"+(cost-discount));
	}

}
