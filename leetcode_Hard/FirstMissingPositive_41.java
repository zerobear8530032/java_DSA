//41. First Missing Positive
//Hard
//Hint
//Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
//You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
//Example 1:
//Input: nums = [1,2,0]
//Output: 3
//Explanation: The numbers in the range [1,2] are all in the array.
//Example 2:
//Input: nums = [3,4,-1,1]
//Output: 2
//Explanation: 1 is in the array but 2 is missing.
//Example 3:
//Input: nums = [7,8,9,11,12]
//Output: 1
//Explanation: The smallest positive integer 1 is missing.
//Constraints:
//1 <= nums.length <= 105
//-231 <= nums[i] <= 231 - 1
package leetcode_Hard;
import java.util.*;

public class FirstMissingPositive_41 {
	
//	note : the below approches get the job done but not follows the contrain of using o(1) space 
//approch :	
	
//	1: add all element to the hashmap to remove duplicated 
//	2: find the min positive  value excluding zero and max of nums array 
//	3: now hashmap will contains all nums and min , max value 
//	4: if min value is greater then 1 then we knew the smallest positive integer missing is 1
//	5: but if the min value is 1 then we need to search through min to max  and return the value which is missing in the hashmap 
//	6: if every single value is present in the in  the hashmap that means the answer is max+1 because from min to max every valye is present 
//	time complexity : o(n)
//	space complexity o(n)
	public static int firstMissingPositiveBruteForce(int[] nums) {
		HashMap <Integer,Integer> map = new HashMap();
		int min =Integer.MAX_VALUE;
		int max =Integer.MIN_VALUE;
		int ans =1;
		for(int i =0;i<nums.length;i++) {
			if(nums[i]>0) {    			
				map.put(nums[i],0);
			}
			if(min>nums[i] && nums[i]>0) {
				min=nums[i];
			}
			if(max<nums[i] ) {
				max=nums[i];
			}
		}
		System.out.println(map);
		System.out.println("max "+max);
		System.out.println("min "+min);
//		if max == map.size() means every element present in the array which are non negative and not zero in the map equal to max means the entire min to max elements are present inside the hashset  
		if(max==map.size()) {
			return max+1;
		}
		if(min >1) {
			return ans;
		}else {
			for(int i =min;i<=max;i++) {
				if(!map.containsKey(i)) {
					ans=i;
					break;
				}
				System.out.println(i);
			}			
		}
		return ans;
	}
	
//	better then brute force approch:
//	approch :
//	1. first we add all non positive integer excluding 0 in a hash map
//	2. now we willl check from 1 to length of hashmap wheather the i is present in the map if its not we return i else we will check next 
//	3. if the entire hash set is traversed and no number is missing then the number missing is size iof hashset +1 // this is outcome of brute force approch
	 public static int firstMissingPositive(int[] nums) {
		 HashMap <Integer,Integer> map = new HashMap();
			for(int i =0;i<nums.length;i++) {
				if(nums[i]>0) {    			
					map.put(nums[i],0);
				}				
			}
			System.out.println(map+" "+map.size());
			int ans = map.size()+1;;
			for(int i =1;i<=map.size();i++) {
				if(!map.containsKey(i)) {
					ans=i;
					break;
				}
			}    
			return ans;
	 }
	
public static void main(String args[]) {
//Example 1:
int []nums1 = {1,2,0};
int Output1=3;
//Explanation: The numbers in the range [1,2] are all in the array.
//Example 2:
int []nums2 = {3,4,-1,1};
int Output2=2;
//Explanation: 1 is in the array but 2 is missing.
//Example 3:
int []nums3 = {7,8,9,11,12};
int Output3= 1;
int []nums4 = {0,-1,3,1};
int Output4= 2;
int []nums5 = {2};
int Output5= 1;
//	int ans1=firstMissingPositive(nums1);
//	int ans2=firstMissingPositive(nums2);
//	int ans3=firstMissingPositive(nums3);
//	int ans4=firstMissingPositiveBruteForce(nums4);
//	int ans1=firstMissingPositive(nums1);
//	int ans2=firstMissingPositive(nums2);
//	int ans3=firstMissingPositive(nums3);
//	int ans4=firstMissingPositive(nums4);
	int ans5=firstMissingPositive(nums5);
//if(ans1==Output1) {
//	System.out.println("Case 1 Passed");
//}else {
//	System.out.println("Case 1 Failed");	
//	System.out.println("program output"+ans1+" correct anwser"+Output1);
//}
//if(ans2==Output2) {
//	System.out.println("Case 2 Passed");
//}else {
//	System.out.println("Case 2 Failed");
//	System.out.println("program output"+ans2+" correct anwser"+Output2);
//}
//if(ans3==Output3) {
//	System.out.println("Case 3 Passed");
//}else {
//	System.out.println("Case 3 Failed");	
//	System.out.println("program output"+ans3+" correct anwser"+Output3);
//}
//if(ans4==Output4) {
//	System.out.println("Case 4 Passed");
//}else {
//	System.out.println("Case 4 Failed");	
//	System.out.println("program output"+ans4+" correct anwser"+Output4);
//}
if(ans5==Output5) {
	System.out.println("Case 5 Passed");
}else {
	System.out.println("Case 5 Failed");	
	System.out.println("program output"+ans5+" correct anwser"+Output5);
}


	
	
	
	
}
}
