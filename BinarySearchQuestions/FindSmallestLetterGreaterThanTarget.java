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
// here its is simple used binary search to do the work but when their is no such character we have to return the first character so we nneed to return s%nums.length
// approch:
// find the char greater then target using binary search (same as finding ceiling of the Number in a array )

public class FindSmallestLetterGreaterThanTarget {
    public static char nextGreatestLetter(char[] letters, char target) {
        int s =0;
        int e=letters.length-1;
        int mid=0;
//        we need to find the char greater the target so we remove the target== nums[mid] 
        while(s<=e){
            mid=s+(e-s)/2;
            if(target<letters[mid]){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
//        when it reaches here the end will always smaller then start and the target would be between start and end 
//        so by intution we know start is higher so we will return start
//        but if the their is no such charcter greater then target so we have to return the first char so we can check
//        if(s==letters.length){return letters[0];}
//        or we can use the letters[s%letters.length] both work same because if the s in btw 0 and length it will return the index 
//        if the s> length then it will always be eequal to length s%length will be 0
        return letters[s%letters.length];
    }
public static void main(String args[]) {
	//Example 1:
	char letters1 []= {'c','f','j'};
	char target1 = 'a';
	char Output1= 'c';
	//Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
	//Example 2:
	char letters2 []= {'c','f','j'};
	char target2= 'c';
	char Output2= 'f';
	//Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
	//Example 3:
	char letters3 []= {'x','x','y','y'};
	char target3= 'z';
	char Output3= 'x';
//	Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].

	if(nextGreatestLetter(letters1, target1)==Output1) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	
	if(nextGreatestLetter(letters2, target2)==Output2) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	
	if(nextGreatestLetter(letters3, target2)==Output3) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");		
	}
	
}
}
