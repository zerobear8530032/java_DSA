package day2_assignment;

import java.util.Scanner;

public class VovelandConconents {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String");
		String str=sc.next().toLowerCase();
		for(int i =0;i<str.length();i++) {
			if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u' ) {
				System.out.println(" Vovel :"+str.charAt(i));
			}else {
				System.out.println(" Consonents :"+str.charAt(i));				
			}
		}
		
	}

}
