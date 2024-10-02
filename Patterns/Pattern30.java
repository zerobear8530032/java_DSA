
//30.         1
//          2 1 2
//        3 2 1 2 3
//      4 3 2 1 2 3 4
//    5 4 3 2 1 2 3 4 5
//

package Patterns;

public class Pattern30 {
	public static void pattern30(int n) {
		for(int row=1;row<=n;row++) {
			int numberofspace= n-row;
			for(int space =1;space<=numberofspace;space++) {
				System.out.print("  ");
			}
			for(int col=1;col<=n-numberofspace;col++) {
				System.out.print((row-col+1)+" ");
			}
			for(int col=2;col<=n-numberofspace;col++) {
				System.out.print((col)+" ");
			}
			
			
			System.out.println();
		}
	}
	public static void main(String[] args) {
		pattern30(5);
	}


}
