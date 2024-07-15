package Day2_video2;

import java.util.Scanner;

public class Conditions {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	int x =sc.nextInt();
	
	if(x>1000) {
		x=x+100;
	}else {
		x=x+50;
	}
	
	System.out.println("after bonus new sal :"+x);
	
	
	
	
}
}
