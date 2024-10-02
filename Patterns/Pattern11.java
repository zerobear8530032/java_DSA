//11.  * * * * *
//      * * * *
//       * * *
//        * *
//         *
package Patterns;

public class Pattern11 {
	public static void pattern11(int n) {
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
	}
	public static void main(String[] args) {
		pattern11(5);
	}

}
