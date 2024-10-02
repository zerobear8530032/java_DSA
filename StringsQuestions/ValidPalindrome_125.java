//125. Valid Palindrome
//Solved
//Easy
//Topics
//Companies
//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//
//Given a string s, return true if it is a palindrome, or false otherwise.
//
//Example 1:
//
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
//Example 2:
//
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
//Example 3:
//
//Input: s = " "
//Output: true

//Explanation: s is an empty string "" after removing non-alphanumeric characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
// 
//
//Constraints:
//
//1 <= s.length <= 2 * 105
//s consists only of printable ASCII characters.
package StringsQuestions;

public class ValidPalindrome_125 {
//	brute force approch : Here is first remove the all space and alohanumeric character from string and check it is a palindrome or not
//	time complexity :O(n)
//	space complexity :O(n)  ->  string builder will create a new string which is no alphanum or blank spaces
	    public static boolean isPalindromeBruteForce(String s) {
	       StringBuilder  ans = new StringBuilder();
	       for(int i =0;i<s.length();i++){
	        char ch = Character.toLowerCase(s.charAt(i));
	        if(ch>='a' && ch<='z' || ch>='0' && ch<='9'){
	            ans.append(ch);
	        }
	       }
	       return checkpalindrome(ans.toString());
	    }
//	    check palindromme
	    public static boolean checkpalindrome(String str ){
	        int start =0;
	        int end = str.length()-1;
	        while(start<=end){
	            if(str.charAt(start)!=str.charAt(end)){
	                return false;
	            }
	            start++;
	            end--;
	        }
	        return true;
	    }
//	approch optimize : here i used 2 pointer start and end if any pointer encounter a non numerica char we skip that interation and increment the pointer 
//	    to next element and if both character are not equal we return false other wise at last it true
//	    time complexity:O(n)
//	    space complexity:O(1) -> no extra space is allocated every 
	       public  static boolean isPalindromeOptimize(String s) {
	            int start =0;
	            int end = s.length()-1;
	            while(start<=end){
	                char sch=Character.toLowerCase(s.charAt(start));
	                char ech=Character.toLowerCase(s.charAt(end));
	                
	            if(!(sch>='a' && sch<='z' || sch>='0' && sch<='9')){
	                start++;
	                continue;
	            } 
	            if(!(ech>='a' && ech<='z' || ech>='0' && ech<='9')){
	                end--;
	                continue;
	            }
	            if(ech!=sch){return false;}
	            start++;
	            end--;
	        }
	    return true;
	        }
	    
	    
	    
	public static void main(String[] args) {
		
	//Example 1:
	//
		System.out.println("Brute approch");
	String s1 = "A man, a plan, a canal: Panama";
	boolean output1= true;
	//Explanation: "amanaplanacanalpanama" is a palindrome.
	
	if(output1==isPalindromeBruteForce(s1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	
	
	//Example 2:
	//
	String s2 = "race a car";
	boolean output2= false;
	//Explanation: "raceacar" is not a palindrome.
	
	if(output2==isPalindromeBruteForce(s2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	//Example 3:
	//
	String s3 = " ";
	boolean output3= true;
	
	if(output3==isPalindromeBruteForce(s3)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}
	
	
//	optimize
	System.out.println("Optimize approch");
	
	if(output1==isPalindromeOptimize(s1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	if(output2==isPalindromeBruteForce(s2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	if(output3==isPalindromeBruteForce(s3)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}
	
	
	}
	


}
