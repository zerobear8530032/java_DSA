//	  n=5
// 	  *
//    **
//    ***
//    ****
//    *****
package Patterns;

public class Pattern2 {
	public static void pattern2(int n) {
		for(int row =0;row<=n;row++) {
			for(int col = 0;col<row;col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		pattern2(5);
		

	}

}
