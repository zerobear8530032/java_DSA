//448. Find All Numbers Disappeared in an Array
//Solved
//Easy
//Topics
//Companies
//Hint
//Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
//
//Example 1:
//
//Input: nums = [4,3,2,7,8,2,3,1]
//Output: [5,6]
//Example 2:
//
//Input: nums = [1,1]
//Output: [2]
// 
//Constraints:
//
//n == nums.length
//1 <= n <= 105
//1 <= nums[i] <= n
package Sorting_Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FindAllNumbersDisappearedinanArray_488 {
//    here is the brute force we iterate 1 to n and check it exist in input array or not 
//	time complexity :O(n*n)
//	space complexity :O(1)
	public static List<Integer> findDisappearedNumbersBruteForce(int[] nums) {
    
		List<Integer> ans = new ArrayList();
//		1 to n loop
    		for(int i =1;i<=nums.length;i++) {
    			boolean found = false;
//    			search i in the input:
    			for(int j =0;j<nums.length;j++) {
    				if(nums[j]==i) {
    					found=true;
    					break;
    				}
    			}
//    			if not found we add tthe answer
    			if(!found) {
    				ans.add(i);
    			}
    			
    		}
    		return ans;
    	}
	
//Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
// we apply simple cyclic sort :
// where the element will be put to element -1 index 
// and where this condition not satisfied the missing element is that index+1;
// so we can append it to answer 
//  time complexity :O(n)
//  Space complexity :O(1)
	
	public static List<Integer> findDisappearedNumbersCyclicsort(int[] nums) {
	        List<Integer> ans = new ArrayList();
	        int index =0;
//	        cyclic sort
	        while(index<nums.length){
	            int correct = nums[index]-1;
	            if(nums[correct]!= nums[index]){
	                // check for duplicate values :
	                // swap:
	                int temp = nums[correct];
	                nums[correct]=nums[index];
	                nums[index]=temp;
	            }else{
	                index++;
	            }
	        }
//	        second pass to find missing elements
	        for(int i =0;i<nums.length;i++){
	            if(nums[i]-1!=i){
	                ans.add(i+1);
	            }
	        }
	        return ans;
	    }
	
//	    extra space solution :
//	    we create a new temp array of same length and
//	    nnow we increament the input element index of temp array by 1 
//	    at last all element which have increment greater then 0 will be present in input
//	    and we can iterate on temp and check which index are 0 and add those to the ans list 
//	    Time complexity: O(n)
//	    Space complexity: O(n)
	    public static List<Integer> findDisappearedNumbersExtraSpace(int[] nums) {
	        // extra space  approch:
	        List<Integer> ans = new ArrayList();
//	    	temp array 
	        int temp[] = new int [nums.length];
//	        initalization of temp
	        for(int i =0;i<nums.length;i++){
	            temp[nums[i]-1]++;
	        }
//	        finding the missing element
	        for(int i=0;i<temp.length;i++){
	            if(temp[i]==0){
	                ans.add(i+1);
	            }
	        }
	        return ans;
	    }
	    public static boolean check(List<Integer> ans, List<Integer> output) {
	    	if(ans.size()!=output.size()) {return false;}
	    	for(int i =0;i<ans.size();i++) {
	    		if(ans.get(i)!=output.get(i)) {return false;}
	    	}
	    	return true;
	    }
	    
	public static void main(String[] args) {
		//Example 1:
		//

		int []nums1 = {4,3,2,7,8,2,3,1};
		List<Integer> output1= new ArrayList(Arrays.asList(5,6));
		List<Integer> ans1 = findDisappearedNumbersBruteForce(nums1);
		System.out.println("Brute Force approch :");
		if(check(ans1, output1)) {
			System.out.println("Case 1 Passed");
		}else {			
			System.out.println("Case 1 Failed");
		}
		
		//Example 2:
		//
		//Input: nums = [1,1]
		//Output: [2]
		int []nums2 = {1,1};
		List<Integer> output2= new ArrayList(Arrays.asList(2));
		List<Integer> ans2 = findDisappearedNumbersBruteForce(nums2);
		if(check(ans2, output2)) {
			System.out.println("Case 2 Passed");
		}else {			
			System.out.println("Case 2 Failed");
		}
//		extra space :
		
		ans1=findDisappearedNumbersExtraSpace(nums1);
		System.out.println("Extra space approch :");
		if(check(ans1, output1)) {
			System.out.println("Case 1 Passed");
		}else {			
			System.out.println("Case 1 Failed");
		}
		
		ans2=findDisappearedNumbersExtraSpace(nums2);
		if(check(ans2, output2)) {
			System.out.println("Case 2 Passed");
		}else {			
			System.out.println("Case 2 Failed");
		}
//		Cyclic sortr approch:
		
		ans1=findDisappearedNumbersCyclicsort(nums1);
		System.out.println("cyclic sort approch :");
		if(check(ans1, output1)) {
			System.out.println("Case 1 Passed");
		}else {			
			System.out.println("Case 1 Failed");
		}
		
		ans2=findDisappearedNumbersCyclicsort(nums2);
		if(check(ans2, output2)) {
			System.out.println("Case 2 Passed");
		}else {			
			System.out.println("Case 2 Failed");
		}


	}

}
