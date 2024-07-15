package Day2_video2;

import java.util.Scanner;

public class CaseChecker {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	char ch = sc.next().trim().charAt(0);
	if(ch>='a' && ch <='z') {
		System.out.println("its LowestCase");
	}else if(ch>='A' && ch <='Z') {
				System.out.println("its Upper Case");
	}else {
		System.out.println("Invalid Input");		
	}
	
	
	
	
	
}
}
