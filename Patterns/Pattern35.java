//35.    1      1
//       12    21
//       123  321
//       12344321

package Patterns;

public class Pattern35 {
	public static void pattern35(int n) {
		for(int row=1;row<=n;row++) {
			for(int col =1;col<=row;col++) {
				System.out.print(col);
			}
			for(int space=0;space<2*n-2*row;space++) {
				System.out.print(" ");
			}	
			for(int col =1;col<=row;col++) {
				System.out.print(row-col+1);
			}
			System.out.println();
		}
	}
	public static void main(String args[]) {
		pattern35(4);
		
	}

}
