//19.    *        *
//       **      **
//       ***    ***
//       ****  ****
//       **********
//       ****  ****
//       ***    ***
//       **      **
//       *        *

package Patterns;

public class Pattern19 {
	public static void pattern19(int n) {
		for(int row=1;row<=n*2-1;row++) {
			if(row<=n) {
				
			int numberofstar =row;
			for(int col=1;col<=row;col++) {
				System.out.print("*");
			}
			for(int space=0;space<2*n-2*row;space++) {
				System.out.print(" ");
			}
			for(int col=1;col<=row;col++) {
				System.out.print("*");
			}
			}else {
				int numberofstar =2*n-row;
				for(int col=1;col<=numberofstar;col++) {
					System.out.print("*");
				}
				for(int space=0;space<(n-numberofstar)*2;space++) {
					System.out.print(" ");
				}
				for(int col=1;col<=numberofstar;col++) {
					System.out.print("*");
				}
				
			}
			
			System.out.println();
		}
	}

	public static void main(String[] args) {
		pattern19(5);
	
	}

}
