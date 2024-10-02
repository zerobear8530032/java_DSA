//680. Valid Palindrome II
//Solved
//Easy
//Topics
//Companies
//Given a string s, return true if the s can be palindrome after deleting at most one character from it.
//
//Example 1:
//
//Input: s = "aba"
//Output: true
//Example 2:
//
//Input: s = "abca"
//Output: true
//Explanation: You could delete the character 'c'.
//Example 3:
//
//Input: s = "abc"
//Output: false
// 
//
//Constraints:
//
//1 <= s.length <= 105
//s consists of lowercase English letters.
package StringsQuestions;

public class ValidPalindrome_680 {
	
//	bruteForce approch:
//	here we check by exculding every single character from main string and check its  palindroe or not 
//	time complexity O(n*n)
//	spacecomplexity O(n*n)
	    public static  boolean validPalindromeBruteForce(String s) {
	        if(ispalindrome(s)){
	            return true;
	        }
	        for(int i =0;i<s.length();i++){
	           
	            if(ispalindrome(s.substring(0,i)+s.substring(i+1,s.length()))){
	                return true;
	            }
	        }
	        
	        return false;
	    }
	
	
	
	
//	better approch :
//	similar to best approch the difference is we give a sub string instead of pointers
//	time complexity O(n)
//	spacecomplexity O(n)
	    public static boolean validPalindromeBetter(String s) {
	        int start =0;
	        int end = s.length()-1;
	        while(start<end){
	            if(s.charAt(start)!=s.charAt(end)){
	                return ispalindrome(s.substring(start+1,end+1)) || ispalindrome(s.substring(start,end));
	            }
	            start++;
	            end--;
	        }
	        return true;
	    }
	    public static boolean ispalindrome(String str){
	        int start =0;
	        int end =str.length()-1;
	        while(start<end){
	            if(str.charAt(start)!=str.charAt(end)){return false;}
	            start++;
	            end--;
	        }
	        return true;
	    }
	
	
	
	
	
//	approch video :
//	https://www.youtube.com/watch?v=JrxRYBwG6EI
//	best approch :
//	here we know we can remove at most one character if a string is not a palindrome 
//	so we can check with 2 pointer at start and end iterate through the string if is by default 
//	apalindrome but it any where character does not match means we can 
//	remove 2 possible character 1 at left side or 1 at right side
//	so we can use 
//	a palindrome funtion where we give the sting and range start+1 till end to check  
//	if we remove left char we get a palindrome 
//	or we check at right side by same function in range from start till end-1;
//	at last if any of them give true means answer iis true other wise false
	
//	time complexity O(n)
//	spacecomplexity O(1)
	
	    public static boolean validPalindromeBest(String s) {
	        int start =0;
	        int end = s.length()-1;
	        while(start<end){
	            if(s.charAt(start)!=s.charAt(end)){
	                return ispalindrome(s,start+1,end) || ispalindrome(s,start,end-1);
	            }
	            start++;
	            end--;
	        }
	        return true;
	    }
	    public static boolean ispalindrome(String str,int start,int end){
	        while(start<end){
	            if(str.charAt(start)!=str.charAt(end)){return false;}
	            start++;
	            end--;
	        }
	        return true;
	    }
	
	
public static void main(String[] args) {
	//Example 1:
	String s1 = "aba";
	boolean output1= true;
	
	//Example 2:
	String s2 = "abca";
	boolean output2= true;
	//Explanation: You could delete the character 'c'.
	
	//Example 3:
	String  s3 = "abc";
	boolean output3= false;
	
	
	System.out.println("bruteForce approch");
	if(output1==validPalindromeBruteForce(s1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	if(output2==validPalindromeBruteForce(s2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	if(output3==validPalindromeBruteForce(s3)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}

	
	
	
	System.out.println("better approch");
	if(output1==validPalindromeBetter(s1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	if(output2==validPalindromeBetter(s2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	if(output3==validPalindromeBetter(s3)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}

	
	
	System.out.println("BestForce approch");
	if(output1==validPalindromeBest(s1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	if(output2==validPalindromeBest(s2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	if(output3==validPalindromeBest(s3)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}

}
}
