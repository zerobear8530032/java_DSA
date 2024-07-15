package day2_assignment;

import java.util.Scanner;

public   class NCRandNPR {
static int factorial (int n) {
int fact =1;
for(int i =1;i<=n;i++) {
	fact=fact*i;
}
return fact;
}
	public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the N:");
	int n =sc.nextInt();
	System.out.println("Enter the R:");
	int r =sc.nextInt();
	int factr=factorial(r);
	int factn=factorial(n);
	int nr=factorial(n-r);
	System.out.println(factr);
	System.out.println(factn);
	System.out.println(nr);
	float NCR=factn/(factr*nr);
	
	System.out.println("NCR : "+NCR);
	float NPR=factn/(nr);
	System.out.println("NPR : "+NPR);
	
	
	
}
}
