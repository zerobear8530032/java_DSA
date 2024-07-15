package day2_assignment;

import java.util.Scanner;
public class LCM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the n1");
		int n1 =sc.nextInt();
		System.out.println("Enter the n2");
		int n2 =sc.nextInt();
		int lcm=1;
		int i =2;
		while(true) {		
			if(n1%i==0 && n2%i==0) {
				n1=n1/i;
				n2=n2/i;
				lcm=lcm*i;
			}else if(n1%i==0){
				n1=n1/i;
				lcm=lcm*i;				
			}else if(n2%i==0){
				n2=n2/i;
				lcm=lcm*i;				
			}
			else {
				i++;
			}
			if(n1==1 && n2==1) {
				break;
			}
		}
		System.out.println("LCM"+lcm);
	}
}
