//1163. Last Substring in Lexicographical Order
//Solved
//Hard
//Topics
//Companies
//Hint
//Given a string s, return the last substring of s in lexicographical order.
//
//Example 1:
//
//Input: s = "abab"
//Output: "bab"
//Explanation: The substrings are ["a", "ab", "aba", "abab", "b", "ba", "bab"]. The lexicographically maximum substring is "bab".
//Example 2:
//
//Input: s = "leetcode"
//Output: "tcode"
// 
//
//Constraints:
//
//1 <= s.length <= 4 * 105
//s contains only lowercase English letters.




package StringsQuestions;
import java.util.*;
public class LastSubstringinLexicographicalOrder_1163 {
//	  brute Force approch : 
//	first we will create a list of substring possible from input string 
//	then sort the entire list and return last index string of the sorted list 
	
//	time complexity : O(n*n) + O(n log n)
//	space complexity : O(n*n)
	
	public static String lastSubstringBruteForce(String s) {
		  ArrayList<String> substrings = new ArrayList();
//		  here we will geenrate all possible substrings 
		  for(int i =0;i<s.length();i++) {
			  for(int j = i+1 ;j<=s.length();j++) {
				  substrings.add(s.substring(i,j));
			  }
		  }
//		  sort the entire substrings
		  Collections.sort(substrings);
//		  return last substring of list
		  return substrings.get(substrings.size()-1);
	  }
	
	
//	Better Brute Force approch : 
//	first we will create a list of substring which are most likely to be the last sub string from input string 
//	how we will figure out the most likely substrings 
//	first we need to know what Lexicographical order is 
//	the Lexicographical order is a way to arrage the string in a certain way 
//	we check the string to be  arranged in alphabetic order 
//	if the string is proper prefix of a string then we will sort accordingg to length 

//	so we need to find the max character of string and find its possition in the string if their are multiple of them means
//	their are multiple possible string which we can store in a list and sort them to find last one 
	
//	example : abcccdadfdfecdsa : here max characcter is f
//	 fdfecdsa , fecdsa 
//	now we can sort this where we will get our string fecdsa as last substring 

//	then sort the entire list and return last index string of the sorted list 
	
//	time complexity : O(n*n) + O(n log n)
//	space complexity : O(n*n)
	
	public static String lastSubstringBetterBruteForce(String s) {
		ArrayList<String> substrings = new ArrayList();
//		  here we will generate all possible substrings 
		char ch = s.charAt(0);
//		getting max character 
		for(int i =0;i<s.length();i++) {
			if (ch<s.charAt(i)) {
				ch = s.charAt(i);
			}
		}
		for(int i = 0;i<s.length();i++) {
			if(s.charAt(i)== ch) {
				substrings.add(s.substring(i,s.length()));
			}
		}
//		  sort the entire substrings
		Collections.sort(substrings);
//		  return last substring of list
		return substrings.get(substrings.size()-1);
	}
	
	
//approc : using  2 pointer 1 i and 2 j 
//	here i =0 and j =i+1
//	now we will take an offset of both string k =0
//	initally 
//	now we will loop from j+k <n
//	inside loop we will check if character at s[k+i] == s[j+i] if equal we will increment offset k++
//	so that we can check next character 
//	if s[k+i] > s[j+i] then we know current i strinng is better means we can
//	start finding new string form j+1 but we already have checked from j till k in prev iterations
//	so we put j = j+k+1
//	if s[k+i] < s[j+i] then we know j  strinng is better means we can
//	put i at j and find finding new string form j+1 but we already have checked from j till k in prev iterations
//	so we put i = maxof(i+k+1, j)  if i+k+1 is greater which means we can say next character is our next substring start 
//	otherwise its j 
//	at last we can return substring(i) this will make substring starting from i till last character of stirng
	public static String lastSubstringOptimize(String s) {
		int i =0; // it will  keep track of current best substring 
		int j = i+1;// it will  keep track of next best substring which could be best  
		int k =0; // offset of the substrings
		while(j+k<s.length()) {
			if(s.charAt(k+i) == s.charAt(k+j)) {
				k++;
				
			}else if(s.charAt(k+i)>s.charAt(k+j)) {
				j=j+k+1;
				k=0;
			}else {
				i=Math.max(i+k+1, j);
				j=i+1;
				k=0;
			}
		}
		return s.substring(i);
		
	}
	public static void main(String[] args) {
		//Example 1:
		String  s1 = "abab";
		String output1 ="bab";
		//Explanation: The substrings are ["a", "ab", "aba", "abab", "b", "ba", "bab"]. The lexicographically maximum substring is "bab".

		//Example 2:
		String  s2 = "leetcode";
		String output2 ="tcode";
		
		
		//Example 3: here the 'a' is repeated over 1k time but for testing purposes its give smaller string 

		String  s3 = "aaaaaaaaaaa";
		String output3 ="aaaaaaaaaaa";
		
		if(lastSubstringBruteForce(s1).equals(output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		if(lastSubstringBruteForce(s2).equals(output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
//		this case will get out of heap memory error because of brute force approch each substring will cost a lot of memeory even with a bit better the only character here is a means its will have s.length()! substrings which is equal to brute force approch  
		if(lastSubstringBruteForce(s3).equals(output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
		
		
		
		
		
		if(lastSubstringBetterBruteForce(s1).equals(output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		if(lastSubstringBetterBruteForce(s2).equals(output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
//		this case will get out of heap memory error because of brute force approch each substring will cost a lot of memeory 
		if(lastSubstringBetterBruteForce(s3).equals(output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}

		
		
		if(lastSubstringOptimize(s1).equals(output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		if(lastSubstringOptimize(s2).equals(output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		if(lastSubstringOptimize(s3).equals(output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
		
		
		
	}
}
