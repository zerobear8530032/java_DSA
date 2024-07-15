//1499. Max Value of Equation
//Hard
//Companies
//Hint
//You are given an array points containing the coordinates of points on a 2D plane, sorted by the x-values, where points[i] = [xi, yi] such that xi < xj for all 1 <= i < j <= points.length. You are also given an integer k.
//Return the maximum value of the equation yi + yj + |xi - xj| where |xi - xj| <= k and 1 <= i < j <= points.length.
//It is guaranteed that there exists at least one pair of points that satisfy the constraint |xi - xj| <= k.
//Example 1:
//Input: points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
//Output: 4
//Explanation: The first two points satisfy the condition |xi - xj| <= 1 and if we calculate the equation we get 3 + 0 + |1 - 2| = 4. Third and fourth points also satisfy the condition and give a value of 10 + -10 + |5 - 6| = 1.
//No other pairs satisfy the condition, so we return the max of 4 and 1.
//Example 2:
//Input: points = [[0,0],[3,0],[9,2]], k = 3
//Output: 3
//Explanation: Only the first two points have an absolute difference of 3 or less in the x-values, and give the value of 0 + 0 + |0 - 3| = 3.
// 
//
//Constraints:
//
//2 <= points.length <= 105
//points[i].length == 2
//-108 <= xi, yi <= 108
//0 <= k <= 2 * 108
//xi < xj for all 1 <= i < j <= points.length
//xi form a strictly increasing sequence
package leetcode_Hard;

import java.util.Arrays;

public class MaxValueOfEquation_1499 {
//	brute force approch:
//	approch solve equation with every possible combination :
//	created a max elment which will update for max possible answer
//	create a loop from 0 to n n=length of array
//	create the nested loop i to n
//	now evaluate the equation for i,j at each iteration and update max if eq is greater then max 
	   public static int findMaxValueOfEquation(int[][] points, int k) {
		   int max=Integer.MIN_VALUE;
		   for(int i =0;i<points.length;i++) {
			   for(int j =i;j<points.length;j++) {
				   if(i==j) {
					   continue;
				   }
			   int xi=points[i][0];
			   int xj=points[j][0];
			   int yi=points[i][1];
			   int yj=points[j][1];
			   if(Math.abs(xi-xj)<=k) {
				   int eq= yi + yj + Math.abs(xi - xj);
				   System.out.println("Xi "+xi+" Xj "+xj+" yi "+yi+" Yj "+yj+" ans "+eq);
				   if(eq>max) {
					   max=eq;
				   }
			   }
			 }
		   }
		   return max;
	    }
public static void main(String[] args) {
	
	//Example 1:
	int [][] points1 = {{1,3},{2,0},{5,10},{6,-10}};
	int k1 = 1;
	int Output1=4;
	//Explanation: The first two points satisfy the condition |xi - xj| <= 1 and if we calculate the equation we get 3 + 0 + |1 - 2| = 4. Third and fourth points also satisfy the condition and give a value of 10 + -10 + |5 - 6| = 1.
	//No other pairs satisfy the condition, so we return the max of 4 and 1.
	//Example 2:
	int [][] points2 = {{0,0},{3,0},{9,2}};
	int k2 = 3;
	int Output2=3;
	
	int [][] points3 = {{-19,9},{-15,-19},{-5,-8}};
	int k3 = 10;
	int Output3=-6;
	
	
	
	int [][] points4 = {{-19,-12},{-13,-18},{-12,18},{-11,-8},{-8,2},{-7,12},{-5,16},{-3,9},{1,-7},{5,-4},{6,-20},{10,4},{16,4},{19,-9},{20,19}};
	int k4 = 6;
	int Output4=35;
	
	
	
	System.out.println("Answer 1 : ");
	System.out.println(findMaxValueOfEquation(points1,k1));
	System.out.println("Answer 2 : ");
	System.out.println(findMaxValueOfEquation(points2,k2));
	System.out.println("Answer 3 : ");
	System.out.println(findMaxValueOfEquation(points3,k3));
	System.out.println("Answer 4 : ");
	System.out.println(findMaxValueOfEquation(points4,k4));

	
	
}
}
