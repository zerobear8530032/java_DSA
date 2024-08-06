//You have n books, each with arr[i] a number of pages. m students need to be allocated contiguous books, with each student getting at least one book.
//Out of all the permutations, the goal is to find the permutation where the sum of the maximum number of pages in a book allotted to a student should be the minimum, out of all possible permutations.
//
//Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).
//
//Examples:
//
//Input: n = 4, arr[] = [12, 34, 67, 90], m = 2
//Output: 113
//Explanation: Allocation can be done in following ways:
//{12} and {34, 67, 90} Maximum Pages = 191
//{12, 34} and {67, 90} Maximum Pages = 157
//{12, 34, 67} and {90} Maximum Pages =113.
//Therefore, the minimum of these cases is 113, which is selected as the output.
//Input: n = 3, arr[] = [15, 17, 20], m = 5
//Output: -1
//Explanation: Allocation can not be done.
//Expected Time Complexity: O(n logn)
//Expected Auxilliary Space: O(1)
//
//Constraints:
//1 <=  n, m <= 105
//1 <= arr[i] <= 106    

package BinarySearchQuestions;


// binary search solution was simple but if the range of search is not  taken carefully the answer will not be achoved
// approch :
// we take start = maxpages,
// and take end as sum of all pages 
// now we just calculate the mid and returnt that if the students are allocated at mid page is ppssible or not 
//time complexity = O(n log n)

public class BookallocationFromGandG {
	 public static long findPages(int n, int[] arr, int m) {
		 int start =Integer.MIN_VALUE;
		 int end = 0;
	        if(m>n){return -1;}
	        for(int x: arr){
	          end=end+x;
	          start = Math.max(x, start);
	        }
	        
	      long ans =0;
	      while(start<=end){
	          int mid = start+(end-start)/2;
	          if(getm(arr,mid,m)){
	        	  ans=mid;
	        	  end= mid-1;
	          }else{
	        	  start=mid+1;
	          }
	      }
	       
	      return ans ;
	    }
	    
	    public static boolean getm(int [] nums,int capacity,int m){
	        int current_page_assigned =0;
	        int student =1;
	        for(int i =0;i<nums.length;i++){
	                current_page_assigned=current_page_assigned+nums[i];
	            if(current_page_assigned>capacity){
	                current_page_assigned=nums[i];
	                student++;
	            }
	        }
	        
	        return student<=m;
	    }
	public static void main(String[] args) {
//				Input: n = 4, arr[] = [12, 34, 67, 90], m = 2
//				Output: 113
		int arr1[] = {12,34,67,90};
		int m1=2;
		int n1 =4;
		int output1=113;
//				Explanation: Allocation can be done in following ways:
//				{12} and {34, 67, 90} Maximum Pages = 191
//				{12, 34} and {67, 90} Maximum Pages = 157
//				{12, 34, 67} and {90} Maximum Pages =113.
//				Therefore, the minimum of these cases is 113, which is selected as the output.
		System.out.println(findPages(n1, arr1, m1));
		if(output1==findPages(n1, arr1, m1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		int arr2[] = {15,17,20};
		int m2=5;
		int n2 =3;
		int output2=-1;
//				Input: n = 3, arr[] = [15, 17, 20], m = 5
//				Output: -1
//				Explanation: Allocation can not be done.
		if(output2==findPages(n2, arr2, m2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
//		this case took me a lot of time because of precise range need to be taken 
		int arr3[] = {13 ,31, 37, 45, 46, 54 ,55, 63, 73, 84, 85};
		int m3=9;
		int n3 =11;
		int output3=85;
		if(output3==findPages(n3, arr3, m3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
	}
}