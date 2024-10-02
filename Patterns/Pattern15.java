//15.      *
//        * *
//       *   *
//      *     *
//     *       *
//      *     *
//       *   *
//        * *
//         *

package Patterns;

public class Pattern15 {
	public static void pattern15(int n) {
		for(int row=1;row<=2*n-1;row++) {
			
			int numberofspace = row>n ? row-n :n-row;
//			print spaces
			
			for(int space=1;space<=numberofspace;space++) {
				System.out.print(" ");
			}
//			print left half
			for(int col=1;col<=n-numberofspace;col++) {
				if(col==1) {
					System.out.print("*");					
				}else {
					System.out.print(" ");										
				}
			}
//			print right half
			for(int col=1;col<=row-1;col++) {
				if(col==row-1 && row<=n || row>n && col == 2*n-row-1) {
					System.out.print("*");					
				}else {
					System.out.print(" ");										
				}
			}
			
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
		pattern15(5);

	}


}
