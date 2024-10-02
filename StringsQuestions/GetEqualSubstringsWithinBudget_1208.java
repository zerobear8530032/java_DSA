//1208. Get Equal Substrings Within Budget
//Attempted
//Medium
//Topics
//Companies
//Hint
//You are given two strings s and t of the same length and an integer maxCost.
//
//You want to change s to t. Changing the ith character of s to ith character of t costs |s[i] - t[i]| (i.e., the absolute difference between the ASCII values of the characters).
//
//Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of t with a cost less than or equal to maxCost. If there is no substring from s that can be changed to its corresponding substring from t, return 0.

//Example 1:
//
//Input: s = "abcd", t = "bcdf", maxCost = 3
//Output: 3
//Explanation: "abc" of s can change to "bcd".
//That costs 3, so the maximum length is 3.
//Example 2:
//
//Input: s = "abcd", t = "cdef", maxCost = 3
//Output: 1
//Explanation: Each character in s costs 2 to change to character in t,  so the maximum length is 1.
//Example 3:
//
//Input: s = "abcd", t = "acde", maxCost = 0
//Output: 1
//Explanation: You cannot make any change, so the maximum length is 1.
// 
//
//Constraints:
//
//1 <= s.length <= 105
//t.length == s.length
//0 <= maxCost <= 106
//s and t consist of only lowercase English letters.


package StringsQuestions;

public class GetEqualSubstringsWithinBudget_1208 {
	
//	  approch sliding windows :
//	if increase size of window if cost is less if cost is greater then max we c=decrement it 
//	time complexity :O(n)  
//	space complexity :O(1)  
	    public  static int equalSubstring(String s, String t, int maxCost) {
	     int curCost =0;
	     int left =0;
	     int res =0;
	    //  sliding window 
	     for(int right =0;right<s.length();right++){
	        // here size of window will increase as we keep updating the cost with pervoius cost 
	        curCost +=Math.abs(s.charAt(right)-t.charAt(right));
	        // when cost get higher we will decrese cost of window by increasing left side 
	        while(curCost>maxCost){
	            curCost -=Math.abs(s.charAt(left)-t.charAt(left));
	            left++;
	        } 
	        // at last we find max size of window
	        res = Math.max(res,right-left+1);
	     }
	    //  here return ans ;
	     return res;   
	    }

	
	
	public static void main(String[] args) {
		
		//Example 1:
		//
		String s1 = "abcd", t1 = "bcdf";
		int maxCost1 = 3;
		int output1= 3;
		//Explanation: "abc" of s can change to "bcd".
		//That costs 3, so the maximum length is 3.
		
		
		//Example 2:
		
		String s2 = "abcd", t2 = "cdef";
		int maxCost2 = 3;
		int output2= 1;
		//Explanation: Each character in s costs 2 to change to character in t,  so the maximum length is 1.

		
		//Example 3:
		//
		String s3 = "abcd", t3 = "acde";
		int maxCost3 = 0;
		int output3= 1;
		//Explanation: You cannot make any change, so the maximum length is 1.
		
		if(output1==equalSubstring(s1, t1, maxCost1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		
		if(output2==equalSubstring(s2, t2, maxCost2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		if(output3==equalSubstring(s3, t3, maxCost3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
	}

}
