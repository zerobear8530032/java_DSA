//556. Next Greater Element III
//Medium
//Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.
//
//Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.
//
//Example 1:
//
//Input: n = 12
//Output: 21
//Example 2:
//
//Input: n = 21
//Output: -1
// 
//
//Constraints:
//
//1 <= n <= 231 - 1

package StringsQuestions;

public class NextGreaterElementIII_556 {
//	approch :
//	first conver tthe  int to char array for better handling 
//	find first non increment element from right to left  =nums[i]
//	if the entire string is  in increasing order from right to left we can say its already smallest elemebnt possibke
//	means we can return -1
//	once we find it now we need to find the element just greater then the nums[i] by traversing from right to left  let it be num[j]
//	now swap nums[i] and nums[j]
//	once we swaped it 
//	now we can reverse the entire nums from i till length 
//	at last we can convert the string to integer if the integer is over flown  
//	we can return the -1 accordding to questions
	
//	time complexity :O(n);
//	space complexity :O(n);
	    public static int nextGreaterElement(int n) {
	        // conver tot char array 
	        char[] chararr = (""+n).toCharArray();
	        // get second last index
	        int index = chararr.length-2;
	        // find first non increasing  element in the array from right to left  
	        while(index>=0 && chararr[index]>=chararr[index+1]){     
	            index--;
	        }
	        // if entire  array is in decreasing order means no possible way :
	        if(index < 0){
	            return -1;
	        }
	        
	        // after finding first non decreasing element in the array get its values
	        int findgreater = chararr[index];
	       // Step 2: Find the element just larger than chararr[index] from the end
	        int j = chararr.length-1;
	        while(j>index){
	            if(findgreater<chararr[j]){
	        // swap :
	                swap(chararr,index,j);
	                break;
	            }
	            j--;
	        }
	        int left =index+1;
	        int right = chararr.length-1;
	        // reverse the arrya from the index+1 till end of the array 
	        while(left<=right){
	            swap(chararr,left,right);
	            left++;
	            right--;
	        }
	        // convert to string 
	        String ans = new String(chararr);
	        try{
	            // convert to number 
	            // this number can over flow as an int to we can check the exception
	        int num = Integer.parseInt(ans);
	        return num;
	        } catch(Exception e){
	            return -1;
	        }
	    }
	    public static void swap(char arr [], int i, int j){
	        char temp = arr[i];
	        arr[i]=arr[j];
	        arr[j]=temp;
	    }
	

	public static void main(String[] args) {
		
		
		//Example 1:
		//
		int n1 = 12;
		int output1= 21;

		
		//Example 2:
		//
		int n2 = 21;
		int output2= -1;
		
		
		if(output1==nextGreaterElement(n1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		
		if(output2==nextGreaterElement(n2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}


	}

}
