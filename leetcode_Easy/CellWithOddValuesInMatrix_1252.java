//
//There is an m x n matrix that is initialized to all 0's. There is also a 2D array indices where each indices[i] = [ri, ci] represents a 0-indexed location to perform some increment operations on the matrix.
//
//For each location indices[i], do both of the following:
//
//Increment all the cells on row ri.
//Increment all the cells on column ci.
//Given m, n, and indices, return the number of odd-valued cells in the matrix after applying the increment to all locations in indices.
//
// 
//
//Example 1:
//
//
//Input: m = 2, n = 3, indices = [[0,1],[1,1]]
//Output: 6
//Explanation: Initial matrix = [[0,0,0],[0,0,0]].
//After applying first increment it becomes [[1,2,1],[0,1,0]].
//The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.
//Example 2:
//
//
//Input: m = 2, n = 2, indices = [[1,1],[0,0]]
//Output: 0
//Explanation: Final matrix = [[2,2],[2,2]]. There are no odd numbers in the final matrix.
// 
//
//Constraints:
//
//1 <= m, n <= 50
//1 <= indices.length <= 100
//0 <= ri < m
//0 <= ci < n
// 
//
//Follow up: Could you solve this in O(n + m + indices.length) time with only O(n + m) extra space?
//
//
//Seen this question in a real interview before?
//1/5




//  approched used here i created 2 functions incremetrows(int [][] mat,int index),incrementcols(int [][] mat,int index)
// now we iterate over input array indices and create an array ans where will increment the matrix as given in the question we have indices which is a 2D array where 
//each row is a increment operation and each column such that col0 = row increment and col 1= column increment now these 2 parameter are passed u=iin our functions
// once entire increment is happened we only need to count the number off odd values peresent in the ans matrix and return its count
package leetcode_Easy;
import java.util.*;
class solution{
 void incrementrow(int[][] matrix ,int index){
	 for(int row =0;row<matrix[index].length;row++) {
		 matrix[index][row]=matrix[index][row]+1;
	 }

    }
 void incrementcol(int[][] matrix ,int index){
	 for(int col =0;col<matrix.length;col++) {
		 matrix[col][index]=matrix[col][index]+1;
	 }
	 
 }



    public int oddCells(int m, int n, int[][] indices) {
        int ans [][] = new int [m][n];
        for(int i =0;i<indices.length;i++){
            System.out.print(indices[i][0]);
            System.out.println(indices[i][1]);
            incrementrow(ans,indices[i][0]);
            incrementcol(ans,indices[i][1]);
        }
        for(int i=0;i<ans.length;i++) {
        	System.out.println("after increment"+Arrays.toString(ans[i]));
        }
        int c=0;
        for(int rows =0;rows<ans.length;rows++) {
        	for(int cols=0;cols<ans[rows].length;cols++) {
        		if(ans[rows][cols]%2!=0) {
        		c++;	
        		}
        	}
        	
        }

        return c;
    }
}


public class CellWithOddValuesInMatrix_1252 {
public static void main(String[] args) {
	solution s = new solution();
	int m=2;
	int n=3;
	
	int indices [][]= {
			{0,1},
			{1,1}
			};
System.out.println(	s.oddCells(m, n,indices));
	
}
}
