package leetcode_Easy;
/*1854. Maximum Population Year
Solved
Easy
Topics
Companies
Hint
You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.
The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.
Return the earliest year with the maximum population.
Example 1:
Input: logs = [[1993,1999],[2000,2010]]
Output: 1993
Explanation: The maximum population is 1, and 1993 is the earliest year with this population.
Example 2:
Input: logs = [[1950,1961],[1960,1971],[1970,1981]]
Output: 1960
Explanation: 
The maximum population is 2, and it had happened in years 1960 and 1970.
The earlier year between them is 1960.
Constraints:
1 <= logs.length <= 100
1950 <= birthi < deathi <= 2050
*/

import java.util.*;
//approch  brute force created a array of 1950 to 2050 and then just increment the born year by 1 and decrement a deth year by -1 then we just need to find the first year which is hvaing th max population 
class MaximumPopulationYear_1854{
    public static int maximumPopulation(int[][] logs) {
    int rows =logs.length;
    int lowerlimit=1950;   
    int upperlimit=2050;
    // for(int i =0;i<rows;i++){
    //     if(upperlimit<logs[i][1]){
    //         upperlimit=logs[i][1];
    //     }
    //     if(lowerlimit>logs[i][0]){
    //         lowerlimit=logs[i][0];
    //     }
    // }
    System.out.println("upper"+upperlimit);
    System.out.println("lower"+lowerlimit);

    int s =upperlimit-lowerlimit+1;
    System.out.println(s);
    int line [] = new int[s];
    for(int i =0;i<rows;i++){
        line[logs[i][0]-lowerlimit]++;
        line[logs[i][1]-lowerlimit]--;
    }
    System.out.println(Arrays.toString(line));
    int sum=0;
    int max =0;
    int year =0;
    for(int i =0;i<s;i++){
        sum=sum+line[i];
        if(max<sum){
            max=sum;
            year=lowerlimit+i;
        }
    }
     return year;  
    }

public static void main(String args[]) {
	int [][] logs1 = {{1993,1999},{2000,2010}};
	int [][] logs2 = {{1950,1961},{1960,1971},{1970,1981}};

	int case1=maximumPopulation(logs1);
	if(case1==1993) {
		System.out.println("Passed Case 1");
	}else {
		System.out.println("Failed Case 1");		
	}
	
	int case2=maximumPopulation(logs2);
	if(case2==1960) {
		System.out.println("Passed Case 2");
	}else {
		System.out.println("Failed Case 2");		
	}
}
}
