//74. Search a 2D Matrix
//Solved
//Medium
//Topics
//Companies
//You are given an m x n integer matrix matrix with the following two properties:
//
//Each row is sorted in non-decreasing order.
//The first integer of each row is greater than the last integer of the previous row.
//Given an integer target, return true if target is in matrix or false otherwise.
//
//You must write a solution in O(log(m * n)) time complexity.
//
// 
//
//Example 1:
//
//
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
//Example 2:
//
//
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false
// 
//
//Constraints:
//
//m == matrix.length
//n == matrix[i].length
//1 <= m, n <= 100
//-104 <= matrix[i][j], target <= 104

package BinarySearchQuestions;

public class SearchIn2DMatrix_74 {
//	 brute force approch:
//	approch iterate over each index and return true if found else false;
//	time complexity : O(m*n)
	public static  boolean searchMatrixBruteForce(int[][] matrix, int target) {
//		iterate overr rows
		for(int i =0;i<matrix.length;i++) {
//			iterate over cols
			for(int j =0;j<matrix[i].length;j++) {
//				if found 
				if(matrix[i][j]==target) {
					return true;
				}
			}
			
		}
//		default false;
		return false;
	}
	
	
//	approch :Binary Search :
//	create a for loop to go through all the rows 
//	and apply binary search on each row if foud=nd return true else false
//	time complexity : O(log(m*n))
	public static  boolean searchMatrixOptimize(int[][] matrix, int target) {
        for (int i=0;i<matrix.length;i++){
//        	here is some optimization we can skip the row if its element is smaller then target becayse its give
//        	in contrain that row last element is smaller then next row first element
            if(target > matrix[i][matrix[i].length-1]){
                continue;
            }
            int searchres =BinarySearch(matrix[i],target);
            if(searchres>=0){
                return true;
            }
        }
        return false;
    }
    public static int BinarySearch(int [] nums,int target){
        int start =0;
        int end =nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(target == nums[mid]){
                return mid;
            }else if(target>nums[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
    
    

    
public static void main(String[] args) {
	
	//Example 1:
	//
	//
	int [][]matrix1 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
	int target1 = 3;
	boolean output1= true;
	if(output1==searchMatrixBruteForce(matrix1, target1)) {
		System.out.println("Case 1 Passed");
	}else {		
		System.out.println("Case 1 Failed");
	}
	
	//Example 2:
	//
	//
	int [][]matrix2 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
	int target2 = 13;
	boolean output2= false;
	//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
	if(output2==searchMatrixBruteForce(matrix2, target2)) {
		System.out.println("Case 2 Passed");
	}else {		
		System.out.println("Case 2 Failed");
	}
//optimized
	if(output1==searchMatrixOptimize(matrix1, target1)) {
		System.out.println("Case 1 Passed");
	}else {		
		System.out.println("Case 1 Failed");
	}
	if(output2==searchMatrixOptimize(matrix2, target2)) {
		System.out.println("Case 2 Passed");
	}else {		
		System.out.println("Case 2 Failed");
	}
}
}
