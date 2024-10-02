//848. Shifting Letters
//Solved
//Medium
//Topics
//Companies
//You are given a string s of lowercase English letters and an integer array shifts of the same length.
//
//Call the shift() of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').
//
//For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
//Now for each shifts[i] = x, we want to shift the first i + 1 letters of s, x times.
//
//Return the final string after all such shifts to s are applied.
//
//Example 1:
//
//Input: s = "abc", shifts = [3,5,9]
//Output: "rpl"
//Explanation: We start with "abc".
//After shifting the first 1 letters of s by 3, we have "dbc".
//After shifting the first 2 letters of s by 5, we have "igc".
//After shifting the first 3 letters of s by 9, we have "rpl", the answer.
//Example 2:
//
//Input: s = "aaa", shifts = [1,2,3]
//Output: "gfd"
// 
//
//Constraints:
//
//1 <= s.length <= 105
//s consists of lowercase English letters.
//shifts.length == s.length
//0 <= shifts[i] <= 109



package StringsQuestions;

public class ShiftingLetters_848 {
	
	// brute force approch:
//	approch : here we have a string coverted to character and  we have a function which will increment the chracter by giving it the 
//	the number of shifts and return the string 
	
//	time complexity :O(n*n);
//	space complexity :O(1);
	    public static String shiftingLettersBruteForce(String s, int[] shifts) {
	        char [] str = s.toCharArray();
//	        here we apply string shift from 0 till length 
	        for(int i =0;i<str.length;i++){
//	        	we need to apply string untill shift [i] each time so we need to apply from 0 till i on each time 
	            shift(str,i,shifts[i]);
	        }
	        return new String(str);
	    }
//	    here we have shfit operation
	    public static void shift(char [] str,int range
	    		,int shift){
//	chracter hold the characater in array 
	        char [] characters ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	        for(int i =0;i<=range;i++){
//	        	here str[i]+shift will give next character but we need only a to z and z +1 == a so we need to round it 
//	        	str[i]+shift-97 will give us which characte it will be but because of shift it can lead to over the index 
//	        	so we need to mod it with 26 to keep them in character[ index]
	            str[i]=characters[(str[i]+shift-97)%26];
	        }
	    }

// Optimize approch :
//	    approch : here we know we need to apply each operation index i times on each operations
//	    so we just take a suffix sum then we does not need to apply shift in range instead we apply it all att once
//	    here we 
//	    Time Complexity: O(n)
//	    Space Complexity: O(n)
	        public static String shiftingLettersOptimize(String s, int[] shifts) {
	            char [] str = s.toCharArray();
	            long []operations = new long[shifts.length];
	            long sum=0;
//	            taking suffix sum
	            for(int i =operations.length-1;i>=0;i--){
	                sum=sum+shifts[i];
	                operations[i]=sum;
	            }
	            
	            char [] characters ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
//	            apply shifting characters
	            for(int i =0;i<str.length;i++){
	                int index = (int)((long)(str[i]+operations[i]-97L)%26l);
	                str[i]=characters[index];
	            }
	            return new String(str);
	        }

	        
// Best approch :
//	    approch : here we know we need to apply each operation index i times on each operations
//	    so we just take a suffix sum then we does not need to apply shift in range instead we apply it all att once
//	    here we 
//	    Time Complexity: O(n)
//	    Space Complexity: O(n)
	        public static String shiftingLettersBest(String s, int[] shifts) {
	        	char [] str = s.toCharArray();
	        	int totalshift=0;
//	            taking suffix sum
	        	for(int i =str.length-1;i>=0;i--){
	        		totalshift=totalshift+shifts[i]%26;
	        		str[i]= (char)((str[i]+totalshift-'a')%26 + 'a'); 
	        	}
	        	return new String(str);
	        }
	        
	    

	public static void main(String[] args) {
		//Example 1:
		//
		String s1 = "abc";
		int shifts1[] = {3,5,9};
		String output1="rpl";
		
		//Explanation: We start with "abc".
		//After shifting the first 1 letters of s by 3, we have "dbc".
		//After shifting the first 2 letters of s by 5, we have "igc".
		//After shifting the first 3 letters of s by 9, we have "rpl", the answer.
		
		
		//Example 2:
		String s2 = "aaa";
		int shifts2[] = {1,2,3};
		String output2="gfd";
		System.out.println("Brute Force Approch : " );
		if(output1.equals(shiftingLettersBruteForce(s1, shifts1))) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		if(output2.equals(shiftingLettersBruteForce(s2, shifts2))) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		
		
		System.out.println("Optimize Approch : " );
		if(output1.equals(shiftingLettersOptimize(s1, shifts1))) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		if(output2.equals(shiftingLettersOptimize(s2, shifts2))) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		
		
		System.out.println("Best Approch : " );
		if(output1.equals(shiftingLettersBest(s1, shifts1))) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		if(output2.equals(shiftingLettersBest(s2, shifts2))) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
	}

}
