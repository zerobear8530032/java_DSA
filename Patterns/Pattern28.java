//28.      *
//        * *
//       * * *
//      * * * *
//     * * * * *
//      * * * *
//       * * *
//        * *
//         *

package Patterns;

public class Pattern28 {
	public static void pattern28(int n) {
		for(int row=0;row<=2*n-1;row++) {
			int numberofspace = row<=n?n-row:row-n;
			for(int space=0;space<numberofspace;space++) {
				System.out.print(" ");
			}
			for(int col=0;col<n-numberofspace;col++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
		pattern28(5);
		
	}

}
