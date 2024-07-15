package day3_assignment;

import java.util.Scanner;

public class PalindromNumber {
static boolean isPandrome(int n) {
	int t=n;
	int sum=0;
	while(t>0) {
		int rem =t%10;
		sum=sum*10+rem;
		t=t/10;
	}
	return (n==sum);
}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Number");
	int num=sc.nextInt();
	System.out.println(isPandrome(num));

}}