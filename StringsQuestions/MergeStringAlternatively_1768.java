//1768. Merge Strings Alternately
//Solved
//Easy
//Topics
//Companies
//Hint
//You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
//
//Return the merged string.
//
// 
//
//Example 1:
//
//Input: word1 = "abc", word2 = "pqr"
//Output: "apbqcr"
//Explanation: The merged string will be merged as so:
//word1:  a   b   c
//word2:    p   q   r
//merged: a p b q c r
//Example 2:
//
//Input: word1 = "ab", word2 = "pqrs"
//Output: "apbqrs"
//Explanation: Notice that as word2 is longer, "rs" is appended to the end.
//word1:  a   b 
//word2:    p   q   r   s
//merged: a p b q   r   s
//Example 3:
//
//Input: word1 = "abcd", word2 = "pq"
//Output: "apbqcd"
//Explanation: Notice that as word1 is longer, "cd" is appended to the end.
//word1:  a   b   c   d
//word2:    p   q 
//merged: a p b q c   d
// 
//
//Constraints:
//
//1 <= word1.length, word2.length <= 100
//word1 and word2 consist of lowercase English letters.

package StringsQuestions;

public class MergeStringAlternatively_1768 {
//	approch : simple approch where we have a struingbuilder 
//	and we start at index 0 and loop untill index< wiord1 || index<word2
//	and append word 1 char iin ans then word 2 character in answe 
//	and check if it possible that index reach end of anu string 
//	at last return answer 
//	time complexity :O(max(n,m));
	    public static String mergeAlternately(String word1, String word2) {
	        int index=0;
	        int s1=word1.length();
	        int s2=word2.length();
	        StringBuilder str = new StringBuilder(s1+s2);
	        while(index<s1 || index<s2){
	            if(index<s1 ){
	                str.append(word1.charAt(index));
	            }
	            if(index<s2){
	                str.append(word2.charAt(index));
	            }
	            index++;
	        }
	        return str.toString();
	    }
public static void main(String[] args) {
	
	
	//Example 1:
	//
	String word11 = "abc", word12 = "pqr";
	String output1= "apbqcr";
	
	//Explanation: The merged string will be merged as so:
	//word1:  a   b   c
	//word2:    p   q   r
	//merged: a p b q c r
	
	//Example 2:
	//
	String  word21 = "ab", word22 = "pqrs";
	String output2= "apbqrs";
	//Explanation: Notice that as word2 is longer, "rs" is appended to the end.
	//word1:  a   b 
	//word2:    p   q   r   s
	//merged: a p b q   r   s
	
	//Example 3:
	//
	String word31 = "abcd", word32 = "pq";
	String output3= "apbqcd";
			
	//Explanation: Notice that as word1 is longer, "cd" is appended to the end.
	//word1:  a   b   c   d
	//word2:    p   q 
	//merged: a p b q c   d
	
	if(output1.equals(mergeAlternately(word11, word12))) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	if(output2.equals(mergeAlternately(word21, word22))) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	if(output3.equals(mergeAlternately(word31, word32))) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}


}
}
		