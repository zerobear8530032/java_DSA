//81. Search in Rotated Sorted Array II
//Solved
//Medium
//Topics
//Companies
//There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
//
//Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
//
//Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
//
//You must decrease the overall operation steps as much as possible.
//
//Example 1:
//
//Input: nums = [2,5,6,0,0,1,2], target = 0
//Output: true
//Example 2:
//
//Input: nums = [2,5,6,0,0,1,2], target = 3
//Output: false
// 
//
//Constraints:
//
//1 <= nums.length <= 5000
//-104 <= nums[i] <= 104
//nums is guaranteed to be rotated at some pivot.
//-104 <= target <= 104
package BinarySearchQuestions;

public class SearchinRotatedSortedArrayII_81 {
//	answer solution is all similar to rotated binarys search only difference is how we find pivote :
	    public static boolean search(int[] nums, int target) {
	        int pivot =FindPivot(nums);
	        if(pivot ==-1){
	            int searchres=binarySearch(nums,target,0,nums.length-1);
	            return searchres>=0;
	        }else if(nums[pivot]==target){
	            int searchres= pivot;
	            return searchres>=0;
	        }

	        if(target >=nums[0]){
	            int searchres= binarySearch(nums,target,0,pivot-1);
	            return searchres>=0;
	        }
	        else{
	            int searchres= binarySearch(nums,target,pivot+1,nums.length-1);
	            return searchres>=0;
	        }
	    }
	    public static int binarySearch(int nums[],int target,int start ,int end){
	        while(start<=end){
	            int mid = start+(end-start)/2;
	            if(target == nums[mid]){
	                return mid;
	            }else if(target>nums[mid]){
	                start=mid+1;
	            }else{
	                end=mid-1;
	            }
	        }
	        return -1;
	    }

//	    this is a bit change to handle duplicates
	    public static  int FindPivot(int [] nums){
	        int start =0;
	        int end =nums.length-1;

	        while(start<end){
	            int mid = start+(end-start)/2;
	            if( mid<end && nums[mid]>nums[mid+1]){
	                return mid;
	            }else if(mid>start &&  nums[mid]<nums[mid-1]){
	                return mid-1;
//	                if start end and mid all are same so we cant determine which are pivote so we 
//	                can skip them by incrementing start and decrementing end
//	                but we also need to check wheather these element which we are skipping are not our pivote so
//	                we check first if nums[start]>nums[[start+1]
//	                and if nums[end]<nums[end-1]
//	                if any condition of these are rtrue we find our pivote other wise we will skip them
	                
	            }else if(nums[mid]==nums[start] && nums[mid]==nums[end]){
//	             check start if it is a pivote
	            	if(nums[start]>nums[start+1]){
	                    return start;
	                }
//	            	if not skip current start
	                start++;
//	             check endif it is a pivote
	                if(nums[end]<nums[end-1]){
	                    return end;
	                }
//	            	if not skip current end
	                end--;
//	                here we are checking whether start and mid is equal or not 
	                
	            }else if (nums[start] <= nums[mid]) {
//	            	here if they both are equal we cannot determine which way to go so we skip it 
	                if (nums[start] == nums[mid]) {
	                    start++;
	                } else {
//	                	is they are not equal we can use our old search method
	                    start = mid + 1;
	                }
//	                here we are checking whether end and mid is equal or not 
	            } else {
//	            	here if they both are equal we cannot determine which way to go so we skip it 
	                if (nums[end] == nums[mid]) {
	                    end--;
	                } else {
//	                	is they are not equal we can use our old search method
	                    end = mid - 1;
	                }
	            }
	        }
	        return -1;
	    }
	
	public static void main(String[] args) {
		//Example 1:
		
		int []nums1 = {2,5,6,0,0,1,2};
		int	target1 = 0;
		boolean output1=true;
		
		//Example 2:
		
		int []nums2 = {2,5,6,0,0,1,2};
		int	target2 = 3;
		boolean output2=false;
		
		int []nums3 = {1,0,1,1,1};
		int	target3 = 0;
		boolean output3=true;
		
		int []nums4 = {2,2,2,3,1};
		int	target4 = 1;
		boolean output4=true;
		
		if(search(nums1, target1)==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
		}
		
		if(search(nums2, target2)==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
		}
			
		if(search(nums3, target3)==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
		}
		
		if(search(nums4, target4)==output4) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
		}
		
		


	}

}
