//374. Guess Number Higher or Lower
//Solved
//Easy
//Topics
//Companies
//We are playing the Guess Game. The game is as follows:
//
//I pick a number from 1 to n. You have to guess which number I picked.
//
//Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
//
//You call a pre-defined API int guess(int num), which returns three possible results:
//
//-1: Your guess is higher than the number I picked (i.e. num > pick).
//1: Your guess is lower than the number I picked (i.e. num < pick).
//0: your guess is equal to the number I picked (i.e. num == pick).
//Return the number that I picked.
//
// 
//
//Example 1:
//
//Input: n = 10, pick = 6
//Output: 6
//Example 2:
//
//Input: n = 1, pick = 1
//Output: 1
//Example 3:
//
//Input: n = 2, pick = 1
//Output: 1
// 
//
//Constraints:
//
//1 <= n <= 231 - 1
//1 <= pick <= n
package BinarySearchQuestions;
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */
class guessNum{
	static int n;
	public guessNum(int num){
		n=num;
	}
	public guessNum(){
	
	}
	
	public static int guess(int num) {
		if(num==n) {
			return 0;
		}else if(num>n) {
			return -1;
		}else {
			return 1;
		}
	}
	
}
public class GuessTheNumberHigherOrLower_374 extends guessNum{
//	approch we have a class nameguess number which give a range as input and we have to found a number 
//	we can use a guess(x) method which return our number is greater or equal or smaller
//	so we can apply a binary seach from 0 to n where 
//	if (guess(mid) == 0) return mid;
//	if(guess(mid)==-1) e=mid-1 -> means the number is smaller then mid we need to check on left side
//	if(guess(mid)==1) s=mid+1 -> means the number is greater then mid we need to check on right side
	   public static int guessNumber(int n) {
		     int s =0;
		     int e = n;
		     while(s<=e){
		        int mid =s+(e-s)/2;
		        if(guess(mid)==0){
		            return mid;
		        }else if(guess(mid)==-1){
		            e=mid-1;
		        }else{
		            s=mid+1;
		        }
		     }
		     return -1;  
		    }
	   public static void main(String args[]) {
		 //Example 1:
		 int  n1 = 10; 
		 int pick1 = 6;
		 guessNum obj = new guessNum(pick1);
		 if(pick1==guessNumber(n1)) {
			 System.out.println("Case 1 Passed");
		 }else {
			 System.out.println("Case 1 Failed");			 
		 }
		 
		 //Example 2:
		 int  n2 = 1; 
		 int pick2 = 1;	 
		 obj = new guessNum(pick2);
		 if(pick2==guessNumber(n2)) {
			 System.out.println("Case 2 Passed");
		 }else {
			 System.out.println("Case 2 Failed");			 
		 }
		 //Example 3:
		 int  n3 = 2; 
		 int pick3 = 1;
		 obj = new guessNum(pick3);
		 if(pick3==guessNumber(n3)) {
			 System.out.println("Case 3 Passed");
		 }else {
			 System.out.println("Case 3 Failed");			 
		 }
	   }
}
