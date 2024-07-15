//73. Set Matrix Zeroes
//Medium
//Topics
//Hint
//Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
//You must do it in place.
//Example 1:
//Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//Output: [[1,0,1],[0,0,0],[1,0,1]]

//Example 2:
//Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
//Constraints:
//m == matrix.length
//n == matrix[0].length
//1 <= m, n <= 200
//-231 <= matrix[i][j] <= 231 - 1
//Follow up:
//A straightforward solution using O(mn) space is probably a bad idea.

//A simple improvement uses O(m + n) space, but still not the best solution.

//Could you devise a constant space solution?
package leetcode_Medium;

import java.util.Arrays;
import java.util.LinkedList;

public class Set_Matrix_Zero_73 {
//	brute force approch here :
//	i created a simple function which will put the matrixx row and col to zero :
//	the function setRowColsToZero:
//	for rows we just create a new row of same length  and assign to the row 
//	this is done in o(1) time complexity 
//	but o(n) space complexity
//  now we need to find the 0 appear in which row and col which is done in the main functiom setZeroes()
//	this will have a list which will contain  the x,y index of 0 appear in the matrix now
//	now we can iterate the list and at row and col set to zero with above function 
//	time complexity : 
//	O(m * n) + k * O(m + n)
//	In the worst case, k could be up to m * n (if the entire matrix is zeros), 
//	so the worst-case time complexity can be as bad as O((m * n) * (m + n)).
	
	static void setRowColsToZero(int [][] matrix,int r,int c) {
//		put rows to zero
		matrix[r]= new int [matrix[r].length];
//		put col to zero :
		for(int i =0;i<matrix.length;i++) {
			matrix[i][c]=0;
		}
		
		
	}
	
public static  void setZeroesBrute(int[][] matrix) {
	LinkedList<int [] > index= new LinkedList();

       for(int rows =0;rows<matrix.length;rows++) {
    	   for(int cols =0;cols<matrix[rows].length;cols++) {
    		   if(matrix[rows][cols]==0) {
    			   index.add(new int [] {rows,cols});
    		   }
    	   }	   
       }
       
       for(int i =0;i<index.size();i++) {
    	setRowColsToZero(matrix,index.get(i)[0],index.get(i)[1]);
       }
    }
//optimal solution:
//	here we created 2 array type boolean row , col which are same length of the matrix row and cols 
// now we iterate the entire matrix and where we found the 0 
//we will intialzie to true at row index of rows array 
//we will intialzie to true at col index of cols array 
// now we will start a second pass where we will iterate again is same way just have a simple condition :
// if(rows[row]|| cols[col]){
// matrix[row][col]=0;
//}
// this will complete the work:
//time complexity :
//O(m * n) + O(m * n)
//Simplifies to O(m * n).
// space comeplexity O(m+n)
public static void setZeroesOptimal(int [][] matrix) {
	boolean []rows = new boolean [matrix.length];
	boolean []cols = new boolean [matrix[0].length];
//	first pass
	for(int row=0;row<matrix.length;row++) {
		for(int col=0;col<matrix[row].length;col++) {
			if(matrix[row][col]==0) {
				rows[row]=true;
				cols[col]=true;
			}
		}	
	}
//	second pass:
	for(int row=0;row<matrix.length;row++) {
		for(int col=0;col<matrix[row].length;col++) {
			if(rows[row]|| cols[col]) {
				matrix[row][col]=0;
			}
		}	
	}
	
	
}
	
public static void main(String args[]) {
//	brute force 
	System.out.println("brute force");
	int [][]matrix1 = {
			{1,1,1},
			{1,0,1},
			{1,1,1}
	};
	System.out.println("Matrix 1");
	setZeroesBrute(matrix1);
	for(int i =0;i<matrix1.length;i++) {
		System.out.println(Arrays.toString(matrix1[i]));
	}
	
	
	int [][]matrix2 = {
			{0,1,2,0},
			{3,4,5,2},
			{1,3,1,5}
			};
	System.out.println("Matrix 2");
	setZeroesBrute(matrix2);
	for(int i =0;i<matrix2.length;i++) {
		System.out.println(Arrays.toString(matrix2[i]));
	}
//	Optimal :
	System.out.println("optimal");
	int [][]matrix3 = {
			{1,1,1},
			{1,0,1},
			{1,1,1}
	};
	System.out.println("Matrix 1");
	setZeroesOptimal(matrix3);
	for(int i =0;i<matrix3.length;i++) {
		System.out.println(Arrays.toString(matrix3[i]));
	}
	
	
	int [][]matrix4 = {
			{0,1,2,0},
			{3,4,5,2},
			{1,3,1,5}
			};
	System.out.println("Matrix 2");
	setZeroesOptimal(matrix4);
	for(int i =0;i<matrix4.length;i++) {
		System.out.println(Arrays.toString(matrix4[i]));
	}
	
	
	
}
}
