//441. Arranging Coins
//Solved
//Easy
//Topics
//Companies
//You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.
//
//Given the integer n, return the number of complete rows of the staircase you will build.
//
// 
//
//Example 1:
//Input: n = 5
//Output: 2
//Explanation: Because the 3rd row is incomplete, we return 2.
//Example 2:
//
//
//Input: n = 8
//Output: 3
//Explanation: Because the 4th row is incomplete, we return 3.
// 
//
//Constraints:
//
//1 <= n <= 231 - 1
package BinarySearchQuestions;

public class ArrangingCoins_441 {
//	here we apply simple repeated substraction from n until it reaches 0 or less 
//	this will take O(n) time complexity:
//	where n is number of r=possible rows 
	  public int arrangeCoinsBruteForce(int n) {
	        int row =0;
	        
	        for(int i =0;i<=n;i++){
	            if(n<=0){
	            break;
	            }
	            n=n-i;
	            row++;
	        }
	    return row-1;
	    }
	  
//	  here we use binary seach :
//	  there is formula which allow us to find the sumition of consicutive integers which is k(k+1)/2:
//	  this formula allow us to find the sumition of k consicutive numbers
//	  now we apply binary search form 0 to n and check which mid value satisfy 
//	  case1 : mid(mid+1)/2 ==n : {return mid}-> means all coins are places in a row
//	  case2 : mid(mid+1)/2 < n :{s=mid+1}-> means there are some coins left to place but row are less
//	  case3 : mid(mid+1)/2 > n :{e=mid-1}-> means there are some place left in row but coins are ended
//	  simple term we apply mid(mid+1)/2 formula and check which k value equal to n 
//	  if none satisfy we will return the end 
//	  because when a row is not full we does not count it  
	public static int arrangeCoinsOptimize(int n) {
	       int s =0;
	       int e =n;
	       while(s<=e){
	        int mid =s+(e-s)/2;
	        long coins=(long)mid*(mid+1)/2;
	        if(coins==n){
	            return mid;
	        }else if(coins<n){
	            s=mid+1;
	        }else{
	            e=mid-1;
	        }
	       }
	       return e;
	    }
	
	
	
public static void main(String[] args) {
	
//Example 1:
int n1 = 5;
int output1= 2;
//Explanation: Because the 3rd row is incomplete, we return 2.
//Example 2:
//
//
int n2 = 8;
int output2= 3;
//Explanation: Because the 4th row is incomplete, we return 3.
}
}
