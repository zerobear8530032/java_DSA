//88. Merge Sorted Array
//Solved
//Easy
//Topics
//Companies
//Hint
//You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//
//Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
//The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
//
// 
//
//Example 1:
//
//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
//Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
//Example 2:
//
//Input: nums1 = [1], m = 1, nums2 = [], n = 0
//Output: [1]
//Explanation: The arrays we are merging are [1] and [].
//The result of the merge is [1].
//Example 3:
//
//Input: nums1 = [0], m = 0, nums2 = [1], n = 1
//Output: [1]
//Explanation: The arrays we are merging are [] and [1].
//The result of the merge is [1].
//Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
// 
//
//Constraints:
//
//nums1.length == m + n
//nums2.length == n
//0 <= m, n <= 200
//1 <= m + n <= 200
//-109 <= nums1[i], nums2[j] <= 109
// 
//
//Follow up: Can you come up with an algorithm that runs in O(m + n) time?

package Sorting_Questions;
public class MergeSortedArray {
	public static void mergeBruteForce(int[] nums1, int m, int[] nums2, int n) {
		int n2=n-1;
		for(int i =nums1.length-1;i>=0;i--){
			if(n2<0){
				break;
			}
			nums1[i]=nums2[n2--];
		}
		sort(nums1);
	}
	public static void sort(int [] nums){
		for(int i =0;i<nums.length-1;i++){
			for(int j =1;j<nums.length;j++){
				if(nums[j-1]>nums[j]){
					int temp = nums[j-1];
					nums[j-1]=nums[j];
					nums[j]=temp;
				}
			}
		}
	}
	public static boolean  check(int [] ans,int [ ] output) {
		if(ans.length!=output.length) {
			return false;
		}else {
			for(int i =0;i<ans.length;i++) {
				if(ans[i]!=output[i]) {
					return false;
				}
			}
			return true;
		}
	}
	
	
public static void main(String[] args) {
	//Example 1:
	//
	int [] nums11= {1,2,3,0,0,0},nums12= {2,5,6};
	int m1=3,n1=3;
	int []output1= {1,2,2,3,5,6};
	mergeBruteForce(nums11, m1, nums12, n1);
	if(check(nums11, output1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	
	//The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

	//Example 2:
	int [] nums21= {1},nums22= {};
	int m2=1,n2=0;
	int []output2= {1};
	mergeBruteForce(nums21, m2, nums22, n2);
	//Explanation: The arrays we are merging are [1] and [].
	//The result of the merge is [1].
	if(check(nums21, output2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	
	//Example 3:
	int [] nums31= {0},nums32= {1};
	int m3=1,n3=1;
	int []output3= {1};
	mergeBruteForce(nums31, m3, nums32, n3);
	//Explanation: The arrays we are merging are [] and [1].
	//The result of the merge is [1].
	//Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
	if(check(nums31, output3)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}

	
}
}
