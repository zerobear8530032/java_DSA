//8.      *
//       ***
//      *****
//     *******
//    *********
package Patterns;
public class Pattern8 {
	public static void pattern8(int n) {
		for(int row=1;row<=n;row++) {
			int numberofspaces = n-row;
			for(int space=1;space<=n-row;space++) {
				System.out.print(" ");
			}
//			left half
			for(int col=0;col<n-numberofspaces;col++) {
				System.out.print("*");				
			}
//			right half
			for(int col=0;col<row-1;col++) {
				System.out.print("*");				
			}
			System.out.println("");
		}
	}
	public static void main(String[] args) {
		pattern8(5);
	}
}
