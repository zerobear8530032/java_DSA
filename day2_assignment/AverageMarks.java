package day2_assignment;

import java.util.Scanner;

public class AverageMarks {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Number of subject");
	int n =sc.nextInt();
	float sum =0;
	
	for(int i =0;i<n;i++) {
	float	marks=sc.nextInt();
	sum=sum+marks;	
	}
	
	float avgmarks=sum/n;
	System.out.println(avgmarks);
	
	
	
	
}
}
