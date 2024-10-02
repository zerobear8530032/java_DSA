//709. To Lower Case
//Solved
//Easy
//Topics
//Companies
//Hint
//Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.
//
//Example 1:
//
//Input: s = "Hello"
//Output: "hello"
//Example 2:
//
//Input: s = "here"
//Output: "here"
//Example 3:
//
//Input: s = "LOVELY"
//Output: "lovely"
// 
//
//Constraints:
//
//1 <= s.length <= 100
//s consists of printable ASCII characters.
package StringsQuestions;

public class ToLowerCase_709 {
	
	
//	brute force approch*: used .tolowecase():
	public static String toLowerCaseBruteForce(String s) {
		return s.toLowerCase();
	}
	
//	used character funtion to convert :
//	time complexity O(n)
	  public static String toLowerCaseanotherway(String s) {
	        StringBuilder str = new StringBuilder();
	        for (int i = 0; i < s.length(); i++) {
	            char ch = s.charAt(i);
	            str.append(Character.toLowerCase(ch));
	        }
	        return str.toString();
	    }
	  
//	used character funtion to convert :
//	time complexity O(n)
	  public static String toLowerCaseManual(String s) {
	        StringBuilder str = new StringBuilder();
	        for(int i=0;i<s.length();i++){
	            int chascii = (int)s.charAt(i);
	            if(chascii>='A'  && chascii<='Z'){          
	            chascii=chascii+32;
	            str.append((char)chascii);
	            }else{
	                str.append((char)chascii);
	            }
	        }
	        return str.toString();
	    }	    
public static void main(String[] args) {
	//Example 1:
	//
	String s1= "Hello";
	String output1= "hello";
	
	System.out.println("pre build function way ");
	//Output: "hello"
	if(output1.equals(toLowerCaseBruteForce(s1))) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	
	//Example 2:
	//
	String s2= "here";
	String output2= "here";
	if(output2.equals(toLowerCaseBruteForce(s2))) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	
	//Example 3:
	//
	String s3= "LOVELY";
	String output3= "lovely";
	if(output3.equals(toLowerCaseBruteForce(s3))) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}
	
//	abother way 
	System.out.println("pre build function way ");
	if(output1.equals(toLowerCaseanotherway(s1))) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	
	if(output2.equals(toLowerCaseanotherway(s2))) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	
	if(output3.equals(toLowerCaseanotherway(s3))) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}
	
//	manual way 
	System.out.println("Manual way ");
	if(output1.equals(toLowerCaseManual(s1))) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	if(output2.equals(toLowerCaseManual(s2))) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	if(output3.equals(toLowerCaseManual(s3))) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}

	
}
}
