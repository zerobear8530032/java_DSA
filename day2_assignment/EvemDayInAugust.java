package day2_assignment;

import java.util.Scanner;

public class EvemDayInAugust {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int c =0;
		int n=31;
		
		for(int i =0;i<n;i++) {
			if(i%2==0) {
			c++;	
			}
		}
		
		System.out.println("Number of days Kunal can Go out"+c);
}

}
