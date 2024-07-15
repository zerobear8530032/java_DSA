//34. Find First and Last Position of Element in Sorted Array
//Solved
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
//
//0 <= nums.length <= 105
//-109 <= nums[i] <= 109
//nums is a non-decreasing array.
//-109 <= target <= 109
package BinarySearchQuestions;
public class FindFirstAndLastPositionOfElementInSortedArray_34 {
//	approch 2 pass algo :Linear Search approch
//	first pass search the first index  where is the target is present and once it find it will update s=target index
//	the second pass will search for the end index by starting from the start 's' and every time we encounter target e will be increment by 1
//	time complexity here is : O(n)
//	space complexity O(1);
//	cases :
//	this algo works  only in sorted array or where the target is consicutively occuring
	
	    public static int[] searchRangeBruteForce(int[] nums, int target) {
	        int s =-1;
	        int e =-1;
//	        first pass find the starting index:
	        for(int i =0;i<nums.length;i++){
	            if(target == nums[i]){
	                s=i;
	                break;
	            }
	        }
//	        here if s == -1 means their is no target present in the entire array which mean we does not need second pass 
//	        so we return -1,-1
	        if(s==-1){
	            return new int []{-1,-1};
	        }
	        e=s;
//	        this will search for end index 
//	        second pass start from s+1 and each time target is encounter it will increment by 1
//	        
	        for(int i =s+1;i<nums.length;i++){
	            if(target==nums[i]){
	                e++;
	            }
	        }
	        return new int[]{s,e};
	    }
	    
	    public static boolean check(int [] target,int [] output) {
	    	if(target.length != output.length) {
	    		return false;
	    	}
	    	for(int i =0;i<target.length;i++) {
	    		if(!(target[i]==output[i])) {
	    			return false;
	    		}
	    	}
	    	return true;
	    }
	    
//	    Optimize approch : using binary search :
//	    approch used simple binary search with some additional functionality to find the last and first index 
//	    the binary search work as it is the only additional stuff is when it found the target it does not return the index 
//	    instead it tries to find first or last index by reducing the search space more to the apposite side 
//	    means if we want to search the start index we will search is the left side 
//	    and if we want to find end we will seach in the right hand side
//	    time complexity = O(log n) // using binary search
//	    space complexity = O(1)
	public static int[] searchRange(int[] nums, int target) {
		int ans []= {-1,-1};
		System.out.println("find start");
//		we use a boolean to be true to search the first index and false for last index 
//		here we will use binary search to find first index : if it return -1 means the target is not at all present in the array
//		so we can return {-1 ,-1}
		ans[0]=search(nums, target, true);
		if(ans[0]==-1) {
			return ans;
		}
//		here we find end so we insert a bboolean which will toggle the search to work for right side to find last inndex 
		System.out.println("find end");
		ans[1]=search(nums, target, false);
//		final answer 
		return ans;
	}
//	binary search
	public static int search(int [] nums, int target,boolean findstartindex) {
		int s =0;
		int e =nums.length-1;
		int ans =-1;
		while(s<=e) {
			int mid = s+(e-s)/2;
//			if target is greater we will seach right side
			if(target>nums[mid]) {
				s=mid+1;
//				if target is lesser we will search left side 
			}else if(target<nums[mid]) {
				e=mid-1;
			}else {
//				when we find the target we will not return it but we will try to go extream right :
//				here ans is possible answer :
				ans=mid;
//				here we check the left and right side to find the actual answer
//				if findstartindex is toggle true then we will reduce search space from right side
				if(findstartindex) {
					e=mid-1;
				}else {
//					else if findstartindex is flase we will reduce seach space from the left side
					s=mid+1;
				}
//				System.out.println(mid+" "+nums[mid]);
			}
		}
		return ans;
	}
	
	    	    
	
public static void main(String args[]) {
	System.out.println("Brute force Approch");
	//Example 1:
	int [] nums1 = {5,7,7,8,8,10};
	int target1 = 8;
	int [] output1= {3,4};
	int [] ans1 = searchRangeBruteForce(nums1, target1);
	if(check(output1,ans1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	//Example 2:
	int [] nums2 = {5,7,7,8,8,10};
	int target2 = 6;
	int [] output2= {-1,-1};
	int [] ans2 = searchRangeBruteForce(nums2, target2);
	if(check(output2,ans2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	//Example 3:
	int [] nums3 = {};
	int target3 = 0;
	int [] output3= {-1,-1};
	int [] ans3 = searchRangeBruteForce(nums3, target3);
	if(check(output3,ans3)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}
	
	System.out.println("Optimize Approch");		
	ans1 =searchRange(nums1, target1);
	if(check(output1,ans1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	
	ans2 = searchRange(nums2, target2);
	if(check(output2,ans2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	ans3 = searchRange(nums3, target3);
	if(check(output3,ans3)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}
	
}
}
