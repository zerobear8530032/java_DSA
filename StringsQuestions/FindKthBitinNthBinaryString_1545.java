//1545. Find Kth Bit in Nth Binary String
//Solved
//Medium
//Topics
//Companies
//Hint
//Given two positive integers n and k, the binary string Sn is formed as follows:
//
//S1 = "0"
//Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
//Where + denotes the concatenation operation, reverse(x) returns the reversed string x, and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).
//
//For example, the first four strings in the above sequence are:
//
//S1 = "0"
//S2 = "011"
//S3 = "0111001"
//S4 = "011100110110001"
//Return the kth bit in Sn. It is guaranteed that k is valid for the given n.
//
// 
//
//Example 1:
//
//Input: n = 3, k = 1
//Output: "0"
//Explanation: S3 is "0111001".
//The 1st bit is "0".
//Example 2:
//
//Input: n = 4, k = 11
//Output: "1"
//Explanation: S4 is "011100110110001".
//The 11th bit is "1".
// 
//
//Constraints:
//
//1 <= n <= 20
//1 <= k <= 2n - 1


package StringsQuestions;

public class FindKthBitinNthBinaryString_1545 {
//	approch : first create string "0" 
//	append +"1" and then invert it then reverse it and append to last result repeat it n-1 times return k-1 index of final string at ooutput
//	time complexity : O(n*n)
//	space complexity : O(n*n)
//	reverse String  
	public static String reverse (String str){
	        char [] word  = str.toCharArray();
	        int start =0;
	        int end = str.length()-1;
	        while(start<=end){
	            char t = word[start];
	            word[start]=word[end];
	            word[end]=t;
	            start++;
	            end--;
	        }
	        return new String(word);
	    }
//	inverting 0 to1 and 1 to 0
	    public static String inverted (String str){
	        char [] word  = str.toCharArray();
	        for(int i =0;i<word.length;i++){
	            if(word[i]=='0'){
	                word[i]='1';
	            }else{
	                word[i]='0';
	            }
	        }
	        return new String(word);
	    }

	    public static  char findKthBit(int n, int k) {
//	        inital string 
	    	String ans = "0";
//	        apply function on string
	        for(int i =1;i<n;i++){
	            String inverted = inverted(ans);
	            String reversed = reverse(inverted);
	            ans = ans+"1"+reversed;
	        }
	        return ans.charAt(k-1);
	    }
	
	
	public static void main(String[] args) {
		
		
		//Example 1:
		//
		int  n1 = 3, k1 = 1;
		char output1= '0';
		//Explanation: S3 is "0111001".
		//The 1st bit is "0".
		
		//Example 2:
		//
		int  n2 = 4, k2 = 11;
		char output2 ='1';
		//Explanation: S4 is "011100110110001".
		//The 11th bit is "1".

		if(output1==findKthBit(n1, k1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");			
		}
		if(output2==findKthBit(n2, k2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");			
		}
	}

}
