//35. Search Insert Position
//Solved
//Easy
//Topics
//Companies
//Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
//You must write an algorithm with O(log n) runtime complexity.
//Example 1:
//
//Input: nums = [1,3,5,6], target = 5
//Output: 2
//Example 2:
//
//Input: nums = [1,3,5,6], target = 2
//Output: 1
//Example 3:
//
//Input: nums = [1,3,5,6], target = 7
//Output: 4
// 
//
//Constraints:
//
//1 <= nums.length <= 104
//-104 <= nums[i] <= 104
//nums contains distinct values sorted in ascending order.
//-104 <= target <= 104

package BinarySearchQuestions;

public class SearchInsertionPosition_35 {
//	approch :
//	here we applied a binary search where if we found the element we will return the index of mid
//	but if we does not found element so we already know we have to return the element where it could be 
//	so by intution our binary search will find the element where the element we want will be 
//	nnow we only return the index where we can insert it 
//	now if the array is sorted asceding we know the element at start and end will be close to each other 
//	and when start>end the binary seach will terminate 
//	so now we know end < start so we will return start because we know the element will be insert after end at it index will be start 
//	so we can return start at the end or end+1 both will work
//	time complexity : O(log n)
//	 same approch used in finding the floor of a number in a sorted array 
    public static int searchInsert(int[] nums, int target) {
        int start =0;
        int end =nums.length-1;
//        binary search 
        while(start<=end){
            int mid = start+(end-start)/2;
//            if we found target return it
            if(nums[mid]==target){
                return mid;
//                if target is big search at right
            }else if(target>nums[mid]){
                start=mid+1;
//                if target is small search at left 
            }else{
                end=mid-1;
            }
        }
//        at last start will be the index where we can insert the target  
        return start;
    }
	public static void main(String[] args) {
		
		
		//Example 1:
		int []nums1 = {1,3,5,6};
		int target1 = 5;
		int output1=2;
		
		if(output1==searchInsert(nums1, target1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		
		//Example 2:
		int []nums2 = {1,3,5,6};
		int target2 = 2;
		int output2= 1;
		
		if(output1==searchInsert(nums2, target2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		//Example 3:
		int []nums3 = {1,3,5,6};
		int target3 = 7;
		int output3= 4;
	
		
		if(output1==searchInsert(nums3, target3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
}
}
