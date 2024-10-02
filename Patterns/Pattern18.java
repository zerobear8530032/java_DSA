//18.   **********
//      ****  ****
//      ***    ***
//      **      **
//      *        *
//      *        *
//      **      **
//      ***    ***
//      ****  ****
//      **********

package Patterns;

public class Pattern18 {
	public static void pattern18(int n) {
		for(int row=0;row<n*2;row++) {
			if(row<n) {				
			int numberofstar =n-row; 
			for(int col=0;col<numberofstar;col++) {
				System.out.print("*");
			}
			for(int space=0;space<2*n-2*numberofstar;space++) {
				System.out.print(" ");
			}
			for(int col=0;col<numberofstar;col++) {
				System.out.print("*");
			}
			}else {
				int numberofstar=row-n;
//				System.out.println(numberofstar);
				for(int col=0;col<=numberofstar;col++) {
					System.out.print("*");
				}
				for(int space=0;space<2*n-2*numberofstar-2;space++) {
					System.out.print(" ");
				}
				
				for(int col=0;col<=numberofstar;col++) {
					System.out.print("*");
				}
				
			}
			
			
			
			System.out.println("");
		}
		
	}
	public static void pattern_18(int n) {
			for(int row=0;row<=n*2;row++) {
				
				int numberofstar = row<=n ?  n-row : row-n; 
				for(int col=0;col<=numberofstar;col++) {
					System.out.print("*");
				}
				for(int space=0;space<2*n-2*numberofstar;space++) {
					System.out.print(" ");
				}
				for(int col=0;col<=numberofstar;col++) {
					System.out.print("*");
				}			
				System.out.println("");
			}			
	}

	public static void main(String[] args) {
		pattern18(5);
		pattern_18(5);

	}

}
