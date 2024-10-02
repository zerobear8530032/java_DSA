//1668. Maximum Repeating Substring
//Solved
//Easy
//Topics
//Companies
//Hint
//For a string sequence, a string word is k-repeating if word concatenated k times is a substring of sequence. The word's maximum k-repeating value is the highest value k where word is k-repeating in sequence. If word is not a substring of sequence, word's maximum k-repeating value is 0.
//
//Given strings sequence and word, return the maximum k-repeating value of word in sequence.
//
// 
//
//Example 1:
//
//Input: sequence = "ababc", word = "ab"
//Output: 2
//Explanation: "abab" is a substring in "ababc".
//Example 2:
//
//Input: sequence = "ababc", word = "ba"
//Output: 1
//Explanation: "ba" is a substring in "ababc". "baba" is not a substring in "ababc".
//Example 3:
//
//Input: sequence = "ababc", word = "ac"
//Output: 0
//Explanation: "ac" is not a substring in "ababc". 
// 
//
//Constraints:
//
//1 <= sequence.length <= 100
//1 <= word.length <= 100
//sequence and word contains only lowercase English letters.


package StringsQuestions;
public class MaximumRepeatingSubstring_1668 {
// herer we create a temp stringbuilder which will append the string each time that present in the sequence
//	and we check till it present in the sequennce if its not we return count 
	
//	time complexity :O(n): n = number of exp present
//	space complexity :O(n): n = string length
	public static int maxRepeating(String sequence, String word) {
	        int maxRepeats = 0;
	        StringBuilder repeatedWord = new StringBuilder(word);
	        
	        while (sequence.contains(repeatedWord)) {
	            maxRepeats++;
	            repeatedWord.append(word);  // Increase the length by appending the word
	        }
	        
	        return maxRepeats;
	    }
	
	public static void main(String[] args) {
	//Example 1:
	//
	String sequence1 = "ababc", word1 = "ab";
	int output1= 2;
	//Explanation: "abab" is a substring in "ababc".
	
	
	//Example 2:
	//
	String sequence2 = "ababc", word2 = "ba";
	int output2= 1;
	//Explanation: "ba" is a substring in "ababc". "baba" is not a substring in "ababc".
	
	//Example 3:
	//
	String  sequence3 = "ababc", word3 = "ac";
	int output3=0;
	
	//Explanation: "ac" is not a substring in "ababc". 

	if(output1==maxRepeating(sequence1,word1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	if(output2==maxRepeating(sequence2,word2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	if(output3==maxRepeating(sequence3,word3)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}
	
	
}
}
