package day2_assignment;

import java.util.Scanner;

public class AverageNNumbers {
public static void main(String args[]) {
	System.out.println("Enter the Numbers you want to average :");
	Scanner sc = new Scanner(System.in);
	int n =sc.nextInt();
	
	float sum =0;
	for(int i =1;i<=n;i++) {
		sum=sum+i;
	}
	
	System.out.println("sum"+sum);
	System.out.println("avg :"+(sum/n));
	
}
}
