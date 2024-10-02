//1573. Number of Ways to Split a String
//Solved
//Medium
//Topics
//Companies
//Hint
//Given a binary string s, you can split s into 3 non-empty strings s1, s2, and s3 where s1 + s2 + s3 = s.
//
//Return the number of ways s can be split such that the number of ones is the same in s1, s2, and s3. Since the answer may be too large, return it modulo 109 + 7.
//
//Example 1:
//
//Input: s = "10101"
//Output: 4
//Explanation: There are four ways to split s in 3 parts where each part contain the same number of letters '1'.
//"1|010|1"
//"1|01|01"
//"10|10|1"
//"10|1|01"
//Example 2:
//
//Input: s = "1001"
//Output: 0
//Example 3:
//
//Input: s = "0000"
//Output: 3
//Explanation: There are three ways to split s in 3 parts.
//"0|0|00"
//"0|00|0"
//"00|0|0"
// 
//
//Constraints:
//
//3 <= s.length <= 105
//s[i] is either '0' or '1'.
package StringsQuestions;

public class NumberofWaystoSplitaString_1573 {
//	approch :
//	find th ecount of ones 
//	and find the required ones per string 
//	and find boundary of the strings
//	 find the boundary and find intermediate zeros count on left +1 * count oof zero on right+1 ans 
//	if count of total ones are 0 apply n-1Cr 
//	if count of ones are not multiple of 3 return 0
	
	
	
	
//	note : the int can over flow so make sure it anns evaluate in the long
	
//	Time Complexity: O(n), where n is the length of the string s.
//	Space Complexity: O(1) beyond the input string.

	
	    public static int numWays(String s) {
	        int required =0;
	        int countones=0;
	        long mod = 1_000_000_007;;
	        for(int i =0;i<s.length();i++){
	            if(s.charAt(i)=='1'){
	                countones++;
	            }
	        }
	        System.out.println(countones);
	        if(countones%3!=0){
	            return 0;
	        }else if(countones%3==0){
	            required=countones/3;
	        }
	        if(countones==s.length()){
	            return 1;
	        }
	        int n = s.length();
	    if (countones == 0) {
	        long numWays = (n - 1L) * (n - 2L) / 2L % mod; // Directly compute n-1 choose 2
	        return (int) numWays;
	    }

	        int left =0;
	        int countleft1=0;
	        int countleft0=1;
	        while(left<s.length()){
	            if(s.charAt(left)=='1' && countleft1<required){
	                countleft1++;
	            }
	            else if(required==countleft1){
	                if(s.charAt(left)=='0'){
	                    countleft0++;
	                }else{
	                    break;
	                }
	            }
	            left++;
	        }
	       
	       
	        int right =s.length()-1;
	        int countright1=0;
	        int countright0=1;
	        while(right>=0){
	            if(s.charAt(right)=='1' && countright1<required){
	                countright1++;
	            }
	            else if(required==countright1){
	                if(s.charAt(right)=='0'){
	                    countright0++;
	                }else{
	                    break;
	                }
	            }
	            right--;
	        }
	    return (int)(countleft0%mod*countright0%mod);
	    }
	    
	    
	    public static void count(String s) {
	    	int c1=0;
	    	int c0=0;
	    	for(int i =0 ;i<s.length();i++) {
	    		if(s.charAt(i)=='1') {
	    			c1++;
	    		}else {
	    			c0++;
	    		}
	    	}
	    	System.out.println(c0+"     "+c1);
	    }

	   public static void main(String[] args) {
		 //Example 1:
		   //
		   String s1 = "10101";
		   int output1= 4;
		   //Explanation: There are four ways to split s in 3 parts where each part contain the same number of letters '1'.
		   //"1|010|1"
		   //"1|01|01"
		   //"10|10|1"
		   //"10|1|01"
		   
		   //Example 2:
		   //
		   String s2 = "1001";
		   int output2= 0;

		   
		   
		   //Example 3:
		   //
		   String s3 = "0000";
		   int output3= 3;
		   //Explanation: There are three ways to split s in 3 parts.
		   //"0|0|00"
		   //"0|00|0"
		   //"00|0|0"
		   
			
			if(output1==numWays(s1)) {
				System.out.println("Case 1 Passed");
			}else {
				System.out.println("Case 1 Failed");			
			}
			
			if(output2==numWays(s2)) {
				System.out.println("Case 2 Passed");
			}else {
				System.out.println("Case 2 Failed");			
			}
			
			
			if(output3==numWays(s3)) {
				System.out.println("Case 3 Passed");
			}else {
				System.out.println("Case 3 Failed");			
			}
			
			
			
	}

}
