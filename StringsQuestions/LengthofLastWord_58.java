//58. Length of Last Word
//Solved
//Easy
//Topics
//Companies
//Given a string s consisting of words and spaces, return the length of the last word in the string.
//
//A word is a maximal 
//substring
// consisting of non-space characters only.
//
// 
//
//Example 1:
//
//Input: s = "Hello World"
//Output: 5
//Explanation: The last word is "World" with length 5.
//Example 2:
//
//Input: s = "   fly me   to   the moon  "
//Output: 4
//Explanation: The last word is "moon" with length 4.
//Example 3:
//
//Input: s = "luffy is still joyboy"
//Output: 6
//Explanation: The last word is "joyboy" with length 6.
// 
//
//Constraints:
//
//1 <= s.length <= 104
//s consists of only English letters and spaces ' '.
//There will be at least one word in s.

package StringsQuestions;
public class LengthofLastWord_58 {
//	brute force :
//	here we use trime which remove all starting and ending blank spaces which will use some extra space:
	    public static int lengthOfLastWordBruteForce(String s) {
	        s=s.trim();
	        int index = s.length()-1;
	        int c=0;
	        while(index>=0){
	            if(s.charAt(index)==' '){
	                break;
	            }else{
	                c++;
	            }
	                index--;
	        }
	        return c;
	    }
	
	
	
	
//	better approch : we use a pointer where in first loop we skip the trailing spaces and once we get the character 
//	we break it and go to next loop which we iterate until we are going to get character and increment count
//	now when we get blank means we got our last wordd letter 
//	time complexity: O(n)
	    public static int lengthOfLastWordBetter(String s) {
	        int index = s.length()-1;
	        while(s.charAt(index)==' '){
	            index--;
	        }
	        int c=0;
	        while(index>=0){
	            if(s.charAt(index)==' '){
	                break;
	            }else{
	                c++;
	            }
	                index--;
	        }
	        return c;
	    }
	
	
	
//	time complexity :O(n)
//	best optimize approch : we iterate over the string if we found ' ' we will skip it first 
//	once we get a single non empty space means we found starting of word that means we toggle the found 
//	so when the space comes we will exit the loop
	
	    public static int lengthOfLastWordBest(String s) {
	         boolean found = false;
	        int counter = 0;
	        for(int i = s.length()-1; i >=0; i--) {
	            if(s.charAt(i) != ' ') {
	                counter++;
	                found = true;
	            }
	            else if(found) break;
	        }
	        return counter;
	    }
	

	public static void main(String[] args) {
		//Example 1:
		//
		String  s1 = "Hello World";
		int output1=5;
		//Explanation: The last word is "World" with length 5.
		
		//Example 2:
		//
		String s2 = "   fly me   to   the moon  ";
		int output2= 4;
		//Explanation: The last word is "moon" with length 4.
		
		//Example 3:
		//
		String s3 = "luffy is still joyboy";
		int output3= 6;
		//Explanation: The last word is "joyboy" with length 6.
		
		System.out.println("Brute Force :");
		if(output1==lengthOfLastWordBruteForce(s1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		
		if(output2==lengthOfLastWordBruteForce(s2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		if(output3==lengthOfLastWordBruteForce(s3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
		
		
		System.out.println("Better Approch :");
		if(output1==lengthOfLastWordBetter(s1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		
		if(output2==lengthOfLastWordBetter(s2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		if(output3==lengthOfLastWordBetter(s3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
		System.out.println("Best Approch :");
		
		if(output1==lengthOfLastWordBest(s1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		
		if(output2==lengthOfLastWordBest(s2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		if(output3==lengthOfLastWordBest(s3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
		


	}

}
