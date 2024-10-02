//29.      
//       *        *
//       **      **
//       ***    ***
//       ****  ****
//       **********
//       ****  ****
//       ***    ***
//       **      **
//       *        *
package Patterns;

public class Pattern29 {
	public static void pattern29(int n) {
		for(int row=1;row<=2*n-1;row++) {
			int numberofstar = row<=n? row:2*n-row;
			for(int col=1;col<=numberofstar;col++) {
				System.out.print("*");
			}
			for(int space=1;space<=2*(n-numberofstar);space++) {
				System.out.print(" ");
			}
			for(int col=1;col<=numberofstar;col++) {
				System.out.print("*");
			}
			
			
			
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		pattern29(5);

	}

}
