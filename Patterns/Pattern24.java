//24.    *        *
//       **      **
//       * *    * *
//       *  *  *  *
//       *   **   *
//       *   **   *
//       *  *  *  *
//       * *    * *
//       **      **
//       *        *



package Patterns;

public class Pattern24 {
	public static void pattern24(int n) {
		
		for(int row=1;row<=2*n-1;row++) {
			int  numberofstar = row<=n? row:2*n-row;
//			System.out.println(numberofstar);
			for(int col=1;col<=numberofstar;col++) {
				if(col==1 || col== numberofstar) {					
				System.out.print("*");
				}else {
					System.out.print(" ");					
				}
			}
			for(int col=1;col<=2*n-2*numberofstar;col++) {
				System.out.print(" ");
			}
			for(int col=1;col<=numberofstar;col++) {
				if(col==1 || col== numberofstar) {					
					System.out.print("*");
				}else {
					System.out.print(" ");					
				}
			}
			
			
			System.out.println("");
			
		}
		
	}
	public static void main(String[] args) {
	pattern24(5);
	
}

}
