//55. Jump Game
//Medium
//Topics
//Companies
//You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
//Return true if you can reach the last index, or false otherwise.
//Example 1:
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//Example 2:
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
//Constraints:
//1 <= nums.length <= 104
//0 <= nums[i] <= 105
package leetcode_Medium;
public class JumpGame_55 {
//	approch : we will use greedy approch by making the goal reach to us :
//	The function canJump checks whether you can reach the last index starting from the first index given an array nums where each element represents the maximum jump length at that position.
//
//	Steps:
//
//	Initialize goal:
//	Set goal to the last index of the array.
//	Iterate from the end to the beginning:
//	Iterate through the array from the last index to the first index.
//	For each index i, check if i + nums[i] >= goal. If true, update goal to i.
//	Check if the start can reach the goal:
//	After the loop, if goal is 0, it means you can reach the last index from the first index.
//	Time Complexity Analysis
//	Time Complexity:
//
//	The algorithm iterates through the array once from the last index to the first index.
//	This results in a time complexity of O(n), where n is the length of the array.
//	Space Complexity:
//
//	The algorithm uses a constant amount of extra space.
//	This results in a space complexity of O(1).
	public static boolean canJump(int[] nums) {
	    int l = nums.length - 1;  // Get the last index
	    int goal = l;             // Set the initial goal as the last index

	    // Iterate from the last index to the first index
	    for (int i = l; i >= 0; i--) {
	        // Print the current state for debugging
	        System.out.println(nums[i] + " " + i + " " + goal);

	        // Check if the current position can reach or exceed the goal
	        if (i + nums[i] >= goal) {
	            goal = i;  // Update the goal to the current index
	        }
	    }

	    // Check if the goal has been updated to the first index
	    return goal == 0;
	}


	public static void main(String args[]) {
		//Example 1:
		int [] nums1 = {2,3,1,1,4};
		boolean out1= true;
		//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
		//Example 2:
		int [] nums2 = {3,2,1,0,4};
		boolean out2= false;
		
		//Example 3:
		int [] nums3 = {1,1,2,2,0,1,1};
		boolean out3= true;
		
		//Example 4:
		int []nums4 = {2,5,0,0};
		boolean out4=true;
		
		//Example 5:
		int []nums5 = {1,1,2,2,0,1,4};
		boolean out5=true;
		
//		System.out.println("case 1 "+(canJump(nums1)== out1));
//		System.out.println("case 2 "+(canJump(nums2)== out2));
//		System.out.println("case 3 "+(canJump(nums3)== out3));
//		System.out.println("case 4 "+(canJump(nums4)== out4));
		System.out.println("case 5 "+(canJump(nums5)== out5));
		
		

		
		
		
	}

}
