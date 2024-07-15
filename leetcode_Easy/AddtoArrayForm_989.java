//The array-form of an integer num is an array representing its digits in left to right order.
//For example, for num = 1321, the array form is [1,3,2,1].
//Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
//Example 1:
//Input: num = [1,2,0,0], k = 34
//Output: [1,2,3,4]
//Explanation: 1200 + 34 = 1234
//Example 2:
//Input: num = [2,7,4], k = 181
//Output: [4,5,5]
//Explanation: 274 + 181 = 455
//Example 3:
//Input: num = [2,1,5], k = 806
//Output: [1,0,2,1]
//Explanation: 215 + 806 = 1021
//Constraints:
//1 <= num.length <= 104
//0 <= num[i] <= 9
//num does not contain any leading zeros except for the zero itself.
//1 <= k <= 104

package leetcode_Easy;

import java.util.*;
public class AddtoArrayForm_989 {
    public static List<Integer> addToArrayForm(int[] num, int k) {
    	LinkedList<Integer> result = new LinkedList();
    	for(int i =num.length-1;i>=0;i--) {
    		 result.addFirst((num[i]+k)%10);
             k=(num[i]+k)/10;
    	}
    	
    	while(k>0) {
    		result.addFirst(k%10);
    		k=k/10;
    	}
        return result;
    }

	public static void main(String args[]) {
		int[] num1 = {1,2,0,0}; 
		int k1 = 34;		
		System.out.println(addToArrayForm(num1,k1));

		int []num2 = {2,7,4};
		int k2 = 181;
		System.out.println(addToArrayForm(num2,k2));
		
		int [] num3 ={4,5,5};
		int k3=806;
		System.out.println(addToArrayForm(num3,k3));

}
}
