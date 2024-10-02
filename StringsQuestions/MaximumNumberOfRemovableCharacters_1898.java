//1898. Maximum Number of Removable Characters
//Medium
//You are given two strings s and p where p is a subsequence of s. You are also given a distinct 0-indexed integer array removable containing a subset of indices of s (s is also 0-indexed).
//
//You want to choose an integer k (0 <= k <= removable.length) such that, after removing k characters from s using the first k indices in removable, p is still a subsequence of s. More formally, you will mark the character at s[removable[i]] for each 0 <= i < k, then remove all marked characters and check if p is still a subsequence.
//
//Return the maximum k you can choose such that p is still a subsequence of s after the removals.
//
//A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
//
// 
//
//Example 1:
//
//Input: s = "abcacb", p = "ab", removable = [3,1,0]
//Output: 2
//Explanation: After removing the characters at indices 3 and 1, "abcacb" becomes "accb".
//"ab" is a subsequence of "accb".
//If we remove the characters at indices 3, 1, and 0, "abcacb" becomes "ccb", and "ab" is no longer a subsequence.
//Hence, the maximum k is 2.
//Example 2:
//
//Input: s = "abcbddddd", p = "abcd", removable = [3,2,1,4,5,6]
//Output: 1
//Explanation: After removing the character at index 3, "abcbddddd" becomes "abcddddd".
//"abcd" is a subsequence of "abcddddd".
//Example 3:
//
//Input: s = "abcab", p = "abc", removable = [0,1,2,3,4]
//Output: 0
//Explanation: If you remove the first index in the array removable, "abc" is no longer a subsequence.
// 
//
//Constraints:
//
//1 <= p.length <= s.length <= 105
//0 <= removable.length < s.length
//0 <= removable[i] < s.length
//p is a subsequence of s.
//s and p both consist of lowercase English letters.
//The elements in removable are distinct.

package StringsQuestions;

public class MaximumNumberOfRemovableCharacters_1898 {
//	approch : Binary Search 
//	apply  Binary Search on removable  from 0 till length of removable
//	now we can apply binary search by calculating mid 
//	and checking by removing number of mid element from removablep[i] indexs
//	 and check if substring is still avalible 
//	if substring is  avaible we can do start =mid+1
//	else end= mid-1;
//	at last the start will have the answer 
	
//	time complexity : O((n + m) * log k
//	time complexity : O(n)
	    public static int maximumRemovals(String s, String p, int[] removable) {
	        int start=0;
	        int end=removable.length-1;
	        while(start<=end){
	            int mid = start+(end-start)/2;
	            if(possibletoremove(s,p,removable,mid)){
	                start=mid+1;
	            }else{
	                end=mid-1;
	            }          
	        }
	        return start;
	    }
	    public static boolean possibletoremove(String s , String p,int []removable,int removeindex ){
	        char [] chararr =s.toCharArray();
	        for(int i =0;i<=removeindex;i++){
	            chararr[removable[i]]=' ';
	        }
	        return subStringExists(chararr,p);
	    }
	    public static boolean subStringExists(char [] s, String p){
	        int pindex =0;
	        for(int i =0;i<s.length;i++){
	            if(s[i]==p.charAt(pindex)){
	                pindex++;
	            }
	            if(pindex==p.length()){
	                break;
	            }
	        }
	       return  pindex==p.length();
	        
	    }
	

	public static void main(String[] args) {
		//Example 1:
		//
		String s1 = "abcacb", p1 = "ab";
		int []removable1 = {3,1,0};
		int output1 =2;
		//Explanation: After removing the characters at indices 3 and 1, "abcacb" becomes "accb".
		//"ab" is a subsequence of "accb".
		//If we remove the characters at indices 3, 1, and 0, "abcacb" becomes "ccb", and "ab" is no longer a subsequence.
		//Hence, the maximum k is 2.
	
		//Example 2:
		//
		String s2 =  "abcbddddd", p2 = "abcd";
		int []removable2 = {3,2,1,4,5,6};
		int output2 =1;
		//Explanation: After removing the character at index 3, "abcbddddd" becomes "abcddddd".
		//"abcd" is a subsequence of "abcddddd".
		
		//Example 3:
		//
		String s3 =  "abcab", p3 = "abc";
		int []removable3 = {0,1,2,3,4};
		int output3 =0;
		//Explanation: If you remove the first index in the array removable, "abc" is no longer a subsequence.
		
		if(output1==maximumRemovals(s1, p1, removable1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		if(output2==maximumRemovals(s2, p2, removable2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		if(output3==maximumRemovals(s3, p3, removable3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
	}

}
