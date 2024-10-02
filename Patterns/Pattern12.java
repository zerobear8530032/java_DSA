//12.  * * * * *
//      * * * *
//       * * *
//        * *
//         *
//         *
//        * *
//       * * *
//      * * * *
//     * * * * *


package Patterns;

public class Pattern12 {
	public static void pattern12(int n) {
//		upper part
		for(int row = 1;row<=n;row++) {
			int numberofspace = row-1;
			for(int space =0;space<numberofspace;space++) {
				System.out.print(" ");				
			}
			for(int col =1;col<=n-numberofspace;col++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
//		lower part
		for(int row = 1;row<=n;row++) {
			int numberofspace = n-row;
			for(int space =0;space<numberofspace;space++) {
				System.out.print(" ");				
			}
			for(int col =1;col<=row;col++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
	}

public static void main(String[] args) {
	pattern12(5);
}
}
