//350. Intersection of Two Arrays II
//Solved
//Easy
//Topics
//Companies
//Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
//
//Example 1:
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2,2]

//Example 2:
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [4,9]
//Explanation: [9,4] is also accepted.
// 

//Constraints:
//
//1 <= nums1.length, nums2.length <= 1000
//0 <= nums1[i], nums2[i] <= 1000
// 
//
//Follow up: come after sorting question:
//***********************************************************************************
//What if the given array is already sorted? How would you optimize your algorithm?
//What if nums1's size is small compared to nums2's size? Which algorithm is better?
//What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
//***********************************************************************************
package BinarySearchQuestions;
import java.util.*;
public class InterSectionOfTwoArrays2_350 {
//	approch: we will search every element in the first array in second array and add element which are present in the intersection and return the result:
	
	public static  int[] intersect(int[] nums1, int[] nums2) {
	     ArrayList<Integer> temp = new ArrayList();
	    for(int i =0;i<nums1.length;i++){
	        int j = search(nums2,nums1[i]);
	        if(j!=-1){
	            temp.add(nums2[j]);
	            nums2[j]=-1;
	        }
	    }
	    //  System.out.println(temp);
	     int ans [] = new int [temp.size()];
	     int i =0;
	     for( int x : temp){
	        ans[i++]=x;

	     }

	return ans;
	    }
	
       public static int search(int [] nums , int target){
           for(int x=0;x< nums.length;x++){
               if(target == nums[x]){
                   return x;
               }
           }
           return -1;
       }

   	public static boolean check(int ans[], int [] output) {
		if(ans.length!=output.length) {
			return false;			
		}
		for(int i =0;i<ans.length;i++) {
			if(search(output,ans[i])==-1) {
				return false;
			}
		}
		return true;
	}
public static void main(String[] args) {
		//Example 1:
		int [] nums11 = {1,2,2,1}, nums12 = {2,2};
		int []output1= {2,2};
		int [] ans1=intersect(nums11, nums12);	
		
		if(check(ans1,output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		//Example 2:
		//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
		//Output: [4,9]
		int [] nums21 = {4,9,5}, nums22 = {9,4,9,8,4};
		int []output2= {4,9};
		int [] ans2=intersect(nums21, nums22);
		
		//Explanation: [9,4] is also accepted.
		
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
	
}
}
