//		0123456
//17.      1        0
//        212       1
//       32123      2
//      4321234     3
//       32123      4
//        212       5
//         1        6

package Patterns;

public class Pattern17 {
	public static void pattern17(int n) {
		for(int row=1;row<=n*2-1;row++) {
			if(row<=n) {	
			int numberofspace=n-row;
			for(int space=0;space<numberofspace;space++) {
				System.out.print(" ");
			}
			for(int col=1;col<=n-numberofspace;col++) {
					System.out.print(row-col+1);					
			}
			for(int col=2;col<=row;col++) {
				System.out.print(col);
			}
			}else {
				int numberofspace=row-n;
				for(int space=0;space<numberofspace;space++) {
					System.out.print(" ");
				}
				for(int col=1;col<=n-numberofspace;col++) {
					System.out.print(2*n-row-col+1);					
				}
				for(int col=2;col<=n-numberofspace;col++) {
					System.out.print(col);
				}
				
				
			}
			
			System.out.println();
			
		}
		
	}

	public static void main(String[] args) {
		pattern17(9);
	}

}
