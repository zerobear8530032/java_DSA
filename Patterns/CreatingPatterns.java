package Patterns;
import java.util.Scanner;
public class CreatingPatterns {
//	pattern 1:
	public static void printSquare(int n) {
		for (int rows =1;rows<=n;rows++ ) {
			for (int cols =1;cols<=n;cols++ ) {
			System.out.print("*");
			}
			System.out.println("");
		}
	}
//	pattern 1:
	public static void printRectangle(int rows ,int cols) {
		for (int i =1;i<=rows;i++ ) {
			for (int j=1;j<=cols;j++ ) {
			System.out.print("*");
			}
			System.out.println("");
		}
	}
	
//	pattern 2:
	public static void printTriangle(int n) {
//		outer will run for number of row times
		for (int i = 1; i <=n; i++) {
//			the inner loop will execute number of time upper will run
			for(int j =1;j<=i;j++) {// this will run number of col times
				System.out.print("* ");
			}
//			at the end of each row we will go to next line
			System.out.println();
		}		
	}
	
//	pattern 3:
	public static void printRevTriangle(int n) {
//		outer will run for number of row times
		for (int row = 1; row <=n; row++) {
//			we can also do 
//			for(int col = n-row ;col >=0;  col--){
			for (int col= 1; col<=n-row+1; col++) {
			System.out.print("* ");	
			}
			System.out.println();	
		}		
	}
	
//	pattern 4:
	public static void NumberTriangle(int n) {
//		outer will run for number of row times
		for (int row = 1; row <=n; row++) { 
			for (int col= 1; col<=n-row+1; col++) {
				System.out.print(col+" ");	
			}
			System.out.println();	
		}		
	}
//	pattern 5:
	public static void verticalPyramid(int n) {
		for (int row = 1; row <=n*2-1; row++) { 
			if(row<=n) {				
			for (int col= 1; col<=row; col++) {
				System.out.print("* ");	
			}
			}else {
				for (int col=1 ; col<=2*n-row; col++) {
					System.out.print("* ");	
				}				
			}
			System.out.println();	
		}		
	}

	
//	pattern 17:
	public static void printNumberSymetricDiamond(int n) {
		for (int row =1; row <=2*n-1; row++) { 
//			here we calculat number of rows :
			int c = row>n?2*n-row : row;
//			printing spaces
			for(int s =0;s<n-c;s++) {
				System.out.print("  ");
			}
//			printing  left half
			for (int col =c; col>=1; col--) {
				System.out.print(col+" ");
			}
//			printing right half
			for (int col =2; col<=c; col++) {
				System.out.print(col+" ");
			}			
			System.out.println("");	
		  }
		}

	
	
//	pattern 28:
	public static void printDiamond(int n) {
		for (int row = 1; row <=n*2-1; row++) { 
			if(row<=n) {
//				here this loop will print spaces
			for(int col = 1;col<=n-row;col++) {
				System.out.print(" ");
			}
//				here this loop will print *
			for(int col = 1;col<=row;col++) {
				System.out.print("* ");
			}
			}else {
//				here this loop will print spaces
				for(int col = 1;col<=row-n;col++) {
					System.out.print(" ");
				}
//				here this loop will print *
				for(int col = 1;col<=2*n-row;col++) {
					System.out.print("* ");
				}				
			}
			System.out.println("");	
		}		
	}
	
//	pattern 17:
//	public static void printNumberSymetricDiamond(int n) {
//		for (int row =1; row <=2*n-1; row++) { 
//			if(row<=n) {
//				
////			printing spaces
//			for(int s =0;s<n-row;s++) {
//				System.out.print("  ");
//			}
////			printing  left half
//			for (int col =row; col>=1; col--) {
//				System.out.print(col+" ");
//			}
////			printing right half
//			for (int col =2; col<=row; col++) {
//				System.out.print(col+" ");
//			}			
//			}else {
//				int numberofspaces=0;
//				for(int s = 1;s<=row-n;s++) {
//					System.out.print("  ");
//				}
//				numberofspaces=row-n;
//				
//////				here this loop will print left half
//				for(int col = 1;col<=2*n-row;col++) {
//					System.out.print((n-col-numberofspaces+1)+" ");
//				}
////			printing right half
//				for (int col =2; col<=2*n-row; col++) {
//					System.out.print(col+" ");
//				}			
//			}
//			
//			
//			System.out.println("");	
//		}		
//	}
//	pattern 30:
	public static void printNumberSymetricPyramid(int n) {
		for (int row =1; row <=n; row++) { 
//			printing spaces
			for(int s =0;s<n-row;s++) {
				System.out.print("  ");
			}
//			printing  left half
			for (int col =row; col>=1; col--) {
				System.out.print(col+" ");
			}
//			printing right half
			for (int col =2; col<=row; col++) {
				System.out.print(col+" ");
			}
			
			
			System.out.println("");	
		}		
	}
	

//	pattern 31:
	public static void printNumberSquare(int n) {
		int originalN=n;
		n=2*n;
		
		for (int row =1; row <n; row++) { 
			for (int col=1; col<n; col++) {
				int ateveryindex=originalN-Math.min(Math.min(row,col),Math.min(n-row,n-col) );
			System.out.print((ateveryindex+1)+ " ");
			}			
			System.out.println("");	
		}		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of Pyramid : ");
		int n = sc.nextInt();
//		printTriangle(n);
//		printSquare(n);
//		printRectangle(n,5);
//		NumberTriangle(n);
//		verticalPyramid(n);
//		printDiamond(n);
//		printNumberSymetricDiamond(n);
		printNumberSquare(n);
		
		
		
		
}
}
