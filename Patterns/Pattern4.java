//	  n=5
// 	  1
//    12
//    123
//    1234
//    12345
package Patterns;

public class Pattern4 {
	public static void pattern4(int n) {
		for(int row =1;row<=n;row++) {
			for(int col = 1;col<=row;col++) {
				System.out.print(col);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		pattern4(5);
		

	}

}
