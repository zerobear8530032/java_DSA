//1813. Sentence Similarity III
//Solved
//Medium
//Topics
//Companies
//Hint

//A sentence is a list of words that are separated by a single space with no leading or trailing spaces. For example, "Hello World", "HELLO", "hello world hello world" are all sentences. Words consist of only uppercase and lowercase English letters.
//Two sentences sentence1 and sentence2 are similar if it is possible to insert an arbitrary sentence (possibly empty) inside one of these sentences such that the two sentences become equal. For example, sentence1 = "Hello my name is Jane" and sentence2 = "Hello Jane" can be made equal by inserting "my name is" between "Hello" and "Jane" in sentence2.
//Given two sentences sentence1 and sentence2, return true if sentence1 and sentence2 are similar. Otherwise, return false.

//Example 1:
//
//Input: sentence1 = "My name is Haley", sentence2 = "My Haley"
//Output: true
//Explanation: sentence2 can be turned to sentence1 by inserting "name is" between "My" and "Haley".
//Example 2:
//
//Input: sentence1 = "of", sentence2 = "A lot of words"
//Output: false
//Explanation: No single sentence can be inserted inside one of the sentences to make it equal to the other.
//Example 3:
//
//Input: sentence1 = "Eating right now", sentence2 = "Eating"
//Output: true
//Explanation: sentence2 can be turned to sentence1 by inserting "right now" at the end of the sentence.
// 
//
//Constraints:
//
//1 <= sentence1.length, sentence2.length <= 100
//sentence1 and sentence2 consist of lowercase and uppercase English letters and spaces.
//The words in sentence1 and sentence2 are separated by a single space.


package StringsQuestions;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SentenceSimilarityIII_1813 {
//	approch :
	
// split both strings on spaces becuse they are valid sentences each word will be at particular indexes 
// now match the prefix of smaller sentence with bigger sentence 
//	if the entire smaller sentence matches the prefix of bigger sentecen we can say rest of sentence can be inserted at left side of the string so we got our answer 
//	if not we can  check the suffix 
//	now we will find how much words from the suffix of smaller sentence is matching with the bigger sentence 
//	at last we return true if the matching words are equal or greater to number of words in the smaller sentence
//	this works because we check prefix and suffix of each sentence so if there would be any word which is not 
//	a part bigger sentence will not be count as match which will return true when we check number of words and matching
	
//	   Time Complexity: O(n+m+min(L1,L2)) ->  O(n+m) is becaue of split other wise it is O(min(l1,l2))
//	   Space Complexity :O(L1+L2) -> this space is taken by split arrays 	   
	
	   public static boolean  areSentencesSimilar(String sentence1, String sentence2) {
	        String s1[] = sentence1.split(" ");
	        String s2[] = sentence2.split(" ");
	        if(s1.length>s2.length){
	            return areSentencesSimilar(sentence2,sentence1);
	        }
	        int matching =0;
	        int index =0;
	        while(index<s1.length){
	            if(!s1[index].equals(s2[index])){
	                break;
	            }
	            matching++;
	            index++;
	        }
	        if(index==s1.length){
	            return true;
	        }
	        index=s1.length-1;
	        int s2index=s2.length-1;
	        while(index>=0){
	            if(!s1[index].equals(s2[s2index])){
	                break;
	            }
	            index--;
	            matching++;
	            s2index--;
	        }
	        return matching>=s1.length;
	    }
	
//	  using deque :
//	   approch : here we put every sentence word in the deque now we can pop matching prefix and suffix
//	   at last if any deque is empty we can say true because entire string is matched either at prefix or suffix
//	   similar to previous approch 
//	   Time Complexity: O(n+m+min(L1,L2))
//	   Space Complexity :O(L1+L2)	   
		   public static boolean   areSentencesSimilarDeque(String sentence1, String sentence2) {
	        Deque <String> dq1 = new ArrayDeque(Arrays.asList(sentence1.split(" ")));
	        Deque <String> dq2 = new ArrayDeque(Arrays.asList(sentence2.split(" ")));
	        while(!dq1.isEmpty() && !dq2.isEmpty() && dq1.peek().equals(dq2.peek())){
	            System.out.println(dq1);
	            System.out.println(dq2);
	            dq1.poll();
	            dq2.poll();
	        }

	        while(!dq1.isEmpty() && !dq2.isEmpty() && dq1.peekLast().equals(dq2.peekLast())){
	            System.out.println(dq1);
	            System.out.println(dq2);
	            dq1.pollLast();
	            dq2.pollLast();
	        }
	        return dq1.isEmpty()|| dq2.isEmpty();
	    }
	   
	   
	public static void main(String[] args) {
		
		
		//Example 1:
		//
		String sentence11 = "My name is Haley", sentence12 = "My Haley";
		boolean output1 = true;
		//Explanation: sentence2 can be turned to sentence1 by inserting "name is" between "My" and "Haley".

		
		//Example 2:
		//
		String  sentence21 = "of", sentence22 = "A lot of words";
		boolean output2= false;
		//Explanation: No single sentence can be inserted inside one of the sentences to make it equal to the other.
		
		
		//Example 3:
		//
		String sentence31 = "Eating right now", sentence32 = "Eating";
		boolean output3= true;
		//Explanation: sentence2 can be turned to sentence1 by inserting "right now" at the end of the sentence.
		
		
		if(output1==areSentencesSimilar(sentence11, sentence12)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		
		if(output2==areSentencesSimilar(sentence21, sentence22)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		if(output3==areSentencesSimilar(sentence31, sentence32)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
		
		
		
//		Another approch :
		if(output1==areSentencesSimilarDeque(sentence11, sentence12)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		
		if(output2==areSentencesSimilarDeque(sentence21, sentence22)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		if(output3==areSentencesSimilarDeque(sentence31, sentence32)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
		
	}
}
