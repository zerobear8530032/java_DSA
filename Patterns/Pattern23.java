//23.        *      *
//         *   *  *   *
//       *      *      *


package Patterns;

public class Pattern23 {
	    public static void pattern23(int n) {
	    	for (int row = 1; row <= n; row++) {
	    		int numberofspace=n-row;
	    		
	    		for(int space=0;space<numberofspace;space++) {
	    			System.out.print("  ");
	    		}
	    		
	    		for(int col=0;col<n-numberofspace;col++) {
	    			System.out.print("* ");
	    		}	    		
	    		for(int col=0;col<n-numberofspace-1;col++) {
	    				System.out.print("* ");	    					    				
	    			
	    		}
	    		for(int space=0;space<numberofspace;space++) {
	    			System.out.print("    ");
	    		}
	    		
	    		for(int col=0;col<n-numberofspace;col++) {
	    			System.out.print("* ");
	    		}	    		
	    		for(int col=0;col<n-numberofspace-1;col++) {
	    			System.out.print("* ");
	    		}
	            System.out.println();  
	        }
	    }
	public static void main(String[] args) {
		pattern23(3);
	}

}
