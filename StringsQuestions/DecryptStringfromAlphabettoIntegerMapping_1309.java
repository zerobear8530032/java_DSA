//1309. Decrypt String from Alphabet to Integer Mapping
//Solved
//Easy
//Topics
//Companies
//Hint
//You are given a string s formed by digits and '#'. We want to map s to English lowercase characters as follows:
//
//Characters ('a' to 'i') are represented by ('1' to '9') respectively.
//Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
//Return the string formed after mapping.
//
//The test cases are generated so that a unique mapping will always exist.
//
// 
//
//Example 1:
//
//Input: s = "10#11#12"
//Output: "jkab"
//Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
//Example 2:
//
//Input: s = "1326#"
//Output: "acz"
// 
//
//Constraints:
//
//1 <= s.length <= 1000
//s consists of digits and the '#' letter.
//s will be a valid string such that mapping is always possible.


package StringsQuestions;
import java.util.*;

public class DecryptStringfromAlphabettoIntegerMapping_1309 {
//	 extra space : this approch is faster to process even with extra space because look up in the array is faster
//	 we could also use a hashmap to do a fast look up but it would take  a bit more space compare to array 
//	 time complexity O(n)
//	 space complexity O(1): because the space is constant
	 public static String freqAlphabets(String s) {
	        StringBuilder ans = new StringBuilder();
	        int i = s.length() - 1;
	        
	        // Arrays for direct mapping
	        char[] map = {' ','a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
	                        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 
	                        't', 'u', 'v', 'w', 'x', 'y', 'z'};
	        
	        while (i >= 0) {
	            if (s.charAt(i) == '#') {
	                // Mapping 10# to 26#
	                int num = Integer.parseInt(s.substring(i - 2, i));
	                ans.append(map[num]);
	                i -= 3; // Skip over the two digits and '#'
	            } else {
	                // Mapping 1 to 9
	                int num = s.charAt(i) - '0'; // Convert char digit to integer
	                ans.append(map[num]);
	                i--;
	            }
	        }
	        
	        return ans.reverse().toString(); // Reverse the string to get the correct order
	    }
//	 no extra space :
//	 time complexity O(n)
//	 space complexity O(1)
	 public static String freqAlphabetsAnotherApproch(String s) {
	       StringBuilder ans = new StringBuilder();
	       for(int i =s.length()-1;i>=0;i--){
	        if(s.charAt(i)=='#'){
	            switch(Character.toString(s.charAt(i-2)) +Character.toString(s.charAt(i-1)) ){
	                case "10"->ans.insert(0,"j");
	                case "11"->ans.insert(0,"k");
	                case "12"->ans.insert(0,"l");
	                case "13"->ans.insert(0,"m");
	                case "14"->ans.insert(0,"n");
	                case "15"->ans.insert(0,"o");
	                case "16"->ans.insert(0,"p");
	                case "17"->ans.insert(0,"q");
	                case "18"->ans.insert(0,"r");
	                case "19"->ans.insert(0,"s");
	                case "20"->ans.insert(0,"t");
	                case "21"->ans.insert(0,"u");
	                case "22"->ans.insert(0,"v");
	                case "23"->ans.insert(0,"w");
	                case "24"->ans.insert(0,"x");
	                case "25"->ans.insert(0,"y");
	                case "26"->ans.insert(0,"z");
	            }
	            i=i-2;
	           }else{
	            switch(s.charAt(i)){
	                case '1'->ans.insert(0,"a");
	                case '2'->ans.insert(0,"b");
	                case '3'->ans.insert(0,"c");
	                case '4'->ans.insert(0,"d");
	                case '5'->ans.insert(0,"e");
	                case '6'->ans.insert(0,"f");
	                case '7'->ans.insert(0,"g");
	                case '8'->ans.insert(0,"h");
	                case '9'->ans.insert(0,"i");
	           }
	       } 
	    }
	       return ans.toString();
	}
public static void main(String[] args) {
	
	//Example 1:
	//
	String s1 = "10#11#12";
	String output1= "jkab";
	//Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
	
	if(output1.equals(freqAlphabets(s1))) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}

	//Example 2:

	String s2 = "1326#";
	String output2= "acz";
	if(output2.equals(freqAlphabets(s2))) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	
	
	
	if(output1.equals(freqAlphabetsAnotherApproch(s1))) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	
	
	if(output2.equals(freqAlphabetsAnotherApproch(s2))) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	
	
	
}
}
