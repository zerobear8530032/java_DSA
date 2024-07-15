//238. Product of Array Except Self
//Solved
//Medium
//Companies
//Hint
//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//You must write an algorithm that runs in O(n) time and without using the division operation.
//Example 1:
//Input: nums = [1,2,3,4]
//Output: [24,12,8,6]
//Example 2:
//Input: nums = [-1,1,0,-3,3]
//Output: [0,0,9,0,0]
//Constraints:
//2 <= nums.length <= 105
//-30 <= nums[i] <= 30
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
package leetcode_Medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf_238 {
//	here approch we will use is the suffix and perfix multiplication :
//	we will use 2 passes to complete this :
//	1. pass 1 :
//	we will make  a output array of length same as input and prod =1;
//	now we will start a loop from  0 to length 
//	and assign prod to out[i]
//	then prod =prod*nums[i]
//	this will evaluate like this :
//	case 1 :
//	input :[1,2,3,4]
//	1:iteration :
//prod =1
//	out [0]=prod;(out[0]=1)
//	prod=prod*nums[0] (prod=1*1)
//	2: iteration:
//	out [1]=prod (out[1]=1)
//	prod=prod*nums[1] (prod=1*2)
//	3: iteration :
//	out[2]=prod (out[2]=2)
//	prod=prod*nums[2] (prod=2*3)
//	4:iteration :
//	out[3]=prod (out[3]=6)
//	prod=prod*nums[3] (prod=6*4)
//	 first pass completed as length is reached : now if we see it carefully we have computed the product of all element except self for all element on the left side 
//	ans store in output array :
//	after first pass out put =[1,1,2,6]
//	
//	Second pass:
//	prod=1;
//  now we have to calculate the right and side product :
// so we will create a revser loop from length -1 to the 0 index of the array :
//	1:iteration :
//prod =1
//	out [3]=prod*out[3];(out[3]=6)
//	prod=prod*nums[3] (prod=1*4) 
//	2: iteration:
//	out [2]=prod (out[2]=4)
//	prod=prod*nums[2] (prod=4*3)
//	3: iteration :
//	out[1]=prod (out[1]=12)
//	prod=prod*nums[1] (prod=12*2)
//	4:iteration :
//	out[0]=prod (out[0]=24)
//	prod=prod*nums[0] (prod=24*1)
//	 after second pass out put =[24,12,8,6]

    public static int[] productExceptSelf(int[] nums) {
        int l =nums.length;
        int out[]= new int [l];
        int prod=1;
        for(int i =0;i<l;i++){
            out[i]=prod;
        	prod=prod*nums[i];
        }
         System.out.println(Arrays.toString(out));
        prod=1;
        for(int i =l-1;i>=0;i--){
            out[i]=prod*out[i];
            prod=prod*nums[i];
        }
        System.out.println(Arrays.toString(out));
        return out;
    }
    static boolean check(int [] ans , int out []) {
    	for(int i =0;i<out.length;i++) {
    		if(out[i]!=ans[i]) {
    			return false;
    		}
    	}
    	return true;
    }
    public static void main(String args[]) {
    		int []nums1 = {1,2,3,4};
    		int [] out1 = {24,12,8,6};
    		int []nums2 = {-1,1,0,-3,3};
    		int [] out2 = {0,0,9,0,0};
    		int [] ans1 =productExceptSelf(nums1);    				
    		int [] ans2 =productExceptSelf(nums2);
    		if(check(out1,ans1)) {
    			System.out.println("Case 1 Passed ");
    		}else {
    			System.out.println("Case 1 Failed ");    			
    		}
    		if(check(out2,ans2)) {
    			System.out.println("Case 2 Passed ");
    		}else {
    			System.out.println("Case 2 Failed ");    			
    		}
    	}
    }
