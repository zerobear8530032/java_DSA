//1967. Number of Strings That Appear as Substrings in Word
//Solved
//Easy
//Topics
//Companies
//Hint
//Given an array of strings patterns and a string word, return the number of strings in patterns that exist as a substring in word.
//
//A substring is a contiguous sequence of characters within a string.
//
//Example 1:
//
//Input: patterns = ["a","abc","bc","d"], word = "abc"
//Output: 3
//Explanation:
//- "a" appears as a substring in "abc".
//- "abc" appears as a substring in "abc".
//- "bc" appears as a substring in "abc".
//- "d" does not appear as a substring in "abc".
//3 of the strings in patterns appear as a substring in word.
//Example 2:
//
//Input: patterns = ["a","b","c"], word = "aaaaabbbbb"
//Output: 2
//Explanation:
//- "a" appears as a substring in "aaaaabbbbb".
//- "b" appears as a substring in "aaaaabbbbb".
//- "c" does not appear as a substring in "aaaaabbbbb".
//2 of the strings in patterns appear as a substring in word.
//Example 3:
//
//Input: patterns = ["a","a","a"], word = "ab"
//Output: 3
//Explanation: Each of the patterns appears as a substring in word "ab".
// 
//
//Constraints:
//
//1 <= patterns.length <= 100
//1 <= patterns[i].length <= 100
//1 <= word.length <= 100
//patterns[i] and word consist of lowercase English letters.


package StringsQuestions;

public class NumberofStringsThatAppearasSubstringsinWord_1967 {
	    public  static int numOfStrings(String[] patterns, String word) {
	        int c=0;
	        for(int i =0;i<patterns.length;i++){
	            if(contains(word,patterns[i])){
	                c++;}
	        }
	        return c;        
	    }
	    public  static int numOfStringsbetter(String[] patterns, String word) {
	    	int c=0;
	    	for(int i =0;i<patterns.length;i++){
	    		if(word.contains(patterns[i])){
	    	
	    			c++;}
	    	}
	    	return c;        
	    }
	 public static boolean contains(String str, String find) {
	        if (find.length() > str.length()) {
	            return false;
	        }

	        for (int i = 0; i <= str.length() - find.length(); i++) {
	            int j = 0;
	            while (j < find.length() && str.charAt(i + j) == find.charAt(j)) {
	                j++;
	            }
	            if (j == find.length()) {
	                return true;
	            }
	        }
	        return false;
	    }
	
public static void main(String[] args) {
	//Example 1:
	//
	String []patterns1 = {"a","abc","bc","d"} ;
	String word1 = "abc";
	int output1= 3;
	//Explanation:
	//- "a" appears as a substring in "abc".
	//- "abc" appears as a substring in "abc".
	//- "bc" appears as a substring in "abc".
	//- "d" does not appear as a substring in "abc".
	//3 of the strings in patterns appear as a substring in word.
	
	//Example 2:
	//
	String []patterns2 = {"a","b","c"} ;
	String word2 = "aaaaabbbbb";
	int output2= 2;
	//Explanation:
	//- "a" appears as a substring in "aaaaabbbbb".
	//- "b" appears as a substring in "aaaaabbbbb".
	//- "c" does not appear as a substring in "aaaaabbbbb".
	//2 of the strings in patterns appear as a substring in word.
	//Example 3:
	//
	//Input: patterns = ["a","a","a"], word = "ab"
	//Output: 3
	//Explanation: Each of the patterns appears as a substring in word "ab".
	String []patterns3 = {"a","a","a"} ;
	String word3 = "ab";
	int output3= 3;
	
	if(numOfStrings(patterns1, word1)==output1) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");
	}
	
	
	if(numOfStrings(patterns2, word2)==output2) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");
	}
	
	if(numOfStrings(patterns3, word3)==output3) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");
	}
	
	
	
	if(numOfStringsbetter(patterns1, word1)==output1) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");
	}
	
	if(numOfStrings(patterns2, word2)==output2) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");
	}
	
	if(numOfStrings(patterns3, word3)==output3) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");
	}
	
}

}
