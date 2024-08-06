//1231. Divide Chocolate
//
//You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the
//array sweetness.
//
//You want to share the chocolate with your K friends so you start cutting the chocolate bar into K+1 pieces
//using K cuts, each piece consists of some consecutive chunks.
//
//Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your
//friends.
//
//Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.
//
//Example 1:
//
//Input: sweetness = [1,2,3,4,5,6,7,8,9], K = 5
//Output: 6
//Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]
//
//Example 2:
//
//Input: sweetness = [5,6,7,8,9,1,2,3,4], K = 8
//Output: 1
//Explanation: There is only one way to cut the bar into 9 pieces.
//
//Example 3:
//
//Input: sweetness = [1,2,2,1,2,2,1,2,2], K = 2
//Output: 5
//Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]
//
//Constraints:
//
//    0 <= K < sweetness.length <= 10^4
//    1 <= sweetness[i] <= 10^5
package BinarySearchQuestions;

public class DivideChocolateproblem {
	public static int dividechocolate(int[] chocolate,int k) {
		int start =Integer.MAX_VALUE;
		int end = 0;
		for(int i :chocolate) {
			end = end+i;
			start=Math.min(start,i);
		}
		int ans=0;
		System.out.println(start+" "+end);
		while(start<=end) {
			int mid = start+(end-start)/2;
			if(ispossibletodivide(chocolate,k+1,mid)) {
				ans=mid;
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		return ans;
	}
	
	public static boolean ispossibletodivide(int [] sweetness,int piece,int minsweetness) {
		int count=0;
		int currentsweetness =0;
		for(int i =0;i<sweetness.length;i++) {
			currentsweetness+=sweetness[i];
			if(currentsweetness>=minsweetness) {
				count++;
				currentsweetness=0;
			}
			
		}
		return count>=piece;
		
	}
public static void main(String[] args) {

	//Example 1:
	//
	int []sweetness1 = {1,2,3,4,5,6,7,8,9};
	int k1 = 5;
	int output1=6;
	
	//Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]
	System.out.println("ans "+dividechocolate(sweetness1, k1));
	
	//Example 2:
	//
	int []sweetness2 = {5,6,7,8,9,1,2,3,4};
	int k2 = 8;
	int output2=1;
	System.out.println(dividechocolate(sweetness2, k2));
	
	//Explanation: There is only one way to cut the bar into 9 pieces.
	//
	//Example 3:
	//
	//Input: sweetness = [1,2,2,1,2,2,1,2,2], K = 2
	//Output: 5
	int []sweetness3 = {1,2,2,1,2,2,1,2,2};
	int k3 = 2;
	int output3=5;
	System.out.println(dividechocolate(sweetness3, k3));
	
	//Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]

}
}
