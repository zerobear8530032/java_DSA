//168. Excel Sheet Column Title
//Easy
//Topics
//Companies
//Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
//
//For example:
//
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//...
// 
//
//Example 1:
//
//Input: columnNumber = 1
//Output: "A"
//Example 2:
//
//Input: columnNumber = 28
//Output: "AB"
//Example 3:
//
//Input: columnNumber = 701
//Output: "ZY"
// 
//
//Constraints:
//
//1 <= columnNumber <= 231 - 1


package StringsQuestions;

public class ExcelSheetColumnTitle_168 {
	    public static String convertToTitle(int columnNumber) {
	           StringBuilder result = new StringBuilder();
	      while (columnNumber > 0) {
	            columnNumber--; // Convert to 0-based index
	            int remainder = columnNumber % 26;
	            result.append((char) ('A' + remainder)); // Convert to corresponding character
	            columnNumber /= 26; 
	        }
	        
	        return result.reverse().toString();    
	    }
	
	public static void main(String[] args) {
		//Example 1:
		//
		int columnNumber1 = 1;
		String output1= "A";
		
		if(output1.equals(convertToTitle(columnNumber1))) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");			
		}
		
		//Example 2:
		int columnNumber2 = 28;
		String output2= "AB";
		
		if(output2.equals(convertToTitle(columnNumber2))) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");			
		}
		//Example 3:

		int columnNumber3 = 701;
		String output3= "ZY";
		if(output3.equals(convertToTitle(columnNumber3))) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");			
		}

	}

}
