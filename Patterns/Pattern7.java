//	 n=5
//   *****
//    ****
//     ***
//      **
//       *

package Patterns;
public class Pattern7 {
public static void pattern7(int n) {
	for(int row=0;row<n;row++) {
		for(int space =0;space<row;space++) {
			System.out.print(" ");
		}
		for(int col=0;col<n-row;col++) {
			System.out.print("*");
		}
		System.out.println();
	}
}
public static void main(String[] args) {
	pattern7(5);
}
}
