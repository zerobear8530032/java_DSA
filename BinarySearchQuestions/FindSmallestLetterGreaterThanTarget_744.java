//744. Find Smallest Letter Greater Than Target
//Solved
//Easy
//Topics
//Companies
//Hint
//You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.
//
//Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.
//Example 1:
//
//Input: letters = ["c","f","j"], target = "a"
//Output: "c"
//Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.

//Example 2:
//
//Input: letters = ["c","f","j"], target = "c"
//Output: "f"
//Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.

//Example 3:
//
//Input: letters = ["x","x","y","y"], target = "z"
//Output: "x"
//Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
// 
//Constraints:
//2 <= letters.length <= 104
//letters[i] is a lowercase English letter.
//letters is sorted in non-decreasing order.
//letters contains at least two different characters.
//target is a lowercase English letter.

package BinarySearchQuestions;
public class FindSmallestLetterGreaterThanTarget_744 {
//	here we apply simple binary search if the target is less them current mid we will search right side else left side
//	case 1 : letters[mid]<target : s=mid+1; 
//	case 2 : letters[mid]>target : e=mid-1; 
//	to handdle the edge case of returning the first index if there is no potential answer so we return 
//	letters[s%length of array] 
    public static char nextGreatestLetter(char[] letters, char target) {
	     int s =0;
    	     int n =letters.length-1;
    	     int e =n;
    	     while(s<=e){
    	        int mid = s+(e-s)/2;
    	        if(target<letters[mid]){
    	            e=mid-1;
    	        }else{
    	            s=mid+1;
    	        }
    	    }
    	     return letters[s%(n+1)];
    }
public static void main(String[] args) {
	//Example 1:
	//
	char []letters1 = {'c','f','j'};
	char target1 = 'a';
	char output1= 'c';
	//Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
	if(nextGreatestLetter(letters1,target1)==output1) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}

	//Example 2:
	//
	char []letters2 = {'c','f','j'};
	char target2 = 'c';
	char output2= 'f';

	if(nextGreatestLetter(letters2,target2)==output2) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	//Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.

	//Example 3:
	char []letters3 = {'x','x','y','y'};
	char target3 = 'z';
	char output3= 'x';

	if(nextGreatestLetter(letters3,target3)==output3) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}
	//Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
	
}

}
