package Day_14_video5;
import java.util.Scanner;
public class BinarySearch {
//Binary Search:
public static int LinearSearch(int [] nums, int target) {
	for(int i =0;i<nums.length;i++) {
		if(nums[i]==target) {
			return i;
		}
	}
	return -1;
}
//simple binary search
// works in ascending order only
public static int BinarySearchAscending(int [] nums, int target) {
	int s=0;
	int e=nums.length-1;
//	why we not took m=(s+e)/2: because the mid value can exceed with int as mid

	while(s<=e) {
		int mid=s+(e-s)/2;
		if(nums[mid]==target) {
			return mid;
		}
		if(target<nums[mid]) {
			e=mid-1;
		}
		else {
			s=mid+1;
		}
	}
	return -1;
}


//simple binary search
// works in ascending order only
public static int BinarySearchDescending(int [] nums, int target) {
	int s=0;
	int e=nums.length-1;
//	why we not took m=(s+e)/2: because the mid value can exceed with int as mid
	
	while(s<=e) {
		int mid=s+(e-s)/2;
		if(nums[mid]==target) {
			return mid;
		}
		if(target>nums[mid]) {
		 e=mid-1;
		}
		else {
		 s=mid+1;
		}
	}
	return -1;
}

// agnostic binary search :works on any ascending or descending order number array  :
public static int orderAgnosticBinarySearch(int []nums,int target) {
	int s=0;
	int e=nums.length-1;
	boolean isAsc=nums[s]<=nums[e];
		while(s<=e) {
			int mid=s+(e-s)/2;
			if(nums[mid]==target) {
				return mid;
			}
		if(isAsc) {		
			 if(nums[mid]<target) {
				s=mid+1;
			}else {
				e=e-1;
			}
		}else {				
			if(nums[mid]>target) {
					s=mid+1;
			}else {
				e=e-1;
			}	
		}
		}
		
	
	
	
	return -1;
}


	public static void main(String args[]) {
//	int []arr= {2,4,6,8,10,12,14,20,36,48};
//	int target1=36;
//	simple linear search
//	time complexity : o(n)
//	System.out.println(LinearSearch(arr, target));
//	System.out.println(LinearSearch(arr, 98));

//	simple Binary search
//	time complexity : o(log n)
	
//	System.out.println(BinarySearchAscending(arr, target));
//	System.out.println(BinarySearchAscending(arr, 98));
	
//	System.out.println(BinarySearchAscending(arr, target));

//	int[]arr2= {-13,-4,-2,0,1,2,3,6,7,9,12,18,23};
//	target=0;
//	System.out.println(BinarySearchAscending(arr2, target));
	int []arr1= {2,4,6,8,10,12,14,20,36,48};
	int target1=36;
	int[]arr2= {100,98,35,24,2,0,-1,-4,-10};
	int target2=35;
//	System.out.println(BinarySearchDescending(arr3, target));

	System.out.println(orderAgnosticBinarySearch(arr1, target1));
	System.out.println(orderAgnosticBinarySearch(arr2, target2));
	
}
}
