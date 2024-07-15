//540. Single Element in a Sorted Array
//Solved
//Medium
//Topics
//Companies
//You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
//Return the single element that appears only once.
//Your solution must run in O(log n) time and O(1) space.

//Example 1:
//Input: nums = [1,1,2,3,3,4,4,8,8]
//Output: 2

//Example 2:
//Input: nums = [3,3,7,7,10,11,11]
//Output: 10

//Constraints:
//
//1 <= nums.length <= 105
//0 <= nums[i] <= 105

package BinarySearchQuestions;
import java.util.*;
public class SingleElementinaSortedArray_540 {
//	Brute force approch:
//	here we create a hashmap and append each element in it as key and its frequnecy as value
//	now we will iterate over that hashmap and check which key have value ==1
//	works for any number of repeated element we always get the element which occur single
//	time complexity : O(n) for hashmap creating 
//	O(n) : for finding key 
//	space complexity :  O(n) : for hashmap
//	o(n) to get the key value pairs 
	public static int singleNonDuplicateBruteForce(int[] nums) {
		
        HashMap <Integer,Integer>map=new HashMap();
        for(int x :nums){
            if(map.containsKey(x)){
            map.put(x,map.get(x)+1);
            }else{
                map.put(x,1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(value == 1){
                return key;
            }
        }

       return -1;
    }
	
//	approch : binary Search 
	
//	here intution is that we does not know how to reach the element 
//	we can check nums[mid]!=nums[mid-1] && nums[mid]==nums[mid+1] then we get the element 
//	but we does not know how to reach it 
	
//	to reach it :
//	we know according to contrain the element each is only have 2 occurences means every element comes 2 time
//	except what we want to find and array is sorted means if there are duplicates they will be with each other
//	so now we can say  if first element is not equal to second element we found our answer
//	and we can also say if last element is not equal to second last we found our answer
	
//	now we need to under stand one thing : because every element will be repeated 2 times except 1 
//	so the element which are repeating will be on 2 indexes first even and second odd
//	example {1,1,2,2,(3),4,4,5,5,8,8}
//	so here 1,1 are on index 0, 1  and 2,2 are on 2,3
//	so we can see the pattern if we are on left side of our element 
//	if ((mid%2==0 && nums[mid]==nums[mid-1]) )
//	this condition will help us to go left :
//	if we go right side we can see condition is broke 
//	but their are some cases which can lead to wrong answer with this case 
//	what if {7,7,10,11,11,12,12}; here when we cacluate mid it will skip the element
//	so we also need to check this condition also :(mid%2==1 && nums[mid]==nums[mid+1])
//	if both above condition are true we will search left 
//	other wise right 
//	at the end we will get the elemennt
	public static int singleNonDuplicateOptimize(int[] nums) {
		int start =0;
		int end =nums.length-1;
//		start and end element check allow us to check mid +1 , mid-1 because it can generate error
//		if length == 1
		if (nums.length==1) {
			return nums[0];
		}
//		check start element
		if(nums[0]!=nums[1]) {
			return nums[0];
		}
//		check last element 
		if(nums[end]!=nums[end-1]) {
			return nums[end];
		}
//		binnary search
		while(start<=end) {
			int mid= start+(end-start)/2;
//			check for element 
			if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]) {
				return nums[mid];
			}
//			search left
			if((mid%2==0 && nums[mid]==nums[mid-1]) ||(mid%2==1 && nums[mid]==nums[mid+1])) {
				end =mid-1;
//			search right
			}else {
				start=mid+1;
			}
		}
	return -1;	
	}
	
	
public static void main(String[] args) {
	//Example 1:
	int []nums1 = {1,1,2,3,3,4,4,8,8};
	int output1=2;

	//Example 2:
	int []nums2 = {3,3,7,7,10,11,11};
	int output2=10;
	
	//Example 3:
	int []nums3 = {7,7,10,11,11,12,12};
	int output3=10;
	
	int [] nums4= {1,2,2,3,3,4,4};
	int output4=1;
	
	int [] nums5= {1,1,2,2,3,3,4,4,5};
	int output5=5;
	
	if(output1==singleNonDuplicateBruteForce(nums1)) {
		System.out.println("Case 1 Passed ");
	}else {
		System.out.println("Case 1 Failed ");		
	}
	
	if(output2==singleNonDuplicateBruteForce(nums2)) {
		System.out.println("Case 2 Passed ");
	}else {
		System.out.println("Case 2 Failed ");		
	}
	
	if(output3==singleNonDuplicateBruteForce(nums3)) {
		System.out.println("Case 3 Passed ");
	}else {
		System.out.println("Case 3 Failed ");		
	}
	
	if(output4==singleNonDuplicateBruteForce(nums4)) {
		System.out.println("Case 4 Passed ");
	}else {
		System.out.println("Case 4 Failed ");		
	}
	
	if(output5==singleNonDuplicateBruteForce(nums5)) {
		System.out.println("Case 5 Passed ");
	}else {
		System.out.println("Case 5 Failed ");		
	}

	//	optimize approch:
	
	if(output1==singleNonDuplicateOptimize(nums1)) {
		System.out.println("Case 1 Passed ");
	}else {
		System.out.println("Case 1 Failed ");		
	}
	
	if(output2==singleNonDuplicateOptimize(nums2)) {
		System.out.println("Case 2 Passed ");
	}else {
		System.out.println("Case 2 Failed ");		
	}
	
	if(output3==singleNonDuplicateOptimize(nums3)) {
		System.out.println("Case 3 Passed ");
	}else {
		System.out.println("Case 3 Failed ");		
	}
	
	if(output4==singleNonDuplicateOptimize(nums4)) {
		System.out.println("Case 4 Passed ");
	}else {
		System.out.println("Case 4 Failed ");		
	}
	
	if(output5==singleNonDuplicateOptimize(nums5)) {
		System.out.println("Case 5 Passed ");
	}else {
		System.out.println("Case 5 Failed ");		
	}
	
	
	
	
	
	
}
}
