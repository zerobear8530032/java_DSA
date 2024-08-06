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
//	approch is simple we determine the mid of all column and find the max element iof that column:\
//	now we will chcek max of that col is peak if yes return 
//	if max < left element end=mid-1
//	if max < right element start=mid+1;
//	time complexity O(log (m)*n)
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
	
	       public static int[] findPeakGridOptimize(int[][] mat) {
		     int start = 0;
		     int n =mat.length; 
		     int end = mat[start].length-1;
		     int m =end+1; 
		     while(start<=end){
		        int mid = start+(end-start)/2;
		        int row = getmaxincolumns(mat,n,m,mid);
		        int left = mid-1>=0 ? left=mat[row][mid-1]:-1;
		        int right = mid+1<m ? right=mat[row][mid+1]:-1;
		        if(mat[row][mid]>left && mat[row][mid]>right){
		            return new int []{row,mid};
		        }else if(left>mat[row][mid]){
		            end=mid-1;
		        }else{
		            start=mid+1;
		        }
		        
		     }
		        return new int []{-1,-1};
		    }
		    public static int getmaxincolumns(int [][] mat, int numr,int numc,int col){
		        int index =0;
		        int max =0;
		        for(int i =0;i<mat.length;i++){
		            if(max<mat[i][col]){
		                max=mat[i][col];
		                index=i;
		            }
		        }
		        return index;
		    }
	public static boolean check( int [] ans,int out[]) {
		if(out.length!=ans.length) {
			return false;
		}
		for(int i =0;i<ans.length;i++) {
			if(ans[i]!=out[i]) {
				return false;
			}
		}
		return true;
	}
	   
	public static void main(String[] args) {
	//Example 1:
	//
	int [][]mat1 = {{1,4},{3,2}};
	int []output1= {0,1};
	//Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.
	int ans1 []=findPeakGrid(mat1);	
	//Example 2:
	if(check(ans1, output1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	//
	int [][]mat2 = {{10,20,15},{21,30,14},{7,16,32}};
	int []output2= {1,1};
	//Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
	//Output: [1,1]
	//Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
	int ans2 []=findPeakGrid(mat2);
	if(check(ans2, output2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	
	ans1=findPeakGridOptimize(mat1);
	ans2=findPeakGridOptimize(mat2);
	if(check(ans1, output1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	if(check(ans2, output2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	
	
	
	
}
}
