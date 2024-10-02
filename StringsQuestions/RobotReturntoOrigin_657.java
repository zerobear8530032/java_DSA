//657. Robot Return to Origin
//Solved
//Easy
//Topics
//Companies
//There is a robot starting at the position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.
//
//You are given a string moves that represents the move sequence of the robot where moves[i] represents its ith move. Valid moves are 'R' (right), 'L' (left), 'U' (up), and 'D' (down).
//
//Return true if the robot returns to the origin after it finishes all of its moves, or false otherwise.
//
//Note: The way that the robot is "facing" is irrelevant. 'R' will always make the robot move to the right once, 'L' will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.
//
//
//Example 1:
//
//Input: moves = "UD"
//Output: true
//Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.
//Example 2:
//
//Input: moves = "LL"
//Output: false
//Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is not at the origin at the end of its moves.
// 
//
//Constraints:
//
//1 <= moves.length <= 2 * 104
//moves only contains the characters 'U', 'D', 'L' and 'R'.

package StringsQuestions;

public class RobotReturntoOrigin_657 {
//	simple 2 variable x acxis and y : if we see L we deceremebt x if we see R we increment x 
//   same for U increment y for D we can decerenent y
	//	time complexity O(n) :
	public static boolean judgeCircle(String moves) {
	     int x = 0, y=0;
	     for(int i =0;i<moves.length();i++){
	        if(moves.charAt(i)=='U'){y++;}
	        if(moves.charAt(i)=='D'){y--;}
	        if(moves.charAt(i)=='L'){x--;}
	        if(moves.charAt(i)=='R'){x++;}
	     }

	     return   x==0 && y==0;
	    }
//	just a same approch here i used the array 
	public static boolean judgeCircleanother(String moves) {
		int[] move = {0 ,0};
		for(int i =0;i<moves.length();i++){
			if(moves.charAt(i)=='U'){move[0]++;}
			if(moves.charAt(i)=='D'){move[0]--;}
			if(moves.charAt(i)=='L'){move[1]--;}
			if(moves.charAt(i)=='R'){move[1]++;}
		}
		
		return   move[0]==0 && move[1]==0;
	}
	
public RobotReturntoOrigin_657() {
	
	//Example 1:
	//
	String moves1 = "UD";
	boolean output1= true;
	//Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.
	if(judgeCircle(moves1)==output1) {
		System.out.println("Case 1 Passed ");
	}else {
		System.out.println("Case 1 Failed");		
	}
	
	
	//Example 2:
	//
	//Input: moves = "LL"
	String moves2 = "LL";
	boolean output2= false;
	//Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is not at the origin at the end of its moves.

	if(judgeCircle(moves2)==output2) {
		System.out.println("Case 2 Passed ");
	}else {
		System.out.println("Case 2 Failed");		
	}
	
	
	
	if(judgeCircleanother(moves1)==output1) {
		System.out.println("Case 1 Passed ");
	}else {
		System.out.println("Case 1 Failed");		
	}
	if(judgeCircle(moves2)==output2) {
		System.out.println("Case 2 Passed ");
	}else {
		System.out.println("Case 2 Failed");		
	}
	
}
}
