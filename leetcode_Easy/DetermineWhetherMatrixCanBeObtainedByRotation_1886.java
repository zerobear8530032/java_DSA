//1886. Determine Whether Matrix Can Be Obtained By Rotation
//Solved
//Easy
//Topics
//Companies
//Hint
//Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.
//Example 1:
//Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
//Output: true
//Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.
//Example 2:
//Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
//Output: false
//Explanation: It is impossible to make mat equal to target by rotating mat.
//Example 3:
//Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
//Output: true
//Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.
//Constraints:
//n == mat.length == target.length
//n == mat[i].length == target[i].length
//1 <= n <= 10
//mat[i][j] and target[i][j] are either 0 or 1.
package leetcode_Easy;

public class DetermineWhetherMatrixCanBeObtainedByRotation_1886 {
//	approch : first create 2 function to check  wheather the matrix is equal to target and a method to rotate matrix: 
//	rotation: this will first transpose the entire matrix and then reverse every row ths will rotate the matrix by 90 degress
//	now the function will run a loop 3 times and check wheather the matrix is equal to target if yes it return true if not it will rotate matrix and check again once it check 4 times it will return false;
public	static boolean check(int [][] mat,int [][]target){
	        for(int i =0;i<mat.length;i++){
	            for(int j=0;j<mat[i].length;j++){
	                if(mat[i][j]!=target[i][j]){
	                    return false;
	                }
	            }
	        }
	        return true;
	    }

public	static 	    int [][] rotate(int [][] mat){
	    int rows=mat.length;
		int cols=mat[0].length;
		int [][] transposedmatrix= new int[cols][rows];
		for(int i =0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				transposedmatrix[j][i]=	mat[i][j];
			}
		}
	    for(int i =0;i<rows;i++){
	        int start=0;
	        int end=mat[i].length-1;
	        while(start<end){
	            int t =transposedmatrix[i][start];
	            transposedmatrix[i][start]=transposedmatrix[i][end];
	            transposedmatrix[i][end]=t;
	            start++;
	            end--;
	        }
	    }
		return transposedmatrix;

	    }
public	static  boolean findRotation(int[][] mat, int[][] target) {
	        boolean equal=false;
	        for(int i= 0;i<4;i++){
	         equal=check(mat,target);
	         if(equal){
	            break;
	         }
	            mat = rotate(mat);
	        }
	        return equal;
	    }
	
	public static void main(String[] args) {
		int [][]mat1 = {{0,1},{1,0}}, target1 = {{1,0},{0,1}};
		boolean output1= true;
		
		int [][] mat2 = {{0,1},{1,1}}, target2 = {{1,0},{0,1}};
		boolean output2= false;
		
		int[][] mat3 = {{0,0,0},{0,1,0},{1,1,1}}, target3 = {{1,1,1},{0,1,0},{0,0,0}};
		boolean output3= true;
		
		boolean ans1=findRotation(mat1, target1);
		boolean ans2=findRotation(mat2, target2);
		boolean ans3=findRotation(mat3, target3);
	
		if(ans1 == output1) {
			System.out.println("case 1 passed");
		}else {
			System.out.println("case 1 failed");
		}
		
		if(ans2 == output2) {
			System.out.println("case 2 passed");
		}else {
			System.out.println("case 2 failed");
		}
		
		if(ans3 == output3) {
			System.out.println("case 3 passed");
		}else {
			System.out.println("case 3 failed");
		}

	}

}
