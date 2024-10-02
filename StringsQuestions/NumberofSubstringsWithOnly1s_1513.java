//1513. Number of Substrings With Only 1s
//Solved
//Medium
//Topics
//Companies
//Hint
//Given a binary string s, return the number of substrings with all characters 1's. Since the answer may be too large, return it modulo 109 + 7.
//
// 
//
//Example 1:
//
//Input: s = "0110111"
//Output: 9
//Explanation: There are 9 substring in total with only 1's characters.
//"1" -> 5 times.
//"11" -> 3 times.
//"111" -> 1 time.
//Example 2:
//
//Input: s = "101"
//Output: 2
//Explanation: Substring "1" is shown 2 times in s.
//Example 3:
//
//Input: s = "111111"
//Output: 21
//Explanation: Each substring contains only 1's characters.
// 
//
//Constraints:
//
//1 <= s.length <= 105
//s[i] is either '0' or '1'.


package StringsQuestions;

public class NumberofSubstringsWithOnly1s_1513 {
//	approch: using forumal (integer )((n+1)*n)/2
//	by the formula we just need to count number of consicutive 1 and apply formula to it 
//	and add all consicutive grp sum as answer 
//	time compelxity : O(n)
//	Space compelxity : O(1)
	
	public static  int numSub(String s) {
	        int ans =0;
	        int mod = 1_000_000_007;
//	        interate over string 
	        for(int i =0;i<s.length();i++){
//	        one counter
	        	int count=0;
//	        	counting number of consicutive ones
	        while(i<s.length() && s.charAt(i)=='1'){
	            count++;
	            i++;
	        }
//	        adding result of all the grp sub sequence 
	        ans = (ans%mod+ calculate(count)%mod);
	      }
	      return ans;
	    }
//	it will calculate all possible sub sequence of 1 with in every consicutive group
	    public static int calculate(int n ){
	        int mod = 1_000_000_007;
	        long num = n;
//	        formula for calcualting all possible sub sequence 
	        num=((num+1)*num)/2;
	        return (int)(num%mod);
	    }
	

	public static void main(String[] args) {
		
		//Example 1:
		String s1  = "0110111";
		int  output1= 9;
		//Explanation: There are 9 substring in total with only 1's characters.
		//"1" -> 5 times.
		//"11" -> 3 times.
		//"111" -> 1 time.
		
		//Example 2:
		String s2  = "101";
		int  output2= 2;
		//Explanation: Substring "1" is shown 2 times in s.
		
		//Example 3:
		String s3 = "111111";
		int output3=21;
		//Explanation: Each substring contains only 1's characters.
		
		if(output1==numSub(s1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		if(output2==numSub(s2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		if(output3==numSub(s3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}


	}

}
