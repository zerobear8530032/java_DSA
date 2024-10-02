//557. Reverse Words in a String III
//Solved
//Easy
//Topics
//Companies
//Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
//
//Example 1:
//
//Input: s = "Let's take LeetCode contest"
//Output: "s'teL ekat edoCteeL tsetnoc"
//Example 2:
//
//Input: s = "Mr Ding"
//Output: "rM gniD"
// 
//
//Constraints:
//
//1 <= s.length <= 5 * 104
//s contains printable ASCII characters.
//s does not contain any leading or trailing spaces.
//There is at least one word in s.
//All the words in s are separated by a single space
package StringsQuestions;

public class ReverseWordsinaStringIII_557 {
//	here we used a pre build function :
// approch first split array at space and then reverse each word and append to the answer 	
// time complexity O(n*n)
	public static String reverseWordsPreBuilde(String s) {
	        String [] words = s.split(" ");
	        StringBuilder ans = new StringBuilder();
	        for(int i =0;i<words.length;i++){
	            ans.append(reverse(words[i])+" ");
	        }
	        return ans.toString().trim();   
	    }
	    public static String reverse(String str){
	        char [] arr = str.toCharArray();
	        int s=0;
	        int e=arr.length-1;
	        while(s<=e){
	            char t = arr[s];
	            arr[s]=arr[e];
	            arr[e]=t;
	            s++;
	            e--;
	        }
	        return new String(arr); 
	    }
public static void main(String[] args) {
	
	//Example 1:
	//
	String s1 = "Let's take LeetCode contest";
	String output1 = "s'teL ekat edoCteeL tsetnoc";
	
	if(output1.equals(reverseWordsPreBuilde(s1))) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	
	//Example 2:
	//
	String s2 = "Mr Ding";
	String output2 = "rM gniD";
	

	if(output2.equals(reverseWordsPreBuilde(s2))) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	
	
}
}
