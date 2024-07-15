package day3_assignment;
import java.util.Scanner;
public class EvenOdd {
	static void evenodd(int n ) {
		if(n%2==0) {
			System.out.println("Even");
		}else {
			System.out.println("odd");
			
		}
	}
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Number");
	int n =sc.nextInt();
	evenodd(n);

	
	
}
}
