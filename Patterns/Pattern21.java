//21.    1
//       2  3
//       4  5  6
//       7  8  9  10
//       11 12 13 14 15

package Patterns;

public class Pattern21 {
	public static void pattern21(int n) {
		int i =1;
		for(int row=1;row<=n;row++) {
			for(int col = 1;col<=row;col++) {
				System.out.print(i+" ");
				i++;
			}
			System.out.println("");
		}
		
	}

	public static void main(String[] args) {
		pattern21(5);
	}

}
