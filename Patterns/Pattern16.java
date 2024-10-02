package Patterns;

public class Pattern16 {
    // Function to generate and print Pascal's Triangle
    public static void pattern16(int n) {
        // Outer loop for each row
        for (int row = 0; row < n; row++) {
            // Printing spaces before numbers for centering the triangle
            for (int space = 0; space < n - row - 1; space++) {
                System.out.print("  ");  // 2 spaces for proper alignment
            }

            int number = 1; // First number in the row is always 1
            // Inner loop to print the numbers in the current row
            for (int col = 0; col <= row; col++) {
                System.out.print(number + "   ");  // Print the number and a few spaces
                // Update the number using Pascal's triangle formula
                number = number * (row - col) / (col + 1);
            }

            System.out.println();  // Move to the next line after printing each row
        }
    }

    public static void main(String[] args) {
        pattern16(6);  // Generate Pascal's Triangle for 5 rows
    }
}
