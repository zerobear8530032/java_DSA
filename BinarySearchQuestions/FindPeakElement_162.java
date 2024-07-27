//162. Find Peak Element
//Medium
//Topics
//Companies
//A peak element is an element that is strictly greater than its neighbors.
//Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
//You may imagine that nums[-1] = nums[n] = -infinite. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
//You must write an algorithm that runs in O(log n) time.

//Example 1:
//Input: nums = [1,2,3,1]
//Output: 2
//Explanation: 3 is a peak element and your function should return the index number 2.
//Example 2:
//Input: nums = [1,2,1,3,5,6,4]
//Output: 5

//Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
package BinarySearchQuestions;
public class FindPeakElement_162 {
//	brute force approch here we used simple linear search and find the max element from the array :
	public static int findPeakElementBruteForce(int[] arr) {
		int max =Integer.MIN_VALUE;
		int index=0;
		for(int i =0;i<arr.length;i++){
			if(max<arr[i]){
				max=arr[i]; 
				index=i; 
			}
		}
		return index;
	}
	
//	here we used the binary search with some advancement 
//	we know 2 things the peak array means their is some point in the array which is the greatest in the entire array 
//	and from  start till that point the array will be ascending sorted and from peak till last element the array will be sorted in descending order
//	now we know already know how to make the array work for both ascending or descending order sorted 
//	here we does not know the target and we does not have any idea at initial level where the peak will be 
//	so what we will do is :
//	we will calculate mid =  and check
//	if( arr[mid]<arr[mid+1]) -> if this is true means we are in the ascending side of the array so we know the greater element will bee on right side
//	if( arr[mid]>arr[mid+1]) -> if this is true means we are in the descemding side of the array so we know the greater element will be on left side
//  now we know how to traverse but where to stop 
//	because we does not have any particular target to stop we will let the s==e because the peak will be the mid of both ascending and descending order array 
//	so we can say while(s<e){-> this will terminate when s == e
//	....binary search
//}
	public static int findPeakElementOptimize(int[] arr) {
		int s =0;
		int e=arr.length-1;
//binary search starting:
		while(s<e) {
			int mid =s+(e-s)/2;
//	search right side if array in ascendding order
			if(arr[mid]<arr[mid+1]) {
//		here we update s = mid+1 we already seen mid+1 is greater then mid so we does not need to check at mid 				
				s=mid+1;
//		search left side if array is descending order
			}else/* if(arr[mid]>arr[mid+1])*/ {//-> this check can be replaced with else also but for 
//here we doing mid not mid + 1 because their is a chance the mid element is the answer because we check mid and mid+1 not mid and mid-1
				e=mid;
			}
		}
		return s;	
	}
public static void main(String[] args) {
	
		System.out.println("Brute Force approch");
		//Example 1:
		int[] nums1 = {1,2,3,1};
		int output1= 2;
		//Explanation: 3 is a peak element and your function should return the index number 2.		
		if(output1==findPeakElementBruteForce(nums1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");		
		}
		//Example 2:
		int[] nums2 = {1,2,1,3,5,6,4};
		int output2= 5;
		if(output2==findPeakElementBruteForce(nums2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");		
		}
		
		int[] nums3 = {7,2,3,1,2};
		int output3= 0;
		System.out.println(findPeakElementOptimize(nums3));
		
		System.out.println("Optimize approch");
		if(output1==findPeakElementOptimize(nums1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");		
		}
		if(output2==findPeakElementOptimize(nums2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");		
		}
	}
}
