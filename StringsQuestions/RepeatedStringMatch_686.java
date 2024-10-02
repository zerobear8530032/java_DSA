//686. Repeated String Match
//Solved
//Medium
//Topics
//Companies
//Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for to be a substring of a after repeating it, return -1.
//
//Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".
//
//Example 1:
//
//Input: a = "abcd", b = "cdabcdab"
//Output: 3
//Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.
//Example 2:
//
//Input: a = "a", b = "aa"
//Output: 2
// 
//
//Constraints:
//
//1 <= a.length, b.length <= 104
//a and b consist of lowercase English letters.*/

package StringsQuestions;

public class RepeatedStringMatch_686 {
//	approch bruteforce :
//	here we check wheather the str1 have str2 in side if yes return 1
//	other wise we will append str1 with str1 until its length is greater then str2 
//	now we check does it have str2 in side str1
//	if no we check one more time by appending if not found we return -1
//	time complexity :O(n * (m + n))	
//	space complexity :O(n + m)
	
	public static int repeatedStringMatch(String str1, String str2) {
		int count =1;
		StringBuilder repeating = new StringBuilder(str1);
		if(repeating.indexOf(str2)>=0) {
			return 1;
		}
		while(repeating.length()<str2.length()) {
			repeating.append(str1);
			count++;
		}
		if(repeating.indexOf(str2)>=0) {
			return count;
		}
		repeating.append(str1);
		count++;	
		if(repeating.indexOf(str2)>=0) {
			return count;
		}else {
			return -1;
		}
		
		
	}
	
//	approch :
	// intution of solution 
	// a= "abcd" 
	// b = "cdabcdab"                   
	// b = prefix + a*n + suffix = n+2 (cd (abcd) ab)
	// b  = prefix +a*n = n+1 (cd (abcd) )
	// b  = a*n+suffix = n+1 ((abcd)ab )
	// b  = a*n = n ((abcd))
	
	// so we need to find out n and check  whether 
	//  if we append string n times it have the b as substring 
	//  if we append string n+1 times it have the b as substring 
	//  if we append string n+2 times it have the b as substring 
	//  other wise -1 
	
//	space complexity: O(N+M)
//	time complexity: O(N+M)
	 public static int repeatedStringMatchAnother(String a, String b) {
	        int n1=a.length();
	        int n2=b.length();
	        int n = n2/n1;
	        int counter =0;
	        StringBuilder str = new StringBuilder();
	        while(counter<n){
	            str.append(a);
	            counter++;
	        }
	        if(str.indexOf(b)>=0){
	            return counter;
	        }
	        str.append(a);
	        if(str.indexOf(b)>=0){
	            return counter+1;
	        }
	        str.append(a);
	        if(str.indexOf(b)>=0){
	            return counter+2;
	        }
	        return -1;
	    }
	
public static void main(String[] args) {
	//Example 1:
	//
	String a1 = "abcd", b1 = "cdabcdab";
	int output1=3;
	
	//Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.
	//Example 2:
	//
	String a2 = "a", b2 = "aa";
	int output2= 2;
	
	
	
	
	if(output1==repeatedStringMatch(a1, b1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	if(output2==repeatedStringMatch(a2, b2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	
	
	
	if(output1==repeatedStringMatchAnother(a1, b1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	if(output2==repeatedStringMatchAnother(a2, b2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}

}
}
