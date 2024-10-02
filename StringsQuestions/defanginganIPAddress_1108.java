//1108. Defanging an IP Address
//Easy
//Topics
//Companies
//Given a valid (IPv4) IP address, return a defanged version of that IP address.
//
//A defanged IP address replaces every period "." with "[.]".
//
//Example 1:
//
//Input: address = "1.1.1.1"
//Output: "1[.]1[.]1[.]1"
//Example 2:
//
//Input: address = "255.100.50.0"
//Output: "255[.]100[.]50[.]0"
// 
//
//Constraints:
//
//The given address is a valid IPv4 address.
package StringsQuestions;

public class defanginganIPAddress_1108 {
//	brute force approch :
//	the string class is imutable which means every tine we make a change in string it alllocate a new string 
//	which take more space then required 
//	approch :simple go through the entire string and add the bracket when we encounter the "."
//	time complexity : O(n)
//	space complexity O(n*n)
	
	
	
	public static String defangIPaddrBruteForce(String address) {
//		immutable string 
        String ans ="";
        for(int i =0;i<address.length();i++){
            if(address.charAt(i)=='.'){
                ans = ans+"[.]";
            }else{
                ans=ans+address.charAt(i);
            }
        }
        return ans;   
    }
	
	
	
//	optimize approch :
//	the stringBuilder class is mutable which means every tine we make a change in string it does not allocate a new string 
//	which take more space then required instead it  change the existing one which save space : 
//	approch :simple go through the entire string and add the bracket when we encounter the "."
//	time complexity : O(n)
//	space complexity O(n) --> we can exclude it to O(1) because the answer required a string that why its O(n)
	
    public  static String defangIPaddrOptimize(String address) {
        StringBuilder  ans =new StringBuilder("");
        for(int i =0;i<address.length();i++){
            if(address.charAt(i)=='.'){
                ans.append("[.]");
            }else{
                ans=ans.append(address.charAt(i));
            }
        }
        return ans.toString();       
    }
	
	public static void main(String[] args) {
		//Example 1:
		//
		String address1 = "1.1.1.1";
		String output1 = "1[.]1[.]1[.]1";
		if(output1.equals(defangIPaddrBruteForce(address1))) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		
		//Example 2:
		//
		String address2 = "255.100.50.0";
		String output2= "255[.]100[.]50[.]0";
		if(output2.equals(defangIPaddrBruteForce(address2))) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
//		optimize approch :
		if(output1.equals(defangIPaddrOptimize(address1))) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		
		if(output2.equals(defangIPaddrOptimize(address2))) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		System.out.println(output1.toCharArray().toString());
		
		
	}
}
