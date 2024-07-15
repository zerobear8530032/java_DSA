//852. Peak Index in a Mountain Array
//Solved
//Medium
//Topics
//Companies
//You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.
//Return the index of the peak element.
//Your task is to solve it in O(log(n)) time complexity.
//Example 1:
//Input: arr = [0,1,0]
//Output: 1
//Example 2:
//Input: arr = [0,2,1,0]
//Output: 1
//Example 3:
//Input: arr = [0,10,5,2]
//Output: 1
//Constraints:
//3 <= arr.length <= 105
//0 <= arr[i] <= 106
//arr is guaranteed to be a mountain array.


package BinarySearchQuestions;
public class PeakIndexInAMountainArray_852 {
//	brute force approch here we used simple linear search and find the max element from the array :
	public static  int peakIndexInMountainArrayBruteForce(int[] arr) {
		int max =Integer.MIN_VALUE;
		int index=0;
		for(int i =0;i<arr.length;i++){
			if(max<arr[i]){
				max=arr[i]; 
				index=i; 
			}
		}
		return index;
	}
//	here we used the binary search with some advancement 
//	we know 2 things the peak array means their is some point in the array which is the greatest in the entire array 
//	and from  start till that point the array will be ascending sorted and from peak till last element the array will be sorted in descending order
//	now we know already know how to make the array work for both ascending or descending order sorted 
//	here we does not know the target and we does not have any idea at initial level where the peak will be 
//	so what we will do is :
//	we will calculate mid =  and check
//	if( arr[mid]<arr[mid+1]) -> if this is true means we are in the ascending side of the array so we know the greater element will bee on right side
//	if( arr[mid]>arr[mid+1]) -> if this is true means we are in the descemding side of the array so we know the greater element will be on left side
//  now we know how to traverse but where to stop 
//	because we does not have any particular target to stop we will let the s==e because the peak will be the mid of both ascending and descending order array 
//	so we can say while(s<e){-> this will terminate when s == e
//	....binary search
//}
	public static  int peakIndexInMountainArrayOptimize(int[] arr) {
		int s =0;
		int e=arr.length-1;
//		binary search starting:
		while(s<e) {
			int mid =s+(e-s)/2;
//			search right side if array in ascendding order
			if(arr[mid]<arr[mid+1]) {
//				here we update s = mid+1 we already seen mid+1 is greater then mid so we does not need to check at mid 				
				s=mid+1;
//				search left side if array is descending order
			}else if(arr[mid]>arr[mid+1]) {//-> this check can be replaced with else also but for 
//		here we doing mid not mid + 1 because their is a chance the mid element is the answer because we check mid and mid+1 not mid and mid-1
				e=mid;
			}
		}
		return s;	
	}
	
	
public static void main(String args[]) {
	System.out.println("Brute Force approch");

	//Example 1:
	int [] arr1 = {0,1,0};
	int output1=1;
	if(output1==peakIndexInMountainArrayBruteForce(arr1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	
	//Example 2:
	int [] arr2 = {0,2,1,0};
	int output2= 1;	
	if(output2==peakIndexInMountainArrayBruteForce(arr2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	//Example 3:
	int [] arr3 = {0,10,5,2};
	int output3=1;
	if(output3==peakIndexInMountainArrayBruteForce(arr3)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}
	System.out.println("Optimize approch");
	if(output1==peakIndexInMountainArrayOptimize(arr1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	if(output2==peakIndexInMountainArrayOptimize(arr2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	if(output3==peakIndexInMountainArrayOptimize(arr3)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}
	
	
	
	
	
	
}
}
