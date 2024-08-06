//4. Median of Two Sorted Arrays
//Solved
//Hard
//Topics
//Companies
//Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//
//The overall run time complexity should be O(log (m+n)).
//
//
//Example 1:
//
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
//Example 2:
//
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// 
//
//Constraints:
//
//nums1.length == m
//nums2.length == n
//0 <= m <= 1000
//0 <= n <= 1000
//1 <= m + n <= 2000
//-106 <= nums1[i], nums2[i] <= 106
package BinarySearchQuestions;

import java.util.Arrays;

public class MedianofTwoSortedArrays_4 {
	
//	 we can solve this problem by figuring oout how many element can be on left side and how many can vbe on right side
//	of our median
//	see the solution it is not simple and required a lot of time to understand completely:
//	https://www.youtube.com/watch?v=F9c7LpRZWVQ&pp=ygUbbWVkaWFuIG9mIHR3byBzb3J0ZWQgYXJyYXlz
	
//	time complexity =O(Log(Min(N1,N2)))
//	space complexity =O(1)
	public static double findMedianSortedArraysOptimize(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n2<n1){return findMedianSortedArraysOptimize(nums2,nums1); }
        int start =0;
        int end = nums1.length;
        int left = (n1+n2+1)/2;
        while(start<=end){
            int mid1 = start+(end-start)/2;
            int mid2 = left-mid1;
            int l1 =Integer.MIN_VALUE;
            int l2 =Integer.MIN_VALUE;
            int r1 =Integer.MAX_VALUE;
            int r2 =Integer.MAX_VALUE;
            if(mid1<n1 ){r1=nums1[mid1];}
            if(mid2<n2 ){r2=nums2[mid2];}
            if(mid1-1 >= 0){l1=nums1[mid1-1];}
            if(mid2-1 >= 0){l2=nums2[mid2-1];}
            if(l1<=r2 && l2<=r1){
                if((n1+n2)%2==1){return Math.max(l1,l2);}
                return (Math.max(l1,l2)+Math.min(r1,r2))/2.f;
            }
            else if(l1>r2){end = mid1-1;}
            else{start=mid1+1;}
        }
        return -1;
    }
//	brute force:
//	allocate a new array which will combine both array and just returnn the median of that array :
    public static double findMedianSortedArraysBruteforce(int[] nums1, int[] nums2) {
    int arr []= new int [nums1.length+nums2.length];
    int index =0;
    for(int e:nums1){
        arr[index]=e;
        index ++;
    }    

    for(int e:nums2){
        arr[index]=e;
        index ++;
    }    
    Arrays.sort(arr);
 
    if(index%2!=0){
        return (double)arr[index/2];
    }else{
        return ((double)arr[index/2]+(double)arr[index/2-1])/2.0;
    }
    }
	
public static void main(String[] args) {
	
	//Example 1:
	//
	int []nums11 = {1,3}, nums12 = {2};
	double output1=2.0000;
	if(findMedianSortedArraysBruteforce(nums11, nums12)==output1) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");
	}
	//Output: 2.00000
	//Explanation: merged array = [1,2,3] and median is 2.
	
	//Example 2:
	//
	int []nums21 = {1,2}, nums22 = {3,4};
	double output2=2.5000;
	if(findMedianSortedArraysBruteforce(nums21, nums22)==output2) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");
	}
	
	//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
	
	if(findMedianSortedArraysOptimize(nums11, nums12)==output1) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");
	}
	
	if(findMedianSortedArraysBruteforce(nums21, nums22)==output2) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");
	}
}
}
