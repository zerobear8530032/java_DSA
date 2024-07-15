//367. Valid Perfect Square
//Solved
//Easy
//Topics
//Companies
//Given a positive integer num, return true if num is a perfect square or false otherwise.
//
//A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.
//
//You must not use any built-in library function, such as sqrt.
//Example 1:
//Input: num = 16
//Output: true
//Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
//Example 2:
//Input: num = 14
//Output: false
//Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.
// 
//
//Constraints:
//
//1 <= num <= 231 - 1
package BinarySearchQuestions;
public class ValidPerfectSquare_367 {
//	use binary search to find perfect square :
//	
//	time complexity O(log n)
//	approch is similar to find square root only difference is we only take perfect square
//            if mid * mid == num then only num is a perfect square
//	so we will just apply binary seach from 0 to num 
//	case 1 :if mid*mid < num: s=mid+1;
//	case 2 :if mid*mid > num: e=mid-1;
//	case 3 :if mid*mid ==num : return (true)
//	if the search terminate return false;
    public boolean isPerfectSquare(int num) {
        int s =0;
        int e=num;
//        binary search
        while(s<=e){
            long mid=s+(e-s)/2;
            if(mid*mid<num){
                s=(int)mid+1;
            }else if(mid*mid>num){
                e=(int)mid-1;
            }else {
                return true;
            }
        }
        return false;
    }
	public static void main(String[] args) {
		//Example 1:
		int num1 = 16;
		boolean output1= true;
		//Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
		//Example 2:
		int num2 = 14;
		boolean output2= false;
		//Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.

	}

}
