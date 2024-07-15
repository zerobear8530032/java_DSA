//26. Remove Duplicates from Sorted Array
//Solved
//Easy
//Topics
//Companies
//Hint
//Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
//Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
//Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
//Return k.
//Custom Judge:
//The judge will test your solution with the following code:
//int[] nums = [...]; // Input array
//int[] expectedNums = [...]; // The expected answer with correct length
//int k = removeDuplicates(nums); // Calls your implementation
//assert k == expectedNums.length;
//for (int i = 0; i < k; i++) {
//    assert nums[i] == expectedNums[i];
//}
//If all assertions pass, then your solution will be accepted.
//Example 1:
//Input: nums = [1,1,2]
//Output: 2, nums = [1,2,_]
//Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).
//Example 2:
//Input: nums = [0,0,1,1,1,2,2,3,3,4]
//Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
//Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).
//Constraints:
//1 <= nums.length <= 3 * 104
//-100 <= nums[i] <= 100
//nums is sorted in non-decreasing order.

package leetcode_Easy;

import java.util.HashMap;
import java.util.TreeMap;

public class RemoveDuplicatesFromSortedArray_26 {
//	approch using 2 pointer anchor and look the anchor will start at 0 and look at 1 inndex and will iterate over the array :
//	when ever the nums[look]!=nums[anchor] this means the number is unique:
//	so we will increment the anchoor by 1 and put the number at the achor place
//	and look will increment every iteration
//	at last we will have the final index where the element got input but we need too return the count of
//	unique elements means we will increment the anchr by 1 because the index start with 0;
// time complexity here is o(n)
//	Time Complexity: 
//	O(n), where n is the length of the input array.
//	Space Complexity: 
//	O(1).
	public static int removeDuplicates(int[] nums) {
        int l=nums.length;
        int anchor=0;
        int look=1;
        while(look<l){
        if(nums[look]!=nums[anchor]){
            anchor++;
            nums[anchor]=nums[look];
        }
           look++; 
        }       
 return anchor+1;       
    }
	
	
	public static void main(String args[]) {
		int nums1[]= {1,1,2};
		int out1[]= {1,2};
		int nums2[]= {0,0,1,1,1,2,2,3,3,4};
		int out2[]= {0,1,2,3,4};
		int ans1=removeDuplicates(nums1);
		int ans2=removeDuplicates(nums2);
		HashMap <Integer,Boolean> map1 = new HashMap();
		for(int i =0;i<nums1.length;i++) {
			map1.put(nums1[i], false);
		}
		HashMap <Integer,Boolean> map2 = new HashMap();
		for(int i =0;i<nums1.length;i++) {
			map2.put(nums1[i], false);
		}
		
		for(int i =0;i<ans1;i++) {
			if(map1.containsKey(nums1[i])){
				map1.put(nums1[i], true);
			}
		}
		for(int i =0;i<ans2;i++) {
			if(map2.containsKey(nums2[i])){
				map2.put(nums2[i], true);
			}
		}
		boolean check1=!(map1.containsValue(false));
		boolean check2=!(map1.containsValue(false));
		
		if(check1) {
			System.out.println("Case 1 passed");
		}else {
			System.out.println("Case 1 failed");			
		}
		
		if(check2) {
			System.out.println("Case 2 passed");
		}else {
			System.out.println("Case 2 failed");			
		}
		
		
		
		
	
		
	}
}
