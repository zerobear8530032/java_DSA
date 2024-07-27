//1011. Capacity To Ship Packages Within D Days
//Solved
//Medium
//Topics
//Companies
//Hint
//A conveyor belt has packages that must be shipped from one port to another within days days.
//
//The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
//
//Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.
//
//Example 1:
//
//Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
//Output: 15
//Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
//1st day: 1, 2, 3, 4, 5
//2nd day: 6, 7
//3rd day: 8
//4th day: 9
//5th day: 10
//
//Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.

//Example 2:
//
//Input: weights = [3,2,2,4,1,4], days = 3
//Output: 6
//Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
//1st day: 3, 2
//2nd day: 2, 4
//3rd day: 1, 4

//Example 3:
//
//Input: weights = [1,2,3,1,1], days = 4
//Output: 3
//Explanation:
//1st day: 1
//2nd day: 2
//3rd day: 3
//4th day: 1, 1

//Constraints:
//
//1 <= days <= weights.length <= 5 * 104
//1 <= weights[i] <= 500
package BinarySearchQuestions;

public class CapacityToShipPackagesWithinDDays_1011 {
//this approch is also same but it is less effiecient because we can optimize it thats why we keep it here 
//	like 1 : we took range as 1 till sum of all weigths
//	2: logic is not writen well here like in getdays() this function need to manage edge cases 
//	Overall Time Complexity: O(nlogW) -> but this is more compare to other one here W is total sum of all elements
	    public static int shipWithinDaysFirst(int[] weights, int days) {
	    int start =1;
	    int end = 0;
	    for(int i =0;i<weights.length;i++){
	        end=end+weights[i];
	    }
	    int mid =0;
	    while(start<end){
	        mid= start+(end-start)/2;
	        if((getDays(weights,mid)-days)>0){
	            start=mid+1;
	        }else /*if((getDaysWithSize(weights,mid)-days)<0)*/{
	            end=mid;
	        }
	    // System.out.println(" start "+start+" end "+end+" mid "+mid);
	    }

	    return start;
	    }
	    public static int getDays(int [] nums,int boatsize){
	        int boat =0;
	        int days =1;
	    for(int i =0;i<nums.length;i++){
	        if(boatsize<nums[i]){
	            return Integer.MAX_VALUE;
	        }
	        if((boat+nums[i])<=boatsize){
	                boat =boat+nums[i];
	            }else{
	                days++;
	                boat=nums[i];
	            }
	        }
	        System.out.println("days "+days);
	        return days;
	    }
	
	
//	binary search : 
//	we will apply binary search here  to find minimum space the boat required to send all the packages in given days 
//	here are 2 intutions we can use 
//	1: the boat always need to have its minimum size as the heights weight package other wise we cant 
//	be able to transport it or any package
//	2: the maximum a ship can hold is the sum of all weights of package 
//	so now our approch is simple 
//	i have calculated both max of array and sum of all numbers in the weights array 
//	so start = max of weights
//	so end= sum of all weights
//	now we apply a simple binary search while(s<e){
//	and at each mid calculation we will check how many days it will take for ship to send all packages 
//	if ship took more days assign to us then it need to increase space then we will find 
//	in right side of range max of weights to total sum of wreights :
//	s=mid+1;
//	if days are equal or less then our given days so we will assume the current days are 
//	possible answer but we will not use it as final answer 
//	and try to search left side also end = mid -> we does not do end=mid-1 because the currebt nid could be a possible answer
//	
//	}

//		Overall Time Complexity: O(nlogW) -> but this is less compare to other one here W total sum of all elements- max element
	    public static int shipWithinDaysOptimize(int[] weights, int days) {
//	    here intial start , end
	    int start =0;
	    int end = 0;
	    
	    for(int i =0;i<weights.length;i++){
//	        end = sum of all element s
	    	end=end+weights[i];
//	    	start = max of weights
	        if(start<weights[i]){
	            start=weights[i];
	        }
	    }
//	    binary search start till end 
	    while(start<end){
//	    	cal mid
	     int   mid= start+(end-start)/2;
//	     here getDaysWithSize()-> this will take weights and calculate number of days it take to send all the 
//	     packages at mid boat size or given boat size : here this exp show if the getdays() return high number of days 
//	     we required means we need to increase ship size
//	     
	     if((getDaysWithSize(weights,mid)-days)>0){
	            start=mid+1;
//	     if above condition is true means either ship size is good or we can lower it down   
	     }else {
	            end=mid;
	        }
	    }
// at last start , end mid all will be equal so we can return anthign
	    return start;
	    }
//	    this function calculate number of days it take to send all packages in given boat size
	    public static int  getDaysWithSize(int [] nums,int boatsize){
	        int boat =0;
	        int days =1;
	    for(int i =0;i<nums.length;i++){
	        if((boat+nums[i])<=boatsize){
	                boat =boat+nums[i];
	            }else{
	                days++;
	                boat=nums[i];
	            }
	        }
	        // System.out.println("days "+days);
	        return days;
	    }
	public static void main(String[] args) {
		//Example 1:
		//
		//Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
		int [] weights1 = {1,2,3,4,5,6,7,8,9,10};
		int days1 =5;
		int output1= 15;
		//Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
		//1st day: 1, 2, 3, 4, 5
		//2nd day: 6, 7
		//3rd day: 8
		//4th day: 9
		//5th day: 10
		//
		//Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.

		if(shipWithinDaysFirst(weights1, days1)==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
		}
		
		//Example 2:
		//
		//Input: weights = [3,2,2,4,1,4], days = 3
		//Output: 6
		int [] weights2 = {3,2,2,4,1,4};
		int days2 =3;
		int output2=6;
		//Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
		//1st day: 3, 2
		//2nd day: 2, 4
		//3rd day: 1, 4

		if(shipWithinDaysFirst(weights2, days2)==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
		}

		
		//Example 3:
		//
		//Input: weights = [1,2,3,1,1], days = 4
		int [] weights3 = {1,2,3,1,1};
		int days3 =4;
		int output3=3;
		//Output: 3
		//Explanation:
		//1st day: 1
		//2nd day: 2
		//3rd day: 3
		//4th day: 1, 1

		if(shipWithinDaysFirst(weights3, days3)==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
		}
		
//		optimize :
		
		
		if(shipWithinDaysOptimize(weights1, days1)==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
		}
		if(shipWithinDaysOptimize(weights2, days2)==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
		}
		if(shipWithinDaysOptimize(weights3, days3)==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
		}

	}

}
