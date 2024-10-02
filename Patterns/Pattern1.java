//    n= 5
//    *****
//    *****
//    *****
//    *****
//    *****
package Patterns;

public class Pattern1 {
	public static void pattern1 (int n) {
		for(int rows =0;rows<n;rows++) {
			for(int cols =0;cols<n;cols++) {
			System.out.print("*");	
			}
			System.out.println("");
		}
	}
	
	public static void pattern1 (int r,int c) {
		for(int rows =0;rows<r;rows++) {
			for(int cols =0;cols<c;cols++) {
				System.out.print("*");	
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		System.out.println("square : ");
		pattern1(5);// square
		System.out.println("rectangle : ");
		pattern1(5,4);//rectangle
	}
}
