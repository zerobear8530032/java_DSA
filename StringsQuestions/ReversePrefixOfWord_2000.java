//2000. Reverse Prefix of Word
//Solved
//Easy
//Topics
//Companies
//Hint
//Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.
//
//For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive). The resulting string will be "dcbaefd".
//Return the resulting string.
//
//Example 1:
//
//Input: word = "abcdefd", ch = "d"
//Output: "dcbaefd"
//Explanation: The first occurrence of "d" is at index 3. 
//Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
//Example 2:
//
//Input: word = "xyxzxe", ch = "z"
//Output: "zxyxxe"
//Explanation: The first and only occurrence of "z" is at index 3.
//Reverse the part of word from 0 to 3 (inclusive), the resulting string is "zxyxxe".
//Example 3:
//
//Input: word = "abcd", ch = "z"
//Output: "abcd"
//Explanation: "z" does not exist in word.
//You should not do any reverse operation, the resulting string is "abcd".
// 
//
//Constraints:
//
//1 <= word.length <= 250
//word consists of lowercase English letters.
//ch is a lowercase English letter.


package StringsQuestions;
public class ReversePrefixOfWord_2000 {
//	approch : we iterate over string and check for the ch  if we found it we use a function reverse which take string and end index so we pass char index to reverse as end and full string  
//	the revese function convert string to char array then we can rever string from 0 till char index and returnthe string 
//	at last we return the string we got after reverse 
//	if the char not found we return default string 
//	time complexity :O(n+n)
//	space complexity :O(n) -> for reverse
	
	
	   public static String reversePrefix(String word, char ch) {
	        for(int i =0;i<word.length();i++){
	            if(word.charAt(i)==ch){
	                return reverse(word,i);
	            }
	        }
	        return word;
	        
	    }
	    public static String  reverse(String str ,int end){
	        int start =0;
	        char [] chararr = str.toCharArray();
	        while(start<end){
	            char temp = chararr[start];
	            chararr[start]=chararr[end];
	            chararr[end]=temp;
	            start++;
	            end--;
	        }
	        return new String(chararr);
	    }
	
	public static void main(String[] args) {
		
		
		
		//Example 1:
		//
		String word1 = "abcdefd";
		char ch1 = 'd';
		String output1= "dcbaefd";
		//Explanation: The first occurrence of "d" is at index 3. 
		//Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
		
		
		//Example 2:
		//
		String word2 = "xyxzxe";
		char ch2 = 'z';
		String output2= "zxyxxe";
		
		//Explanation: The first and only occurrence of "z" is at index 3.
		//Reverse the part of word from 0 to 3 (inclusive), the resulting string is "zxyxxe".
		
		
		//Example 3:
		//
		String word3 = "abcd";
		char ch3 = 'z';
		String output3= "abcd";
		//Explanation: "z" does not exist in word.
		//You should not do any reverse operation, the resulting string is "abcd".
		
		
		if(output1.equals(reversePrefix(word1, ch1) )) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		
		
		
		if(output2.equals(reversePrefix(word2, ch2))) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		
		
		
		if(output3.equals(reversePrefix(word3, ch3) )) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
	}

}
