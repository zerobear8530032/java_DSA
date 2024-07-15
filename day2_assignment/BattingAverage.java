package day2_assignment;

import java.util.Scanner;

public class BattingAverage {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the total number of run scored by bats man : ");
	int run=sc.nextInt();
	System.out.println("Enter the total number of Times bats man got out : ");
	int out=sc.nextInt();
	System.out.println("Batting Average : "+(run/out));
}
}
