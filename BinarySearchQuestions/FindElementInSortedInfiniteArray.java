//assume their is a sorted array and you have to apply a seaching algo to find the element 

package BinarySearchQuestions;
// brute force approch : linear seach
// their is not a particular way to allocate an infinite array but we can assume that an aaray is infinite and we cant acces the length of array 
// so the linear search will be like this
// 
public class FindElementInSortedInfiniteArray {
	public static int linearSearch(int nums[], int target) {
		int i =0;
			try {
				
		while(true) {
			if(nums[i]==target) {
				return i;
			}
			if(nums[i]>target) {
				return -1;
			}
			i++;
		}
			}catch(Exception e) {
				return -1;
			}	
	}
	
//	optimize approch : Binary search:
//	we will apply binnary search to chunks of array if we found the element we willl return else -1
//	every time a chunks does not able to found the element we will just increase the chunk size by * 2
	
	public static int BinarySearchInfiniteArray(int []nums, int target) {
		int s =0;
		int e =1;
		while(target>nums[e]) {
//			taking new start for updating start but we need original start in the end so we use new start
			int newstart=e+1;
//			taking the size of box by e+(e-s+1)  and *2 to double the size :
//			box size:
//			e =total area from start to end
//			s = start of box
//			e-s = area remaining after box		
//			e-s = s-1 
//			so e-(s-1)=e-s+1
			e=e+(e-s+1)*2;
			s=newstart;
		}
		int ans = binarySearch(nums, target, s, e);
		
		return ans;
	}
	public static int binarySearch(int [] nums,int target,int start,int end) {
		int s =start;
		int e=end;
		while(s<=e) {
			int mid=s+(e-s)/2;
			if(nums[mid]==target) {
				return mid;
			}else if(target>nums[mid]) {
				s=mid+1;
			}else {
				e=mid-1;
			}
		}
		return -1;
	}
	
	
public static void main(String args[]) {
	 int nums1[]= {1,2,2,3,4,5,6,7,11,12,23,34,56,78,100,134};
	 int target1=23;
	 int ans1 = 10;
	 
	 if(ans1==linearSearch(nums1, target1)) {
		 System.out.println("Case 1 Passed");
	 }else {
		 System.out.println("Case 1 Failed");		 
	 }
	 
	 int nums2[]= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,19,20,120,124,134};
	 int target2=124;
	 int ans2 = 20;
	 
	 if(ans2==linearSearch(nums2, target2)) {
		 System.out.println("Case 2 Passed");
	 }else {
		 System.out.println("Case 2 Failed");		 
	 }
	 
	 int nums3[]= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,19,20,120,124,134};
	 int target3=1000;
	 int ans3 = -1;
	 
	 if(ans3==linearSearch(nums3, target3)) {
		 System.out.println("Case 3 Passed");
	 }else {
		 System.out.println("Case 3 Failed");		 
	 }
	 
	 
	 if(ans1==BinarySearchInfiniteArray(nums1, target1)) {
		 System.out.println("Case 1 Passed");
	 }else {
		 System.out.println("Case 1 Failed");		 
	 }
	 if(ans2==BinarySearchInfiniteArray(nums2, target2)) {
		 System.out.println("Case 2 Passed");
	 }else {
		 System.out.println("Case 2 Failed");		 
	 }
	 if(ans3==BinarySearchInfiniteArray(nums3, target3)) {
		 System.out.println("Case 3 Passed");
	 }else {
		 System.out.println("Case 3 Failed");		 
	 }
	 
	 
	 
	
	 
	
	
}
}
