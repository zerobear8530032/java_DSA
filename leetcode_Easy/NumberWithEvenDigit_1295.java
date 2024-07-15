package leetcode_Easy;

public class NumberWithEvenDigit_1295 {
	
//	complex calculation using log we can get the number of digit present in the integer:
//	this requires the n time complexity but complex calculations:    
	
//	Time Complexity:
//
//		The loop iterates through each element in the nums array, so it runs n times where n is the length of the array.
//		For each element, the time complexity of Math.log10(nums[i]) is O(1) because logarithm calculations are generally considered constant time operations.
//		Adding 1 and the modulo operation are also O(1).
//		Therefore, the overall time complexity of this method is 
//		time complecity O(n).
	
	public static  int findNumbers(int[] nums) {
	        int evendigitcount=0;
	        for(int i =0;i<nums.length;i++){
	            int length = (int) (Math.log10(nums[i]) + 1);
	            if(length%2==0){
	                evendigitcount++;
	            }
	        }
	        return evendigitcount;
	    }
// using simple division by 10 and count number of digit and then check the digit count is even or not:
//	this required the O (n*d) time complexity
//	where n = number of integer
//	and d = number of digit present in the number
	
	    public static int findNumberseasy(int[] nums) {
	        int evendigitcount=0;
	        for(int i =0;i<nums.length;i++){
	            int t=nums[i];
	            int digitcount=0;
	            while(t>0){
	                t=t/10;
	                digitcount++;
	            }
	            if(digitcount%2==0){
	                evendigitcount++;
	            }
	        }
	        return evendigitcount;
	    }
	    
	public static void main(String[] args) {
		int []nums1 = {12,345,2,6,7896};
		int c1 =findNumberseasy(nums1);
		if(c1==2) {
			System.out.println("pass case 1");
		}else {
			System.out.println("failed case 1");			
		}
		
		int []nums2 = {555,901,482,1771};
		int c2 =findNumberseasy(nums2);
		if(c2==1) {
			System.out.println("pass case 2");
		}else {
			System.out.println("failed case 2");			
		}
		

	
}
}
