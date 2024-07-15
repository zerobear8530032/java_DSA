//Given an integer array nums, find the 
//subarray
// with the largest sum, and return its sum.
//Example 1:
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: The subarray [4,-1,2,1] has the largest sum 6.
//Example 2:
//Input: nums = [1]
//Output: 1
//Explanation: The subarray [1] has the largest sum 1.
//Example 3:
//Input: nums = [5,4,-1,7,8]
//Output: 23
//Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
//Constraints:
//1 <= nums.length <= 105
//-104 <= nums[i] <= 104
//Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

package leetcode_Easy;

import java.util.Arrays;

public class MaximumSubArray {
//	approch : best optimal solution how this works is we make the sum by suming all the element from index 0 to length if the sum ever get less then 0:
//	then we reset the sum because that all the numbers which we encounter are less then 0 and even if all the positive integer comes ahead will be sum to previous ones,
//	and each time we sum the numbers we will store the max sum to get the output :
//	time complexity O(n)
// space O(1)
	   public static int maxSubArray(int[] nums) {
	        int max =Integer.MIN_VALUE;
	        int sum =0;
	        for(int i =0;i<nums.length;i++){
	            sum=sum+nums[i];
	            if(sum>max){
	                max=sum;

	            }
	            if(sum<0){
	                sum=0;
	            }

	        }
	    return max;
	    }
//	 approch here is brute force here we will try to find out every possible sub array from the array and sum it and returnt the max sum
//	   very costly:
//	   time complexity O(n^3)
//space O(1)
public static int maxSubArrayBrute(int[] nums) {
		   int max =Integer.MIN_VALUE;
		   int sum =0;
		   for(int i =0;i<nums.length;i++) {
			   for(int j =i;j<nums.length;j++) {
				   sum =0;
				   for(int k=i;k<=j;k++) {
					   sum  =sum+nums[k];
				   }
				   if(sum>max) {
					   max=sum;
				   }
			   }
		   }
		  
		   return max;
	   }
//	  better brute force approch here we will iterate with nested loop aand sum the nums[i] and keep on summing untill it reach at last inndex :
// now the next iteration will be 1 step ahead of the previous one and next iteration again next step this and we keep the max sum of the array
// time complexity : o(n*n);
//space O(1)
public static int maxSubArraybetterBrute(int[] nums) {
	int max =Integer.MIN_VALUE;
	int sum =0;
	for(int i =0;i<nums.length;i++) {
		sum=0;
		for(int j =i;j<nums.length;j++) {
			sum =sum+nums[j];
			if(sum>max) {
				max=sum;
			}
		}
	}
	
	return max;
}

	   
	   
	   
public static void main(String[] args) {
	int n1[]= {-2,1,-3,4,-1,2,1,-5,4};
	int out1=6;
	int n2[]= {1};
	int out2=1;
	int n3[]= {5,4,-1,7,8};
	int out3=23;
	
	int case1=maxSubArray(n1);
	int case2=maxSubArray(n2);
	int case3=maxSubArray(n3);
	
	if(case1==out1) {
		System.out.println("case 1 passed");
	}else {
		System.out.println("case 1 failed");		
	}
	
	if(case2==out2) {
		System.out.println("case 2 passed");
	}else {
		System.out.println("case 2 failed");		
	}
	
	if(case3==out3) {
		System.out.println("case 3 passed");
	}else {
		System.out.println("case 3 failed");		
	}
//	not optimmal at all:
//	System.out.println("n1 :"+Arrays.toString(n1));			
//	System.out.println("ans 1 :"+maxSubArrayBrute(n1));
//	System.out.println("n2 :"+Arrays.toString(n2));			
//	System.out.println("ans 2 :"+maxSubArrayBrute(n2));
//	System.out.println("n3 :"+Arrays.toString(n3));			
//	System.out.println("ans 3 :"+maxSubArrayBrute(n3));
	
//	better then previous bruute force
	System.out.println("n1 :"+Arrays.toString(n1));			
	System.out.println("ans 1 :"+maxSubArraybetterBrute(n1));
	System.out.println("n2 :"+Arrays.toString(n2));			
	System.out.println("ans 2 :"+maxSubArraybetterBrute(n2));
	System.out.println("n3 :"+Arrays.toString(n3));			
	System.out.println("ans 3 :"+maxSubArraybetterBrute(n3));
	
	
}

}
