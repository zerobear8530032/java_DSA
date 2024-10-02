//1859. Sorting the Sentence
//Solved
//Easy
//Topics
//Companies
//Hint
//A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each word consists of lowercase and uppercase English letters.
//
//A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.
//
//For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
//Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.

//
//Example 1:
//
//Input: s = "is2 sentence4 This1 a3"
//Output: "This is a sentence"
//Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.
//Example 2:
//
//Input: s = "Myself2 Me1 I4 and3"
//Output: "Me Myself and I"
//Explanation: Sort the words in s to their original positions "Me1 Myself2 and3 I4", then remove the numbers.
// 
//
//Constraints:
//
//2 <= s.length <= 200
//s consists of lowercase and uppercase English letters, spaces, and digits from 1 to 9.
//The number of words in s is between 1 and 9.
//The words in s are separated by a single space.
//s contains no leading or trailing spaces.

package StringsQuestions;
public class SortingTheSentence_1859 {
//	approch we split the sentence on space this create a array which contain each word as a string in index 
//	now we create a new array of String which is same length of splitted array and just add the
//	words at the value-1 (index) where it belong at last we just create a string from the array 
//  to remove the index number from original value we can use sub string methed from 0 till length-1 
//	by joinin the elemennt seperated by index

//	time complexity :	O(n+m)
//	space complexity :	O(n+m)
    public static String sortSentence(String s) {
        String [] str = s.split(" ");
        String ans [] = new String[str.length];
        // System.out.println(Arrays.toString(str)+str.length);
        for(int i =0;i<str.length;i++){
            int index = Integer.parseInt(Character.toString(str[i].charAt(str[i].length()-1)))-1;
            if( index!=str.length-1){
            ans[ index]=str[i].substring(0,str[i].length()-1)+" ";
            }else{
            ans[ index]=str[i].substring(0,str[i].length()-1);
            }
        }
        // System.out.println(Arrays.toString(ans));
        StringBuilder sentence = new StringBuilder();
        for(String temp:ans){sentence.append(temp);}
        return sentence.toString();
    }
//	this approch is also same but here we used a technique to directlystring to index rather then type casting it 
// and we also use a method to create a sentence this make the answer clean and we can see new method in actions    
//    this is more efficient also 
//    time complexity O(m+n)
//    Space complexity O(m+n)
    public static String sortSentenceOtherWay(String s) {
        String [] str = s.split(" ");
        String ans [] = new String[str.length];
        // System.out.println(Arrays.toString(str)+str.length);
        for(int i =0;i<str.length;i++){
            int index = str[i].charAt(str[i].length()-1)-'0'-1;
            ans[ index]=str[i].substring(0,str[i].length()-1);
           
        }

        return String.join(" ", ans);
    }
public static void main(String[] args) {
	//Example 1:
	//
	String s1 = "is2 sentence4 This1 a3";
	String output1= "This is a sentence";
	//Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.
	if(output1.equals(sortSentence(s1))) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	
	
	//Example 2:
	//
	String s2 = "Myself2 Me1 I4 and3";
	String output2= "Me Myself and I";
	//Explanation: Sort the words in s to their original positions "Me1 Myself2 and3 I4", then remove the numbers.
	if(output2.equals(sortSentence(s2))) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}
	
	
//	another approch
	if(output1.equals(sortSentenceOtherWay(s1))) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");		
	}
	if(output2.equals(sortSentenceOtherWay(s2))) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");		
	}

	
}

}
