package day1_assignment;
import java.util.Scanner;
public class ArmStrngNumber {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a number");
	int n=sc.nextInt();
	int t=n;
	int sum=0;
	while(t>0) {
		int rem =t%10;
		t=t/10;
		sum=sum+(int)Math.pow(rem, 3);	
		}
System.out.println(sum);
if(sum==n) {
	System.out.println(n + " is  a ArmString Number");
}else {
	System.out.println(n + " is not a ArmString Number");
	
}
}
}
