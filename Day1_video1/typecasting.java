package Day1_video1;

import java.util.Scanner;

public class typecasting {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
//	implicit type conversion
//	float num =sc.nextFloat();// input 23
//	System.out.println(num);//output :23.0
//	 explicit type convertion
	int x=(int)34.5f;
	System.out.println(x);
	byte a=(byte)(257);//256%257
	System.out.println(a);
	String str="你好";	
	System.out.println(0+str.charAt(1));
	boolean b1=true;
	boolean b2=false;
}
}
