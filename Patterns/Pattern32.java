//32.    E
//       D E
//       C D E
//       B C D E
//       A B C D E

package Patterns;

public class Pattern32 {
	public static void pattern32(int n) {
		for(int row=1;row<=n;row++) {
			for(int col=row;col>0;col--) {
				System.out.print((char)('A'+n-col));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		pattern32(5);

	}

}
