//20. Valid Parentheses
//Easy
//Topics
//Companies
//Hint
//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.
// 
//
//Example 1:
//
//Input: s = "()"
//Output: true
//Example 2:
//
//Input: s = "()[]{}"
//Output: true
//Example 3:
//
//Input: s = "(]"
//Output: false
// 
//
//Constraints:
//
//1 <= s.length <= 104
//s consists of parentheses only '()[]{}'.
package StringsQuestions;
import java.util.*;
public class ValidParentheses_20 {
// approch : use an array when the opening bracket come push themm in stack when the closing bracket comes 
//	check their is any bracket in stack if yes then check the opening and closing breacket are same or not 
//	if they are same then pop else just return false
//	at last if stack is empty we can say the stringhave valid paranthesis other wise not 
//	time complexity :O(n)
//	space complexity :O(n)
	
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{'){
                stack.push(ch);
            }else if(ch==')' || ch==']' || ch=='}'){
                if(stack.empty()){return false;}
                else{
                   char top =stack.pop();
                   if(ch==')' && top!='(' || ch==']' && top!='[' ||ch=='}' && top!='{'  ){
                    return false;
                   }
                }
            }
        }
        return stack.empty();
    }

	public static void main(String[] args) {
		//Example 1:
		String  s1 = "()";
		boolean output1= true;
		
		//Example 2:
		
		String  s2 = "()[]{}";
		boolean output2= true;
		
		//Example 3:
		
		String  s3 = "(]";
		boolean output3= false;
		
		if(output1==isValid(s1)) {
			System.out.println("Case 1 Passed");
		}else {			
		System.out.println("Case 1 Failed");
		}
		
		if(output2==isValid(s2)) {
			System.out.println("Case 2 Passed");
		}else {			
			System.out.println("Case 2 Failed");
		}
		
		if(output3==isValid(s3)) {
			System.out.println("Case 3 Passed");
		}else {			
			System.out.println("Case 3 Failed");
		}
		


	}

}
