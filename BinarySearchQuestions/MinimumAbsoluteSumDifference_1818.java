//1818. Minimum Absolute Sum Difference
//Solved
//Medium
//Topics
//Companies
//Hint
//You are given two positive integer arrays nums1 and nums2, both of length n.
//
//The absolute sum difference of arrays nums1 and nums2 is defined as the sum of |nums1[i] - nums2[i]| for each 0 <= i < n (0-indexed).
//
//You can replace at most one element of nums1 with any other element in nums1 to minimize the absolute sum difference.
//
//Return the minimum absolute sum difference after replacing at most one element in the array nums1. Since the answer may be large, return it modulo 109 + 7.
//
//|x| is defined as:
//
//x if x >= 0, or
//-x if x < 0.
// 
//
//Example 1:
//
//Input: nums1 = [1,7,5], nums2 = [2,3,5]
//Output: 3
//Explanation: There are two possible optimal solutions:
//- Replace the second element with the first: [1,7,5] => [1,1,5], or
//- Replace the second element with the third: [1,7,5] => [1,5,5].
//Both will yield an absolute sum difference of |1-2| + (|1-3| or |5-3|) + |5-5| = 3.
//Example 2:
//
//Input: nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
//Output: 0
//Explanation: nums1 is equal to nums2 so no replacement is needed. This will result in an 
//absolute sum difference of 0.
//Example 3:
//
//Input: nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
//Output: 20
//Explanation: Replace the first element with the second: [1,10,4,4,2,7] => [10,10,4,4,2,7].
//This yields an absolute sum difference of |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
// 
//
//Constraints:
//
//n == nums1.length
//n == nums2.length
//1 <= n <= 105
//1 <= nums1[i], nums2[i] <= 105

//___________________________________________solution link with explanation____________________
//https://www.youtube.com/watch?v=lNNwokAvN3M
//_______________________________________________________________

package BinarySearchQuestions;
import java.util.*;
public class MinimumAbsoluteSumDifference_1818 {
	    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
	            final int MOD = 1_000_000_007;
	        long sumdiff =0;
	        int[] diffarr= new int [nums1.length];
	        for(int i =0;i<nums1.length;i++){
	           sumdiff= (Math.abs(nums1[i]-nums2[i])+sumdiff);
	           diffarr[i]= Math.abs(nums1[i]-nums2[i]);
	        }
	        if(sumdiff==0){
	            return 0;
	        }
	        int [] sortednums1 =nums1.clone();
	        Arrays.sort(sortednums1);
	        int [] bestdiff = new int [nums1.length];
//	        int [] bestdifference = new int[nums1.length];
	        for(int i =0;i<nums2.length;i++){
	            int lindex =BinarySearchForLowerBound(sortednums1,nums2[i]);
	            int updif = Math.abs(sortednums1[lindex]-nums2[i]);
	            int lbdif = 0;
	            if(lindex==0){
	            lbdif = Math.abs(sortednums1[lindex]-nums2[i]);
	            }else{
	            lbdif = Math.abs(sortednums1[lindex-1]-nums2[i]);
	            }
	            bestdiff[i]=Math.min(updif,lbdif);
	        }
	            // System.out.println(Arrays.toString(bestdiff));
	            // System.out.println(Arrays.toString(diffarr));
	            long maxdif =0;
	            for(int i =0;i<nums1.length;i++){
	                maxdif = Math.max(maxdif,Math.abs(diffarr[i]-bestdiff[i]));
	            }
	            System.out.println(Math.abs(sumdiff-maxdif));
	        return (int)(Math.abs(sumdiff-maxdif)%MOD);
	    }
	    public static  int BinarySearchForLowerBound(int []nums,int target){
	        int start =0;
	        int end =nums.length-1;
	        while(start<=end){
	            int mid = start+(end-start)/2;
	            if(nums[mid]==target){
	                return mid;
	            }else if(target>nums[mid]){
	                start=mid+1;
	            }else{
	                end=mid-1;
	            }
	        }
	        if(start>=nums.length){
	            return start-1;
	        }else if(start<0) {
	            return 0;
	        }
	        return start;
	    }
	
public static void main(String[] args) {
	//Example 1:
	//
	int []nums11 = {1,7,5}, nums12 = {2,3,5};
	int output1=3;
	//Explanation: There are two possible optimal solutions:
	//- Replace the second element with the first: [1,7,5] => [1,1,5], or
	//- Replace the second element with the third: [1,7,5] => [1,5,5].
	//Both will yield an absolute sum difference of |1-2| + (|1-3| or |5-3|) + |5-5| = 3.
	if(output1==minAbsoluteSumDiff(nums11, nums12)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	
	//Example 2:
	//
	//Input: nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
	int []nums21 = {2,4,6,8,10}, nums22 = {2,4,6,8,10};
	int output2=0;
	
	if(output2==minAbsoluteSumDiff(nums21, nums22)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	//Explanation: nums1 is equal to nums2 so no replacement is needed. This will result in an 
	//absolute sum difference of 0.
	//Example 3:
	//
	//Input: nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
	int []nums31 = {1,10,4,4,2,7}, nums32 = {9,3,5,1,7,4};
	int output3=20;

	//Explanation: Replace the first element with the second: [1,10,4,4,2,7] => [10,10,4,4,2,7].
	//This yields an absolute sum difference of |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20

	if(output3==minAbsoluteSumDiff(nums31, nums32)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}
	
}

}
