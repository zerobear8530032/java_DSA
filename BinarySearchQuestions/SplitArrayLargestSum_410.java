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

	
public static int splitArray(int[] nums, int k) {
//	start and end initially
    int start =0;
    int end =0;
    for(int i =0;i<nums.length;i++) {
//    start = max of array
    	start=Math.max(start, nums[i]);
//    end = sum of all element in array
    	end=end+nums[i];
    }
	
	System.out.println("start "+start+" end "+end);
//	binary seach :
// here  this will terminate when the s==e	
	while(start<end) {
		
		int mid =start+(end-start)/2;
//		here sum of sumition of sub array 
		int sum=0;
		int pieces=1;// inital the piece will be one because minimum is always one
// now we will divide element in sub array 
		for(int n:nums) {
//			if current sub exceed the mid we will start a new sub array by adding the element on the next arary and increasing the piece
//			here mid is the potential answer
			if(sum+n>mid) {
//				means first sub array is filled 
//				create a new sub array :
				sum=n;
//				increase the piece because new pieace is required
				pieces++;
//				else sum the number 
			}else {
//				adding the number to the sub array :
				sum=sum+n;
			}
		}	
//		check wheather the pieace condition is voilated or not
//		if pieces are more means we need to increase size of sub array means we will increase the sizze  of mid by seaching on right side 
			if(pieces>k) {
				
				start=mid+1;
//		if pieces are less means we need to decrease size of sub array means we will deacrease the sizze  of mid by seaching on left side 
			}else {
				end=mid;
			}
	}
//	finally return the answer as end
	return end;
    }
public static void main(String[] args) {
//Example 1:
int []nums1 = {7,2,5,10,8};
int k1 = 2;
int output1=18;
//Explanation: There are four ways to split nums into two subarrays.
//The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
	
//Example 2:
int [] nums2 = {1,2,3,4,5}; 
int k2 = 2;
int output2= 9;
//Explanation: There are four ways to split nums into two subarrays.
//The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
	
splitArray(nums1,k2);
	


}
}
