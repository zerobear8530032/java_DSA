//442. Find All Duplicates in an Array
//Solved
//Medium
//Topics
//Companies
//Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
//
//You must write an algorithm that runs in O(n) time and uses only constant extra space.
//
//Example 1:
//
//Input: nums = [4,3,2,7,8,2,3,1]
//Output: [2,3]
//Example 2:
//
//Input: nums = [1,1,2]
//Output: [1]
//Example 3:
//
//Input: nums = [1]
//Output: []
// 
//
//Constraints:
//
//n == nums.length
//1 <= n <= 105
//1 <= nums[i] <= n
//Each element in nums appears once or twice.
package Sorting_Questions;

import java.util.*;

public class FindAllDuplicatesinanArray_422 {
//brute force approch:
//	we check every number from 1 to n present in input array
//	time complexity:O(n*n)
	public static List<Integer> findDuplicatesBruteForce(int[] nums) {
		List<Integer>  ans = new ArrayList<Integer>();
		for(int i =0;i<nums.length;i++) {
			for(int j =0;j<nums.length;j++) {
				if(nums[i]==nums[j] && i!=j) {
					if(!ans.contains(nums[i])) {
					ans.add(nums[i]);
					}
			}
		}
	}
		return ans;
}
	
	
	
	
	//	 approch : used simple cyclic sort where the element should be at element will be at element-1 index;
	//  now if the element is not at their	their position those are our answer;
	//	time complexity : O(n)    
	public static List<Integer> findDuplicatesCyclicSort(int[] nums) {
	        int index = 0;
	        List<Integer> ans = new ArrayList();
//	        simple cylic sort:
	        while (index < nums.length) {
	            int correct = nums[index] - 1;
	            if (nums[correct] != nums[index]) {
	                // swap :
	                int temp = nums[correct];
	                nums[correct] = nums[index];
	                nums[index] = temp;
	            } else {
	                index++;
	            }
	        }
//	        check which element does not satisfied condition nums[i] = i+1 or nums[i]-1 = i
	        for (int i = 0; i < nums.length; i++) {
	            if (nums[i] != i + 1) {
	                ans.add(nums[i]);
	            }
	        }
	        return ans;
	    }
	    static boolean check(List<Integer> ans,List<Integer>output) {
	    	if(ans.size()!=output.size()) {
	    		return false;
	    	}
	    	Collections.sort(ans);
	    	Collections.sort(output);
	    	
	    	for(int i =0;i<ans.size();i++) {
	    		if(ans.get(i)!=output.get(i)) {
	    			return false;
	    		}
	    	}
	    	return true;
	    }
	
	
	public static void main(String[] args) {
		System.out.println("Brute Force approch :");
		//Example 1:
		//
		int []nums1 = {4,3,2,7,8,2,3,1};
		List<Integer> output1= new ArrayList(Arrays.asList(2,3));
		List<Integer> ans1 =findDuplicatesBruteForce(nums1);
		if(check(ans1, output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		
		//Example 2:
		//
		int []nums2 = {1,1,2};
		List<Integer> output2= new ArrayList(Arrays.asList(1));
		List<Integer> ans2 =findDuplicatesBruteForce(nums2);
		if(check(ans2, output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}

		//Example 3:
		//
		int []nums3 = {1};
		List<Integer> output3= new ArrayList(Arrays.asList());
		List<Integer> ans3 =findDuplicatesBruteForce(nums3);
		if(check(ans3, output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}

//		cyclis sort approch approch
		System.out.println("Cyclic sort approch :");
		ans1 =findDuplicatesCyclicSort(nums1);
		if(check(ans1, output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		
		ans2 =findDuplicatesCyclicSort(nums2);
		if(check(ans2, output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		ans3 =findDuplicatesCyclicSort(nums3);
		if(check(ans3, output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}

		
		
//		Extra space approch approch
		System.out.println("Extra space approch :");
		ans1 =findDuplicatesExtraSpace(nums1);
		if(check(ans1, output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		
		ans2 =findDuplicatesExtraSpace(nums2);
		if(check(ans2, output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		ans3 =findDuplicatesExtraSpace(nums3);
		if(check(ans3, output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
		
	
}




	private static List<Integer> findDuplicatesExtraSpace(int[] nums) {
        int index =0;
        while(index<nums.length){
            int correct = nums[index]-1;
            if(nums[index]!=nums[correct]){
                int temp = nums[correct];
                nums[correct]=nums[index];
                nums[index]=temp;
            }else{
                index++;
            }
        }
        List<Integer>ans = new ArrayList();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
            	ans.add(nums[i]);
            }
        }

       return ans; 
    }
}
