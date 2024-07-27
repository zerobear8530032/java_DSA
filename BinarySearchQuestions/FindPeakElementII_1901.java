//1901. Find a Peak Element II
//Solved
//Medium
//Topics
//Companies
//Hint
//A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.
//
//Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].
//
//You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
//
//You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.
//
// 
//
//Example 1:
//
//Input: mat = [[1,4],[3,2]]
//Output: [0,1]
//Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.

//Example 2:
//
//Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
//Output: [1,1]
//Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
// 
//
//Constraints:
//
//m == mat.length
//n == mat[i].length
//1 <= m, n <= 500
//1 <= mat[i][j] <= 105
//No two adjacent cells are equal
package BinarySearchQuestions;

public class FindPeakElementII_1901 {
	    public static int[] findPeakGrid(int[][] mat) {
	        for(int [] rows :mat){
	            int peakindex =BinarySearch(rows);
	            System.out.println(rows[peakindex]);
	        }
	        return new int []{1,1};
	   }

	   public static int BinarySearch(int [] nums){
	    int start =0;
	    int end = nums.length-1;
	    if(nums.length == 2){
	        if(nums[start]>nums[end]){
	            return start;
	        }else{
	            return end;
	        }
	    }


	    while(start<end){
	        System.out.println("hello");
	        int mid = start+(end-start);
	        if(mid<end && nums[mid]<nums[mid+1]){
	            start=mid+1;
	        }else{
	            end=mid;
	        }
	    }
	    return start;
	   }
	
	public static void main(String[] args) {
	//Example 1:
	//
	int [][]mat1 = {{1,4},{3,2}};
	int []output1= {0,1};
	//Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.
	findPeakGrid(mat1);	
	//Example 2:
	//
	int [][]mat2 = {{10,20,15},{21,30,14},{7,16,32}};
	int []output2= {1,1};
	//Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
	//Output: [1,1]
	//Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
	
}
}
