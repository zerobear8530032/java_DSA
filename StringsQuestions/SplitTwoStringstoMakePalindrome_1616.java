//1616. Split Two Strings to Make Palindrome
//Attempted
//Medium
//Topics
//Companies
//Hint
//You are given two strings a and b of the same length. Choose an index and split both strings at the same index, splitting a into two strings: aprefix and asuffix where a = aprefix + asuffix, and splitting b into two strings: bprefix and bsuffix where b = bprefix + bsuffix. Check if aprefix + bsuffix or bprefix + asuffix forms a palindrome.
//
//When you split a string s into sprefix and ssuffix, either ssuffix or sprefix is allowed to be empty. For example, if s = "abc", then "" + "abc", "a" + "bc", "ab" + "c" , and "abc" + "" are valid splits.
//
//Return true if it is possible to form a palindrome string, otherwise return false.
//
//Notice that x + y denotes the concatenation of strings x and y.
//
// 
//
//Example 1:
//
//Input: a = "x", b = "y"
//Output: true
//Explaination: If either a or b are palindromes the answer is true since you can split in the following way:
//aprefix = "", asuffix = "x"
//bprefix = "", bsuffix = "y"
//Then, aprefix + bsuffix = "" + "y" = "y", which is a palindrome.
//Example 2:
//
//Input: a = "xbdef", b = "xecab"
//Output: false
//Example 3:
//
//Input: a = "ulacfd", b = "jizalu"
//Output: true
//Explaination: Split them at index 3:
//aprefix = "ula", asuffix = "cfd"
//bprefix = "jiz", bsuffix = "alu"
//Then, aprefix + bsuffix = "ula" + "alu" = "ulaalu", which is a palindrome.
// 
//
//Constraints:
//
//1 <= a.length, b.length <= 105
//a.length == b.length
//a and b consist of lowercase English letters



package StringsQuestions;

