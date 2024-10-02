//227. Basic Calculator II
//Medium
//Topics
//Companies
//Given a string s which represents an expression, evaluate this expression and return its value. 
//
//The integer division should truncate toward zero.
//
//You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
//
//Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
//
//Example 1:
//
//Input: s = "3+2*2"
//Output: 7
//Example 2:
//
//Input: s = " 3/2 "
//Output: 1
//Example 3:
//
//Input: s = " 3+5 / 2 "
//Output: 5
// 
//
//Constraints:
//
//1 <= s.length <= 3 * 105
//s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
//s represents a valid expression.
//All the integers in the expression are non-negative integers in the range [0, 231 - 1].
//The answer is guaranteed to fit in a 32-bit integer.

package StringsQuestions;
import java.util.Stack;
public class BasicCalculator_227 {
// approch : used stack to evaluate exp:
	
//	we traverse String and extract number and operator 
//	if the number is encounter we will assume it as positive integer and push in stack 
//	when the operator '-' encounter will make the next number to be negative and push in stack 
//	when we see operator '*' we pop first element of stack and evaluate next number with it and push its ans or product in stack 
//	when we see operator '/' we pop first element of stack and evaluate next number with it and push its ans or division in stack 
//	at last we will take sum of all element in the stack and return as answer 
//	time complexity :O(n)
//	space complexity :O(n)
	public static int calculate(String s) {
//		initializations
        Stack<Integer> stk = new Stack();
        int l =s.length();
        char sign ='+';
        int num=0;
//        traversal
        for(int i =0;i<s.length();i++){
//        	character
            char ch = s.charAt(i);
//            number creating
            if(Character.isDigit(ch)){
                num= num*10+ch-'0';
            }
//            if the character is not a number it will be a blank space or an operator 
//            so before that we check is the number is ended and we can use operator
//            i==s.length()-1 make sure the last element will also got evaluate because the loop will terminate after it complete the number generation
//            this will be no operator at last so it need a condition to evaluate at  last number 
//            example : 3+4/2 -> here 3+4 will push in stack but after 2 get their is no another operator so it wont be able to enter the stack
            
            if(!Character.isDigit(ch) && ch!=' ' || i== s.length()-1){
//                if + we push as positive
            	if(sign =='+'){
                    stk.push(num);
//                    if - we push as negative num
                }else if(sign=='-'){
                    stk.push(-num);
//                    if '*' then we evaluate element with last pushed or top element and push the result
                }else if(sign=='*'){
                    stk.push(stk.pop()*num);
//                    if '/' then we evaluate element with last pushed or top element and push the result
                }else{
                    stk.push(stk.pop()/num);
                }
            sign = ch;
            num=0;
            }
        }
//        after each element is evaluated we add all element because we enter substracting element as negeative this will get handle here 
//        and we already handle all higher precedence element above
        int ans =0;
        while(!stk.isEmpty()){ans+=stk.pop();}
        return ans;
    }
	
	public static void main(String[] args) {
		
		//Example 1:
		
		String s1 = "3+2*2";
		int output1=7;
		
		//Example 2:
		
		String s2 = "3/2";
		int output2=1;
		
		//Example 3:
		
		String s3 = "3+5 / 2";
		int output3=5;
		
		if(output1== calculate(s1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		if(output2== calculate(s2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		if(output3== calculate(s3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}


	}

}
