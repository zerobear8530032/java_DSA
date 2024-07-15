//59. Spiral Matrix II
//Solved
//Medium
//Topics
//Companies
//Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
//Example 1:
//Input: n = 3
//Output: [[1,2,3],[8,9,4],[7,6,5]]
//Example 2:
//Input: n = 1
//Output: [[1]]
//Constraints:
//1 <= n <= 20
package leetcode_Medium;

public class SpiralMatrix_2_59 {
//	approch is similar to spiral matrix only thinng change is a new element e which will increment each loop iteration and put e value while traversing the matrix
	
    public int[][] generateMatrix(int n) {
        int mat[][] = new int [n][n];
      int top=0;
      int bottom = mat.length;
      int left =0;
      int right=mat[0].length;
      int e=1;
      while(top<bottom && left <right){
// top row:

for(int i =left;i<right;i++){
    mat[top][i]=e;
    e++;
}
top++;
System.out.println(top+" "+bottom+" "+left+" "+right);
// right column:
for(int i =top;i<bottom;i++){
    mat[i][right-1]=e;
    e++;
}
right--;
System.out.println(top+" "+bottom+" "+left+" "+right);
if(!(top<bottom && left <right)){
    break;
}

// bottom row:
for(int i =right-1;i>left-1;i--){
    mat[bottom-1][i]=e;
    e++;
}
bottom--;
System.out.println(top+" "+bottom+" "+left+" "+right);
// left column:
for(int i =bottom-1;i>=top;i--){
    mat[i][left]=e;
    e++;
}
left++;
System.out.println(top+" "+bottom+" "+left+" "+right);

      }
return mat;
    }
public static void main  (String args[]) {
	
}
}
