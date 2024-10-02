//539. Minimum Time Difference
//Solved
//Medium
//Topics
//Companies
//Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.
// 
//
//Example 1:
//
//Input: timePoints = ["23:59","00:00"]
//Output: 1
//Example 2:
//
//Input: timePoints = ["00:00","23:59","00:00"]
//Output: 0
// 
//
//Constraints:
//
//2 <= timePoints.length <= 2 * 104
//timePoints[i] is in the format "HH:MM".

package Sorting_Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference_539 {
	
//	approch : here we first conver the string of hrsand minutes to integer minutes 
//	then sort the array 
//	now we will check the minimum time in minutes btw it it will be done by substraction min[i]- nim[i-1]
//	at last because time is cicular soo we need to check the difference btw first and last time also because 
//	if we have 00:00 ,1:00 , 23:59 
//	so in minutes 0, 60,  1439 we can see the minimum is btw 0 and 60 but actually 23:59 +1 = 00:00 which means 
//	 so here will be 0+ 1439 = 1440-1439= 1 which is our actual answer
//	we have to check circular time also by adding both first and last time and substract with 1440 which is 24 hrs in minutes
	    public static int findMinDifference(List<String> timePoints) {
	        int l =  timePoints.size();
	        int [] minutes = new int[l];
//	        converting entire String hh:mm in minutes  
	        for (int i =0;i< l;i++) {
	            minutes[i]=convertToMinutes(timePoints.get(i));
	        }
//	        sort minute array 
	        Arrays.sort(minutes);
//	        finding smallest difference btw sorted minutes : because its sorting in ascending order 
//	        means the difference btw 2 element will be minimum
	        int smallesttime = Integer.MAX_VALUE;
	        for(int i=1;i<minutes.length; i++){
//	        calculating difference
	            int diff = minutes[i] - minutes[i - 1];
//	            findingg  min differene
	            smallesttime= Math.min(smallesttime,diff);
	        }
	        // because time is actually circular so we need to check first ans last time also :
//	        1
	        int circularDiff = (1440 - minutes[l - 1] + minutes[0]);
	        smallesttime = Math.min(smallesttime, circularDiff);
	        
	        return smallesttime;
	    }
	     public static int convertToMinutes(String time) {
	        int hours = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
	        int minutes = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
	        return hours * 60 + minutes;
	    }

	public static void main(String[] args) {
		
		//Example 1:
		//
		List<String>timePoints1 = new ArrayList(Arrays.asList("23:59","00:00"));
		int output1= 1;
		
		//Example 2:
		//
		List<String>timePoints2 = new ArrayList(Arrays.asList("00:00","23:59","00:00"));
		int output2=0;

		//Example 3:
		//
		List<String>timePoints3 = new ArrayList(Arrays.asList("05:31","22:08","00:35"));
		int output3=147;
		
		
		if(output1==findMinDifference(timePoints1)) {
			System.out.println("Case 1 Passed");
		}else{
			System.out.println("Case 1 Failed");
		}
		if(output2==findMinDifference(timePoints2)) {
			System.out.println("Case 2 Passed");
		}else{
			System.out.println("Case 2 Failed");
		}
		if(output3==findMinDifference(timePoints3)) {
			System.out.println("Case 3 Passed");
		}else{
			System.out.println("Case 3 Failed");
		}

	
	}

}
