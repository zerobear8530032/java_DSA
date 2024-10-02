//925. Long Pressed Name
//Solved
//Easy
//Topics
//Companies
//Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
//
//You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
//
// 
//
//Example 1:
//
//Input: name = "alex", typed = "aaleex"
//Output: true
//Explanation: 'a' and 'e' in 'alex' were long pressed.
//Example 2:
//
//Input: name = "saeed", typed = "ssaaedd"
//Output: false
//Explanation: 'e' must have been pressed twice, but it was not in the typed output.
// 
//
//Constraints:
//
//1 <= name.length, typed.length <= 1000
//name and typed consist of only lowercase English letters.

package StringsQuestions;

public class LongPressedName_925 {
//	approch : here we need to make sure that if a charcater is repeating means it can be a possible but we need to assure it  
//	this question is not just matching the string we have to match consicutive strings :
//	alex , aaleex : here we can see a is repeating and e is repeating 
//	saeed , ssaedd: here even s is reapeating the e is not same which mmean the user was typing something else 
//	if we keep this is mind then only the solution is true 
//	time complexity:O(n)
//	space complexituy :O(1)
	
	 public static boolean isLongPressedName(String name, String typed) {
	        int n=0;
	        int t =0;
//	        check if first char us same if not means the typed and name are 2 different string s
	        if(name.charAt(n)!=typed.charAt(t)){return false;}
//	        	now we check go  over each char at typed and match it with name 
//	        if the char at name is equal to name we go next char other wise we will check
//	        is the previous char of types is equal is yes we will go to next char in the typed other wise we return false
	        while(t<typed.length()){
	            if(n< name.length() && name.charAt(n)==typed.charAt(t)){
	                n++;
	            }else if( typed.charAt(t) != typed.charAt(t-1)){
	                return false;
	            }
	            t+=1;
	        }
	        return n==name.length();
	    }
	
public static void main(String[] args) {
	//Example 1:
	//
	String name1 = "alex", typed1 = "aaleex";
	boolean output1= true;
	//Explanation: 'a' and 'e' in 'alex' were long pressed.
	
	if(output1==isLongPressedName(name1,typed1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");
	}
	
	//Example 2:
	//
	String name2 = "saeed", typed2 = "ssaaedd";
	boolean output2= false;
	//Explanation: 'e' must have been pressed twice, but it was not in the typed output.
	
	if(output2==isLongPressedName(name2,typed2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");
	}

	
}
}
