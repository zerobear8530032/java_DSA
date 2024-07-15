//1608. Special Array With X Elements Greater Than or Equal X
//Solved
//Easy
//Topics
//Companies
//Hint
//You are given an array nums of non-negative integers. nums is considered special if there exists a number x such that there are exactly x numbers in nums that are greater than or equal to x.
//
//Notice that x does not have to be an element in nums.
//
//Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value for x is unique.
//
//Example 1:
//
//Input: nums = [3,5]
//Output: 2
//Explanation: There are 2 values (3 and 5) that are greater than or equal to 2.

//Example 2:
//
//Input: nums = [0,0]
//Output: -1
//Explanation: No numbers fit the criteria for x.
//If x = 0, there should be 0 numbers >= x, but there are 2.
//If x = 1, there should be 1 number >= x, but there are 0.
//If x = 2, there should be 2 numbers >= x, but there are 0.
//x cannot be greater since there are only 2 numbers in nums.

//Example 3:
//
//Input: nums = [0,4,3,0,4]
//Output: 3
//Explanation: There are 3 values that are greater than or equal to 3.

//Constraints:
//
//1 <= nums.length <= 100
//0 <= nums[i] <= 1000
package BinarySearchQuestions;

import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanorEqualX_1604 {
//	approch we apply brute force we can see in question we have to find elements that are greater then or equal to x 
//	should be equal to x 
//	so we can assumne the answer will lie btw 0 , n : where n = nummber of elemet in array
//	why ?
//	assume arr ={3,5}
//	if we say x =1 
//	then 3>=1 :true count++
//	then 5>=1 :true count++
//	but x != count
//	means x is not valid 
//	now if x = 2 :
//	then 3>=2: true count++
//	then 5>=2: true count++
//	x==count 
//	true  we found the answer
//	but assume 2 is not actual answer 
//	we try for 3 
//	3>=3 :true
//	5>=3: true
//	but now their will no be a 3rd integer
//	so the count will be reach max 2 
//	the last contion of x== count will never be true means 
//	our answer will always be  x = 1 to length of array or N
	
//	now we know the answer range last thing we can do is create a for loop from x=0 till n
//	and check every time how many elements are greater then the x if any element is x ==  count 
//	we got our answer other wise we will check the next element if non match we can return -1;
	
//	time complexity : O(n*n)
//	space complexity : O(1)
	
	
    public static int specialArrayBruteForce(int[] nums) {
//  we start the inital range loop 0 till length of array 
        for(int i  =0;i<=nums.length;i++){
//        	here  getcount will get number of element greater then the i 
        	
            int count = getcount(nums,i);
//            if count==i we got our answer 
            if(count==i){
                return count;
            }
        }
//        if non element satisfy condition we return -1
        return -1;
    }
//    get count will go through entire array and found element count greater then the target which is x:
    
    public static int getcount(int []nums,int target){
        int count=0;
        for(int i : nums){
            if(i>=target){
                count++;
            }
        }
        return count;
    }

//    binary search approch : we can optimize above approch by using binary search :   
//    here we apply a binary search on the array 
//    for that we first sort the input array
//    now we again search from 0 till length of array 
//    now we know the array is sorted so we can search for element which are equal or greater then the element we are
//    searching 
//    now we can search first element equal or greater then the target so we get its index using binary search  
//    once we get that index we know the rest of element from index of search result  till last element 
//    will be greater then the element because array is sorted 
//    so we can easily get count by this formul count = nums.length -binarysearch result
//    now we can check the count == i if true return i else check next element 
//    iff not any element found in  0 till length f array we can return -1 
    
//    time complexity : O(n log n): this is for sorting the array 
//    time complexity : log n for the binary search 
//    time complexity : n for the traversal of 0 till n 
//    so final time complexity : O(n log n)

    public static int specialArrayOptimize(int[] nums) {
//       sort array in ascending order
    	Arrays.sort(nums);
//    	loop from 0 till length of array 
    	
       for(int i =0;i<=nums.length;i++) {
//    	   get the first element index which is greater or equal to i 
    	   int index = BinarySearch(nums,i);
//    	   get count of greater or equal element by length - index
    	   
    	   int count= nums.length-index;
//    	   if count == i :return i
    	   if(count==i) {
    		   return i;
    	   }
       }
//       if no such element found return -1
       return -1;
    }
//    binary search : its a simple binary search used to find the floor of array 
//    we will search  if arr[mid]<target{s=mid+1}
//    if arr[mid]>target{e=mid-1}
//    so when the when the binary search break s > e
//    so we know the greater number will be at s so we return s as result 
    
    public static  int BinarySearch(int [] nums,int target) {
    	int s =0;
    	int e =nums.length-1;
    	while(s<=e) {
    		int mid = s+(e-s)/2;
//    		if(target==nums[mid]) {return mid;}  we does not use this condition because there are duplicate so 
//    		this condition can lead to find any duplicate element rather then its first occurence means 
//    		 if {0,1,2,2,3}
//    		here answe is 2 but if binary search result find 2 at index of 3 on both time will lead to wrong answer
    		if(target>nums[mid]) {s=mid+1;}
    		else {e=mid-1;}
    	}
    	return s;
    }
  
// Another approch using binary search :
//    here we apply 2 binary searches every thing is same but we apply a binary search on range array 0 till n 
//    to find best value of x 
//    we apply  with 2 cases 
//    if(count<mid){e=mid-1}: if count is less means we have to choose lesser  mid
//    else if(count>mid){s=mid+1}: if count is greater we need to increase size of mid 
//    if count == mid : return mid : here we found x as mid
//    Combining Both Parts Sorting the array:  
//    O(nlogn) Main loop with binary search: O((logn) 2 ) 
//    Since O(nlogn) dominates  O((logn) 2 ) for large  n, t
//    he overall time complexity is: O(nlogn)
    public static int specialArrayDoubleBinarySearch(int[] nums) {
//      sort array in ascending order
    Arrays.sort(nums);
//   	loop from 0 till length of array 
    int start =0;
    int end = nums.length;
//   	binary search on the range 
      while(start<=end) {
    	  int mid = start+(end-start)/2;
//   	   get the first element index which is greater or equal to mid 
   	   int index = BinarySearch(nums,mid);
//   	   get count of greater or equal element by length - index
   	   
   	   int count= nums.length-index;
//   	   if count == mid :return mid
   	   if(count==mid) {
   		   return mid;
//   		   if count<mid we  need to search left side
   	   }else if(count<mid) {
   		   end=mid-1;
//   		   if count > mid we need to search right side
   	   }else {
   		   start=mid+1;
   	   }
      }
//      if no such element found return -1
      return -1;
   }
 
//    less time extra space : till now all approches using no extra space but we can use some extra space to reduce the time 
//    this approch remove the requirement of sorting the array 
//    we can allocate an array of max+ 1 size and find the frequency of each element in that array 
//    now we can find the cumulative frequency of each element from last till first 
//    now our answer will be where frequency[i]==i
//    why ?
//    once we took all frequency of array 
//    we map it like the index with its occurence 
//    means 0 index of ferquency will have its number of occurence 
//    same goes with all element of the array
//    we found max of element so that all the element can be mapped
//    exampple :input {3,5}
//    frequency ={0,0,0,1,0,1} 

//    now we take cf of entire array from length till 0 index 
//    cumulativefrequency= {2,2,2,2,1,1}
//    now we have to match index with its element where its same we return output 
//    as i 
//    else if non found return -1
    
//    Total Time Complexity
//    Combining all the parts:
//    Finding the maximum element:  O(n)
//    Populating the frequency array: O(n)
//    Calculating the cumulative frequency: O(max)
//    Finding the result:  O(max)
//    Thus, the total time complexity is:O(n)+O(n)+O(max)+O(max)=O(n+max)


//    Time Complexity: O(n+max)
//    Space Complexity: O(max) 
//    this approch is better for time but required a bit of extra space and it required way large space so we can furthur optimize it
    
    
    
    public static int specialArrayOptimzeExtraSpace(int[] nums) {
    	int max =0;
//    	find max element in array :
    	for(int x: nums) {
    		if(max<x) {max=x;}
    	}
//    	frequncy array :
    	int [] frequency = new int [max+1];
//    	find frequency of every element and store in the array :
    	for(int i =0;i<nums.length;i++) {
    		frequency[nums[i]]++;	
    	}
    	
    	
//    	 find cumulative frequency :
    	int cf =0;
    	for(int i =frequency.length-1;i>=0;i--) {
    		cf = cf+frequency[i];
    		frequency[i]=cf;
    	}
    	
    	
//    	find the result:
    	for(int i =0;i<frequency.length;i++) {
    		if(frequency[i]==i) {
    			return i;
    		}
    	}
//    	if non is found return -1
    	return -1;

    }
    
//    lesser extra space approch:
//    every thing is similar the only difference is that when we create frequency array of length input.lemgth+1
//    we check wheather the element is
//    greater then the length if yes we will increment the frequency  at last index  because we does not need to have 
//    all element frequency we can just put it their as a number of element greater then that 
//    so we can check if element is greater then length increase last index 
//    else we can increment index of element in our array this 
//    example: {3,5}
//    frequecy ={0,0,0} - itital value
//    after calculating fre : {0,0,2}
//    after cf{2,2,2}
//    finaly we can see  index 2 have 2 its our answer
//    we coome to this solution by combining our first brute force as we know answer lies btw 0 till length 
//    and extra space solution which maps our input on an array 
    
//    this approch is better then compared to the last approch it took less spacee compare to it :

//    Thus, the total time complexity is: O(n)+O(l)+O(l)=O(n+l) 
//    Since  l is the length of the input array, this can be simplified to:O(n+n)=O(2n)=O(n) 
//    Total Space Complexity The primary space usage comes from the frequency array: 
//    Space Complexity: O(l)
  
    
    
    public static int specialArrayOptimzeLessExtraSpace(int[] nums) {
    	int l =nums.length;
    	
//    	frequncy array :
    	int [] frequency = new int [l+1];
//    	find frequency of every element and store in the array :
    	for(int i =0;i<nums.length;i++) {
    		if(nums[i]<l) {
    			frequency[nums[i]]++;	    			
    		}else {
    			frequency[l]++;
    		}
    	}
    	
    	System.out.println(Arrays.toString(frequency));
//    	 find cumulative frequency :
    	int cf =0;
    	for(int i =frequency.length-1;i>=0;i--) {
    		cf = cf+frequency[i];
    		frequency[i]=cf;
    	}
    	
    	System.out.println(Arrays.toString(frequency));
    	
//    	find the result:
    	for(int i =0;i<frequency.length;i++) {
    		if(frequency[i]==i) {
    			return i;
    		}
    	}
//    	if non is found return -1
    	return -1;
    	
    }

    
public static void main(String[] args) {

//Example 1:
//
int [] nums1 = {3,5};
int output1=2;
//Explanation: There are 2 values (3 and 5) that are greater than or equal to 2.
if(specialArrayBruteForce(nums1)==output1) {
	System.out.println("Case 1 Passed");
}else {
	System.out.println("Case 1 Failed");	
}

//Example 2:
int [] nums2 = {0,0};
int output2=-1;
if(specialArrayBruteForce(nums2)==output2) {
	System.out.println("Case 2 Passed");
}else {
	System.out.println("Case 2 Failed");	
}
//Input: n
//Explanation: No numbers fit the criteria for x.
//If x = 0, there should be 0 numbers >= x, but there are 2.
//If x = 1, there should be 1 number >= x, but there are 0.
//If x = 2, there should be 2 numbers >= x, but there are 0.
//x cannot be greater since there are only 2 numbers in nums.

//Example 3:
//
//Explanation: There are 3 values that are greater than or equal to 3.
int [] nums3 = {0,4,3,0,4};
int output3=3;

if(specialArrayBruteForce(nums3)==output3) {
	System.out.println("Case 3 Passed");
}else {
	System.out.println("Case 3 Failed");	
}


// optimize approch :

if(specialArrayOptimize(nums1)==output1) {
	System.out.println("Case 1 Passed");
}else {
	System.out.println("Case 1 Failed");	
}

if(specialArrayOptimize(nums2)==output2) {
	System.out.println("Case 2 Passed");
}else {
	System.out.println("Case 2 Failed");	
}


if(specialArrayOptimize(nums3)==output3) {
	System.out.println("Case 3 Passed");
}else {
	System.out.println("Case 3 Failed");	
}



// Double binary search approch :
if(specialArrayDoubleBinarySearch(nums1)==output1) {
	System.out.println("Case 1 Passed");
}else {
	System.out.println("Case 1 Failed");	
}

if(specialArrayDoubleBinarySearch(nums2)==output2) {
	System.out.println("Case 2 Passed");
}else {
	System.out.println("Case 2 Failed");	
}


if(specialArrayDoubleBinarySearch(nums3)==output3) {
	System.out.println("Case 3 Passed");
}else {
	System.out.println("Case 3 Failed");	
}



// Extra space approch :
if(specialArrayOptimzeExtraSpace(nums1)==output1) {
	System.out.println("Case 1 Passed");
}else {
	System.out.println("Case 1 Failed");	
}

if(specialArrayOptimzeExtraSpace(nums2)==output2) {
	System.out.println("Case 2 Passed");
}else {
	System.out.println("Case 2 Failed");	
}


if(specialArrayOptimzeExtraSpace(nums3)==output3) {
	System.out.println("Case 3 Passed");
}else {
	System.out.println("Case 3 Failed");	
}



specialArrayOptimzeLessExtraSpace(nums1);
}
}