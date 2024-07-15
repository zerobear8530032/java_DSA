//34. Find First and Last Position of Element in Sorted Array
//Medium
//Topics
//Companies
//Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//If target is not found in the array, return [-1, -1].
//You must write an algorithm with O(log n) runtime complexity.
//Example 1:
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
//Example 2:
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
//Example 3:
//Input: nums = [], target = 0
//Output: [-1,-1]
//Constraints:
//0 <= nums.length <= 105
//-109 <= nums[i] <= 109
//nums is a non-decreasing array.
//-109 <= target <= 109
package leetcode_Medium;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray_34 {
//	Original Solution: O(n)
//	Performs a linear scan from both ends of the array, leading to O(n) time complexity in the worst case.
//	approch simple brute force :
//	used 2 pointer left and right if
//	left at 0 index 
//	right at last index of input:
//	now we will loop left to right from left pointer 
//	and right to left with right pointer and if a target is found we will stop the movement of the array 
//	and assign  the index to the return array 
//	andd we keep on doing that until both pointer are set
//	we can return the output array as -1,-1 if no target is found
	public static int[] searchRange(int[] nums, int target) {
        int l=-1;
        int r=-1;
        int left =0;
        int right =nums.length-1;
        if(right<0){
        	return new int [] {-1,-1};
        }
        
        
        while(left<=right){
        	System.out.println(nums[left]+" "+nums[right]);
        	if(nums[left]==target) {
        		l=left;
        	}else {
        		left++;
        	}
        	
        	if(nums[right]==target) {
        		r=right;
        	}else {
        		right--;
        	}
        	
        	if(l>=0 && r>=0) {
        		break;
        	}             
        }
        return new int[] {l,r};
    }
public static void main(String args[]) {

//		Example 1:
		int []nums1 = {5,7,7,8,8,10}; 
		int  target1 = 8;
		System.out.println(Arrays.toString(searchRange(nums1, target1)));
		
		
//		output = [3,4]
//		Example 2:

		int []nums2 = {5,7,7,8,8,10};
		int target2 = 6;
		System.out.println(Arrays.toString(searchRange(nums2, target2)));
//		Output: [-1,-1]
//		Example 3:

		int [] nums3 = {};
		int target3 = 0;
//		Output: [-1,-1]
		System.out.println(Arrays.toString(searchRange(nums3, target3)));
	
		int [] nums4 = {1};
		int target4 = 1;
	
		System.out.println("Case 4"+Arrays.toString(searchRange(nums4, target4)));
}
}
