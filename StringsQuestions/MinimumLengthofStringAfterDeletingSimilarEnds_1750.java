//1750. Minimum Length of String After Deleting Similar Ends
//Solved
//Medium
//Topics
//Companies
//Hint
//Given a string s consisting only of characters 'a', 'b', and 'c'. You are asked to apply the following algorithm on the string any number of times:
//
//Pick a non-empty prefix from the string s where all the characters in the prefix are equal.
//Pick a non-empty suffix from the string s where all the characters in this suffix are equal.
//The prefix and the suffix should not intersect at any index.
//The characters from the prefix and suffix must be the same.
//Delete both the prefix and the suffix.
//Return the minimum length of s after performing the above operation any number of times (possibly zero times).
//
// 
//
//Example 1:
//
//Input: s = "ca"
//Output: 2
//Explanation: You can't remove any characters, so the string stays as is.
//Example 2:
//
//Input: s = "cabaabac"
//Output: 0
//Explanation: An optimal sequence of operations is:
//- Take prefix = "c" and suffix = "c" and remove them, s = "abaaba".
//- Take prefix = "a" and suffix = "a" and remove them, s = "baab".
//- Take prefix = "b" and suffix = "b" and remove them, s = "aa".
//- Take prefix = "a" and suffix = "a" and remove them, s = "".
//Example 3:
//
//Input: s = "aabccabba"
//Output: 3
//Explanation: An optimal sequence of operations is:
//- Take prefix = "aa" and suffix = "a" and remove them, s = "bccabb".
//- Take prefix = "b" and suffix = "bb" and remove them, s = "cca".
// 
//
//Constraints:
//
//1 <= s.length <= 105
//s only consists of characters 'a', 'b', and 'c'.


package StringsQuestions;

public class MinimumLengthofStringAfterDeletingSimilarEnds_1750 {
//	approch :
//	using 2 pointers 
//	first pointer start from 0 index 
//	second pointer start from stringlength()-1
//	and loop will run till start<end {start++; end--;}
//	now we will check character at start and end index is equal other wise we break if they ar equal
//	then we store that character and  increment start till we does not encounter another chracter
//	same as start decrement end till we does not encounter another chracter
//	and we check start <= end 
//	to make sure we does not cross pointers 
//	at last we return end-start+1 which is the length of character btw start and end 
	

	    public static int minimumLength(String s) {
//	    	initalize pointers
	        int start =0;
	        int end =s.length()-1;
//	        loop untill start and end character are equal or there pointer are not equal
	        while(start<end && s.charAt(start)==s.charAt(end)){
//	        	if both char is equal we can skip the character 
	            char skipchar = s.charAt(start);
//	            skipping character which is equal from prefix untill another character comes
	            while(start<s.length() && skipchar==s.charAt(start) && start<=end){start++;}
//	            skipping character which is equal from suffix untill another character comes
	            while(end>-1 &&skipchar==s.charAt(end) && start<=end){end--;}
	          
	        }
//	        at last we can return the number of character btw start and end ;
	        int ans =end-start+1;
	        return ans;
	    }
	public static void main(String[] args) {
		
		
		
		//Example 1:
		//
		String s1 = "ca";
		int output1= 2;
		//Explanation: You can't remove any characters, so the string stays as is.
		//Example 2:
		//
		String s2 = "cabaabac";
		int output2=0;
		//Explanation: An optimal sequence of operations is:
		//- Take prefix = "c" and suffix = "c" and remove them, s = "abaaba".
		//- Take prefix = "a" and suffix = "a" and remove them, s = "baab".
		//- Take prefix = "b" and suffix = "b" and remove them, s = "aa".
		//- Take prefix = "a" and suffix = "a" and remove them, s = "".
		//Example 3:
		//
		String s3 = "aabccabba";
		int output3=3;
		//Explanation: An optimal sequence of operations is:
		//- Take prefix = "aa" and suffix = "a" and remove them, s = "bccabb".
		//- Take prefix = "b" and suffix = "bb" and remove them, s = "cca".

		
		
	
		if(output1== minimumLength(s1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		if(output2== minimumLength(s2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		if(output3== minimumLength(s3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}

	}

}
