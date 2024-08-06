//410. Split Array Largest Sum
//Hard
//Topics
//Companies
//Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
//
//Return the minimized largest sum of the split.
//
//A subarray is a contiguous part of the array.
//Example 1:
//Input: nums = [7,2,5,10,8], k = 2
//Output: 18
//Explanation: There are four ways to split nums into two subarrays.
//The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

//Example 2:
//Input: nums = [1,2,3,4,5], k = 2
//Output: 9
//Explanation: There are four ways to split nums into two subarrays.
//The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.

//Constraints:
//1 <= nums.length <= 1000
//0 <= nums[i] <= 106
//1 <= k <= min(50, nums.length)

package BinarySearchQuestions;
public class SplitArrayLargestSum_410 {
//	approch :
//	first this question will be solved with binary search where we will apply binary seach ???:
//	we will apply binary seach here on the min and max possible answer of the array :
//  assume 2 cases 1 : what will be tthe minimum partition we can create :
//	example [1,2,3,4,3,1,2] , k=1
//	so here minimum partition will be one only means we can say the entire summition of array is the answer 

//	case 2: what will be the max number of partition  it will be number of element 
//	[1,2,3,4,5] k=5 ->{[1],[2],[3],[4],[5]};
//	now here answer will be the max of array because we to find the max of all submition of sub array 
//	the sumition of sub array will be number it self and max of that will be sumition of it 

// so now if we say start = max(array)
// and end = sum of all(arr)
	
//	now we can apply binary search on this range while keep on checking wheather the number of m is exceed or in limit or not
//	if (k<number of sub array ) then we will start = mid+1 // because we need a sub array with more element means their will be less sub arrays 
//	else  end = mid .//means if k>number of sub array then we will reduce the sizes of sub array 

	    public static  int splitArray(int[] nums, int k) {
	        int start =Integer.MIN_VALUE;
	        int end =0;
	        for (int x : nums){
	            start=Math.max(start,x);
	            end+=x;
	        }
	        // System.out.println(start+" "+end);
	        int ans =0;
	        while(start<=end){
	            int mid = start+(end-start)/2;
	            if(getrequired(nums,mid)<=k){
	                ans =mid;
	                end = mid-1;
	            }else{
	                start=mid+1;
	            }
	        }
	        return ans;                                                       
	    }
	    public static int getrequired(int [] nums, int cap){
	        int currentk=1;
	        int currsum=0;
	        for(int x: nums){
	            if(currsum+x<=cap){
	                currsum=currsum+x;
	            }else{
	                currentk++;
	                currsum=x;
	            }
	        }
	        return currentk;

	    }

public static void main(String[] args) {
//Example 1:
int []nums1 = {7,2,5,10,8};
int k1 = 2;
int output1=18;
//Explanation: There are four ways to split nums into two subarrays.
//The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
	if(output1==splitArray(nums1, k1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
//Example 2:
int [] nums2 = {1,2,3,4,5}; 
int k2 = 2;
int output2= 9;
//Explanation: There are four ways to split nums into two subarrays.
//The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
	
if(output2==splitArray(nums2, k2)) {
	System.out.println("Case 2 Passed");
}else {
	System.out.println("Case 2 Failed");		
}
}
}
