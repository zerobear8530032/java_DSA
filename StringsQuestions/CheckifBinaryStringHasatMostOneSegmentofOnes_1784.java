//1784. Check if Binary String Has at Most One Segment of Ones
//Solved
//Easy
//Topics
//Companies
//Hint
//Given a binary string​​​​​without leading zeros, return true​​​ if s contains at most one contiguous segment of ones. Otherwise, return false.
//
// 
//
//Example 1:
//
//Input: s = "1001"
//Output: false
//Explanation: The ones do not form a contiguous segment.
//Example 2:
//
//Input: s = "110"
//Output: true
// 
//
//Constraints:
//
//1 <= s.length <= 100
//s[i]​​​​ is either '0' or '1'.
//s[0] is '1'.
package StringsQuestions;

public class CheckifBinaryStringHasatMostOneSegmentofOnes_1784 {
//	we need to find is their all one are present in a consiqutive manner 
//	means 1111000 true , 110111 false 
//	so we first check if the lenght == 0  check if  only one char is 1 so return true else false 
//	second we check where are the first occurence of 1  if we found it then we check is the previous one is also 1 if it is
//	we will just go on and check for next char if the prev char is not one means we return false
	public static  boolean checkOnesSegment(String s) {
	        if(s.length()==1){
	            return s.charAt(0)=='1';
	        }
	        boolean seq=false;
	        for(int i =0;i<s.length();i++){
	            if(s.charAt(i)=='1'){
	                if(i>0 && s.charAt(i)!= s.charAt(i-1)){
	                    return false;
	                }
	                seq=true;
	            }
	        }
	        return seq;
	    }
	
	
	public static void main(String[] args) {
		
		//Example 1:
		//
		String s1 = "1001";
		boolean output1= false;
		//Explanation: The ones do not form a contiguous segment.
		
		//Example 2:
		//
		String  s2 = "110";
		boolean output2= true;
		
		if(output1==checkOnesSegment(s1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
		}
		
		if(output1==checkOnesSegment(s1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
		}
		
		if(output2==checkOnesSegment(s2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
		}
	
}
}
