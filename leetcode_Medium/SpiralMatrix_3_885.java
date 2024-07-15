//885. Spiral Matrix III
//Solved
//Medium
//Companies
//You start at the cell (rStart, cStart) of an rows x cols grid facing east. The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.
//You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.). Eventually, we reach all rows * cols spaces of the grid.
//Return an array of coordinates representing the positions of the grid in the order you visited them.
//Example 1:
//Input: rows = 1, cols = 4, rStart = 0, cStart = 0
//Output: [[0,0],[0,1],[0,2],[0,3]]
//Example 2:
//Input: rows = 5, cols = 6, rStart = 1, cStart = 4
//Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
//Constraints:
//1 <= rows, cols <= 100
//0 <= rStart < rows
//0 <= cStart < cols
package leetcode_Medium;

import java.util.*;
public class SpiralMatrix_3_885 {
	
	public static LinkedList <int []> spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
//		int [][] ans = new int [rows*cols][2];
		LinkedList<int []>list = new LinkedList();
		int top=rStart;
		int bottom=rStart+1;
		int left =cStart;
		int right =cStart+1;
		int r =0;
		while(r<rows*cols) {
			right++;
//			top row :
			for(int i =left;i<right-1;i++) {
				System.out.println("top row");
				if(top>0 && i<cols ) {
					list.add(new int []{top,i});					
					r++;					
				}else {
					break;
				}
			}
			for(int [] e: list) {
				System.out.print(Arrays.toString(e)+" ");
			}
			System.out.println();
//			right col:
			bottom++;
			for(int i =top;i<bottom-1;i++) {
				System.out.println("right col"+top+" "+(bottom-1));
				if(i<rows  && right-1<cols) {
					list.add(new int []{i,right-1}); 				
					r++;
				}else {
					break;
				}
			}
			for(int [] e: list) {
				System.out.print(Arrays.toString(e)+" ");
			}
			System.out.println();
//			bottom row:
			left--;
			for(int i =right-1;i>=left;i--) {
				System.out.println("bottom row");
				if(bottom-1<rows && i>=0) {
					list.add(new int [] {bottom-1,i});
					r++;
				}else {
					break;
				}
				
			}
			for(int [] e: list) {
				System.out.print(Arrays.toString(e)+" ");
			}
			System.out.println();
			top--;
//			left col :
			for(int i =bottom-1;i>=top;i--) {
				System.out.println("left col");
				if(left>=0 && i>=0) {
					list.add(new int [] {left,i});
					r++;
				}else {
					break;
				}
			}
			left--;
			
			for(int [] e: list) {
				System.out.print(Arrays.toString(e)+" ");
			}
			System.out.println();
		
			
		}
		System.out.print(r);
		return list;
    
    }
	
	
public static void main(String args[]) {
	int rows1 = 1, cols1 = 4, rStart1 = 0, cStart1 = 0;
	
	LinkedList <int []> ans1 =spiralMatrixIII(rows1, cols1, rStart1, cStart1);

//	for(int [] e: ans1) {
//		System.out.println(Arrays.toString(e));
//	}
	
	int rows2 = 5, cols2 = 6, rStart2 = 1, cStart2 = 4;
		
}
}
