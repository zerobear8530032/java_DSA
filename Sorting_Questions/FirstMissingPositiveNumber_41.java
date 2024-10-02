//41. First Missing Positive
//Solved
//Hard
//Topics
//Companies
//Hint
//Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
//
//You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
//
//Example 1:
//
//Input: nums = [1,2,0]
//Output: 3
//Explanation: The numbers in the range [1,2] are all in the array.
//Example 2:
//
//Input: nums = [3,4,-1,1]
//Output: 2
//Explanation: 1 is in the array but 2 is missing.
//Example 3:
//
//Input: nums = [7,8,9,11,12]
//Output: 1
//Explanation: The smallest positive integer 1 is missing.
// 
//
//Constraints:
//
//1 <= nums.length <= 105
//-231 <= nums[i] <= 231 - 1

package Sorting_Questions;
//************************************************************************************
//note : i have other solution of this in binary search also 
//************************************************************************************
public class FirstMissingPositiveNumber_41 {
//	by using cyclic sort where every element is placed at elmeent-1 index
//	important to skip the negative numbers or the number which are bigger then the length of array 
//	we can them return the index +1 of element which does not follow the conddition element-1 == index
//	and by default we return nums.length+1;
//	because the answer can be the n+1 also
    public static int firstMissingPositive(int[] nums) {
        int index =0;
        while(index<nums.length){
            int correct = nums[index]-1;
            if(correct <0 || correct >nums.length-1){
                index++;
                continue;
            }
            if(nums[correct]!=nums[index]){
                // swap:
                int temp = nums[correct];
                nums[correct]=nums[index];
                nums[index]=temp;
            }else{
                index++;
            }
        }
        // System.out.println(Arrays.toString(nums));
        for(int i =0;i<nums.length;i++){
            if(nums[i]-1!=i){
                return i+1;
            }
        }
        return nums.length+1;
        
    }
    
    public static void main(String[] args) {
    	//Example 1:
    	//
    	int []nums1 = {1,2,0};
    	int output1= 3;
    	//Explanation: The numbers in the range [1,2] are all in the array.
    	//Example 2:
    	//
    	int []nums2 = {3,4,-1,1};
    	int output2= 2;
    	//Explanation: 1 is in the array but 2 is missing.
    	//Example 3:
    	//
    	int []nums3 = {7,8,9,11,12};
    	int output3= 1;
    	
    	//Explanation: The smallest positive integer 1 is missing.

		
	}

}
