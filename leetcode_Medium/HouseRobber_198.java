//198. House Robber
//Medium
//Companies
//You are a professional robber planning to rob houses along a street. 
//Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent 
//houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on 
//the same night.
//Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
//Example 1:
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
//Example 2:
//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//Total amount you can rob = 2 + 9 + 1 = 12.
//Constraints:
//1 <= nums.length <= 100
//0 <= nums[i] <= 400
package leetcode_Medium;

public class HouseRobber_198 {
	 public static int rob(int[] nums) {
	        int l =nums.length;
	        int max=0;
	        for(int i =0;i<l;i++){
	        	
	            for(int j=i+2;j<l;j++){
	            	System.out.print(i+" "+j+" ");
	            	if(max<(nums[i]+nums[j])) {
	            		max=nums[i]+nums[j];
	            		i=j;
	            	}
	            }
	      
	            System.out.println();
	        }
	        return max;
	    }
	public static void main(String args[]) {
//Example 1:
int []nums1 = {1,2,3,1};
int output1= 4;
//Example 2:
int [] nums2 = {2,7,9,3,1};
int output2= 12;

//Example 3:
int [] nums3 = {1,2};
int output3= 2;

int [] nums4 = {2,1,1,2};
int output4= 4;
	System.out.println("Answer "+rob(nums1));
	System.out.println("Answer "+rob(nums2));
	System.out.println("Answer "+rob(nums3));
	System.out.println("Answer "+rob(nums4));
	}

	
}
