//54. Spiral Matrix
//Medium
//Topics
//Companies
//Hint
//Given an m x n matrix, return all elements of the matrix in spiral order.
//Example 1:
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
//Example 2:
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
//Constraints:
//m == matrix.length
//n == matrix[i].length
//1 <= m, n <= 10
//-100 <= matrix[i][j] <= 100

package leetcode_Medium;
import java.util.Scanner;
import java.util.LinkedList;
public class SpiralMatrix_1_54 {
//	approch : use 4 pointers :
//	top which keep track of top boundary intialy 0;
//	bottom which keep track of bottom boundary initially mat.length;  (it have 1 value more then the actual index)
//  left which keep track of left boudary initialy 0;
//  right which keep track of right boudary initialy mat[0].length;
//	now we make a loop which will run untill left< right && top<bottom:
//	now we will create 4 loop :
//	1 loop : for top row:
//	it will execute from left to right after it executed we will increment top by 1 
//	mat[top][i]
//	2 loop : for right column
//	it will loop from top to bottom after it executed we will decrement the right by 1
//	mat[i][right-1]
//	here we will handle some edge case by checking if left < right or top< bottom :
//	then we will break
//	3 loop : for bottom row:
//	it will be a reverse loop from right to left after it executes we will decrement the bottom by 1 
//	mat [bottom-1][i]
//	4 loop : for left col :
//	it will be a reverse  loop from bottom to top after it execute we will increment left by 1 
//	at last we can  add all element in the loops and return the final list
//	time complexity = O(m*n): where m,n are rows and columns of the matrix
//	space complexity = O(1) // because the output is a list 
	
	static LinkedList<Integer> spiralmatrix(int[][] mat) {
		LinkedList<Integer> res = new LinkedList();
		int left =0;
		int right=mat[0].length; 
		int top=0;
		int bottom =mat.length;
		while(top<bottom && left <right) {
			System.out.println("top row");
//			top row:
			for(int i =left;i<right;i++) {
				res.add(mat[top][i]);
//				System.out.println(mat[top][col]);
			}
			top++;
//			right col:
			for(int i=top;i<bottom;i++) {				
				res.add(mat[i][right-1]);
//				System.out.println(mat[row][right-1]);
			}
			right--;
			if(!(top<bottom && left<right)) {
				break;
			}
			 
			
//			bottom row:
			for(int i=right-1;i>left-1;	i--) {
				res.add(mat[bottom-1][i]);
//				System.out.println(mat[bottom-1][col]);
			}
			bottom--;
			
//			left row:
			
			for(int i=bottom-1;i>=top;i--) {
				res.add(mat[i][left]);
//				System.out.println(mat[row][left]);
			}
			left++;
			
		}
		return res;
	
	}
	
	

public static void main(String args[]) {
	int [][] matrix1= {
			{1,2,3},
			{4,5,6},
			{7,8,9}
	};
	int [][] matrix2= 
			{{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12}};
	
	int [][]matrix3= {{1,2,3,4}};
	
System.out.println(	spiralmatrix(matrix1));	
System.out.println(	spiralmatrix(matrix2));	
System.out.println(	spiralmatrix(matrix3));	
	
	
}
}
