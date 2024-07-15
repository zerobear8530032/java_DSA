package leetcode_Easy;
import java.util.*;;
public class MatrixTranspose {
static	void display(int [][] mat) {
		for(int i =0;i<mat.length;i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
	}
//approch: create a new matrix where  with size n* m where input is m*n
// now traverse the  input matrix as usuall while asigning the j,i of transpose the value of i,j;
// the output will be transpose of the matrix:
static int [][] transpose(int [][] mat) {
	int rows=mat.length;
	int cols=mat[0].length;
	int [][] transposedmatrix= new int[cols][rows];
	for(int i =0;i<rows;i++) {
		for(int j=0;j<cols;j++) {
			transposedmatrix[j][i]=	mat[i][j];
		}
	}
	return transposedmatrix;
}

public static void main(String[] args) {
	int matrix1[][] = {
			{0,1},
			{1,0},
	};
	int matrix2[][] = {
			{1,2},
			{3,4},
			{5,6}
	};
	System.out.println("matrix 1 :");
	display(matrix1);
	System.out.println("transposed of matrix 1 :");
	int[][] mat1=transpose(matrix1);
	display(mat1);
	
	System.out.println("matrix 2 :");	
	display(matrix2);
	System.out.println("transposed of matrix 2 :");
	int [][] mat2=transpose(matrix2);
	display(mat2);
}
}
