//33. Search in Rotated Sorted Array
//Medium
//Topics
//Companies
//There is an integer array nums sorted in ascending order (with distinct values).
//Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
//Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
//You must write an algorithm with O(log n) runtime complexity.
//Example 1:
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
//Example 2:
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
//Example 3:
//Input: nums = [1], target = 0
//Output: -1

//Constraints:
//1 <= nums.length <= 5000
//-104 <= nums[i] <= 104
//All values of nums are unique.
//nums is an ascending array that is possibly rotated.
//-104 <= target <= 104
package BinarySearchQuestions;

public class RotatedBinarySeaarch_33 {
//	Linear seach : time complexity is O(n):
	 public static int searchBruteForce(int[] nums, int target) {
	        // linear search
	        for(int i =0;i<nums.length;i++){
	            if(nums[i]==target){
	                return i;
	            }
	        } 
	        return -1;
	    }
//	 Binary seach :
//	 ************************************************************************************
//	 note: the below solution does not get apply on the array containing duplicate value 
//	 binary seach part is ok but the pivote part will raise some errors
//	 ************************************************************************************	 
//	 approch :
//	 1. find the pivot (the pivot is the last element of the original array which is shifted from its position)
//	 example : [1,2,3,4,5,6] 
//	 1 rotation->[6,1,2,3,4,5]
//	 2 rotation->[5,6,1,2,3,4]
//	 3 rotation->[4,5,6,1,2,3]
//	 here we rotate array 3 times now the pivot is the element which was the last index of the inital array or sorted array 
//	 so here 6 is the pivote which is at (3 index)
//	 now once we know the pivot we can see the index from 0 till pivote are all ascending sorted
//	 and the element from pivote+1 till end are also ascending sorted so we will apply binary seach on them and get our answer
//	 else we can return -1 if not found
//   so here 4,5 ,(6),1,2,3-> if we want to find 3
//	 so we can apply binary search on right hand side 
//	 if we want to find 5 we can apply binary search on left hand side
//	 we can figure this out with simple condition
//	 if start index of array is < target (if(nums[0]<=target) so we have to find the left hand side 
//	 because all element smaller are on right hand side of pivote
//	 else if target<nums[0]: so we will search on the right hand side of pivote because all element bigger then target are at left side
	 
	 
	 public static int searchOptimize(int[] nums, int target) {
//		 starting of function
		 int s =0;
		 int e =nums.length-1;
		 
//		 get the pivote
		 int pivot=findpivot(nums);
		 System.out.println("found pivot"+pivot);
//  if the pivote is not found means entire array is sorted then apply binary seach on the entire array 
		 if(pivot==-1) {
			 return binarySearch(nums,target,0,nums.length-1);
		 }
//		 if nums[pivote] == target  means we got our answer 
		 if(nums[pivot]==target) {
			 return pivot;
		 }
//		 if (target >= nums[s]): means what the target lies in the left hand side of pivote so 
//		 we apply binary seach froom 0 till pivote -1 (we already check pivote before that why pivote -1)
		 if(target>= nums[s]) {
			 return binarySearch(nums,target,s,pivot-1);
//			 if (target<nums[s]) : mean the target lies in the right hand side of the pivote so
//			 we can apply binary seach from pivote+1 till end
		 }else {
			 return binarySearch(nums,target,pivot+1,e);			 
		 }
 }
	 
//	 binary search: simple binary seach which take start and end point in array and seach the target
	 
	 public static int binarySearch(int [] nums, int target , int start,int end) {
		 while(start<=end) {
			 int mid =start+(end-start)/2;
			 if(nums[mid]<target) {
				 start=mid+1;
			 }else if(nums[mid]>target) {
				 end=mid-1;
			 }else {
				 return mid;
			 }
		 }
		 return -1;
	 }
	 
	 
//	 find pivot :
//	 before starting with this one here is a intution behind
//	 their are 2 condition to check the number we are on is a pivote :
//	 case 1:
//	     s   pm      e
// 		[4,5,(6),1,2,3]-> here 6 is pivot
//	 now assume the start =index of(4) , end= index of(3) ,and mid = index of(6)
//	 so if we check mid> mid+1 we get our pivote 
//	 why because we can see it the entire array is on ascending order 
//	 except where pivote so we found pivote at [mid] is it breaks the rule
//	 so case 1: if(nums[mid]>nums[mid+1]){ return  }
	 
//	 case 2:
//	     s    p   m   e
// 		[4,5,(6),1,2,3]-> here 6 is pivot
//	 now assume the start =index of(4) , end= index of(3) ,and mid = index of(1)
//	 so if we check mid< mid-1 we get our pivote 
//	 why because we can see it the entire array is on descending order  if we see from end till start 
//	 except where pivote at mid-1 is it breaks the rule so we found pivote as mid-1;
//	 so case 2: if(nums[mid]<nums[mid-1]){ return mid-1  }
	 
//	 
//	 now we know how to get know a number is a pivote or not now we need to figure out how to reach the pivote
//	 	case 3: 
//	 [4,5,(6),1,2,3]-> here if we see the left and right side of pivote is the ascending order :
//	 but their is one more thing nums[0] < index of(p+1 till end)
//	 means the starting index is actually greater then the entire right side array of pivote
//	  so we can say if (nums[s]>=nums[mid]){e=mid-1;}
//	 why ? -> because if we know pivote will also be bigger then the entire right side so can skip the entire side and seach left 
//	 by reducing search space from right side
//	 so case 3:if (nums[s]>=nums[mid]){e=mid-1;}
//	 
//	 case 4:
//	 similarly their can be opposite of that  if(nums[s]<nums[mid]){s=mid+1}-> because if 
//	 mid is greater then we are on left side of seach space and the bigger number will be on right side so we can reduce the 
//	 search space from left
//	 so case 4: if(nums[s]<nums[mid]){s=mid+1}
//	 now if we apply each case we can find the pivote  
	 
	 
	public static int findpivot(int [] nums) {
		int s=0;
		int e=nums.length-1;
//		binary seach
				while(s<=e) {
					
				int mid =s+(e-s)/2;
//				case 1: we discuss earlier  (small adjustment their is a possibility that mid == e and 
//				then mid+1 will raise arrayoutofbound exception so we need to assume mid<e )
				if(mid<e && nums[mid]>nums[mid+1]) {
					return mid;
				}
//				case 2: we discuss earlier  (small adjustment their is a possibility that mid == s and 
//				then mid-1 will raise arrayoutofbound exception so we need to assume mid<e )
				if(mid>s && nums[mid]<nums[mid-1]) {
					return mid-1;
				}
//				case 3:
				if(nums[mid]<=nums[s]) {
					e=mid-1;
//					case 4:
				}else {
					s=mid+1;
				}
				
			}
//				if no pivote is found means the entire array is sorted so return -1;
				return -1;
	}

