//167. Two Sum II - Input Array Is Sorted
//Solved
//Medium
//Topics
//Companies
//Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
//
//Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
//
//The tests are generated such that there is exactly one solution. You may not use the same element twice.
//
//Your solution must use only constant extra space.
//Example 1:
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

//Example 2:
//Input: numbers = [2,3,4], target = 6
//Output: [1,3]
//Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

//Example 3:
//Input: numbers = [-1,0], target = -1
//Output: [1,2]
//Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
//Constraints:
//2 <= numbers.length <= 3 * 104
//-1000 <= numbers[i] <= 1000
//numbers is sorted in non-decreasing order.
//-1000 <= target <= 1000
//The tests are generated such that there is exactly one solution.

package BinarySearchQuestions;

public class TwoSumII_InputArrayIsSorted167 {
//	approch :
//	we will take a difference of target-nums[i] and find that element in the search space using binary search
//	here we used a linear for loop which start from 0 till length and each time we find differnce btw 
//	target-nums[i] 
//	then pass the target with start and end in the search space 
//	if it return answer we return as final answer because in contrain it said their is only 1 possible answer 
//	if binary search return -1 means we need to check for next element in array 
	   public static  int[] twoSum(int[] numbers, int target) {
//		   loop to see differece btw target - nums[i]
	        for(int i =0;i<numbers.length;i++){
	            int find = target-numbers[i];
//	            search the ffind in the array 
	            int searchresult=binarySearch(numbers,find,i+1,numbers.length-1);
//	            if found we have to return their position not index
	            if(searchresult!=-1){
	                return  new int[]{i+1,searchresult+1};
	            }
	        }
//	        this is default block if nothing is found
	        return new int []{-1,-1};
	    }
//	   simple binary search 
	    public static int binarySearch(int [] nums,int target,int start,int end){
	        while(start<=end){
	         int mid =start+(end-start)/2;
	         if(target>nums[mid]){
	            start=mid+1;
	         }else if(target<nums[mid]){
	            end=mid-1;
	         }else{
	            return mid;
	         }   
	        }
	        return -1;
	    }
	    
	   public static boolean check(int ans [],int output[]) {
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
public static void main(String args[]) {
	//Example 1:
	int [] num1 = {2,7,11,15};
	int target1 = 9;
	int []output1= {1,2};
	int ans1[] = twoSum(num1, target1);
	//Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
	if(check(ans1, output1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}

	//Example 2:
	int [] num2 = {2,3,4};
	int target2 = 6;
	int []output2= {1,3};
	int ans2[] = twoSum(num2, target2);
	//Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
	if(check(ans2, output2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}

	//Example 3:
	int [] num3 = {-1,0};
	int target3 = -1;
	int []output3= {1,2};
	int ans3[] = twoSum(num3, target3);
	
	if(check(ans3, output3)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}
	
	
}
}
