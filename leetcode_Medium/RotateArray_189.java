//189. Rotate Array
//Medium
//Companies
//Hint
//Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
//Example 1:
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
//Example 2:
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation: 
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
//Constraints:
//1 <= nums.length <= 105
//-231 <= nums[i] <= 231 - 1
//0 <= k <= 105
//Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
//Example 1:
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
//Example 2:
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation: 
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
//Constraints:
//1 <= nums.length <= 105
//-231 <= nums[i] <= 231 - 1
//0 <= k <= 105
//Follow up:
//Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
//Could you do it in-place with O(1) extra space?
package leetcode_Medium;

import java.util.Arrays;

public class RotateArray_189 {
//	brute force approch here we create a function which rotate the array k number of times :
//	it is done by shifting every index by 1 and swapping the last and first index
//	the time complexity is O(n*k)
//	here n = length of array 
//	k= nummber of rotation
public static void rotateBruteForce(int[] nums, int k) {
        int l =nums.length-1;
    for(int rotatecount=0;rotatecount<k;rotatecount++){
    int t=nums[l];
     for(int i =l;i>0;i--){
        nums[i]= nums[i-1]; 
     }  
     nums[0]=t;
    }    
    }
// it uses k%n which checks the how many rotation can be skipped 
//because if we rotate an array n times it will become as it was initialy 
//so we only rotate it k%n time which make skip the times where we need to rotate array when rotation lead to initial state again
//Time Complexity: 
//𝑂((𝑘%𝑛)×𝑛)
//O((k%n)×n)
//By using k % n, the number of rotations is reduced to the necessary minimum. In the worst case (when k is less than n), the time complexity is still 
//𝑂(𝑘×𝑛)
//O(k×n), but generally, it performs fewer operations.
//Space Complexity: 
//𝑂(1)
//Similar to the first method, only a few extra variables are used.
public static void rotateOptimizeBruteForce(int[] nums, int k) {
	int l =nums.length-1;
	int rotation =k%nums.length;
	System.out.println(rotation);
	for(int rotatecount=0;rotatecount<rotation;rotatecount++){
		int t=nums[l];
		for(int i =l;i>0;i--){
			nums[i]= nums[i-1]; 
		}  
		nums[0]=t;
	}    
}
	
static boolean check(int [] ans,int [] out) {
	if(ans.length!=out.length) {
		return false;
	}
	
	for(int i =0;i<ans.length;i++) {
		if(!(ans[i]==out[i])) {
			return false;
		}
	}
	return true;
}

//optimal then brute force but not best approch :
//approch here i created a rotate array which will keep the rotated array 
// now we know that the rotation of an array for n time where n is the length of array
//will return to its initial state so we will rotate array k%n which  will allow us to rotate array only lesser time
// but their is one more outcome that the times we rotate the array the index of the first value also start from that 
// means if 1,2,3,4,5,6,7 is an array 
//k=3
// 7,1,2,3,4,5,6
// 6,7,1,2,3,4,5
// 5,6,7,1,2,3,4
// here we can see the first value of initial array is at k%n
//k%n=3
//which tell the first value in inital array will be at 3 index of the rotated array
// so i just set the value from that index to the sorrted array with a single for loop and once the right side is finished
// i reset the index to be able to set the rest of indexes
// at last we put the rotated array value to the orginal array as output 
// space complexity o(n)
// time complexity o(n)
   static void rotateoptimal(int[] nums, int k) {
    int l =nums.length;
    int [] rotate = new int[l];    
    int sindex=(k%l);
    for(int i =0;i<l;i++){
        if(sindex<l){
            rotate[sindex]=nums[i];
        }else{
            rotate[sindex-l]=nums[i];
        }
            sindex++;
    }
    for(int i =0;i<l;i++){
        nums[i]=rotate[i];
    }
    }
// best solution :
//   here we reverse the entire array first :
//   so first we create a functtion which can reverse the array which take 3 arguments array, start ,end indexees
//   reverse the entire array 
//   suppose inputs = 1,2,3,4,5,6,7 ,k=3
//   after entire array reverse 
//   7,6,5,4,3,2,1
//   now we will reverse the array 
//   make k = k%n which will give the piovt where the first index of the array will be after rotation
//   now we will reverse the entire array from 0 to k-1 means 
//   k=k%n (3%7)=3   //n = array length
//   this will set the started index of array as rotated array 
//   so after reverse :
//   5,6,7,4,3,2,1
//   now we only need to reverse the  rest of the array :
//   k till n-1
//   this will set the last indexs of the rotatedd array 
//   5,6,7,1,2,3,4
//   Time Complexity: 
//   O(n)
//   Space Complexity: 
//   O(1)
   public static void rotatebest(int[] nums, int k) {
       int n=nums.length;
       k=k%n;
       // reverse the entire array :
       reverse(nums,0,n-1);
       // reverse the array from 0 to k :
       reverse(nums,0,k-1);
       // reverse the array from k to n
       reverse(nums,k,n-1);
   }
   static void reverse(int [] nums,int start,int end){
       while(start<end){
           int t=nums[start];
           nums[start]=nums[end];
           nums[end]=t;
           start++;
           end--;
       }
   }

public static void main(String args[]) {
	//Example 1:
	int [] nums1 = {1,2,3,4,5,6,7};
	int k1 = 3;
	int [] Out1= {5,6,7,1,2,3,4};
	//Example 2:
	int [] nums2 = {-1,-100,3,99};
	int k2 = 2;
	int [] Out2= {3,99,-1,-100};	
	
	
//	rotateBruteForce(nums1,k1);
//	rotateBruteForce(nums2,k2);
//	rotateOptimizeBruteForce(nums1,k1);
//	rotateOptimizeBruteForce(nums2,k2);
//	rotateoptimal(nums1,k1);
//	rotateoptimal(nums2,k2);
	rotatebest(nums1,k1);
	rotatebest(nums2,k2);
	if(check(nums1,Out1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");
		System.out.println("actual output :"+Arrays.toString(nums1));
		System.out.println("output get:"+Arrays.toString(Out1));
	}
	if(check(nums2,Out2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
		System.out.println("actual output :"+Arrays.toString(nums2));
		System.out.println("output get:"+Arrays.toString(Out2));
	}

	
}
}
