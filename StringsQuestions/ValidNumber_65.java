//65. Valid Number
//Hard
//Topics
//Companies
//Given a string s, return whether s is a valid number.
//
//For example, all the following are valid numbers: "2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789", while the following are not valid numbers: "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53".
//
//Formally, a valid number is defined using one of the following definitions:
//
//An integer number followed by an optional exponent.
//A decimal number followed by an optional exponent.
//An integer number is defined with an optional sign '-' or '+' followed by digits.
//
//A decimal number is defined with an optional sign '-' or '+' followed by one of the following definitions:
//
//Digits followed by a dot '.'.
//Digits followed by a dot '.' followed by digits.
//A dot '.' followed by digits.
//An exponent is defined with an exponent notation 'e' or 'E' followed by an integer number.
//
//The digits are defined as one or more digits.
//
// 
//
//Example 1:
//
//Input: s = "0"
//
//Output: true
//
//Example 2:
//
//Input: s = "e"
//
//Output: false
//
//Example 3:
//
//Input: s = "."
//
//Output: false
//
// 
//
//Constraints:
//
//1 <= s.length <= 20
//s consists of only English letters (both uppercase and lowercase), digits (0-9), plus '+', minus '-', or dot '.'.



package StringsQuestions;
public class ValidNumber_65 {
	
//	best approch :
//	Time complexity: O(n)
//	Space complexity: O(1)
	public static boolean isNumberBest(String s) {
	        int i=0;
	        boolean ex=false,dig=false,dot=false;
	        while(i<s.length()){
	            char ch=s.charAt(i);
//	            checking for digit
	            if(Character.isDigit(ch)){
	                dig=true;
//	                handing operator andchecking for exponents
	            }else if(ch=='-' || ch=='+'){
	                if(i>0 && s.charAt(i-1)!='e' && s.charAt(i-1)!='E') return false;
	            }
//	            exponents
	            else if(ch=='e' || ch=='E'){
	                if(ex || !dig) return false;
	                ex=true;
	                dig=false;
//	                handling decimals
	            }else if(ch=='.'){
	                if(dot || ex) return false;
	                dot=true;
	            }else return false;
	            i++;
	        }
//	        return ans;
	        return dig;
	    }
	
//	regex approch :
//	apply regex the time comeplexity can vary  
	   
	    public static boolean isNumberRegex(String s) {
	         // Define the regular expression for a valid number
	        String regex = "^[+-]?((\\d+\\.?\\d*)|(\\.\\d+))([eE][+-]?\\d+)?$";
	        
	        // Use the regex to match the input string
	        return s.matches(regex);
	    }
	    
	    
//	    my approch :it is same perfoance as above but above is compact and mine is trial and error so its a bit dirty code 
//	    time complexity : O(n)
//	    first handle starting operators 
//	    and deciamls
	        public boolean isNumber(String s) {
	            int i =0;
	            int countExponent= 0;
	            int countDecimal= 0;
//	            starting operators handling like +34 || -34
	            if(s.charAt(i)=='+' || s.charAt(i)=='-' ){
	               i++; 
	            }
//	            starting decimals handle  like .034 || .3 this will also handle that thier is not only singel .
	            if(s.length()>1){
	                if(s.charAt(i)=='.'){
	                    countDecimal++;
	                    i++;
//	                    here if the decimal does not have any next character a number then its invalid
//	                    like 23. || 0. ||  234234.
	                     if(i<s.length() &&  !(s.charAt(i)>='0' && s.charAt(i)<='9')){
	                    return false;
	                }
	                }
	            }
//	            this will check if a string have at least one digit in it 
	            boolean numberpresent =false;

//	           handle single e or E or .  
	            if(i<s.length() && (s.charAt(i)=='e' ||  s.charAt(i)=='E' || s.charAt(i)=='.')){
	                return false;
	            }
//	            start loop of string 
	            while(i<s.length()){
//	            	this is because their cannot be a  decimal after exponent  like 2e3.3 || 2e+45.3
//	            	if a . comes means decimal starting 
	                if(s.charAt(i)=='.' && countExponent==0){
	                    countDecimal++;
	                    i++;
	                }
//	                here we handling e or E 
	                if(i<s.length() &&(s.charAt(i)=='E' || s.charAt(i)=='e')){
	                    countExponent++;
//	                    if e have no character after it or an opeartor like + or - and number 
//	               			cases : 34e+3 || 34e-3
	                    if(i+2<s.length() && ((s.charAt(i+1) =='-' && s.charAt(i+2)>='0' && s.charAt(i+2)<='9' ) || (s.charAt(i+1)=='+' && s.charAt(i+2)>='0' && s.charAt(i+2)<='9'))){
	                    i+=2;
//	                    here it handel cases like 3e34
//	                    
	                    }else if(i+1<s.length() && ((s.charAt(i+1)>='0') && (s.charAt(i+1)<='9'))){
	                    i+=1;
	                    }
	                }            
	                
//	                herewe check other digits because we handle every other character above if any character comes
//	                means the number is invalid other wise only digit can reach it 
	                    if(i<s.length() &&  !(s.charAt(i)>='0' && s.charAt(i)<='9')){
	                        return false;
	                    }
//	                    here if the above condition is true means th e current char is a sybol or not a digit but 
//	         			ewe handle them above means the format was wrong            
	               else{
	                    numberpresent=true;
	                }
//	                    this see the . and exp is occuring 1 time only
	                if(countExponent>1 || countDecimal>1){
	                    return false;
	                }
//	                indexmenet index 
	                i++;
	            }
//	            at last we return numberpresent because if its a valid number it will have at least 1 single digit 
	            return numberpresent;
	        }
	    
	    
	    
	
	public static void main(String[] args) {
		//Example 1:
		//
		String s1 = "0";
		boolean output1= true;

		//Example 2:
		//
		String s2 = "e";
		boolean output2= false;
	
		//Example 3:
		String s3 = ".";
		boolean output3= false;
		
		
		System.out.println("Best Approch :");
		if(output1==isNumberBest(s1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		
		if(output2==isNumberBest(s2)){
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		if(output3==isNumberBest(s3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
		
		
		
		
		System.out.println("Regex Approch :");
		if(output1==isNumberRegex(s1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		
		if(output2==isNumberRegex(s2)){
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		if(output3==isNumberRegex(s3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}

	}

}
