//1704. Determine if String Halves Are Alike
//Solved
//Easy
//Topics
//Companies
//Hint
//You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
//
//Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
//
//Return true if a and b are alike. Otherwise, return false.
//
// 
//
//Example 1:
//
//Input: s = "book"
//Output: true
//Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
//Example 2:
//
//Input: s = "textbook"
//Output: false
//Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
//Notice that the vowel o is counted twice.
// 
//
//Constraints:
//
//2 <= s.length <= 1000
//s.length is even.
//s consists of uppercase and lowercase letters.


package StringsQuestions;
public class DetermineIfStringHalvesAreAlike_1704 {
//	approch : we create a index which is n/2 this the starting of the second half now we can just iterate 
//	using 2 pointers one start from 0 to index and second index to length and every time the first pointer 
//	get a vovel it will increment counter and if a second pointer get a vouvel it decrement counter at last 
//	 we return true if counter is 0 else false 
	public static boolean halvesAreAlike(String s) {
        int index = s.length()/2;
        int count=0;
        for(int i =0;i<index;i++){
            char ch1 =Character.toLowerCase(s.charAt(i));
            char ch2 =Character.toLowerCase(s.charAt(i+index));
            if(ch1== 'a' || ch1=='e' || ch1=='i' || ch1 =='o'||ch1 =='u'){
                count++;
            }

            if(ch2== 'a' || ch2=='e' || ch2=='i' || ch2 =='o'||ch2 =='u'){
                count--;
            }
            // System.out.println(ch1+" "+ch2);
        }
        return count==0;
    }
public static void main(String[] args) {

	//Example 1:
	
	String s1 = "book";
	boolean output1= true;
	//Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
	if(halvesAreAlike(s1)==output1) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	
	//Example 2:
	
	String s2 = "textbook";
	boolean output2= false;

	if(halvesAreAlike(s2)==output2) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	//Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
	//Notice that the vowel o is counted twice.
	// 
	
}
}
