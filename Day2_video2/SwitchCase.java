package Day2_video2;

import java.util.Scanner;

public class SwitchCase {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
//	System.out.println("Enter a Fruit Name");
//	String fruit =sc.next();
//	
//	switch(fruit) {
//	case "mango":
//		System.out.println("King of Fruit");
//		break;
//	case "apple":
//		System.out.println("sweet red Fruit");
//		break;
//	case "orange":
//		System.out.println("its a color or a Fruit");
//		break;
//	case "grapes":
//		System.out.println("small Fruit");
//		break;
//	default:
//		System.out.println("IDK this fruit");
//		
//	}
//	
//	switch(fruit) {
//	case "mango"->System.out.println("King of fruits");
//	case "apple"->System.out.println("sweet red Fruit");
//	case "orange"->System.out.println("its a color or a Fruit");
//	case "grapes"->System.out.println("small Fruit");
//	default->System.out.println("IDK this fruit");
//	}
	
	System.out.println("Enter a Day Number");
	int day =sc.nextInt();
	switch(day) {
	case 1->{
		System.out.println("Sunday");		
	}
	case 2->{
		System.out.println("Monday");		
	}
	case 3->{
		System.out.println("Tuesday");		
	}
	case 4->{
		System.out.println("Wednesday");		
	}
	case 5->{
		System.out.println("Thursday");		
	}
	case 6->{
		System.out.println("Friday");		
	}
	case 7->{
		System.out.println("Saturday");		
	}
	default->System.out.println("Invalid number enter 1 to 7");		
	}
	
}
}
