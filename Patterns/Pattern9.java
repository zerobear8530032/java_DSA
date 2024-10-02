//9.  *********
//     *******
//      *****
//       ***
//        *
package Patterns;
public class Pattern9 {
	public static void pattern9(int n) {
		for(int row=1;row<=n;row++) {
			int numberofspaces = row-1;
			for(int space=1;space<=numberofspaces;space++) {
				System.out.print(" ");
			}
//			left half
			for(int col=0;col<n-numberofspaces;col++) {
				System.out.print("*");				
			}
//			right half
			for(int col=0;col<n-row;col++) {
				System.out.print("*");				
			}
			System.out.println("");
		}
	}
	public static void main(String[] args) {
		pattern9(5);
	}
}
