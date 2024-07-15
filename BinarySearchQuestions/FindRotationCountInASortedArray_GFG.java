package BinarySearchQuestions;

public class FindRotationCountInASortedArray_GFG {
//	 here we search the pivot which can be found where the condition of ascending order is vooilated like nums[i]<nums[i+1]
	public static int findRotationCountBruteForce(int[] nums) {
		for(int i =0;i<nums.length-1;i++) {
			if(!(nums[i]<nums[i+1])) {
				return i+1;
			}
		}
		return 0;
	}
	
//	 find pivot :
//	 before starting with this one here is a intution behind
//	 their are 2 condition to check the number we are on is a pivote :
//	 case 1:
//	     s   pm      e
//		[4,5,(6),1,2,3]-> here 6 is pivot
//	 now assume the start =index of(4) , end= index of(3) ,and mid = index of(6)
//	 so if we check mid> mid+1 we get our pivote 
//	 why because we can see it the entire array is on ascending order 
//	 except where pivote so we found pivote at [mid] is it breaks the rule
//	 so case 1: if(nums[mid]>nums[mid+1]){ return  }
	 
//	 case 2:
//	     s    p   m   e
//		[4,5,(6),1,2,3]-> here 6 is pivot
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
	 
	public static int findRotationCountOptimize(int[] nums) {
		int s=0;
		int e=nums.length-1;
//		
		while(s<=e) {
			int mid =s+(e-s)/2;
//		case 1 :
			if(mid<e && nums[mid]>nums[mid+1]) {
//				because pivote is the index and count is pivote+1
				return mid+1;
			}
			if(mid>s && nums[mid]<nums[mid-1]) {
				return mid;
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
		return 0;
		
	}
	
public static void main(String[] args) {
	System.out.println("Brute force");
// Example 1:
 int [] input1= {4,5,6,1,2,3};	
 int output1=3; 
 if(findRotationCountBruteForce(input1)==output1) {
	 System.out.println("Case 1 Passed");
 }else {
	 System.out.println("Case 1 Failed");	 
 }
 
// Example 2:
 
 int [] input2= {15,18,2,3,6,12};	
 int output2=2;
 
 if(findRotationCountBruteForce(input2)==output2) {
	 System.out.println("Case 2 Passed");
 }else {
	 System.out.println("Case 2 Failed");	 
 }
 
// Example 3:
 
 int [] input3= {7,9,11,12,5};	
 int output3=4;
 
 if(findRotationCountBruteForce(input3)==output3) {
	 System.out.println("Case 3 Passed");
 }else {
	 System.out.println("Case 3 Failed "+findRotationCountBruteForce(input3));	 
 }
 System.out.println("Optimze");
 
 if(findRotationCountOptimize(input1)==output1) {
	 System.out.println("Case 1 Passed");
 }else {
	 System.out.println("Case 1 Failed");	 
 }
 
 if(findRotationCountOptimize(input2)==output2) {
	 System.out.println("Case 2 Passed");
 }else {
	 System.out.println("Case 2 Failed "+findRotationCountOptimize(input2));	 
 }
 if(findRotationCountOptimize(input3)==output3) {
	 System.out.println("Case 3 Passed");
 }else {
	 System.out.println("Case 3 Failed");	 
 }
 
 int [] input4= {7,9,11,12};	
 int output4=0;
 
 if(findRotationCountOptimize(input4)==output4) {
	 System.out.println("Case 4 Passed");
 }else {
	 System.out.println("Case 4 Failed");	 
 }
 
}
}
