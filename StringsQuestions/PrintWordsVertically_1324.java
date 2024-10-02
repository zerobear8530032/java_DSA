//1324. Print Words Vertically
//Solved
//Medium
//Given a string s. Return all the words vertically in the same order in which they appear in s.
//Words are returned as a list of strings, complete with spaces when is necessary. (Trailing spaces are not allowed).
//Each word would be put on only one column and that in one column there will be only one word.
//
// 
//
//Example 1:
//
//Input: s = "HOW ARE YOU"
//Output: ["HAY","ORO","WEU"]
//Explanation: Each word is printed vertically. 
// "HAY"
// "ORO"
// "WEU"
//Example 2:
//
//Input: s = "TO BE OR NOT TO BE"
//Output: ["TBONTB","OEROOE","   T"]
//Explanation: Trailing spaces is not allowed. 
//"TBONTB"
//"OEROOE"
//"   T"
//Example 3:
//
//Input: s = "CONTEST IS COMING"
//Output: ["CIC","OSO","N M","T I","E N","S G","T"]
// 
//
//Constraints:
//
//1 <= s.length <= 200
//s contains only upper case English letters.
//It's guaranteed that there is only one space between 2 words.

package StringsQuestions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintWordsVertically_1324 {
// approch :
// iterate over string rows and column wise where the first loop will iterate over the character of string 
//	and the inner loop will iterate over string over rows
//	each time we iterate over character we append to string 
//	and at the end after exiting we append it to our answer 
//	and we exit the loop when the string maxreached
	    public static List<String> printVertically(String s) {
	      int index =0;// index will interate over character 
	      List<String> ans = new ArrayList(); // store answer 
	      String [] words = s.split(" ");// convert string into string array break on spaces
	      int l =words.length;// length of string array 
	        //  this while loop will loop till 200 according to contrain of 200 length of string 
	        // and it allow the index to traver column wise  
	      while(index!=200){ // this condition can be true also but we have contrain so we can keep it like this 
	        // string builder will create the string 
	      StringBuilder str = new StringBuilder();
	    //   this will check when to terminate the upper while loop
	      boolean maxStringLengthReached =true;
	    //   this will iterate over words and we will append charAt(index ) in stringbuilder
	        for(int i =0;i<l;i++){
	            // checking string have character at athat index if yes then append
	            if(words[i].length()>index){
	                str.append(words[i].charAt(index));
	                // if we found character means we can get more character so wee toggle it 
	                maxStringLengthReached =false;
	                // if character is not found at index we willapppend space 
	            }else{
	                str.append(" ");
	            }
	        }
	        // check maxStringLengthReached if yes then break other wise nexxt Iteratioon
	        if(maxStringLengthReached){
	            break;
	        }
	        // here we convert the StringBuilder stirng to string and split all trailing spaces and append it to final answer 
	        ans.add(str.toString().stripTrailing());
	        // index will get increament for each in=terations to get next char 
	        index++;
	      }
	    //   return ans
	      return ans;  
	    }
	    
	    public static boolean check (List<String> ans , List<String> output) {
	    	if(ans.size()!=output.size()) {return false;}
	    	for(int i =0;i<ans.size();i++) {
	    		if(!ans.get(i).equals(output.get(i))) {
	    			return false;
	    		} 		
	    	}
	    	return true;
	    }

	public static void main(String[] args) {

		
		//Example 1:
		//
		String  s1 = "HOW ARE YOU";
		List<String>output1=  new ArrayList(Arrays.asList("HAY","ORO","WEU"));
		List<String>ans1 = printVertically(s1);
		//Explanation: Each word is printed vertically. 
		// "HAY"
		// "ORO"
		// "WEU"
		
		
		
		//Example 2:
		//
		String s2 = "TO BE OR NOT TO BE";
		List<String>output2=  new ArrayList(Arrays.asList("TBONTB","OEROOE","   T"));
		List<String>ans2 = printVertically(s2);

		//Explanation: Trailing spaces is not allowed. 
		//"TBONTB"
		//"OEROOE"
		//"   T"
		
		
		//Example 3:
		//
		String s3 = "CONTEST IS COMING";
		List<String>output3=  new ArrayList(Arrays.asList("CIC","OSO","N M","T I","E N","S G","T"));
		List<String>ans3 = printVertically(s3);
		
	System.out.println(ans1);
	System.out.println(output1);
		
		if(check(ans1, output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		if(check(ans2, output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		if(check(ans3, output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
		


	}

}
