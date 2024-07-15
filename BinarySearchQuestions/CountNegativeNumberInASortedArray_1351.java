//1351. Count Negative Numbers in a Sorted Matrix
//Solved
//Easy
//Topics
//Companies
//Hint
//Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
//Example 1:
//Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
//Output: 8
//Explanation: There are 8 negatives number in the matrix.

//Example 2:
//Input: grid = [[3,2],[1,0]]
//Output: 0
//Constraints:
//
//m == grid.length
//n == grid[i].length
//1 <= m, n <= 100
//-100 <= grid[i][j] <= 100
// 
//
//Follow up: Could you find an O(n + m) solution?
package BinarySearchQuestions;

public class CountNegativeNumberInASortedArray_1351 {
//	simple binary search on  each array of the grid 
//	first we iterate over all the rows and at each row we apply binary search to find the first negetive element 
//	because we know if we found first negetive element we can say the entire right side of that array will be also negative because the array is descendinng sorted
//	if we see arr[mid]> 0 {s=mid+1}
//	if we see arr[mid]< 0 {e=mid-1}
//	when the binary search will terminate the start willl be greater then end :
//	and start index will be having the first index of negetive elements
//	from that we also know end = start -1 
//	so we can do end - arr.length to find all the negetive elemet and sum them at
//	we will repeat this step nummber of rows time and returnt the sum 
//	timeComplexity : O(m*log N) here m = nnumber of rows , n = number of columns in 
    public static int countNegatives(int[][] grid) {
        int negelement =0;
        for(int [] arr : grid){
            int s =0;
            int e =arr.length-1;

            while(s<=e){
                int mid =s+(e-s)/2;
                if(arr[mid]>=0){
                    s=mid+1;
                }else{
                    e=mid-1;
                }
            }

            // negelement =negelement + arr.length-(s+1);
            negelement=negelement+arr.length-s;
        }  
        return negelement;
    }
    public static void main(String[] args) {
    	//Example 1:
    	int [][]grid1 = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};    	
    	int output1= 8;
    	
    	
    	
    	//Explanation: There are 8 negatives number in the matrix.
    	if(countNegatives(grid1)==output1) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Passed");
    	}
    	
		//Example 2:
    	int [][]grid2 = {{3,2},{1,0}};    	
    	int output2=0 ;
    	if(countNegatives(grid2)==output2) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Passed");
    	}
    	
    
		
	}
}
