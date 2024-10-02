//1759. Count Number of Homogenous Substrings
//Medium
//Topics
//Companies
//Hint
//Given a string s, return the number of homogenous substrings of s. Since the answer may be too large, return it modulo 109 + 7.
//
//A string is homogenous if all the characters of the string are the same.
//
//A substring is a contiguous sequence of characters within a string.

//Example 1:
//
//Input: s = "abbcccaa"
//Output: 13
//Explanation: The homogenous substrings are listed as below:
//"a"   appears 3 times.
//"aa"  appears 1 time.
//"b"   appears 2 times.
//"bb"  appears 1 time.
//"c"   appears 3 times.
//"cc"  appears 2 times.
//"ccc" appears 1 time.
//3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.
//Example 2:
//
//Input: s = "xy"
//Output: 2
//Explanation: The homogenous substrings are "x" and "y".
//Example 3:
//
//Input: s = "zzzzz"
//Output: 15
// 
//
//Constraints:
//
//1 <= s.length <= 105
//s consists of lowercase letters.


package StringsQuestions;
import java.util.HashSet;
public class CountNumberofHomogenousSubstrings_1759 {
//	 brute Force Approch :
//	here we know the formula to find all the consicutive number by (n*(n+1))/2
//	so  we can apply that on each character on its each consicutive grp like we do on
//  1513. Number of Substrings With Only 1s -->> this question is same just here we need to apply  it on 1 
//	here we need to apply on every character 
// Time Complexity: O(n)
//	Space Complexity: O(1) -> hash set will have at most 26 characater which is constant 
	
//	
	   public static int countHomogenousBruteForce(String s) {
//		   hash set will contain all unique chracter in input string
	        HashSet <Character> set = new HashSet();
//	        fillinf hash set
	        for(int i =0;i<s.length();i++){
	            set.add(s.charAt(i));
	        }
	        int mod = 1_000_000_007;
	        int ans =0;
//	        applying functtion on every character
	        for(Character ch: set){
	            ans = (ans+numSub(s,ch))%mod;
	        }
	        return ans;
	        
	    }
//	   this function is complete similar to previous question just have a character which is gien
	    public static int numSub(String s,char ch) {
	        int ans =0;
	        int mod = 1_000_000_007;
	        for(int i =0;i<s.length();i++){
	        int count=0;
	        while(i<s.length() && s.charAt(i)==ch){
	            count++;
	            i++;
	        }
	        ans = (ans%mod+ calculate(count)%mod);
	      }
	      return ans;
	    }
//	    here we calculate the ans 
	    public  static int calculate(int n ){
	        int mod = 1_000_000_007;
	        long num = n;
	        num=((num+1)*num)/2;
	        return (int)(num%mod);
	    }

	    
// approch : this is same as prevoius approch only difference we does not need to calculate every single character seperatly
//	    we just apply function on each character directly which allow to faster execution
//	    Time Complexity: O(n)
//	    Space Complexity: O(1) -> here we does not have any hash  set for collecting characters 
	    
	        public static int countHomogenousOptimize(String s) {       
	            int ans =0;
	            int mod = 1_000_000_007;
//	            interate over string over string and found consicutive character to apply calculations
	            for(int i =0;i<s.length();i++){
	            int count=0;
//	            getting currect char for consicutive character
	            char ch = s.charAt(i);
	            while(i<s.length() && s.charAt(i)==ch){
	                count++;
	                i++;
	            }
//	            here we decerement because the loop will exit when get out of consicutive number means a new character is
//	            at i currently having the next character which will get skip if we go in next iteration so we decrement by 1
	            i=i-1;
	            ans = (ans%mod+ calculate(count)%mod);
	          }
	          return ans;
	        }
	    
	public static void main(String[] args) {
		
		//Example 1:
	
		String s1 = "abbcccaa";
		int output1= 13;
		//Explanation: The homogenous substrings are listed as below:
		//"a"   appears 3 times.
		//"aa"  appears 1 time.
		//"b"   appears 2 times.
		//"bb"  appears 1 time.
		//"c"   appears 3 times.
		//"cc"  appears 2 times.
		//"ccc" appears 1 time.
		//3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.
	
		//Example 2:
		
		String s2 = "xy";
		int output2= 2;
		//Explanation: The homogenous substrings are "x" and "y".
		
		//Example 3:
	
		String s3 = "zzzzz";
		int output3= 15;
		
		System.out.println("Brute Force Approch:");		
		if(output1==countHomogenousBruteForce(s1)) {
			System.out.println("Case 1 Passed");
		}else{
			System.out.println("Case 1 Failed");
		}
		if(output2==countHomogenousBruteForce(s2)) {
			System.out.println("Case 2 Passed");
		}else{
			System.out.println("Case 2 Failed");
		}
		if(output3==countHomogenousBruteForce(s3)) {
			System.out.println("Case 3 Passed");
		}else{
			System.out.println("Case 3 Failed");
		}
		
		
		System.out.println("Optimze approch :");		
		if(output1==countHomogenousOptimize(s1)) {
			System.out.println("Case 1 Passed");
		}else{
			System.out.println("Case 1 Failed");
		}
		if(output2==countHomogenousOptimize(s2)) {
			System.out.println("Case 2 Passed");
		}else{
			System.out.println("Case 2 Failed");
		}
		if(output3==countHomogenousOptimize(s3)) {
			System.out.println("Case 3 Passed");
		}else{
			System.out.println("Case 3 Failed");
		}
		
	}

}
