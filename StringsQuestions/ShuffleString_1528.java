//1528. Shuffle String
//Solved
//Easy
//Topics
//Companies
//Hint
//You are given a string s and an integer array indices of the same length. The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
//
//Return the shuffled string.
//
// 
//
//Example 1:
//
//
//Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
//Output: "leetcode"
//Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
//Example 2:
//
//Input: s = "abc", indices = [0,1,2]
//Output: "abc"
//Explanation: After shuffling, each character remains in its position.
// 
//
//Constraints:
//
//s.length == indices.length == n
//1 <= n <= 100
//s consists of only lowercase English letters.
//0 <= indices[i] < n
//All values of indices are unique.
package StringsQuestions;

import java.util.HashMap;

public class ShuffleString_1528 {

//	simple approch : we create a char array and then sort the indeces array in increasing order while also making same swaps inn char array
//	at last we return the char array as a string using string builder
//	the sorting algo is used O(n*n)
//	time complexity : o(n*n)
//	space complexity :O(n)
	
    public static String restoreString(String s, int[] indices) {
        char chararr [] = s.toCharArray();
        sortarray(indices,chararr);
        StringBuilder ans = new StringBuilder();
        ans.append(chararr);
        return ans.toString();
        
    }
    
    
    
    public static void sortarray(int [] indices  , char chararr []){
        for(int i =0;i<indices.length-1;i++){
            for(int j =i+1;j<indices.length;j++){
                if(indices[i]>indices[j]){
                    swap(indices,chararr,i,j);
                }
            }
        }
    }
    public static void swap(int [] arr,char [] ch, int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        char tempch = ch[i];
        ch[i]=ch[j];
        ch[j]=tempch;
    }
    
//    better  approch : by using a hashmap we can create a map which map index to theier characters 
//    now we already know the index will be 0 till length-1 so we can append the character from 0 till llength-1 index 
//    with hash map using string builder and return answwer ;
//     Time complexity : O(n)
//     Space complexity : O(n)
    public static String restoreStringBetter(String s, int[] indices) {
            HashMap<Integer,Character> map = new HashMap();
            for(int i =0;i<indices.length;i++){
                map.put(indices[i],s.charAt(i));
            }
            StringBuilder ans = new StringBuilder();
            for(int i =0;i<indices.length;i++){
                ans.append(map.get(i));
            }
            return ans.toString();
        }

//    brute force approch:
//    time complexity O(n*n)
//    space complexity O(1) -> or we can say O(n) because we convert the string builder tostring
        public static String restoreStringBruteForce(String s, int[] indices) {
         StringBuilder ans = new StringBuilder();
         for(int i  =0;i<indices.length;i++){
            for(int j =0;j<indices.length;j++){
                if(indices[j]==i){
                    ans.append(s.charAt(j));
                    break;
                }
            }
         }
        return ans.toString();   
        }
    
//    here we we create a char array and directly map the character to the index of chararray 
//        and at last we conver tto string and return it 
//        time complecity:O(n)
//        space complecity:O(n) ->  thos o(n) is bettter then using hashmap 
            public static String restoreStringBest(String s, int[] indices) {
                char[] arr = new char[s.length()];
                for(int i =0;i<indices.length;i++){
                    arr[indices[i]]=s.charAt(i);
                } 
                return new String (arr);
            }
        
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Example 1:
		//
		//
		String s1 = "codeleet";
		int []indices1 = {4,5,6,7,0,2,1,3};
		String output1="leetcode";
		if(output1.equals(restoreStringBruteForce(s1, indices1))) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		
		
		//Example 2:
		
		String s2 = "abc";
		int []indices2 = {0,1,2};
		String output2="abc";
		if(output2.equals(restoreStringBruteForce(s2, indices2))) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		
//		better :
		System.out.println("Better approch :");
		if(output1.equals(restoreStringBetter(s1, indices1))) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		if(output2.equals(restoreStringBetter(s2, indices2))) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		
//		Optimized:
		System.out.println("Best approch :");
		if(output1.equals(restoreStringBest(s1, indices1))) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		if(output2.equals(restoreStringBest(s2, indices2))) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
//		Worst:
		System.out.println("worst approch :");
		if(output1.equals(restoreString(s1, indices1))) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		if(output2.equals(restoreString(s2, indices2))) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		StringBuilder s= new StringBuilder();
		

	}

}
