//43. Multiply Strings
//Solved
//Medium
//Topics
//Companies
//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//
//Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
//
//Example 1:
//
//Input: num1 = "2", num2 = "3"
//Output: "6"
//Example 2:
//
//Input: num1 = "123", num2 = "456"
//Output: "56088"
// 
//
//Constraints:
//
//1 <= num1.length, num2.length <= 200
//num1 and num2 consist of digits only.
//Both num1 and num2 do not contain any leading zero, except the number 0 itself.

package StringsQuestions;
public class MultiplyStrings_43 {	
//	approch :
//	here we created a function which allow us to add 2 strings integer and return answer as a stirng 
//	and we implement the way of we simply multiply in our daily life first 
//	multiply each number with first place value of number 
//	then next place value 
//	and at last add them all using string additions
//	time complexity :O(m*n)

	public static String addTwoNumbers(String num1,String num2) {
//		initialize n1,n2
		StringBuilder n1= new StringBuilder(num1);
		StringBuilder n2= new StringBuilder(num2);
		StringBuilder ans = new StringBuilder();
//		reverse the string 
		n1.reverse();
		n2.reverse();
		int carry =0;
		int i =0;
//		we will loop till max length of the num1,num2
		for(i=0;i<Math.max(n1.length(), n2.length()) || carry!=0;i++) {
			int number1= 0;
			int number2= 0;
//			if the  character is in inddex of num1 length then we convert the character to integer 
			if(i< n1.length()) {number1=n1.charAt(i)-'0';}
			if(i< n2.length()) {number2=n2.charAt(i)-'0';}
//			here we sum up the n1 , n2 
			int total = number1+number2+carry;
//			here we take first value 
			ans.append(total%10);
//			here we took carry
			carry = total/10;			
		}
//		at last we reverse the String 
		return ans.reverse().toString();
	}
	public static String multiply(String num1 , String num2) {
//		if any number ==0 means we can just say the output will be 0
		if(num1.length()==1  || num2.length()==1) {
			if(num1.charAt(0)=='0' || num2.charAt(0)=='0') {
				return "0";
			}
		}
//		initalize ans
		String ans ="0";
//		if the num2 is greater then we will swap them because we want n2 to be smaller it allow to multiply faster
		if(num2.length()>num1.length()) {
			return multiply(num2,num1);
		}
//		this loop will iterate over num2
		for(int i = num2.length()-1 ;i>=0;i--) {
//			num2 charaters
			int n2 = num2.charAt(i)-'0';
//			this hold the sum or we can product of the each element multiply the entire number 
			StringBuilder element = new StringBuilder();
			int carry =0;
//			this is the loop for num1 
			for(int j = num1.length()-1;j>=0;j--) {
//				convert char to int 
				int n1=num1.charAt(j)-'0';
//				taking prod
				int prod = n1*n2+carry;

				int rem = prod%10;
//				apppend the rem in the answer
				element.append(rem);
//				initalize the carry with rest of number
				carry = prod/10;
			}
//			if any carry left out we can aappend it 
			if(carry!=0) {
				element.append(carry);
			}
//			this is the manage the place value at each multiplication
			if(i<num2.length()-1) {
				int index =i;
				while(index<num2.length()-1) {
					element.insert(0,"0");
					index++;
				}				
			}
//		here we add the product of each number from num1[i] * entire num2 	
			ans = addTwoNumbers(ans, element.reverse().toString());
		}
//		aat last answer
		return ans;
		
	}
	
	
	public static void main(String[] args) {
		
		//Example 1:
		//
		String num11 = "2", num12 = "3";
		String output1="6";
		//Example 2:
		//
		String num21 = "123", num22 = "456";
		String output2="56088";

		if(output1.equals(multiply(num11, num12))) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		if(output2.equals(multiply(num21, num22))) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}

		
	}

}
