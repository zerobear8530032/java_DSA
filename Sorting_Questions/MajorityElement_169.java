//169. Majority Element
//Solved
//Easy
//Topics
//Companies
//Given an array nums of size n, return the majority element.
//
//The majority element is the element that appears more than [n / 2] times. You may assume that the majority element always exists in the array.
//
// 
//
//Example 1:
//
//Input: nums = [3,2,3]
//Output: 3
//Example 2:
//
//Input: nums = [2,2,1,1,1,2,2]
//Output: 2
// 
//
//Constraints:
//
//n == nums.length
//1 <= n <= 5 * 104
//-109 <= nums[i] <= 109
package Sorting_Questions;

import java.util.*;

public class MajorityElement_169 {
//	brute force approch: sort the entire array and find the frequency without any extra space :
//	time complexity :O(n*n)+O(n) =O(n*n)
//	space complexity O(1);
	
	    public static int majorityElementBruteForce(int[] nums) {
	        if(nums.length==1){return nums[0];}
	        sort(nums);
	            int f = 0;
	            int current = nums[0];
	        for(int i =0;i<nums.length;i++){
	            if(current==nums[i]){
	                f++;
	                if(f>=(float)nums.length/2.0f){
	                    return current;
	                }
	            }else{
	                current=nums[i];
	                f=1;
	            }

	          
	        }
	        return -1;
	    }
	    public static void sort(int[] nums){
	        for(int i =0;i<nums.length-1;i++){
	            for(int j=i+1;j>0;j--){
	                if(nums[j-1]>nums[j]){
	                    int temp = nums[j-1];
	                    nums[j-1]=nums[j];
	                    nums[j]=temp;
	                }
	            }
	        }
	    }
//	    here we can use sort method directly to sort the array and return the n/2 index
//	    why ? : because if some element which have frequency greater then the
//	    half of array length it will occur in at the mid point of the array after sorting

//	   example : [1,2,4,4,4] here ans = 4 why ? because the length = 5 , 4 freq = 3 and 4/2= 2<3
//	   example :[4,6,2,5,2,2,2] sort =[2,2,2,2,4,5,6] same here lengh = 7 , 2 freq = 4 7/2=3<4
//	    time complexity : O(n*n) or O(n log n) depends upon the sorting algo
	    
	    public static int majorityElementBetter(int[] nums) {
	    	if(nums.length==1){return nums[0];}
	    	sort(nums);
	    	return nums[nums.length/2];
	    }
	    
	    
//	    using extra space we can do it in linear time :
//	    we can use a hash set which store value as key and frequemcy as value 
	        public static int majorityElementExtraSpace(int[] nums) {
	            HashMap<Integer,Integer> map = new HashMap();
	            for(int i =0;i<nums.length;i++){
	                if(map.containsKey(nums[i])){
	                    map.put(nums[i],map.get(nums[i])+1);
	                }else{
	                map.put(nums[i],1);
	                }
	            }
	            for(Map.Entry<Integer,Integer> s:map.entrySet()){
	                if(s.getValue()>=(float)nums.length/2){
	                    return s.getKey();
	                }
	            }
	            
	            return -1;
	        }
	        
	public static void main(String[] args) {
		//Example 1:
		//
		int []nums1 = {3,2,3};
		int output1=3;
		
		//Example 2:
		
		int []nums2 = {2,2,1,1,1,2,2};
		int output2= 2;
		
//		Brute Force
		System.out.println("Brute Force");
		if(output1==majorityElementBruteForce(nums1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
		}
		
		if(output2==majorityElementBruteForce(nums2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
		}

// Better approch
		System.out.println("Better ");
		if(output1==majorityElementBetter(nums1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
		}
		
		if(output2==majorityElementBetter(nums2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
		}
		
// Extra space approch
		System.out.println("Extra Space");
		if(output1==majorityElementExtraSpace(nums1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
		}
		
		if(output2==majorityElementExtraSpace(nums2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
		}
	}

}
