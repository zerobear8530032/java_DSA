//
//
//17.      1
//        212
//       32123
//      4321234
//       32123
//        212
//         1
//
//
//18.   **********
//      ****  ****
//      ***    ***
//      **      **
//      *        *
//      *        *
//      **      **
//      ***    ***
//      ****  ****
//      **********
//
//
//19.    *        *
//       **      **
//       ***    ***
//       ****  ****
//       **********
//       ****  ****
//       ***    ***
//       **      **
//       *        *
//
//
//20.    ****
//       *  *
//       *  *
//       *  *
//       ****

package Patterns;

public class Pattern20 {
	public static void pattern20(int n) {
		for(int row=1;row<=n;row++) {
			for(int col=1;col<=n-1;col++) {
				if(col==1 || row==1 || col==n-1 ||  row==n ) {
					System.out.print("*");					
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		pattern20(5);
	}

}
