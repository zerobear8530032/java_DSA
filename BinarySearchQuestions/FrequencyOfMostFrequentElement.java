//1838. Frequency of the Most Frequent Element
//Solved
//Medium
//Topics
//Companies
//Hint
//The frequency of an element is the number of times it occurs in an array.
//
//You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.
//
//Return the maximum possible frequency of an element after performing at most k operations.
//
//Example 1:
//
//Input: nums = [1,2,4], k = 5
//Output: 3
//Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
//4 has a frequency of 3.
//Example 2:
//
//Input: nums = [1,4,8,13], k = 5
//Output: 2
//Explanation: There are multiple optimal solutions:
//- Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
//- Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
//- Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
//Example 3:
//
//Input: nums = [3,9,6], k = 2
//Output: 1
// 
//
//Constraints:
//
//1 <= nums.length <= 105
//1 <= nums[i] <= 105
//1 <= k <= 105
package BinarySearchQuestions;
import java.util.*;


public class FrequencyOfMostFrequentElement {
//	approch using binary search :
//	here we first sort the array because its not said all array will be sorted 
//	why we need to sort :
//	1 : we can only incremenet the number and no decrement is allowed 
//	2: so if we can only increment number of k times so we can say our answerr will be btw lowest , highest number 
//	3: by sorting we can reduce the search space why ?
//	[1,2,4]: assume k =5:
//	now if we want to  make aall element equal to 1 we cant  do it
//	now we will checkk next element can we make all element equal to 2 
//	we can make 1 = equal to 2 with 1 incerment k =34 now 
//	so array will be [2,2,4]
//	but we cant make 4 
//	now we check can be make all element equal 4 :
//	1+3=4 ,k =2
//	2+2=4,k=0
//	[4,4,4] so we can make it
//	but did you notice after we sort we can see onlly element which we can increment are on left side because we cant 
//	make bigger element smaller
	
//	2: now we first sort 
//	3: then we apply binary search 
//	4: binary search : will take 4 things(nums,targetindex,k,prefixsum)
//	nums= our input array 
//	targetindex : element we want at each index position
//	k = number of increement we can apply
//	prefixsum = it is a prefix sum of num used to calculate the sum of element in constatnt time 
//	so we will apply binary seach between the target index and 0 because rest element will be bigger then target
//	binary search starting while(s<=e)
//	calculate mid 
//	here is the most important part 
//	we know if all element between targetindex till start equal to our target then we can calculate it as
//	length of mid till targetindex * target 
//	asssume [1,4,8,13] , k =5
//	if mid = 0,
//	and target == 8, target index = 2
//	so the count of element from mid till target index = (targetindex-mid+1)
//	and its total sum = (targetindex-mid+1)*tareget=(2-0+1)*8=24
//	so if all element are equal to 8 it willl be 24 
//	now we will calculate actual sum of all element btw targetindex and mid 
//	1+4+8=13
//	now if we take difference of both actual and asssumed sum  we will get how many operation we done 
//	24-13=  11 which is greater then k = 5
//	which means we cant use this because we have less operations
//	so start = mid+1
//else we store mid in the result 
//	and we will do end = mid-1 to check better index which we can calculate frequmcy ;
//	now we can calculate original sum = prefixsum[targetindex]-prefixsum[mid]+nums[mid];
//	and once the binary seach will terminate we can return the length of sub arry from 
//	result till target array because result would have best index to find all frequent element 
//	return target_index-res+1;
	    public static int maxFrequency(int[] nums, int k) {
//	    sort
	    	Arrays.sort(nums);
	    int result=0;
//	    calculate prefix sum
	    long prefixsum []= new long [nums.length];
	    prefixsum[0]=nums[0];
	    for(int i =1;i<nums.length ;i++){
	    prefixsum[i]=nums[i]+prefixsum[i-1];
	    }
// trying each element to be target and get max frequency as result from the binary search 
	    for(int target_index =0;target_index<nums.length;target_index++){
	        int frequency =BinarySearch(nums,target_index,k,prefixsum);
	        result  = Math.max( frequency,result);   
	    }
	    return result;
	    }
	    public static int BinarySearch (int [] nums,int target_index,int k,long []prefixsum){
//	        binary search 
	    	int s =0;   
	    	
	        int e=target_index;
	        int res=target_index;
	        
	        while(s<=e){
	            int mid = s+(e-s)/2;
//	            length of sub array or window
	            int count = (target_index-mid+1);
//	            sum of all element in window we need to calculate it in long because of high constrain its important
	            long windowsum = (long)count*nums[target_index];
//	            with prefix sum we can calculate sum faster othrewise we required a for loop
	            
	            long originalsum = prefixsum[target_index]-prefixsum[mid]+nums[mid];
//	            here we calculated numnber of operations
	            long opt = windowsum - originalsum;
//	            if opt exceed limit we can use this window so we shrink it
	            if(opt>k){
	                s=mid+1;
//	            if it less we can store possible resut and expand window ny reducing search space     
	            }else{
	                res=mid;
	                e=mid-1;
	            }
	        }
	        return target_index-res+1;
	    }
	    public static void main(String[] args) {
			
	    	//Example 1:
	    	//
	    	int []nums1 = {1,2,4};
	    	int k1 = 5;
	    	int output1= 3;
	    	//Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
	    	//4 has a frequency of 3.
	    	//Example 2:
	    	//
	    	int []nums2 = {1,4,8,13};
	    	int k2 = 5;
	    	int output2= 2;
	    	//Explanation: There are multiple optimal solutions:
	    	//- Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
	    	//- Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
	    	//- Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
	    	//Example 3:
	    	//
	    	//Input: nums = [3,9,6], k = 2
	    	int []nums3 = {3,9,6};
	    	int k3 = 2;
	    	int output3= 1;
	    	
	    	if(output1==maxFrequency(nums1, k1)) {
	    		System.out.println("Case 1 Passed");
	    	}else {
	    		System.out.println("Case 1 Failed");
	    	}
	    	if(output2==maxFrequency(nums2, k2)) {
	    		System.out.println("Case 2 Passed");
	    	}else {
	    		System.out.println("Case 2 Failed");
	    	}
	    	if(output3==maxFrequency(nums3, k3)) {
	    		System.out.println("Case 3 Passed");
	    	}else {
	    		System.out.println("Case 3 Failed");
	    	}

	    	
	    	
	    	
	    	
	    	
		}
	
}
