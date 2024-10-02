//13.      *
//        * *
//       *   *
//      *     *
//     *********

package Patterns;

public class Pattern13 {
	public static void pattern13(int n) {
//		lower part
		for(int row = 1;row<=n;row++) {
			int numberofspace = n-row;
			for(int space=1;space<=numberofspace;space++) {
				System.out.print(" ");
			}
			for(int col=1;col<=n-numberofspace;col++) {
				if(col==1 || row==n) {
					System.out.print("*");					
				}else {
					System.out.print(" ");										
				}
			}
			for(int col=1;col<=row-1;col++) {
				if(col==row-1 || row==n) {
					System.out.print("*");					
				}else {
					System.out.print(" ");										
				}
			}
			System.out.println("");
		}
	}
	
public static void main(String[] args) {
	pattern13(5);
}
}
