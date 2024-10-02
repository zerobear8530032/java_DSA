//26.   1 1 1 1 1 1
//      2 2 2 2 2
//      3 3 3 3
//      4 4 4
//      5 5
//      6
//

package Patterns;

public class Pattern26 {
	public static void pattern26(int n) {
		for(int row =0;row<=n;row++) {
			for(int col=1;col<=n-row;col++) {
				System.out.print(row+1+" ");
			}
			System.out.println();
			
		}
	}

	public static void main(String[] args) {
		pattern26(6);

	}

}
