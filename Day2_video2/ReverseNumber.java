package Day2_video2;

import java.util.Scanner;

public class ReverseNumber {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number :");
		int x =sc.nextInt();
		int revNumber=0;
		
		while(x>0) {
			int r=x%10;
			revNumber =revNumber*10+r;
			x=x/10;
		}
		System.out.println("Reverse Number "+revNumber);
		
	}
	}
