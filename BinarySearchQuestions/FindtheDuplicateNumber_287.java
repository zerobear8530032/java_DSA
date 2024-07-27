//287. Find the Duplicate Number
//Solved
//Medium
//Topics
//Companies
//Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//
//There is only one repeated number in nums, return this repeated number.
//
//You must solve the problem without modifying the array nums and uses only constant extra space.
//

//Example 1:
//
//Input: nums = [1,3,4,2,2]
//Output: 2
//Example 2:
//
//Input: nums = [3,1,3,4,2]
//Output: 3
//Example 3:
//
//Input: nums = [3,3,3,3,3]
//Output: 3
// 
//
//Constraints:
//
//1 <= n <= 105
//nums.length == n + 1
//1 <= nums[i] <= n
//All the integers in nums appear only once except for precisely one integer which appears two or more times.
package BinarySearchQuestions;
import java.util.*;
public class FindtheDuplicateNumber_287 {
//	this approch is another approch which get the answer but it required to modify the array :
//	which is not allowed in the contrain but approch is given for better understanding
	
// here we can see all element are valid index why because all element lie btw 1 to n and length of array is n+1
//	means we can use each index element to check which element it goes to if we change that visited element 
//	to negetive then we can check wheather the element which we visit is negeative if yes means we visited it from some other index :
	
//	time complexity : O(n)
//	Space complexity : O(1)
//	this approch modify array which is not allowed
	   public static  int findDuplicateHashing(int[] nums) {
	        for(int i =0;i<nums.length;i++){
	           if(nums[Math.abs(nums[i])]<0){
	            return Math.abs(nums[i]);
	           }else{
	            nums[Math.abs(nums[i])]=nums[Math.abs(nums[i])]*-1;
	           }
	        }
	        return -1;
	    }
//	here we just create a set by traversing each element and check it already exist in it :
//	   but this approch need exxtra space which is against constrain:
	   
//	  time complexity : O(n)	  
//	  space complexity : O(n)
	  
	   public static  int findDuplicateExtraSpace(int[] nums) {
		   HashSet <Integer> numbers = new HashSet();
		   for(int i =0;i<nums.length;i++){
			   if(numbers.contains(nums[i])) {
				   return nums[i];
			   }else {
				   numbers.add(nums[i]);
			   }
		   }
		   
		   return -1;
	   }
	   
	
//	this approch is also called turtle and hare or 2 pointer :
//	it contain 2 pointer 1 slow pointer goes 1 step at a time 
//	second fast which goes 2 step at a time 
//	so this allow us to locate a cycle in the array because every element in teh array is a valid index we can apply
//	this because if there is a duplicate element 
//	we can be stuck in a cycle :
//	example :
//	[1,3,4,2,2]
//	we can go nums[0]= 1
//	we can go nums[1]= 3
//	we can go nums[3]= 2
//	we can go nums[2]= 4
//	we can go nums[2]= 4
//	here we can see a cycle 1-> 3-> 2->4
//									^  |
//					                |----
//	time complexity = O(n)
	    public static int findDuplicateTrutleAndHare(int[] nums) {
	        int slow = nums[0];
	        int fast  = nums[0];
	        slow = nums[slow];
	        fast = nums[nums[fast]];
// thiswilll loop uuntil both pointer reaches 
	        while(slow!=fast){
	        slow = nums[slow];
	        fast = nums[nums[fast]];
	        }
//	        once we reach the  a cycle we need to get the  starting of that :
	        slow = nums[0];
	        while(slow!=fast){
	            slow = nums[slow];
	            fast = nums[fast];
	        }

	        return fast;
	    }
	
	
	    
	    
	    
	    
//	Binary search approch :
//	this probllem have multiple answers but because of contrain we can only use some approches
//	Binary search approch :
//	approch:
//	using binary search we ccan find the element which is repeated how ?
//	here is the intution 
//	1 : in contrain its given their are only 1 - n  elements in n+1 length off array 
//	so their is some case where we can proof there will be only n unique elements 
//	assume length is 5 of array = []
//	the element there could be [1,2,3,4,5]
//	but if we increase llength by 1 [1,2,3,4,5, ]-> here we cant put any character btw 1- n which is not already present 
//	because already 1 to n is present so there will be 1 elemennt which will repeat 
//	now if we know this 
//	we can apply binary search 
//	now we know one thing if all element are unique in a array assume array length = 4 with all unqiue
//	[1,2,3,4] : so if we see 1 there is only 1 element which is less or equal to 1 
//	same with 2 : in array there is 1 , 2 which are  2 element which are equal or small then element
//	same goes with 3 and 4 there are 3 and 4 elemen which are equal or smaller then current element 
//	so we can say our anwer will liy btw 1 to n 
//	and we can calculate mid and assume the elemet as a duplicate then we can chcek how many elemennt are equal or smaller then elements :
//	if the duplicate lies in this range the count of less or equal number will be higher then mid 
//	so we can say the element will lie btw 1- mid:
//	 why assume array  = [1,3,4,2,2]
//	 if mid = 3 :
//	so the element equal or less will be (4) which is greater then the element
//	so we can say mid is also a possible answer so we do end = mid not mid+1
	
//	else we can do start = start+1
//	because oif mid = 1: [1,3,4,2,2]
//	then there is only 1 element equal or greater then it self means its correct 
	
//		time complexity : O(N log n): 
//		space complexity : O(1): 
	    public static  int findDuplicateBinarySearch(int[] nums) {
	        int start =0;
	        int end =nums.length;
	        while(start<end){
	            int mid = start+(end-start)/2;
	            if(getlesserorequal(nums,mid)>mid){
	                end = mid;
	            }else{
	                start=mid+1;
	            }

	        }
	        return start;
	    }
//	     this will count the element less or equal
	    public static int getlesserorequal(int [] nums,int mid){
	        int count=0;
	        for(int c: nums){
	            if(c<=mid){
	                count++;
	            }
	        }
	        return count;
	    }
	
	
	
