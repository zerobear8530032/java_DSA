package day2_assignment;

import java.util.Scanner;

public class LargestNumberEnterByUser {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a Number to sum :");
		System.out.println("Enter x to exit :");
		int num=sc.nextInt();
		int max=0;
		while(true) {
			if(num==0) {
				break;
			}
			if(max<num) {
				max=num;
			}
			num=sc.nextInt();
		}
		
		System.out.println("Max "+max);
		System.out.println("exit");
		
	}

}
