//1. Two Sum
//Solved
//Easy
//Topics
//Companies
//Hint
//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.
//Example 1:
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//Example 2:
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//Example 3:
//Input: nums = [3,3], target = 6
//Output: [0,1]
//Constraints:
//2 <= nums.length <= 104
//-109 <= nums[i] <= 109
//-109 <= target <= 109
//Only one valid answer exists.
//Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

package leetcode_Easy;
import java.util.*;
public class TwoSum_1 {
	public static int[] twoSum(int[] nums, int target) {
	    HashMap <Integer,Integer> map = new HashMap();
	    for(int i =0;i<nums.length;i++){
	        int sub=target-nums[i];
	        if(map.containsKey(sub)){
	            return new int[]{map.get(sub),i};
	        }else{
	            map.put(nums[i],i);
	        }
	    }
	    return null;
	    }
	static 	boolean   check(int ans[],int[] org) {
		for(int i =0;i<ans.length;i++) {
			if(ans[i]!=org[i]) {
				return false;
			}
		}
		return true;
	}
	
	
public static void main(String args[]) {
	
	int []nums1 = {2,7,11,15}; 
	int	target1 = 9;
	int [] ans1 = {0,1};
	
	int []nums2 = {3,2,4}; 
	int	target2 = 6;
	int [] ans2 = {1,2};
	
	int []nums3 = {3,3}; 
	int	target3 = 6;
	int [] ans3 = {0,1};
	
	int []case1=twoSum(nums1,target1);
	
	int []case2=twoSum(nums2,target2);
	
	int []case3=twoSum(nums3,target3);
	
	if(check(case1,ans1)) {
		System.out.println("Case1 accepted");
	}else {
		System.out.println("Case1 faileded");		
	}
	
	if(check(case2,ans2)) {
		System.out.println("Case2 accepted");
	}else {
		System.out.println("Case2 faileded");		
	}
	
	if(check(case3,ans3)) {
		System.out.println("Case3 accepted");
	}else {
		System.out.println("Case3 faileded");		
	}	
}

}

