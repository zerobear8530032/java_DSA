//22.    1
//       0 1
//       1 0 1
//       0 1 0 1
//       1 0 1 0 1

package Patterns;

public class Pattern22 {
	public static void pattern22(int n) {
		for(int row =1;row<=n;row++) {
			 int start = row % 2; // Start with 1 for odd rows, 0 for even rows
			for(int col = 1;col<=row;col++) {
				System.out.print(start+" ");
				
				start=1-start;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		pattern22(5);
	}

}
