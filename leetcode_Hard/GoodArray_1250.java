//1250. Check If It Is a Good Array
//Hard
//Topics
//Companies
//Hint
//Given an array nums of positive integers. Your task is to select some subset of nums, multiply each element by an integer and add all these numbers. The array is said to be good if you can obtain a sum of 1 from the array by any possible subset and multiplicand.
//Return True if the array is good otherwise return False.
//Example 1:
//Input: nums = [12,5,7,23]
//Output: true
//Explanation: Pick numbers 5 and 7.
//5*3 + 7*(-2) = 1
//Example 2:
//Input: nums = [29,6,10]
//Output: true
//Explanation: Pick numbers 29, 6 and 10.
//29*1 + 6*(-3) + 10*(-1) = 1
//Example 3:
//Input: nums = [3,6]
//Output: false
//Constraints:
//
//1 <= nums.length <= 10^5
//1 <= nums[i] <= 10^9
package leetcode_Hard;
// approch :
// we find the pair whoes gcd is = 1
// how we come to solution :
// we want to find some sub set of integer whose sum of its multiplicant is 1
// means we have to choose a nummber  x mutiply with any random number x1*y1 +x1*y2 ... xn+yn= 1
// so instead of choosing any sub set we will found only anny two number whose gcd is 1 why ?
// idk how : the explanation i got from a video was this 

//  3: 3*1=3, 3*2=6,3*3=9 
//  6: 6*1=6, 6*12=6,6*3=18 
// with this the difference the multiples of both number is either {0,3,6};
// but it cant be 1 
// and 3,6  have a gcd =3 where 0,3,6 are also multiple of 3 only which is gcd
// so we will evaluate gcd of 1 to n 


public class GoodArray_1250 {
//	old way of gcd
//	static int gcd(int a,int b) {
//		int max =a;
//		int ans =1;
//		if(a<b) {
//			max=b;
//		}
//		for(int i =1;i<=max;i++) {
//			if(a%i==0 && b%i==0) {
//				ans=i;
//			}
//		}
//		return ans;
//		
//	}
//	new way of gcd with euclidian way
	
	
	
static int gcd(int a,int b) {
		 while (b != 0) {
           int temp = b;
           b = a % b;
           a = temp;
       }
       return a;
   }
	
    public static boolean isGoodArray(int[] nums) {
    	int ans=nums[0];
    	for(int i =0;i<nums.length;i++) {
//    		ans = gcd of previous pairs because gcd (a,b,c...) can be expressed as gcd(gcd(gcd (a,b),c),....)
    		ans=gcd(ans,nums[i]);
    		if(ans==1) {
    			break;
    		}
    	}
	        
    	return ans==1;
	    }	
    
    public static void main(String args[]) {
//Example 1:
int []nums1 = {12,5,7,23};
boolean Output1= true;
//Explanation: Pick numbers 5 and 7.
//5*3 + 7*(-2) = 1
//Example 2:
int[] nums2 = {29,6,10};
boolean Output2= true;
//Explanation: Pick numbers 29, 6 and 10.
//29*1 + 6*(-3) + 10*(-1) = 1
//Example 3:
int[] nums3 = {3,6};
boolean Output3= false;

if(isGoodArray(nums1)==Output1) {
	System.out.println("Case 1 Passed");
}else {
	System.out.println("Case 1 Failed");	
}
if(isGoodArray(nums2)==Output2) {
	System.out.println("Case 2 Passed");
}else {
	System.out.println("Case 2 Failed");	
}
if(isGoodArray(nums3)==Output3) {
	System.out.println("Case 3 Passed");
}else {
	System.out.println("Case 3 Failed");	
}


    }
}
