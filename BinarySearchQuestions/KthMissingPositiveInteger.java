//Code
//Testcase
//Testcase
//Test Result
//1539. Kth Missing Positive Number
//Solved
//Easy
//Topics
//Companies
//Hint
//Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
//
//Return the kth positive integer that is missing from this array.

//Example 1:
//
//Input: arr = [2,3,4,7,11], k = 5
//Output: 9
//Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

//Example 2:
//
//Input: arr = [1,2,3,4], k = 2
//Output: 6
//Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.

//Constraints:
//
//1 <= arr.length <= 1000
//1 <= arr[i] <= 1000
//1 <= k <= 1000
//arr[i] < arr[j] for 1 <= i < j <= arr.length

//Follow up:
//
//Could you solve this problem in less than O(n) complexity?

package BinarySearchQuestions;
import java.util.*;
public class KthMissingPositiveInteger {
//	brute foruce approch : 
//	we know the answer will be btw 1 till last index element+k 
//	so we run a for loop from 0 till last element + k
//	we will now use a binary search for each i in array and add the element in the list which are not found
//	at last we can just return list.get(k-1) because index inn list starts from 0
//	
// time complexity  =O( N log (n)):  here N = max of element + k and  n = length of array   
// space complexity ;	
	public static int findKthPositiveBruteForce(int[] arr, int k) {
//    	store missing numbers
        LinkedList<Integer> numlist = new LinkedList();
        int start =0;
        int end = arr.length-1;
//        loop run from 1 till last element + k 
        for(int i =1;i<=arr[arr.length-1]+k;i++){
//        	search the element in the array using binary search :
           int searchresult =  binarySearch(arr,i,start,end);
//           if it not present add to list 
           if(searchresult==-1){
            numlist.add(i);
//            else we can incremnet start because we already visited the element 
           }else{
            start++;
           }
        }
//        return element from num list 
        return numlist.get(k-1);
    }
//    simple binary search :
    public static int binarySearch(int [] nums,int target ,int start ,int end){
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }else if(target>nums[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
    
//    optimize approch :
//    here we apply a simple binnary search and check missing element by the formula of (arr[mid]-mid+1):
//    how this fomula forms ::
//    when we see the question in case 2 we can see :
//    [1,2,3,4]
//    here  at index 0 = 1 , 1=2 and so on
//    so we know every element will be at their index +1 position :
//    so we can say if arr[mid] != mid+1 the element in missing :
//    so we can use arr[mid] - mid+1: find the number of element missing from 0 index till the mid :
//    by this we can check at each mid how much element missinng :
//    now we simmplyy apply a binary search comparing  miss =arr[mid]-(mid+1):
//    case 1 :now we check if (miss<k):s=mid+1: because we know missing element are less so we go right side to fiind more missing element 
//    case 2 :now we check if(miss>k): e=mid-1: because we know missing element are higher then k so we go left to find less missing element :
//    and at last this binary search will terminate such that  end<start:
//    now when we get out of binary search we will have 2 index in btw will be our answer:
//    but we need to get our answer :
//    1 way : we can say arr[end]+missing  here missing are arr[end]-k:
//    means we add the missing elemennt which are left 
//    but this can generate an error if we have missing in such a way [4,6,7]: k=2
//    now the search k will be at negetive index side of array and lead to the array out of bound :
//    so we will return end+1+k
    
//  end+1 +k how ?
//    in simple terms we can say we can write formula as :
//    arr[end]+more: here more are extra element which are in btw end and start 
//    now to calculate more we can say more=(k-missing): here missing are missing element till current index :
//    missing =arr[end]-(end+1): 
//    so finally putting every thing together :
//    arr[end]+k-(arr[end]-(end+1))
// opeb brackets :
//    arr[end]+k-arr[end]+end+1 : here we can cancel arr[end]-arr[end]
//    so end+k+1
//    final formula 
//    or we can further say that end +k:
//    because end < start and when the binary search end end +1=  start
//    
    
   public static int  findKthPositiveOptimze(int [] arr,int k) {
	   int start =0;
	   int end =arr.length-1; 
	   while(start<=end) {
		   int mid = start+(end-start)/2;
//		  missing element formula ->arr[e] - e+1; 
		   int miss = arr[mid]-(mid+1);
		   if(miss<k) {
			   start=mid+1;
		   }else {
			   end=mid-1;
		   }
	   }
//	   int missing = arr[end]-k;
//	   System.out.println(missing);
	   return end+1+k;
//	   or
//	   return start+k;
//	   return arr[end]+missing;
   }
    

public static void main(String[] args) {
		
//Example 1:
int arr1[] = {2,3,4,7,11};
int k1 = 5;
int output1=9;
//Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
//if(output1==findKthPositiveBruteForce(arr1, k1)) {
//	System.out.println("Case 1 Passed");
//}else {
//	System.out.println("Case 1 Failed");	
//}


//Example 2:
//
//Input: arr = [1,2,3,4], k = 2
//Output: 6
int arr2[] = {1,2,3,4};
int k2 = 2;
int output2=6;
//Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.

//if(output2==findKthPositiveBruteForce(arr2, k2)) {
//	System.out.println("Case 2 Passed");
//}else {
//	System.out.println("Case 2 Failed");	
//}


int arr3[] = {2};
int k3 = 1;
int output3=1;

//if(output3==findKthPositiveBruteForce(arr3, k3)) {
//	System.out.println("Case 3 Passed");
//}else {
//	System.out.println("Case 3 Failed");	
//}


System.out.println("Case 1 "+findKthPositiveOptimze(arr1,k1));
System.out.println("Case 2 "+findKthPositiveOptimze(arr2,k2));
System.out.println("Case 3 "+findKthPositiveOptimze(arr3,k3));
}
}
