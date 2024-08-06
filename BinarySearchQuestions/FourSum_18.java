//18. 4Sum
//Solved
//Medium
//Topics
//Companies
//Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
//
//0 <= a, b, c, d < n
//a, b, c, and d are distinct.
//nums[a] + nums[b] + nums[c] + nums[d] == target
//You may return the answer in any order.
//

//Example 1:
//
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

//Example 2:
//
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]

//Constraints:
//
//1 <= nums.length <= 200
//-109 <= nums[i] <= 109
//-109 <= target <= 109

package BinarySearchQuestions;
import java.util.*;
public class FourSum_18 {
//	this question solution is all similar just the difference is in time complexity AND WE WILL USE EXTRA 	loop	
//	for a new pointer :
//	time complexity : O(n^4)
	    public static List<List<Integer>> fourSumOptimize(int[] nums, int target) {
	        Arrays.sort(nums);
	        List<List<Integer>> ans = new ArrayList();
	        for(int i =0;i<nums.length;i++){
	            if(i>0 && nums[i]== nums[i-1]){continue;}
	            for(int j =i+1;j<nums.length;j++){
	            if(j!=i+1 && nums[j]== nums[j-1]){continue;}
	            int k =j+1;
	            int l = nums.length-1;
	            while(k<l){
	                long sum = (long)nums[i]+(long)nums[j]+(long)nums[k]+(long)nums[l];
	                if(target<sum){
	                    l--;
	                }else if(sum<target){
	                    k++;
	                }else{
	                    ans.add(new ArrayList(Arrays.asList(nums[i],nums[j],nums[k],nums[l])));
	                    k++;
	                    l--;
	                    while(k<l && nums[k]==nums[k-1]){k++;}
	                    while(k<l && nums[l]==nums[l+1]){l--;}
	                }
	            }
	            }
	        }
	        return ans;
	    }
	    public  static boolean check (List<List<Integer>> ans,List<List<Integer>> output  ) {
			if(ans.size()!=output.size()) {
				return false;
			}
			if(ans.size()==0 && output.size()==0) {
				return true;
			}
			for(int i =0;i<output.size();i++) {
				Collections.sort(output.get(i));
			}
			
			for(int i =0;i<ans.size();i++) {
				for(int j =0;j<ans.get(i).size();j++) {
					if(ans.get(i).get(j)!=output.get(i).get(j)) {
						return false;
					}
				}
			}
			return true;
		}
	    
	    
public static void main(String[] args) {
	
	//Example 1:
	//
	int [] nums1 = {1,0,-1,0,-2,2};
	int target1 = 0;
	List<List<Integer>> output1 = new ArrayList<>(Arrays.asList(new  ArrayList(Arrays.asList(-2,-1,1,2)),new  ArrayList(Arrays.asList(-2,0,0,2))));
	List<List<Integer>> ans1=fourSumOptimize(nums1, target1); 
	if(check(ans1,output1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	
	//Example 2:
	
	List<List<Integer>> output2 = new ArrayList<>(Arrays.asList(new  ArrayList(Arrays.asList(2,2,2,2))));	
	int [] nums2 = {2,2,2,2,2};
	int target2 = 8;
	List<List<Integer>> ans2=fourSumOptimize(nums2, target2); 
	if(check(ans2,output2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	
	//Example 3:
	
	List<List<Integer>> output3 = new ArrayList<>();	
	int [] nums3 = {1000000000,1000000000,1000000000,1000000000};
	int target3 = -294967296;
	List<List<Integer>> ans3=fourSumOptimize(nums3, target3); 
	if(check(ans3,output3)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}
}
}
