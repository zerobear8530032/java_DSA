//	  n=5
//	  *
//	  **
//	  ***
//	  ****
//	  *****
//	  ****
//	  ***
//	  **
//	  *

package Patterns;

public class Pattern5 {
	public static void pattern5(int n) {
		for(int row = 1;row<=n*2-1;row++) {
			int numberofstar = row>n ? 2*n-row:row ;
			for (int col = 1; col <=numberofstar; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		pattern5(5);
		

	}

}
