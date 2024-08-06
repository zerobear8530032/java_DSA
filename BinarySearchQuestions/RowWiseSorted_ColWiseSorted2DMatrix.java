package BinarySearchQuestions;
import java.util.*;
public class RowWiseSorted_ColWiseSorted2DMatrix {
	public static int[] search(int [][] mat,int target) {
		int r= 0;
		int c=mat[r].length-1;
		while(r<mat.length && c>=0) {
			if(target==mat[r][c]) {
				return new int [] {r,c};
			}else if(target<mat[r][c]) {
				c--;
			}else {
				r++;
			}
		}
		return new int [] {-1,-1};
	}
	public static void main(String[] args) {
	int [][] mat1 = {{10,20,30,40},
					{15,25,35,45},
					{28,29,37,49},
					{33,34,38,50}};
	int target1=45;
	System.out.println(Arrays.toString(search(mat1, target1)));
	
	int [][] mat2 = {{10,20,30,40},
			{15,25,35,45},
			{28,29,37,49},
			{33,34,38,50}};
	int target2=50;
	System.out.println(Arrays.toString(search(mat2, target2)));
	
	
}
}
