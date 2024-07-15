//69. Sqrt(x)
//Attempted
//Easy
//Topics
//Companies
//Hint
//Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
//
//You must not use any built-in exponent function or operator.
//
//For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
//Example 1:
//Input: x = 4
//Output: 2
//Explanation: The square root of 4 is 2, so we return 2.
//Example 2:
//Input: x = 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
//Constraints:
//
//0 <= x <= 231 - 1
package BinarySearchQuestions;

public class SqrtOfX_69 {
//	without seeing the constrain
//	 public int mySqrt(int x) {
//	 return (int) Math.pow(x,0.5);
////	or	 
//	     return(int) Math.sqrt(x);   
//	   }
	
//	Using binary search :
//	intution behind the solution we knew two things about square root :
//	1: if x*x = x^2 
//	then square rooot(x^2)=x
//	2: the square root of any number will always between 0 and x 
	
//	so we will do a binary seach from 0 till x range and check every step:
//	if(mid*mid ==x){return mid}-> means the number is a perfect square and we got our answer
//	else if(mid*mid<x){s=mid+1}-> means the number is smaller we need to search on right side
//	else if(mid*mid>x){e=mid-1}-> means the number is too large we need to seach on the left side
	
	 public static int mySqrt(int x) {
		 int s =0;
		 int e =x;
		 while(s<=e) {
			 int mid =s+(e-s)/2;
			 long midsqr=(long)mid*mid;
			 if(midsqr == x) {
				 return mid;
			 }else if(midsqr< x) {
				 s=mid+1;
			 }else {
				 e=mid-1;
			 }
		 }
		 return e; 
	   }
	
	
public static void main(String[] args) {
	
//Example 1:
int x1 = 4;
int out1=2;
if(out1==mySqrt(x1)) {
	System.out.println("Case 1 Passed");
}else {
	System.out.println("Case 1 Failed");	
}
//Explanation: The square root of 4 is 2, so we return 2.
//Example 2:
int x2 = 8;
int out2=2;

//Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
if(out2==mySqrt(x2)) {
	System.out.println("Case 2 Passed");
}else {
	System.out.println("Case 2 Failed \nanswer"+mySqrt(x2));	
}
int x3 = 2147395599;
int out3=46339;
if(out3==mySqrt(x3)) {
	System.out.println("Case 3 Passed");
}else {
	System.out.println("Case 3 Failed \nanswer"+mySqrt(x2));	
}
}
}
