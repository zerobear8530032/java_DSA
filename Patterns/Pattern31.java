//31.      4 4 4 4 4 4 4  
//         4 3 3 3 3 3 4   
//         4 3 2 2 2 3 4   
//         4 3 2 1 2 3 4   
//         4 3 2 2 2 3 4   
//         4 3 3 3 3 3 4   
//         4 4 4 4 4 4 4   

package Patterns;

public class Pattern31 {
	public static void pattern31(int n) {
		int ogn=n;
		 n= 2*n;
		for(int row=1;row<n;row++) {
			for(int col=1;col<n;col++) {
				int ateveryindex=ogn-Math.min(Math.min(row,col),Math.min(n-row,n-col) );
				System.out.print(ateveryindex+1+" ");
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		pattern31(4);

	}

}
