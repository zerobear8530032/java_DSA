//14.   *********
//      *     *
//       *   *
//        * *
//         *

package Patterns;
public class Pattern14 {
	public static void pattern14(int n) {
//		lower part
		for(int row = 1;row<=n;row++) {
//			int numberofspace = n-row;
			int numberofspace = row-1;
			for(int space=1;space<=numberofspace;space++) {
				System.out.print(" ");
			}
			for(int col=1;col<=n-numberofspace;col++) {
				if(col==1||  row==1) {
					System.out.print("*");										
				}else {
					System.out.print(" ");															
				}
			}
			for(int col=1;col<=n-row;col++) {
					if(col==n-row || row==1) {
						System.out.print("*");										
					}else {
						System.out.print(" ");															
					}
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		pattern14(5);
	}
}
