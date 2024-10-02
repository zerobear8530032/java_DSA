//34.    E D C B A
//       D C B A
//       C B A
//       B A
//       A

package Patterns;


public class Pattern34 {
	public static void pattern34(int n) {
		for(int row=0;row<n;row++) {
			for(int col=n-row;col>0;col--){
				System.out.print((char)('A'+col-1)+" ");
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		pattern34(5);

	}

}
