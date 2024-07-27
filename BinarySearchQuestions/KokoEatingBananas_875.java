//Code
//Testcase
//Test Result
//Test Result
//875. Koko Eating Bananas
//Medium
//Topics
//Companies
//Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
//
//Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
//
//Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
//
//Return the minimum integer k such that she can eat all the bananas within h hours.
//Example 1:
//
//Input: piles = [3,6,7,11], h = 8
//Output: 4
//Example 2:
//
//Input: piles = [30,11,23,4,20], h = 5
//Output: 30
//Example 3:
//
//Input: piles = [30,11,23,4,20], h = 6
//Output: 23
// 
//
//Constraints:
//
//1 <= piles.length <= 104
//piles.length <= h <= 109
//1 <= piles[i] <= 109

package BinarySearchQuestions;

public class KokoEatingBananas_875 {
	
//	binary search : here every thing remain same as brute force but because we know the answer lie btw
//	1 and max so we apply binary search on 1 to max 
//	if coco curernt speed is less we will search in left
//	other wise right side
//	time complexity:O(n)+O(N * log max)
	
	    public int minEatingSpeedoptimze(int[] piles, int h) {
	        // Binary search :
	        int start =1;
//	        get max of the array 
	        int end =getmax(piles);

//	        binary search 
	        while(start<end){
	            int mid = start+(end-start)/2;
//	            getting hrs it take for koko to eat all bananas at k time
	            int kokospeed =checkspeed(piles,mid);
//	            if kokospeed is high we search left 
	            if(kokospeed<=h){
	                end=mid;
//	                if koko speed is slow we search right
	            }else {
	                start=mid+1;
	            }
	        }
//	        at last we return start or end both will do the job because binary search got terminate at start == end
	return start;
	    }
	    
//	    this function will check the hrs it take for koko to finish all bananas at k speed  
	    public int checkspeed(int []nums,int k){
	        int hrs =0;
	        for(int i=0;i<nums.length;i++){
	            hrs=hrs+(int)Math.ceil((double)nums[i]/k);
	        }
	        return hrs;
	    }
//this will find max bananas of piles
	    public int getmax(int nums[] ){
	        int max =0;
	        for(int x :nums){
	            if(x>max){
	                max=x;
	            }
	        }
	        return max;
	    }
//	here we know the speed should be from 1 till max pile element of array
//	    so we create a for loop which run from 1 till max of pile and 
//	    check speed at each instance wheather we can eat all the bana in limited hrs
//	    when we found it we return it
//	    time complexity: o(n)+O(max*n)
	    
public static int minEatingSpeedBruteForce(int[] piles, int h) {
	int max =0;
//	here we will find max
	for(int x :piles) {
		if(max<x) {
			max=x;
		}
	}
//	check k for 1 till max 
	for(int k =1;k<=max;k++) {
		int hours =0;
//		here we calculate number of hrs it take for koko to eat at k speed
		for(int x :piles) {
//			 we taking ceil here because in contrain its given even if coco have speed greather then pile in banana then 
//			then it will only go for next pile in another hour
//			one more important thing is we need to type cast this other wise it can generate wrong answer 
			hours=hours+(int)Math.ceil((double)x/k);
		}
		
//		System.out.println("speed :"+k+" sum "+hours);
//		we will find our answe if hours is greater then or equal to coco eating 
		if(h>=hours) {
			return k;
		}
	}
//	this is if no answer found 
	return -1;
	
}
//	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Example 1:
		int [] piles1 = {3,6,7,11};
		int  h1= 18;
		int output1=4;
		
		if(minEatingSpeedBruteForce(piles1,h1)==output1){
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		//Example 2:

		int [] piles2 = {30,11,23,4,20};
		int  h2= 5;
		int output2=30;
		if(minEatingSpeedBruteForce(piles2,h2)==output2){
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}

		
		if(minEatingSpeedBruteForce(piles2,h2)==output2){
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		
		//Example 3:

		int [] piles3 = {30,11,23,4,20};
		int  h3= 6;
		int output3=23;
		System.out.println("Case 3 ");
		if(minEatingSpeedBruteForce(piles3,h3)==output3){
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
		
		
		

	}

}
