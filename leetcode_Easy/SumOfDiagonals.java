//Given a square matrix mat, return the sum of the matrix diagonals.
//
//Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.
//
// 
//
//Example 1:
//
//
//Input: mat = [[1,2,3],
//              [4,5,6],
//              [7,8,9]]
//Output: 25
//Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
//Notice that element mat[1][1] = 5 is counted only once.
//Example 2:
//
//Input: mat = [[1,1,1,1],
//              [1,1,1,1],
//              [1,1,1,1],
//              [1,1,1,1]]
//Output: 8
//Example 3:
//
//Input: mat = [[5]]
//Output: 5
// 
//
//Constraints:
//
//n == mat.length == mat[i].length
//1 <= n <= 100
//1 <= mat[i][j] <= 100
//

package leetcode_Easy;

import java.util.Arrays;

public class SumOfDiagonals {
//	approch used take length of the input array mat now with our understanding of problem we can say that for diagonals to be taken
//	the input matrix will always be squared 
//	so we only took one length
//	now we need to traverse the diagonals so  i =0 which will traverse the diagonal in a left to right order
//	and j=l-1 to get the right corner of the matrix and we traverse the diagonals now we dont need to include the intersection point in both diagonals so we can esily terimante it by sum it up once when i ==j 
	
	public static int diagonalSum(int[][] mat) {
		int sum =0;
//		traverse first diagranal:
		
		int l =mat.length;
		int i =0;
		int j=l-1;
		
		while(i<l && j>=0) {
			if(i==j) {
				sum=sum+mat[i][i];
				i++;
				j--;
				continue;
			}
			
			sum=sum+mat[i][i];
			sum=sum+mat[j][l-j-1];
			i++;
			j--;
		}
		return sum;
    }
	public static void main(String args[]) {
		
		int [][] mat1 = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		int [][] mat2 = {
				{1,1,1,1},
				{1,1,1,1},
				{1,1,1,1},
				{1,1,1,1}
		};
		int [][] mat3 = {
				{5}
		};
		int [][] mat4 = {
				{7,3,1,9},
				{3,4,6,9},
				{6,9,6,6},
				{9,5,8,5}
				};
		int case1 =diagonalSum(mat1);		
		int case2=diagonalSum(mat2);
		int case3=diagonalSum(mat3);
		
		if(case1==25) {
			System.out.println("case 1 passed");
		}else {
			System.out.println("case 1 failed");
			System.out.println("output :"+case1);
			
		}
		
		if(case2==8) {
			System.out.println("case 2 passed");
		}else {
			System.out.println("case 2 failed");
			System.out.println("output :"+case2);
		}
		
		if(case3==5) {
			System.out.println("case 3 passed");
		}else {
			System.out.println("case 3 failed");			
			System.out.println("output :"+case3);
		}
		int case4=diagonalSum(mat4);
		if(case4==55) {
			System.out.println("case 4 passed");
		}else {
			System.out.println("case 4 failed");			
			System.out.println("output :"+case4);
		}
		
		
	}
}
