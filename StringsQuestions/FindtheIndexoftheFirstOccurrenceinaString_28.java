//28. Find the Index of the First Occurrence in a String
//Solved
//Easy
//Topics
//Companies
//Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack. 

//Example 1:
//
//Input: haystack = "sadbutsad", needle = "sad"
//Output: 0
//Explanation: "sad" occurs at index 0 and 6.
//The first occurrence is at index 0, so we return 0.
//Example 2:
//
//Input: haystack = "leetcode", needle = "leeto"
//Output: -1
//Explanation: "leeto" did not occur in "leetcode", so we return -1.
// 
//
//Constraints:
//
//1 <= haystack.length, needle.length <= 104
//haystack and needle consist of only lowercase English characters.


package StringsQuestions;
public class FindtheIndexoftheFirstOccurrenceinaString_28 {
//	here we use inbuild ffunction:

	public static int strStrBrute(String haystack, String needle) {
		return haystack.indexOf(needle);
	}
//	here we just  start from first index and using a nested loop try to get all character till length of needle to match if not we break 
//	if they matches we return ans 
//	other on the upper loop we only go from the 0 till haystacklength - needlelength
//	because we cant check if the reaminng sting is lesser then the possible string 
//	time complexity :O(n*m)
//	space complexity :O(1)
	    public static int strStrManual(String haystack, String needle) {
	        if (needle.equals("")){
	            return 0;
	        }
	        for(int i =0;i<=haystack.length()-needle.length();i++){            
	            for(int j =0;j<needle.length();j++){
	                if(haystack.charAt(i+j)!=needle.charAt(j)){
	                break;
	                }
	                if(j==needle.length()-1){
	                    return i;
	                }
	            }
	        }
	    return -1;
	    }
	
	public static void main(String[] args) {
		//Example 1:
		//
		String haystack1 = "sadbutsad", needle1 = "sad";
		int output1= 0;
		//Explanation: "sad" occurs at index 0 and 6.
		//The first occurrence is at index 0, so we return 0.
		
		//Example 2:
		//
		String haystack2 = "leetcode", needle2 = "leeto";
		int output2= -1;
		//Explanation: "leeto" did not occur in "leetcode", so we return -1.

		System.out.println("ManuL approch");
		if(output1==strStrManual(haystack1,needle1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		if(output2==strStrManual(haystack2,needle2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		System.out.println("InBuild approch");
		
		if(output1==strStrBrute(haystack1,needle1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		if(output2==strStrBrute(haystack2,needle2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
	}

}