public class SplitTwoStringstoMakePalindrome_1616 {
//	brute Force approch :
//	here we check wheateher one of the string is a palindrome or not because it said that one of the string of prefixx , suffix can be null or empty 
//	so if any one from a,b is a palindrome we can say we does not need any prefix or suffix from other string 
//	if its not true 
//	then we can split string on every single index and check wheather the  combination of strings can make palindrome 
//	time complexity :O(n*n)
//	space complexity :O(n*n)
	    public static  boolean checkPalindromeFormationBruteForce(String a, String b) {
	    	if(ispalindrome(a)||ispalindrome(a)) {
	    		return true;
	    	}
	    	int l=a.length();
	    	for(int i =1;i<a.length()-1;i++) {
	    		String aprefix =a.substring(0,i);
	    		String asuffix=a.substring(i,l);
	    		String bprefix =b.substring(0,i);
	    		String bsuffix=b.substring(i,l);
	    		if(ispalindrome(aprefix+bsuffix)) {
	    			System.out.println("aprefix +bsuffix : index"+i);
	    			return true;
	    		}
	    		if(ispalindrome(bprefix+asuffix)) {
	    			System.out.println("bprefix +asuffix : index"+i);
	    			return true;
	    		}
	    	}
	    	
	    	return false;
	    }
	    public static boolean ispalindrome(String str){
	        int start =0;
	        int end =str.length()-1;
	        
	        while(start<=end){
	            if(str.charAt(start)!=str.charAt(end)){return false;}
	            start++;
	            end--;
	        }
	        System.out.println(str);
	        return true;
	    }
	    
//	    optimize approch :	    	
//	    Explanation of the Approach:
//	    	Initial Palindrome Check:
//
//	    	The function starts by checking if either of the strings a or b is already a palindrome using the ispalindrome function. This provides a quick exit strategy — if either string is already a palindrome, we return true immediately.
//	    	Combination Check (Main Logic):
//
//	    	If neither string is a palindrome, the function then checks if combining a prefix from one string with a suffix from the other forms a palindrome.
//	    	The first check, check(a, b), checks if aprefix + bsuffix forms a palindrome.
//	    	If this check fails, the reverse combination check(b, a) is tried to see if bprefix + asuffix forms a palindrome.
//	    	Helper Function (check):
//
//	    	The check function uses two pointers (l for left and r for right) to traverse both strings from the outside inwards.
//	    	As long as characters from a and b match, the pointers continue moving inward.
//	    	If a mismatch is found, the function checks if the rest of the substring (a[l:r] or b[l:r]) forms a palindrome.
//	    	If a valid palindrome is found at any point, it returns true.
//	    	If the loop completes with no mismatches or finds a valid palindrome, it also returns true.
//	    	Palindrome Check Function (ispalindrome):
//
//	    	This function checks if a substring of a given string is a palindrome by comparing characters from both ends towards the center.
//	    	If all characters match, it returns true; otherwise, it returns false.
//	    	Why This Approach Works:
//	    	The solution leverages the fact that if a mismatch occurs while checking character-by-character, the remaining part must be a palindrome for the combination to work.
//	    	The solution efficiently checks both possible palindrome combinations (aprefix + bsuffix and bprefix + asuffix).
//	    	where n is the length of the strings, making it optimal since each character is checked at most once.
//	The time complexity is O(n), 
//	The space complexity is O(1), 
	    public static  boolean checkPalindromeFormation(String a, String b) {
//	    	 if any single string is a palindrome we can say prefix or suffixof other strinng is null      
	    	if(ispalindrome(b,0,b.length()-1)|| ispalindrome(a,0,a.length()-1)){return true;}
	    	     
	    	
//	    	check function find prefix and suffix and check wheater it is a palindrome or not 
//	    	here we checking a prefix + b suffix 
	    	if(check(a,b)){
	    	        return true;
//	    	here we checking b prefix + a suffix 
	    	     }else{
	    	        return check(b,a);
	    	     }
	    	
	    	    }
//	    check
	    	    public static boolean check(String a,String b){
	    	    int l =0;
	    	    int r=a.length()-1;
//	    	    starting with 2 pointers at 0 and length 
//	    	    where l =0 which iterate over a left to right
//	    	    where e =length of b  which iterate over b from right to left 
	    	    
	    	        while(l<=r){
//	    	        	here we check which character does not equal which means we find our split points
	    	        	
	    	        if(a.charAt(l)!=b.charAt(r)){
//	    	        	here we checking a prefix  +b is a plaindrome 
//	    	        	and b prefix + a suffix 
//	    	        	if any of that is a palindrome we return true 
	    	        	
	    	            if(ispalindrome(b,l,r)|| ispalindrome(a,l,r)){
	    	                return true;
	    	            }else{
	    	                break;
	    	            }
	    	        }
	    	        l++;
	    	        r--;
	    	    }
	    	     if(l>=r){
	    	            return true;
	    	        }
	    	        return false;
	    	    }
	    	    
// here we check palindrome which uses pointer  of the string  	    	    
	    	    public static boolean ispalindrome(String str,int l ,int r){
	    	        while(l<=r){
	    	            if(str.charAt(l)!=str.charAt(r)){
	    	                return false;
	    	            }
	    	            l++;
	    	            r--;
	    	        }
	    	        return true;
	    	    }
	    	
	
	    
	    
	    
	public static void main(String[] args) {
		
		
		
		//Example 1:
		//
		String a1 = "x", b1 = "y";
		boolean output1= true;
		//Explaination: If either a or b are palindromes the answer is true since you can split in the following way:
		//aprefix = "", asuffix = "x"
		//bprefix = "", bsuffix = "y"
		//Then, aprefix + bsuffix = "" + "y" = "y", which is a palindrome.
		
		
		
		
		
		//Example 2:

		String a2 = "xbdef", b2 = "xecab";
		boolean output2= false;

		
		
		//Example 3:

		String a3 = "ulacfd", b3 = "jizalu";
		boolean output3= true;
		
		//Example 4:
		
		String a4 = "aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd", b4 = "uvebspqckawkhbrtlqwblfwzfptanhiglaabjea";
		boolean output4= true;
		
		System.out.println("Brute Force approch : ");
		
		if(output1==checkPalindromeFormationBruteForce(a1, b1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		
		if(output2==checkPalindromeFormationBruteForce(a2, b2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		
		if(output3==checkPalindromeFormationBruteForce(a3, b3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
		
		if(output4==checkPalindromeFormationBruteForce(a4, b4)) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");			
		}
		
		
		
		
		System.out.println("Optimize Force approch : ");
		
		if(output1==checkPalindromeFormation(a1, b1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		
		if(output2==checkPalindromeFormationBruteForce(a2, b2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		
		if(output3==checkPalindromeFormationBruteForce(a3, b3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
		
		if(output4==checkPalindromeFormationBruteForce(a4, b4)) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");			
		}
		
		
		
		
		

		
		

	}

}
