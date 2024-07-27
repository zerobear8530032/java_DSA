//153. Find Minimum in Rotated Sorted Array
//Solved
//Medium
//Topics
//Companies
//Hint
//Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
//
//[4,5,6,7,0,1,2] if it was rotated 4 times.
//[0,1,2,4,5,6,7] if it was rotated 7 times.
//Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
//
//Given the sorted rotated array nums of unique elements, return the minimum element of this array.
//
//You must write an algorithm that runs in O(log n) time.
//

//Example 1:
//
//Input: nums = [3,4,5,1,2]
//Output: 1
//Explanation: The original array was [1,2,3,4,5] rotated 3 times.

//Example 2:
//
//Input: nums = [4,5,6,7,0,1,2]
//Output: 0
//Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

//Example 3:
//
//Input: nums = [11,13,15,17]
//Output: 11
//Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 

//Constraints:
//
//n == nums.length
//1 <= n <= 5000
//-5000 <= nums[i] <= 5000
//All the integers of nums are unique.
//nums is sorted and rotated between 1 and n times.
package BinarySearchQuestions;
public class FindMinimuminRotatedSortedArray_153 {
//	Brute force : apply simmple linear search :
// time complexity will be O(n)
	
	public static int findMinBruteForce(int[] nums) {
		int min =nums[0];
		for(int i =1;i<nums.length;i++){
			if(min>nums[i]){
				min=nums[i];
			}
		}
		return min;
		
	}
//	Binary search: here we can apply a simple binary search to find min element how ?
//	so we know 2 things we can find pivot from them rotated array which we have done in previous questions 
//	and we also know before rotation array was sorted
//	and if we rotate the array the pivote will move to index of number of rotation-1 
//	and pivote will always be the largest element 
//	and pivot +1 is always the smallest elemnt 
//	so we can find pivot  in the roated array and return p+1 index value
//	if non pivote found means array was sorted means we can return first index as our min 
// time complexity will be O(log n)
	
	public static int findMinOptimze(int[] nums) {
		        int pivot=getpivot(nums);
		        if(pivot==-1){
		            return nums[0];
		        }else{
		            return nums[pivot+1];
		        }
		    }
		    public static int getpivot(int [] nums){
		        int start =0;
		        int end = nums.length -1;
		        while(start<end){
		            int mid = start+(end-start)/2;
		            if(mid<end && nums[mid]>nums[mid+1]){
		                return mid;
		            }else if(mid>start && nums[mid]<nums[mid-1] ){
		                return mid-1;
		            }else if(nums[start]>nums[mid]){
		                end = mid;
		            }else{
		                start=mid+1;
		            }
		        }
		            return -1;
		    }

	
	
	public static void main(String[] args) {
		
	//Example 1:	
	int []nums1 = {3,4,5,1,2};
	int output1= 1;
	//Explanation: The original array was [1,2,3,4,5] rotated 3 times.
	
	if(findMinBruteForce(nums1)==output1) {
		System.out.println("Case 1 Passed ");
	}else {
		System.out.println("Case 1 Failed ");		
	}
	

	//Example 2:
	int []nums2 = {4,5,6,7,0,1,2};
	int output2= 0;
	//Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
	if(findMinBruteForce(nums2)==output2) {
		System.out.println("Case 2 Passed ");
	}else {
		System.out.println("Case 2 Failed ");		
	}
	
	//Example 3:
	int []nums3 = {11,12,13,15,17};
	int output3= 11;
	//Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
	if(findMinBruteForce(nums3)==output3) {
		System.out.println("Case 3 Passed ");
	}else {
		System.out.println("Case 3 Failed ");		
	}
	
//	optimized way:
	if(findMinOptimze(nums1)==output1) {
		System.out.println("Case 1 Passed ");
	}else {
		System.out.println("Case 1 Failed ");		
	}
	
	if(findMinOptimze(nums2)==output2) {
		System.out.println("Case 2 Passed ");
	}else {
		System.out.println("Case 2 Failed ");		
	}
	
	if(findMinOptimze(nums3)==output3) {
		System.out.println("Case 3 Passed ");
	}else {
		System.out.println("Case 3 Failed ");		
	}
}
}