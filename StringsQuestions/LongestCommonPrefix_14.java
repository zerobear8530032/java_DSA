//14. Longest Common Prefix
//Solved
//Easy
//Topics
//Companies
//Write a function to find the longest common prefix string amongst an array of strings.
//
//If there is no common prefix, return an empty string "".
//
// 
//
//Example 1:
//
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
//Example 2:
//
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
//Constraints:
//
//1 <= strs.length <= 200
//0 <= strs[i].length <= 200
//strs[i] consists of only lowercase English letters.


package StringsQuestions;

public class LongestCommonPrefix_14 {
// approch : here we have a outer loop which work infinite this act as a index of character :
//	the nesterd loop goes on entire array and we can check the character from each string and append to ans 
//	if it present in the all string of array 
//	else we can break the loop and return ans
	
//	time complexity:O(n*N):  n = lenght of minimum string N is the length of string  
	   public static String longestCommonPrefix(String[] strs) {
	        int index =0;
	        StringBuilder ans = new StringBuilder();
//	       index<200 can also work for this loop because of contrain
	        while(true){
	            char ch =' ';
	            if(index<strs[0].length()){
	                ch= strs[0].charAt(index);
	            }else{
	                break;
	            }
	            boolean match=true;
	            for(int i =1;i<strs.length;i++){
	                if( index>=strs[i].length() || ch!=strs[i].charAt(index)){
	                    match=false;
	                    break;
	                }
	            }
	            if(match){
	                ans.append(ch);
	            }else{
	                break;
	            }
	            index++;
	        }
	        return ans.toString();
	    }
	
	
public static void main(String[] args) {
	//Example 1:
	//
	String [] strs1 = {"flower","flow","flight"};
	String output1= "fl";
	if(longestCommonPrefix(strs1).equals(output1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	

	//Example 2:

	String [] strs2 = {"dog","racecar","car"};
	String output2= "";
	//Explanation: There is no common prefix among the input strings.
	if(longestCommonPrefix(strs2).equals(output2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
}
}
