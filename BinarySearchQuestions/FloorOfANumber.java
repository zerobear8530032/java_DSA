package BinarySearchQuestions;
import java.util.Arrays;
public class FloorOfANumber {
public static int FloorBrute(int nums[],int target) {
	int greater=Integer.MIN_VALUE;
	int index =0;
	for(int i =0;i<nums.length;i++) {
		if(nums[i]>greater && nums[i]<=target) {
			greater=nums[i];
			index=i;
		}
	}
	if(greater==Integer.MIN_VALUE) {
		return -1;
	}
	return greater;
}

public static int FloorOptimize(int nums[],int target) {
	int s=0;
	int e =nums.length-1;
	int mid =0;
	
	if(target<nums[0]) {
		return -1;
	}		
	while(s<e) {
		mid=s+(e-s)/2;
		if(nums[mid]==target) {
			return nums[mid];
		}else if(target>nums[mid]) {
			s=mid+1;
		}else {
			e=mid-1;
		}
		
	}
	
	
	return nums[e];
}



public static void main(String args[]) {	

int arr1 [] = {2,3,5,9,14,16,18};	
int target1=15;
int arr2 [] = {1,2,3,3,12,23};	
int target2=11;
int arr3 [] = {100,101,120,300};	
int target3=23;
int arr4 [] = {100,101,120,300};	
int target4=500;



System.out.println("Linear Search");
System.out.println(FloorBrute(arr1,target1));
System.out.println(FloorBrute(arr2,target2));
System.out.println(FloorBrute(arr3,target3));
System.out.println(FloorBrute(arr4,target4));
System.out.println("Binary Search");
System.out.println(FloorOptimize(arr1,target1));
System.out.println(FloorOptimize(arr2,target2));
System.out.println(FloorOptimize(arr3,target3));
System.out.println(FloorOptimize(arr4,target4));
}
}