	public static int findpivotWithDuplicates(int [] nums) {
		int s=0;
		int e=nums.length-1;
//		
		while(s<=e) {
			int mid =s+(e-s)/2;
//			4,5,6,1,2,3
//		case 1 :
			if(mid<e && nums[mid]>nums[mid+1]) {
				return mid;
			}
			if(mid>s && nums[mid]<nums[mid-1]) {
				return mid-1;
			}
			if(nums[s]==nums[mid] && nums[mid]==nums[e]) {
//				skip duplicates
//				note but start and end could be pivotes
//			check start
				if(nums[s]>nums[s+1]) {
					return s;
				}	
//				check end
				if(nums[e]<nums[e-1]) {
					return e-1;
				}
				e--;
				s++;
			}
//			left side is sorted 
			else if(nums[s]<nums[mid] ||( nums[s]==nums[mid] && nums[e]<nums[mid])) {
				s=mid+1;
			}else {
				e=mid-1;
			}
			
		}
		return -1;
		

	}
	 
	
	
public static void main(String[] args) {
	//Example 1:
	int []nums1 = {4,5,6,7,0,1,2};
	int target1 = 0;
	int output1= 4;
	
//	if(output1==searchBruteForce(nums1,target1)) {
//		System.out.println("Case 1 Passed");
//	}else {
//		System.out.println("Case 1 Failed");		
//	}
	
	//Example 2:
	int []nums2 = {4,5,6,7,0,1,2};
	int target2 = 3;
	int output2= -1;
	
//	if(output2==searchBruteForce(nums2,target2)) {
//		System.out.println("Case 2 Passed");
//	}else {
//		System.out.println("Case 2 Failed");		
//	}
	
	//Example 3:
	int []nums3 = {1};
	int target3 = 0;
	int output3= -1;
	
//	if(output3==searchBruteForce(nums3,target3)) {
//		System.out.println("Case 3 Passed");
//	}else {
//		System.out.println("Case 3 Failed");		
//	}
	
	//Example 4:
	int []nums4 = {1,3,5};
	int target4 = 0;
	int output4= -1;
	
	
//	if(output4==searchBruteForce(nums4,target4)) {
//		System.out.println("Case 4 Passed");
//	}else {
//		System.out.println("Case 4 Failed");		
//	}
	
	//Example 5:
	int []nums5 = {3,5,1};
	int target5 = 0;
	int output5= -1;
	
//	if(output5==searchBruteForce(nums5,target5)) {
//		System.out.println("Case 5 Passed");
//	}else {
//		System.out.println("Case 5 Failed");		
//	}
	
//	if(output1==searchOptimize(nums1,target1)) {
//		System.out.println("Case 1 Passed");
//	}else {
//		System.out.println("Case 1 Failed");		
//	}
//	
//	
//	if(output2==searchOptimize(nums2,target2)) {
//		System.out.println("Case 2 Passed");
//	}else {
//		System.out.println("Case 2 Failed");		
//	}
//	
//	if(output3==searchOptimize(nums3,target3)) {
//		System.out.println("Case 3 Passed");
//	}else {
//		System.out.println("Case 3 Failed");		
//	}
//	
//	if(output4==searchOptimize(nums4,target4)) {
//		System.out.println("Case 4 Passed");
//	}else {
//		System.out.println("Case 4 Failed");		
//	}
	
	if(output5==searchOptimize(nums5,target5)) {
		System.out.println("Case 5 Passed");
	}else {
		System.out.println("Case 5 Failed");		
	}
}
}
