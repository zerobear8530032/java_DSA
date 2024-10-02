//25.       *****
//         *   *
//        *   *
//       *   *
//      *****

package Patterns;

public class Pattern25 {
	public static void pattern25(int n) {
		for(int row=0;row<n;row++) {
			for(int space=0;space<n-row;space++) {
				System.out.print(" ");
			}
			for(int col=0;col<n;col++) {
				if(col==0 || col==n-1 ||  row==0 || row==n-1) {
					System.out.print("*");					
				}else {
					System.out.print(" ");
				}
			}
			System.out.println(" ");
		}
		
	}
public static void main(String[] args) {
	pattern25(5);
}
}
