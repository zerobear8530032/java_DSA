//1023. Camelcase Matching
//Solved
//Medium
//Topics
//Companies
//Hint
//Given an array of strings queries and a string pattern, return a boolean array answer where answer[i] is true if queries[i] matches pattern, and false otherwise.
//
//A query word queries[i] matches pattern if you can insert lowercase English letters pattern so that it equals the query. You may insert each character at any position and you may not insert any characters.
//
//Example 1:
//
//Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
//Output: [true,false,true,true,false]
//Explanation: "FooBar" can be generated like this "F" + "oo" + "B" + "ar".
//"FootBall" can be generated like this "F" + "oot" + "B" + "all".
//"FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
//Example 2:
//
//Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
//Output: [true,false,true,false,false]
//Explanation: "FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
//"FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".
//Example 3:
//
//Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
//Output: [false,true,false,false,false]
//Explanation: "FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".
// 
//
//Constraints:
//
//1 <= pattern.length, queries.length <= 100
//1 <= queries[i].length <= 100
//queries[i] and pattern consist of English letters.


package StringsQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CamelCaseMatching_1023 {
//	approch :
//	using 2 pointers one at pattern and one at string 
//	if both are capital letter then if both equal increment the both pointer other wise false
//	if pattern pointer is cap and other is small increment small
//	if pattern pointer is small and other is cap return false 
//	if both are small and equal then increment both by 1 if both are small and unequal increment inputstirng ponter
//	time complexity : O(n)  
//	space complexity : O(1)  
	public static  boolean applyPattern(String str ,String pattern){
	        int pidx=0;
	        int stridx=0;
	        int plen=pattern.length();
	        int slen=str.length();
	        while(stridx<str.length()){    
	            // if both character are caps means its starting of word so we check if both are caps then both character should be equal also
	            if(pidx < plen && isCapital(pattern.charAt(pidx)) && isCapital(str.charAt(stridx))){
	                if(pattern.charAt(pidx)!=str.charAt(stridx)){
	                    return false;
	                }else{
	                pidx++;
	                }
	                // here we checking wheather also have small characters 
	            }else if(pidx < plen && !isCapital(pattern.charAt(pidx)) && !isCapital(str.charAt(stridx))){
	                if(pattern.charAt(pidx)==str.charAt(stridx)){
	                    pidx++;
	                }
	            // here we check the string is starting a new word but if pattern does not means its false
	            }else if(pidx < plen && !isCapital(pattern.charAt(pidx)) && isCapital(str.charAt(stridx))){
	                return false;
	            }else if(pidx==plen && stridx<slen){
	                if(isCapital(str.charAt(stridx))){
	                    return false;
	                }
	            }
	            stridx++;
	        }
	        return pidx==pattern.length();
	    }
//	   check char is capital or not
	    public static boolean isCapital(char ch){
	        return ch>='A' && ch<='Z';
	    }
//	   check char is capital or not
	    public static List<Boolean> camelMatch(String[] queries, String pattern) { 
	        List<Boolean > ans = new ArrayList();
	        for( String x : queries){
	            ans.add(applyPattern(x,pattern));
	        }
	        
	        return ans;
	    }
                                                                          
	    public static boolean check(List<Boolean> ans , List<Boolean> output) {
	    	if(ans.size()!=output.size()) {
	    		return false;
	    	}
	    	for(int i =0;i<ans.size();i++) {
	    		if(ans.get(i)!= output.get(i)) {
	    			return false;
	    		}
	    	}
	    	return true;
	    	
	    	
	    	
	    }

	public static void main(String[] args) {
		
		
		//Example 1:
		//
		String []queries1 = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
		String pattern1 = "FB";
		List<Boolean> output1 = new ArrayList( Arrays.asList(true,false,true,true,false));
		List<Boolean> ans1 = camelMatch(queries1, pattern1);
		//Explanation: "FooBar" can be generated like this "F" + "oo" + "B" + "ar".
		//"FootBall" can be generated like this "F" + "oot" + "B" + "all".
		//"FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
	
		
		
		
		//Example 2:
		//
		String []queries2 = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
		String pattern2 = "FoBa";
		List<Boolean> output2 = new ArrayList( Arrays.asList(true,false,true,false,false));
		List<Boolean> ans2 = camelMatch(queries2, pattern2);
	
		//Input: queries = [], pattern = "FoBa"
		//Output: []
		//Explanation: "FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
		//"FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".

		
		//Example 3:
		//
		String []queries3 = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
		String pattern3 = "FoBaT";
		List<Boolean> output3 = new ArrayList( Arrays.asList(false,true,false,false,false));
		List<Boolean> ans3 = camelMatch(queries3, pattern3);
		
		//Output: [false,true,false,false,false]
		//Explanation: "FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".

		if(check(ans1, output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		if(check(ans2, output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		if(check(ans3, output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}

	}

}
