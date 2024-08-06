//You are given an array consisting of n integers which denote the position of a stall. You are also given an integer k which denotes the number of aggressive cows. You are given the task of assigning stalls to k cows such that the minimum distance between any two of them is the maximum possible.
//The first line of input contains two space-separated integers n and k.
//The second line contains n space-separated integers denoting the position of the stalls.
//
//Example 1:
//
//Input:
//n=5 
//k=3
//stalls = [1 2 4 8 9]
//Output:
//3
//Explanation:
//The first cow can be placed at stalls[0], 
//the second cow can be placed at stalls[2] and 
//the third cow can be placed at stalls[3]. 
//The minimum distance between cows, in this case, is 3, 
//which also is the largest among all possible ways.
//Example 2:
//
//Input:
//n=5 
//k=3
//stalls = [10 1 2 7 5]
//Output:
//4
//Explanation:
//The first cow can be placed at stalls[0],
//the second cow can be placed at stalls[1] and
//the third cow can be placed at stalls[4].
//The minimum distance between cows, in this case, is 4,
//which also is the largest among all possible ways.
//Your Task:
//Complete the function int solve(), which takes integer n, k, and a vector stalls with n integers as input and returns the largest possible minimum distance between cows.
//
//Expected Time Complexity: O(n*log(10^9)).
//Expected Auxiliary Space: O(1).
//
//Constraints:
//2 <= n <= 10^5
//2 <= k <= n
//0 <= stalls[i] <= 10^9

package BinarySearchQuestions;
import java.util.*;
public class AggressiveCows {
//	time commplexity : O(N log n )
//	approch simply apply binary search and from start till max of stall :
//	and check wheather there is possible to place cows or not 
	public static int solve(int n, int k, int[] stalls) {
	        Arrays.sort(stalls);
	        int start  = 1;
	        int end = stalls[stalls.length-1];
	        while(start<=end){
	            int mid =start+(end-start)/2;
	            if(canplacecows(stalls,mid,k)){
	                start = mid+1;
	            }else{
	               
	                end= mid-1;
	            }
	        }
	        return end;
	    }
	    public static boolean canplacecows(int [] stalls,int mindistance,int cows ){
	        int cowplaced = 1;
	        int lastplaced = stalls[0];
	        for(int i =1;i<stalls.length;i++){
	            if(stalls[i]-lastplaced>=mindistance ){
	                cowplaced++;
	                lastplaced=stalls[i];
	            }
	            if(cowplaced>= cows){return true;}
	        }
	        return false;
	    }
	    
public static void main(String[] args) {
	//Example 1:
	//Input:
	int k1=3;
	int []stalls1 = {1 ,2 ,4 ,8 ,9};
	int n1=stalls1.length; 
	int output1=3;
	//Explanation:
	//The first cow can be placed at stalls[0], 
	//the second cow can be placed at stalls[2] and 
	//the third cow can be placed at stalls[3]. 
	//The minimum distance between cows, in this case, is 3, 
	//which also is the largest among all possible ways.
	
	if(solve(n1, k1, stalls1)==output1) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}

	//Example 2:
	int k2=3;
	int []stalls2 = {10,1,2,7,5};
	int n2=stalls1.length; 
	int output2=4;
	
	//Explanation:
	//The first cow can be placed at stalls[0],
	//the second cow can be placed at stalls[1] and
	//the third cow can be placed at stalls[4].
	//The minimum distance between cows, in this case, is 4,
	//which also is the largest among all possible ways.
	if(solve(n2, k2, stalls2)== output2) {
	System.out.println("Case 2 Passed");	
	}else {
		System.out.println("Case 2 Failed");			
	}	
}
}
