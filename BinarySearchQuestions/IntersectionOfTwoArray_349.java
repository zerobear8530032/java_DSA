//349. Intersection of Two Arrays
//Solved
//Easy
//Topics
//Companies
//Given two integer arrays nums1 and nums2, return an array of their 
//intersection
//. Each element in the result must be unique and you may return the result in any order.

//Example 1:
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2]

//Example 2:
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [9,4]

//Explanation: [4,9] is also accepted.
// 
//
//Constraints:
//
//1 <= nums1.length, nums2.length <= 1000
//0 <= nums1[i], nums2[i] <= 1000
package BinarySearchQuestions;
import java.util.*;
public class IntersectionOfTwoArray_349 {
//	brute force approch : 
//	apply linear search  for each element from array to second array and store common in a set:
//Time Complexity: O(m*n) 
//	Space Complexity: O(min(m,n))
//	The HashSet Numbers will store at most the minimum of the lengths of nums1 and nums2.
	public static int [] intersectionBruteForce(int[] nums1, int[] nums2) {
        HashSet <Integer> Numbers = new HashSet();
        for(int i =0;i<nums1.length;i++){
            int j =Search(nums2,nums1[i]);
            if(j>=0){
                if(!Numbers.contains(nums2[j])){
                Numbers.add(nums2[j]);
                }
            }
        }
        int ans [] = new int [Numbers.size()];
        int index =0;
        for(int i :Numbers){
            ans[index++]=i;
        }
        return ans;
    }
	static int  Search(int [] nums, int target){
        for(int i =0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
	
//	Faster look up :
//	here we can use 2 sets of array 1 , array 2 which will allow us to faster the look up of element for each  set items 
//	time complexity of converting array to sets : O(m+n)
//	then we can can check it in O(n) to create intersect 
//	and save the entire answer in the intersect set array at last we can returnt the result
//	Time Complexity: O(m+n)).
//	Space Complexity: O(m+n)
public static int [] intersectionFasterLookup(int[] nums1, int[] nums2) {
	HashSet<Integer> set1 = new HashSet<Integer>();
	HashSet<Integer> set2 = new HashSet<Integer>();
	HashSet<Integer> intersection = new HashSet<Integer>();
	
	for(int n:nums1) {
		set1.add(n);
	}
	
	for(int n:nums2) {
		set2.add(n);
	}
	
	for(Integer i:set1) {
		if(set2.contains(i)) {
			intersection.add(i);
		}
	}
	
	int [] ans = new int [intersection.size()];
	int i =0;
	for(int n :intersection) {
		ans[i++]=n;
	}
	return ans;
}
	
// reduce space complexit :
// here we can use less length set to make sure we can reduce the sspace :
// here we use 1 set less and we only need to go through each array only once 
//	space Complexity: O(min(m,n)).
//	time Complexity: O(m+n)
public static int [] intersectionReduceSpace(int[] nums1, int[] nums2) {
	HashSet<Integer> set1 = new HashSet();
	HashSet<Integer> intersect = new HashSet();
	if(nums1.length<nums2.length) {
	 for(int x : nums1) {
		 set1.add(x);
	 }
	 for(int n :nums2 ) {
		 if(set1.contains(n)) {
			intersect.add(n); 
		 }
	 }
	}else {
		for(int x : nums2) {			
			set1.add(x);
		}
		for(int n :nums1 ) {
			if(set1.contains(n)) {
				intersect.add(n);
			}
		}
	}
	
	int ans[] = new int[intersect.size()];
	int index =0;
	for( int x :intersect) {
		ans[index++]=x;
	}
	return ans;
}

// this is one more approch which is more time consuming 
// here we sort the entire 2 arrays 
// and search for each element in second array with binary search 
// here we sort one array which is smaller now we can go through all 
//the elment in array 2 and check if the element is present in the sorted one with binary search 
//Time Complexity: O(max(mlogm,nlogn))
//Space Complexity: O(min(m,n))
public static int [] intersectionBinarySearch (int[] nums1, int[] nums2) {
	
//	for sorting i am using sort function here because this file already got lot of line of code 
HashSet<Integer> intersect = new HashSet();
if(nums1.length<nums2.length) {
	Arrays.sort(nums1);
	for(int n:nums2) {
		if(binarySearch(nums1, n)!=-1) {
			intersect.add(n);
		}
	}
}else {
	Arrays.sort(nums2);
	for(int n:nums1) {
		if(binarySearch(nums2, n)!=-1) {
			intersect.add(n);
		}
	}
}
int ans[] = new int[intersect.size()];
int index =0;
for( int x :intersect) {
	ans[index++]=x;
}
return ans;




	
}
public static int binarySearch(int [] nums, int target) {
	int s =0;
	int e=nums.length-1;
	while(s<=e) {
		int mid =s+(e-s)/2;
		if(nums[mid]==target) {
			return mid;
		}else if(nums[mid]<target) {
			s=mid+1;
		}else {
			e=mid-1;
		}
	}
	return -1;
}


	
	public static boolean check(int ans[], int [] output) {
		if(ans.length!=output.length) {
			return false;			
		}
		for(int i =0;i<ans.length;i++) {
			if(Search(output,ans[i])==-1) {
				return false;
			}
		}
		return true;
	}
public static void main(String[] args) {
	//Example 1:
	int []nums11 = {1,2,2,1}, nums12 = {2,2};
	int output1[]= {2};
	int []ans1 = intersectionBruteForce(nums11, nums12);
	if(check(ans1,output1)) {
		System.out.println("Case 1 Passed ");
	}else {
		System.out.println("Case 1 Failed ");		
	}
		
	//Example 2:
	int []nums21 = {4,9,5}, nums22 = {9,4,9,8,4};
	int output2[]= {9,4};
	
	int []ans2 = intersectionBruteForce(nums21, nums22);
	
	if(check(ans2,output2)) {
		System.out.println("Case 2 Passed ");
	}else {
		System.out.println("Case 2 Failed ");		
	}
	
	
//	faster look up method :
	ans1=intersectionFasterLookup(nums11, nums12);
	if(check(ans1,output1)) {
		System.out.println("Case 1 Passed ");
	}else {
		System.out.println("Case 1 Failed ");		
	}
	ans2=intersectionFasterLookup(nums21, nums22);
	
	if(check(ans2,output2)) {
		System.out.println("Case 2 Passed ");
	}else {
		System.out.println("Case 2 Failed ");		
	}
	
	
//	reduce space :
	ans1=intersectionReduceSpace(nums11, nums12);
	if(check(ans1,output1)) {
		System.out.println("Case 1 Passed ");
	}else {
		System.out.println("Case 1 Failed ");		
	}
	ans2=intersectionReduceSpace(nums21, nums22);
	
	if(check(ans2,output2)) {
		System.out.println("Case 2 Passed ");
	}else {
		System.out.println("Case 2 Failed ");		
	}
	
//	binary search :
	ans1=intersectionBinarySearch(nums11, nums12);
	if(check(ans1,output1)) {
		System.out.println("Case 1 Passed ");
	}else {
		System.out.println("Case 1 Failed ");		
	}
	ans2=intersectionBinarySearch(nums21, nums22);
	
	if(check(ans2,output2)) {
		System.out.println("Case 2 Passed ");
	}else {
		System.out.println("Case 2 Failed ");		
	}
	
	
	
}
}

