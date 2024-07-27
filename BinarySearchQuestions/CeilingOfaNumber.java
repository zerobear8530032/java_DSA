package BinarySearchQuestions;
import java.util.Arrays;
public class CeilingOfaNumber {
//find the smallest element in array greater or equal to target in a sorted array :
//	brute force approch which uses a simple loop to finnd the number greater then equal to target
//	note this approch works in both sorted array or unsorted array
	static int ceilingOfaNumberBrute(int [] nums,int target) {
		int n=Integer.MAX_VALUE;
		int index=0;
		for(int i =0;i<nums.length;i++) {
			if(n>nums[i] && nums[i]>=target) {
				n=nums[i];
				index=i;
			}
		}
		if(n==Integer.MAX_VALUE) {
			return -1;
		}
		return index;
//		return n;
	}
//	optimize uses binary search to find the target if target is not present give the closest bigger number then target 
	static int ceilingOfaNumberOptimize(int [] nums,int target) {
		
		int s =0;
		int e=nums.length-1;
		int mid=0;
//		reason when loop ends start > end which means our answer lyes at the right side of the mid which is start
		if(target>nums[nums.length-1]) {
			return -1;
		}		
		while(s<=e) {
			mid=s+(e-s)/2;
			if(nums[mid]==target) {
				return nums[mid];
			}else if(nums[mid]<target) {
				s=mid+1;
			}else {
				e=mid-1;
			}
		}
//		return s;
		return nums[s];
	}
	
public static void main(String[] args) {

int arr1 [] = {2,3,5,9,14,16,18};	
int target1=14;
int arr2 [] = {1,2,3,3,12,23};	
int target2=11;
int arr3 [] = {100,101,120,300};	
int target3=23;
int arr4 [] = {100,101,120,300};	
int target4=500;
int arr5[] = {1,2,4,6,550};	
int target5=500;

System.out.println(ceilingOfaNumberBrute(arr1,target1));
System.out.println(ceilingOfaNumberBrute(arr2,target2));
System.out.println(ceilingOfaNumberBrute(arr3,target3));
System.out.println(ceilingOfaNumberBrute(arr4,target4));
System.out.println(ceilingOfaNumberOptimize(arr1,target1));
System.out.println(ceilingOfaNumberOptimize(arr2,target2));
System.out.println(ceilingOfaNumberOptimize(arr3,target3));
System.out.println(ceilingOfaNumberOptimize(arr4,target4));
System.out.println(ceilingOfaNumberOptimize(arr5,target5));
}
}
