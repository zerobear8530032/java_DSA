//268. Missing Number
//Solved
//Easy
//Topics
//Companies
//Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

//Example 1:
//
//Input: nums = [3,0,1]
//Output: 2
//Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
//Example 2:
//
//Input: nums = [0,1]
//Output: 2
//Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
//Example 3:
//
//Input: nums = [9,6,4,2,3,5,7,0,1]
//Output: 8
//Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
// 
//
//Constraints:
//
//n == nums.length
//1 <= n <= 104
//0 <= nums[i] <= n
//All the numbers of nums are unique.
 

package Sorting_Questions;
import java.util.*;
public class MissingNumber_268 {
//	Brute force: here we check number from 0 till n and check its present in array or not if yes we chcke next '
//  other wise return answer
//	time complexity : O(n*n)
//	Space : O(1)
	    public static int missingNumberBruteForce(int[] nums) {
	        // brute force :
	        for(int i =0;i<=nums.length;i++){
	            boolean found = false;
	            for(int x : nums){
	                if(x==i){
	                    found=true;
	                    break;
	                }
	            }
	            if(found==false){
	                return i;
	            }

	        }
	        return -1;
	    }
	
	
//	better approch :
//	first we allocate the nums.length+1 array 
//	now we can use each element in the array as index of temp array and increment it with 1 
//	now we can iterate over it and get the index which have value =0;
//	time complexity : O(n)
//	Space : O(n)
	public static int missingNumberBetter(int[] nums) {
//		allocate nums.length array 
//		because the mmissing value lies btw 0 to n 
//		if n =5
//		[0,0,0,0,0,0] = values of temp array
//		[0,1,2,3,4,5] = index of arrays 
//		input =[1,2,4,5,3]
//		now we can map the element of input array on the temp araray 
//		then the array will be [0,1,1,1,1,1]
//		so the answe is 0 
//		temp array 
	     int [] temp = new int [nums.length+1];
	     for(int i =0;i<nums.length;i++){
	        temp[nums[i]]++;
	     }
//	     find the answer
	     for(int i =0;i<temp.length;i++){
	        if(temp[i]==0){
	            return i;
	        }
	     }   
//	     default 
	return -1;
	    }
	
	
//	note: we can apply any sorting algo but cyclic sort was fastest
	
//Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
//	solution :
//	use cyclic sort to sort the array  this will put all element to its position
//	if some element is not at it position that is our answer
//	time complexity : O(n)+O(n)=O(n)
//	Space : O(1)
	
	
	    public static int missingNumberOptimize(int[] nums) {
	        // follow up solution:
//	    	starting 
	        int i =0;
	        while(i<nums.length){
	            int correct =nums[i];
//	            if nums[i]== length  {we will skip it because it cant be put}
	            if(correct==nums.length){
	                i++;
	                continue;
	            } 
//	            if element not at correct position we can swap it
	            if(nums[i]!=nums[correct]){
	                int temp = nums[correct];
	                nums[correct]=nums[i];
	                nums[i]=temp;
//	                if it is we will increment
	            }else{
	                i++;
	            }
	        }
	        
	        // second pass  :
//	        if any element is not at index that means nums[i] -1 is answer
//	        why ? :
//	        so in contrain its give the array will contain number 0 to n 
//	         now if we assume a array length 4
//	        so how many element will be their 0 1,2,3,4  ,(n+1, elment will be possible)
//	        but we cant put all element in the entire array so one is always left 
//	        now whenn we sort the array each element will be at it position for ex 0,1,4,2  (3- mssing when we sort it ):
//	        0,1,2,4 , here we can see 0 is at 0 index 1 as 1 index 2 at 2 index but 4 is at 3 and we can say if(arr[i]!=i){that means its index is our naswe or arr[i]-1}
//	   now what if the answe array is [1,2,3,4]
//	        still 1 is at 0 index  means the answer is 1-1=0
//	        but what if the last element is missing [0,1,2,3] - 4 missing 
//	        so we already knew all element can be caught above so we can by default return nums.length;
	        
//	        check for answer 
	        for( i =0;i<nums.length;i++){
	            if(nums[i]!=i){
	                return i;
	            }
	        }
//	        by default nums.length is answer
	        return nums.length;
	    }
	    
	    
//	    optimize easy approch : 
//	    here we use sumition of n natural number formula to sum the number from 0 to n
//	    then take difference of sum of all number in the array
//	    and we will get our answer:
//	time complexity : O(n)
//	Space : O(1)	    
	    public static int missingNumber(int[] nums) {
	        int n = nums.length;
	        int sum=0;
	        for(int i=0;i<nums.length;i++){
	            sum+=nums[i];
	        }         
	        int sumition=n*(n+1)/2;
	        return sumition-sum;
	        }
	
public static void main(String[] args) {
	//Example 1:
	//
	int []nums1 = {3,0,1};
	int output1=2;
	//Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
	//Example 2:
	//
	int []nums2 = {0,1};
	int output2=2;
	//Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
	//Example 3:
	//
	//Input: nums = [9,6,4,2,3,5,7,0,1]
	//Output: 8
	int []nums3 = {9,6,4,2,3,5,7,0,1};
	int output3=8;
	//Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.

	System.out.println("Brute Force approch");
	if(output1==missingNumberBruteForce(nums1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	
	if(output2==missingNumberBruteForce(nums2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	
	if(output3==missingNumberBruteForce(nums3)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}
	
//	better approch :
	System.out.println("Better approch");
	if(output1==missingNumberBetter(nums1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	
	if(output2==missingNumberBetter(nums2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	
	if(output3==missingNumberBetter(nums3)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}
	
	
//	best optimize approch :
	System.out.println("Best approch");
	if(output1==missingNumberOptimize(nums1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	
	if(output2==missingNumberOptimize(nums2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	
	if(output3==missingNumberOptimize(nums3)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}
	
//	best approch:
	System.out.println("Best approch");
	if(output1==missingNumber(nums1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	
	if(output2==missingNumber(nums2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	
	if(output3==missingNumber(nums3)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}
}
}