	public static void main(String[] args) {
// Binary search 

		System.out.println("Binary seach method");
		//		Example 1:
			int []nums1 = {1,3,4,2,2};
			int output1= 2;
			
			if(findDuplicateBinarySearch(nums1)== output1) {
				System.out.println("Case 1 Passed");
			}else {
				System.out.println("Case 1 Failed");				
			}

			//		Example 2:

			int []nums2 = {3,1,3,4,2};
			int output2= 3;
			
			if(findDuplicateBinarySearch(nums2)== output2) {
				System.out.println("Case 2 Passed");
			}else {
				System.out.println("Case 2 Failed");				
			}
			//		Example 3:
			int []nums3 = {3,3,3,3,3};
			int output3= 3;

			if(findDuplicateBinarySearch(nums3)== output3) {
				System.out.println("Case 3 Passed");
			}else {
				System.out.println("Case 3 Failed");				
			}

//			2 Pointer technique :
			System.out.println("2 pointer method");
			if(findDuplicateTrutleAndHare(nums1)== output1) {
				System.out.println("Case 1 Passed");
			}else {
				System.out.println("Case 1 Failed");				
			}
			if(findDuplicateTrutleAndHare(nums2)== output2) {
				System.out.println("Case 2 Passed");
			}else {
				System.out.println("Case 2 Failed");				
			}
			if(findDuplicateTrutleAndHare(nums3)== output3) {
				System.out.println("Case 3 Passed");
			}else {
				System.out.println("Case 3 Failed");				
			}
		
//			using extra space :
			
			System.out.println("Extra space ");
			if(findDuplicateExtraSpace(nums1)== output1) {
				System.out.println("Case 1 Passed");
			}else {
				System.out.println("Case 1 Failed");				
			}
			if(findDuplicateExtraSpace(nums2)==output2) {
				System.out.println("Case 2 Passed");
			}else {
				System.out.println("Case 2 Failed");				
			}
			if(findDuplicateExtraSpace(nums3)== output3) {
				System.out.println("Case 3 Passed");
			}else {
				System.out.println("Case 3 Failed");				
			}
						
// modify array :	
			System.out.println("array hashing ");
			if(findDuplicateHashing(nums1)== output1) {
				System.out.println("Case 1 Passed");
			}else {
				System.out.println("Case 1 Failed");				
			}
			if(findDuplicateHashing(nums2)==output2) {
				System.out.println("Case 2 Passed");
			}else {
				System.out.println("Case 2 Failed");				
			}
			if(findDuplicateHashing(nums3)== output3) {
				System.out.println("Case 3 Passed");
			}else {
				System.out.println("Case 3 Failed");				
			}
			
			
}
}
