//1095. Find in Mountain Array
//Hard
//Topics
//Companies
//Hint
//(This problem is an interactive problem.)
//You may recall that an array arr is a mountain array if and only if:
//arr.length >= 3
//There exists some i with 0 < i < arr.length - 1 such that:
//arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
//arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
//Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.
//You cannot access the mountain array directly. You may only access the array using a MountainArray interface:
//MountainArray.get(k) returns the element of the array at index k (0-indexed).
//MountainArray.length() returns the length of the array.

//****************************************************************************************************************
//Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any 
//solutions that attempt to circumvent the judge will result in disqualification.
//****************************************************************************************************************

//Example 1:
//Input: array = [1,2,3,4,5,3,1], target = 3
//Output: 2
//Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
//Example 2:
//Input: array = [0,1,2,4,2,1], target = 3
//Output: -1
//Explanation: 3 does not exist in the array, so we return -1.
//Constraints:
//3 <= mountain_arr.length() <= 104
//0 <= target <= 109
//0 <= mountain_arr.get(index) <= 109

package BinarySearchQuestions;
// mountain array class for 
class MountainArray{
	int c =0;
	int mountianarr[];
//	constructor
public	MountainArray(int [] arr) {
	this.mountianarr=arr;
}
// get value from the index
public int get(int index) {
	
	c++;
	return this.mountianarr[index];
	 
}
// get length of the array
public int length() {
	c++;
	return mountianarr.length;
	
}
}

public class FindInMountainArray1095 {
	
	/**
	 * // This is MountainArray's API interface.
	 * // You should not implement it, or speculate about its implementation
	 * interface MountainArray {
	 *     public int get(int index) {}
	 *     public int length() {}
	 * }
	 */	 
//	here we have a interface which have some array called mountain array like some of the previous question
//	a mountian array is the  array which have a peak element and it is sorted ascending order from left to right till peak and descending order from peak to end 
// now we have to find an element in this array
//	approch :
//	1. we will find the peak of the mountainarr
//	2. now we know the peak we know the left side of peak is ascending sorted while right side is descending sorted
//	3. so we will apply binary search on both side and return the element if found 
//	note the function used here are given in the contain so we used them like this the implementation can be different on leet code

	    public static int findInMountainArray(int target, MountainArray mountainArr) {
	        int ans = -1;
	        int l =mountainArr.length()-1;
//	        get the peak element with the function
	        int peak=getpeak(mountainArr);
//	        check the peak is equal to target if it is return the peak element
	        if(mountainArr.get(peak)==target){
	            return peak;
	        }
//	        searching ascending side: ascending side is always from 0 to peak
	        ans=BinarySearch(mountainArr,0,peak,target);
//	        if we found it here we will return it here because in constrain there is said there
//	        if their are multiple occurence of target we will return the first or lowest index of occurence
	        if(ans!=-1){
	            return ans;
//	        searching descending side: descending side is always from peak to end
	        }else{
//	        here we will search descending side only if the ascending side is not found so we will seach other side
	        ans=BinarySearch(mountainArr,peak+1,l,target);
	        return ans;
	        }

	    }
//	    this is the simple agnostic binary seach which checks the order first and search accordingly 
	    public static int BinarySearch(MountainArray mountainArr,int start,int end,int target){
//	    	check asc order
	        boolean asc =false;
//	        if first < end element means its ascending order
	        if(mountainArr.get(start)<mountainArr.get(end)){
	            asc=true;
	        }
//	       binary seach 
	        while(start<=end){
	            int mid =start+(end-start)/2;
//	            increasing order seach
	        if(asc){
	            if(mountainArr.get(mid)<target){
	                start=mid+1;
	            }else if(mountainArr.get(mid)>target){
	                end=mid-1;
	            }else{
	                return mid;
	            }
//	            decreasing order seach
	        }else{
	            if(mountainArr.get(mid)<target){
	                end=mid-1;
	            }else if(mountainArr.get(mid)>target){
	                start=mid+1;
	            }else{
	                return mid;
	            }
	        }
	        }
	        return -1;
	    }
// find the peak this will return the peak of mountain array with binary search to divide array in two parts ascending side and descending side
//	    we will just go as a simple binary seach and check mid < mid+1 means we are in ascending side so we should move right side 
//	    because the peak element will always be greatest then the all element 
//	    if mid>mid+1 means we will be on the descending side of the array so the greatest element will be on the left side of the arr 
	    public static int getpeak(MountainArray mountainArr){
	        int s=0;
	        int e =mountainArr.length()-1;
//	        simple binary seach : s<e beacuse if we move right side in ascending order aand left side in descending order
//	        their will be a single element which will be left in mid where e==s and the loop will break and that element 
//	        will be the peak element  
	        while(s<e){
//	    
	            int mid =s+(e-s)/2;
//	            ascending side search
	            if(mountainArr.get(mid)<mountainArr.get(mid+1)){
//	            	here we already check mid < mid+1  means mid is greater so we can move to the next element 
	                s=mid+1;
//	            descending side search
	            }else{
//	            we look from mid because we seen mid<mid+1 so the mid can also be our answer so we need to keep it in side search space
     	
	                e=mid;
	            }
	        }
	        return s;
	    }



	public static void main(String[] args) {
		MountainArray input1 = new MountainArray (new int [] {1,2,3,4,5,3,1});
		int target1 = 3;
		int output1=2;
		if(findInMountainArray(target1, input1)==output1 && input1.c<=100) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		MountainArray input2 = new MountainArray (new int [] {0,1,2,4,2,1});
		int target2 = 3;
		int output2=-1;
		if(findInMountainArray(target2, input2)==output2 && input2.c<=100 ) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		
		
	}
}
