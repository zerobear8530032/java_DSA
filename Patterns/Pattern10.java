//10.      *
//        * *
//       * * *
//      * * * *
//     * * * * *
package Patterns;
public class Pattern10 {
	public static void pattern10(int n) {
		for(int row=1;row<=n;row++) {
			int numberofspace = n-row;
			for(int space=1;space<=numberofspace;space++) {
				System.out.print(" ");
			}
			for(int col=1;col<=n-numberofspace;col++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		pattern10(5);
		
	}

}
