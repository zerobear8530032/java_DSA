//287. Find the Duplicate Number
//Solved
//Medium
//Topics
//Companies
//Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//
//There is only one repeated number in nums, return this repeated number.
//
//You must solve the problem without modifying the array nums and uses only constant extra space.
//
//Example 1:
//
//Input: nums = [1,3,4,2,2]
//Output: 2
//Example 2:
//
//Input: nums = [3,1,3,4,2]
//Output: 3
//Example 3:
//
//Input: nums = [3,3,3,3,3]
//Output: 3
// 
//
//Constraints:
//
//1 <= n <= 105
//nums.length == n + 1
//1 <= nums[i] <= n
//All the integers in nums appear only once except for precisely one integer which appears two or more times.
// 
//

//*******************************************************************************************
// note : this problem is solved using binary search and other approch list in the binary search 
// packages 
//*******************************************************************************************

//Follow up:
//
//How can we prove that at least one duplicate number must exist in nums?
//Can you solve the problem in linear runtime complexity?

package Sorting_Questions;

public class FindDuplicateNumber_287 {
	
//	here we APPLY CYCLIC SORT  and at last every number will be at its possition just one number which is repeating will be not its position
//	the comtraim is broken but it is for practice     
	public static int findDuplicate(int[] nums) {
	        int index =0;
	        while(index<nums.length){
	            int correct = nums[index]-1;
	            if(nums[correct]!=nums[index]){
	                // swap :
	                int temp=nums[correct];
	                nums[correct]=nums[index];
	                nums[index]=temp;
	            }else{
	                if( correct!=index){
	                    return nums[correct];
	                }
	                index++;

	            }
	        }
	return -1;
	    }
	
public static void main(String[] args) {
	//Example 1:
	//
	int [] nums1 = {1,3,4,2,2};
	int output1=2;
	
	//Example 2:
	//
	
	int [] nums2 = {3,1,3,4,2};
	int output2=3;
	
	//Input: nums = [3,1,3,4,2]
	//Output: 3

	//Example 3:
	//
	int [] nums3 = {3,3,3,3,3};
	int output3=3;
	
	if(output1==findDuplicate(nums1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	
	if(output2==findDuplicate(nums2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	
	if(output3==findDuplicate(nums3)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}

	
}
}
