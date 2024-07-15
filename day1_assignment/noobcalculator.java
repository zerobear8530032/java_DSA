package day1_assignment;

import java.util.Scanner;

public class noobcalculator {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter number 1 :");
	float n1=sc.nextInt();
	System.out.println("Enter number 2 :");
	float n2=sc.nextInt();
	System.out.println("Enter Operator  :");
	char op=sc.next().charAt(0);
	
	if(op=='+') {
		System.out.println(n1+" + "+n2+" = "+(n1+n2));
	}else if(op=='-') {		
		System.out.println(n1+" - "+n2+" = "+(n1-n2));
	}else if(op=='*') {		
	System.out.println(n1+" * "+n2+" = "+(n1*n2));
	}else if(op=='/') {		
	System.out.println(n1+" / "+n2+" = "+(n1/n2));
	}else if(op=='%') {		
	System.out.println(n1+" % "+n2+" = "+(n1%n2));
	}
	
}

}
