//777. Swap Adjacent in LR String
//Solved
//Medium
//Topics
//Companies
//Hint
//In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end, return True if and only if there exists a sequence of moves to transform start to end.
//
// 
//
//Example 1:
//
//Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
//Output: true
//Explanation: We can transform start to end following these steps:
//RXXLRXRXL ->
//XRXLRXRXL ->
//XRLXRXRXL ->
//XRLXXRRXL ->
//XRLXXRRLX
//Example 2:
//
//Input: start = "X", end = "L"
//Output: false
// 
//
//Constraints:
//
//1 <= start.length <= 104
//start.length == end.length
//Both start and end will only consist of characters in 'L', 'R', and 'X'.



package StringsQuestions;

public class SwapAdjacentinLRString_777 {
	
//	approch 
//	
//	first pass used to place all x to right places and second pass which willl place all L to their right palces 
//
//
//
//	how passes works :(place  all L)
//
//	1: here first we will iterate over both the string from left to right:
//	1: if both character at idx 1 and idx 2 are equal we can go on next index 
//	if they are not equal we will check specific pairs
//
//	1 s1[idx1]= 'x' && s2[idx2] = 'L'
//	means we can replace x with L 
//	but the string could be 
//	XL -> LX or XXXXL -> LXXXX
//	so we will loop from idx1 till we find annother character not equal to x if we found L we can replace it with a replace method if the character after loop breaks is not L we can say the ending string cant be reached because we can swap XL -> LX only
//
//	same rules apply for RX -> XR
//	but we will again go throught the entire string from right to left this time and follow same processs where this time we check whether s1[idx1]== 'X' && s2 [idx2]=='R
//	if this pair is 
//
//	means we can replace x with R 
//	but the string could be 
//	RX -> XR or RXXXX -> XXXXR
//
//	so we will loop fromm idx1 will we get another character which is not equal to = X
//	if at the end of loop we cant found "R"
//	so means we cannot reach the ending string :
//
//	at last second pass complete we can check wheather s1,s2 are equal or not 

//	time complexity :O(n)
//	Space complexity :O(n)
	   public static  boolean canTransform(String start, String end) {
	        if(start.length()==1){return start.charAt(0)== end.charAt(0);}
	        char [] s1=start.toCharArray();
	        char [] s2=end.toCharArray();
	        int idx1=0;

	// pass 1 : fill all L to their correct positions 

	    while(idx1 <s1.length){
	            char ch1 = s1[idx1];
	            char ch2 = s2[idx1];
	            // check both element are  equal 
	        if(ch1 ==  ch2){
	                idx1++;
	                // if not equal 
	            }else{
	                // we see specific pair that s1[idx1]=='X' && s2[idx]=='L'
	                // because we can only swap in this case only 
	                if(ch1=='X'  &&  ch2 =='L' ){                    
	                    int i=idx1;
	                    // the string could be XL  -> LX
	                    // or XXXXL -> LXXXX
	                    // or XXXXL -> XXLXX
	                    while(i<s1.length-1 && s1[i]=='X'){i++;}
	                    if(s1[i]!=ch2){return false;}
	                    else{swap(s1,idx1,i);
	                    idx1++;
	                    }
	                }else{
	                idx1++;
	                }
	            }
	    }
	    // pass 1 ends;
	//  pass2 start from right to left to fill all R to their correct positions 
	    idx1=s1.length-1;
	    while(idx1 >=0){
	            char ch1 = s1[idx1];
	            char ch2 = s2[idx1];
	        if(ch1 ==  ch2){
	                idx1--;
	            }else{
	                // similar to previous pass but for RX-> XR
	                    // the string could be RX  -> RX
	                    // or RXXXX -> XXXXR
	                    // or RXXXX -> XXRXX
	                if(ch1=='X'  &&  ch2 =='R' ){                    
	                    int i=idx1;
	                    while(i>0 && s1[i]=='X'){i--;}
	                    if(s1[i]!=ch2){return false;}
	                    else{swap(s1,idx1,i);
	                    idx1--;
	                    }
	                }else{
	                idx1--;
	                }
	            }
	    }
	    // pass 2 ended
	            String str1= new String(s1);
	            String str2= new String(s2);
	            return str1.equals(str2);
	    }

	    public static void swap(char [] arr, int i,int j){
	        char t = arr[i];
	        arr[i]=arr[j];
	        arr[j]=t;
	    }
	    
	    
	    
	    
	    
	public static void main(String[] args) {
		
		//Example 1:
		//
		String start1 = "RXXLRXRXL", end1 = "XRLXXRRLX";
		boolean output1= true;
		//Explanation: We can transform start to end following these steps:
		//RXXLRXRXL ->
		//XRXLRXRXL ->
		//XRLXRXRXL ->
		//XRLXXRRXL ->
		//XRLXXRRLX
		//Example 2:
		//
		String start2 = "X", end2 = "L";
		boolean output2= false;
		
		
		String start3 = "RXXXXXXXXXXXXXL", end3 = "XXXXRLXXXXXXXXX";
		boolean output3= true;
		
		
		
		if(output1==canTransform(start1, end1)) {
			System.out.println("Case  1 Passed");
		}else {
			System.out.println("Case  1 Failed");			
		}
		if(output2==canTransform(start2, end2)) {
			System.out.println("Case  2 Passed");
		}else {
			System.out.println("Case  2 Failed");			
		}
		if(output3==canTransform(start3, end3)) {
			System.out.println("Case  3 Passed");
		}else {
			System.out.println("Case  3 Failed");			
		}


	}

}
