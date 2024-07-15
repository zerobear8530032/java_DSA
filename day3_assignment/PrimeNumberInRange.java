package day3_assignment;

import java.util.Scanner;

public class PrimeNumberInRange {
	static void PrimeInRange(int start,int end) {
		boolean isprime=true;
		boolean noprimefound =true;
		int k=start;
		if(start<0 && end>0) {
			start=1;
		}
		
		if(start<end) {
		while(k<=end) {
			if(k<=1) {
				k++;
				continue;
			}
			isprime=true;
			for(int i =2;i*i<=k;i++) {
				if(k%i==0) {
					isprime=false;
					break;
				}
			}
			if(isprime) {			
				noprimefound=false;
			System.out.println(k);
			}
			k++;
		}
		}else if(start <0 && end<0){
			System.out.println("Invalid Input");
		}else {
			System.out.println("Invalid Input");			
		}
		if(noprimefound) {
			System.out.println("No Prime Found In Between the Range");
		}
		
	}
	
	
	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Starting Numeber");
	int ll=sc.nextInt();
	System.out.println("Enter the Ending Numeber");
	int ul=sc.nextInt();	
	PrimeInRange(ll,ul);
	
}
}
