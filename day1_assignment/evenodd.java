package day1_assignment;
import java.util.Scanner;
public class evenodd {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Number");
	int num =sc.nextInt();
	if(num%2==0) {
		System.out.println("its even");
	}else {
		System.out.println("its odd");		
	}
	
}
}
