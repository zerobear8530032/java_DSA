//1678. Goal Parser Interpretation
//Solved
//Easy
//Topics
//Companies
//Hint
//You own a Goal Parser that can interpret a string command. The command consists of an alphabet of "G", "()" and/or "(al)" in some order. The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al". The interpreted strings are then concatenated in the original order.
//
//Given the string command, return the Goal Parser's interpretation of command.
//
//Example 1:
//
//Input: command = "G()(al)"
//Output: "Goal"
//Explanation: The Goal Parser interprets the command as follows:
//G -> G
//() -> o
//(al) -> al
//The final concatenated result is "Goal".
//Example 2:
//
//Input: command = "G()()()()(al)"
//Output: "Gooooal"
//Example 3:
//
//Input: command = "(al)G(al)()()G"
//Output: "alGalooG"
// 
//
//Constraints:
//
//1 <= command.length <= 100
//command consists of "G", "()", and/or "(al)" in some order.
package StringsQuestions;


public class GoalParseInterpretation_1678 {
// approch : simply we just find create a string builder which store result and check for patters 
//	if current index is 'G' append 'G' to ans . if current inndex '(' and index+1 ==')'
//	 we append o at ans and increment the pointer by 1 to skip checking ')'
//	now we can put an else block for "(al)" if we encounter this append al to ans
//	and increment pointer by 3 to skip 'al)' from checking 
	
	public static String interpret(String command) {
        StringBuilder ans = new StringBuilder(); 
     for(int i =0;i<command.length();i++){
//            executes whem :"G"
        if(command.charAt(i)=='G'){
            ans.append("G");
            continue;
//            executes whem :"()"
        }else if(command.charAt(i)=='(' && command.charAt(i+1)==')'){
            ans.append("o");
            i++;
            continue;       
//            executes whem :"(al)"
        }else {
            ans.append("al");
            i=i+3;
            continue;
        }
     }
     return ans.toString();   
    }
	public static void main(String[] args) {
		
		//Example 1:
		//
		String command1 = "G()(al)";
		String output1= "Goal";
		
		//Explanation: The Goal Parser interprets the command as follows:
		//G -> G
		//() -> o
		//(al) -> al
		//The final concatenated result is "Goal".
		
		if(output1.equals(interpret(command1))) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		
		//Example 2:
		//
		String command2 = "G()()()()(al)";
		String output2= "Gooooal";
		//Input: command = "G()()()()(al)"
		//Output: "Gooooal"
		
		if(output2.equals(interpret(command2))) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		
		
		//Example 3:
		//
		String command3= "(al)G(al)()()G";
		String output3= "alGalooG";
		if(output3.equals(interpret(command3))) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
		

	
}
}
