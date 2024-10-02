//27.   1 2 3 4  17 18 19 20
//        5 6 7  14 15 16
//          8 9  12 13
//            10 11
//

package Patterns;

public class Pattern27 {
	public static void pattern27(int n) {
		int firsthalf = 1; 
        int secondhalf = (n * n) + 1; 
        int numberofspace = 0; 
  
        // numOfLines is the line number 
        for (int row = n; row >= 1; 
             row--) { 
  
            for (int space = numberofspace; space >= 1; space--) { 
                System.out.print(" "); 
            } 
            for (int col = 1; col <= row; col++) { 
                if (col == row) {
                	System.out.print((firsthalf++)); 	
                }  
                else {
                	System.out.print((firsthalf++) + " ");                 	
                }
            } 
            for (int col = 1; col <= row; col++) { 
                System.out.print(" " + (secondhalf++)); 
            } 
            System.out.println(); 
         numberofspace += 2; 
         secondhalf = (secondhalf - 1) - ((row - 1) * 2); 
        } 
    } 
	public static void main(String[] args) {
		pattern27(4);
	}

}
