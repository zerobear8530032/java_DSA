//1662. Check If Two String Arrays are Equivalent
//Solved
//Easy
//Topics
//Companies
//Hint
//Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
//
//A string is represented by an array if the array elements concatenated in order forms the string.
//
//Example 1:
//
//Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
//Output: true
//Explanation:
//word1 represents string "ab" + "c" -> "abc"
//word2 represents string "a" + "bc" -> "abc"
//The strings are the same, so return true.
//Example 2:
//
//Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
//Output: false
//Example 3:
//
//Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
//Output: true
// 
//
//Constraints:
//
//1 <= word1.length, word2.length <= 103
//1 <= word1[i].length, word2[i].length <= 103
//1 <= sum(word1[i].length), sum(word2[i].length) <= 103
//word1[i] and word2[i] consist of lowercase letters.
package StringsQuestions;
public class checkIfTwoStringArraysAreEquivalent_1662 {
// brute force extra space :
// here we take 2 string which join the word 1  and word 2 and we can just return true if they are equal or not
//	but this is not effective for very large strings
//	time coomplexity :O(l1+l2)
//	space coomplexity :O(l1+l2)
	public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		String s1 = String.join("",word1);
		String s2 = String.join("",word2);
		return s1.equals(s2);
	}
//	this approch preciselymove the pointer and check the  arrray characters 
//	time coomplexity :O(l1+l2)
//	space coomplexity :O(1)
	 public static  boolean arrayStringsAreEqualBetter(String[] word1, String[] word2) {
	        int i1=0,i2=0; // index of array
	        int j1=0,j2=0; // index of strings
	        while(i1<word1.length && i2<word2.length){
//	        	check for equal characters
	            if(word1[i1].charAt(j1)!= word2[i2].charAt(j2)){return false;}
	            j1++;
	            j2++;
//	            check whether word 1 string reach last index
	            if(word1[i1].length()==j1){
//	                reset string index for word 1
	            	j1=0;
//	            	next string word 1
	                i1++;
	            }
//	            check whether word 2 string reach last index
	            if(word2[i2].length()==j2){
//	                reset string index for word 2 
	            	j2=0;
//	                next string for word 2 
	                i2++;
	            }
	        }
//	        this will be true when both pointer reaches end 
	        return i1==word1.length && i2==word2.length;
	    }
	
	
	public static void main(String[] args) {
		//Example 1:
		//
		String[] word11 = {"ab", "c"}, word12 = {"a", "bc"};
		boolean output1= true;
		if(output1==arrayStringsAreEqual(word11, word12)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		
		//Explanation:
		//word1 represents string "ab" + "c" -> "abc"
		//word2 represents string "a" + "bc" -> "abc"
		//The strings are the same, so return true.
		//Example 2:
		//
		String [] word21 = {"a", "cb"}, word22 = {"ab", "c"};
		boolean output2= false;
		if(output2==arrayStringsAreEqual(word21, word22)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		//Example 3:
		//
		String [] word31  = {"abc", "d", "defg"}, word32 = {"abcddefg"};
		boolean output3= true;
		if(output3==arrayStringsAreEqual(word31, word32)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
		
		
		
		
//		beter approch :
		if(output1==arrayStringsAreEqualBetter(word11, word12)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		if(output2==arrayStringsAreEqualBetter(word21, word22)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		if(output3==arrayStringsAreEqualBetter(word31, word32)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}

	}

}
