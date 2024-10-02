//1773. Count Items Matching a Rule
//Solved
//Easy
//Topics
//Companies
//Hint
//You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.
//
//The ith item is said to match the rule if one of the following is true:
//
//ruleKey == "type" and ruleValue == typei.
//ruleKey == "color" and ruleValue == colori.
//ruleKey == "name" and ruleValue == namei.
//Return the number of items that match the given rule.
//
// 
//
//Example 1:
//
//Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
//Output: 1
//Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
//Example 2:
//
//Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
//Output: 2
//Explanation: There are only two items matching the given rule, which are ["phone","blue","pixel"] and ["phone","gold","iphone"]. Note that the item ["computer","silver","phone"] does not match.
// 
//
//Constraints:
//
//1 <= items.length <= 104
//1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
//ruleKey is equal to either "type", "color", or "name".
//All strings consist only of lowercase letters.
package StringsQuestions;
import java.util.*;
public class CountItemsMatchingaRule_1773 {
//approch : we know that if we need rule key  we have it on specific index:
//	like at index 0 we have type , 1 we have color a, 2 we have name 
//	so we set index accordingly and tthen iterate over the list of lists and check at index that equal to value if yes increase count 
//	at last return count
//	time complexity :O(n)
	    public static  int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
//	        set index according to rule key 
	    	int index = 0;
	        switch(ruleKey){
	            case "color":
	            index=1;
	            break;
	            
	            case "name":
	            index=2;
	            break;
	            default :
	            index=0;
	        }
	        
	        int count =0;
//	        iterate over the list and check for matching values
	        for(int i =0;i<items.size();i++){
	            if(items.get(i).get(index).equals(ruleValue)){count++;}
	        }
	        return count;
	    }
	
	
	public static void main(String[] args) {
		
		//Example 1:
		//
		   List<List<String>> items1 = new ArrayList<>();
	       items1.add(Arrays.asList("phone", "blue", "pixel"));
	       items1.add(Arrays.asList("computer", "silver", "lenovo"));
	       items1.add(Arrays.asList("phone", "gold", "iphone"));
	       String ruleKey1 = "color", ruleValue1 = "silver";
	        int output1= 1;
	       if(countMatches(items1,ruleKey1, ruleValue1)==output1) {
	    	   System.out.println("Case 1 Passed");
	       }else {
	    	   System.out.println("Case 1 Failed");	    	   
	       }
	        
		//Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
		//Example 2:
		//
		//Explanation: There are only two items matching the given rule, which are ["phone","blue","pixel"] and ["phone","gold","iphone"]. Note that the item ["computer","silver","phone"] does not match.
	       List<List<String>> items2 = new ArrayList<>();
	       items2.add(Arrays.asList("phone", "blue", "pixel"));
	       items2.add(Arrays.asList("computer", "silver", "phone"));
	       items2.add(Arrays.asList("phone", "gold", "iphone"));
	       String ruleKey2 = "type", ruleValue2 = "phone";
	       int output2=2;
	       if(countMatches(items2,ruleKey2,ruleValue2)==output2) {
	    	   System.out.println("Case 2 Passed");
	       }else {
	    	   System.out.println("Case 2 Failed");	    	   
	       }
		// 

	
}
}
