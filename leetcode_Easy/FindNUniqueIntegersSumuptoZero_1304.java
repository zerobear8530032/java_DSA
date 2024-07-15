//Given an integer n, return any array containing n unique integers such that they add up to 0.
//Example 1:
//Input: n = 5
//Output: [-7,-1,1,3,4]
//Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
//Example 2:
//Input: n = 3
//Output: [-1,0,1]
//Example 3:
//Input: n = 1
//Output: [0]
//Constraints:
//1 <= n <= 1000

package leetcode_Easy;
import java.util.*;
public class FindNUniqueIntegersSumuptoZero_1304 {
//	approch brute force : 
//	here we initialize the array of input length n now we will insert the half array with positive numbers and half with negetive numbers this will always return true:
//	here if n =5 :
//	our array can be [-2,-1,0,1,2] sum of the array =0
	public static int[] sumZero(int n) {
	        int ans[]=new int[n];
	        int start=0;
	        int end =n-1;
	        int mid =n/2;
	        while(start<end){
	            ans[start]=mid;
	            ans[end]=mid*-1;
	            start++;
	            end--;
	            mid--;
	        }
	return ans;
	    }	
	   
	   static int sumarray(int [] arr) {
		   int s =0;
		   for(int i =0;i<arr.length;i++) {
			   s=s+arr[i];
		   }
		   return s;
	   }
public static void main(String args[]) {
	int input1  = 5;
	int input2 = 3;
	int input3=1;
	
	int [] ans1=sumZero(input1);
	int [] ans2=sumZero(input2);
	int [] ans3=sumZero(input3);
	
	if(sumarray(ans1)==0) {
		System.out.println("case 1 passed");		
	}else {
		System.out.println("case 1 failed");				
	}
	
	if(sumarray(ans2)==0) {
		System.out.println("case 2 passed");		
	}else {
		System.out.println("case 2 failed");				
	}
	
	if(sumarray(ans3)==0) {
		System.out.println("case 3 passed");
	}else {
		System.out.println("case 3 failed");		
	}
	
}
}
