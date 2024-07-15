package day3_assignment;
import java.util.Scanner;
public class Voter {
static void canvote(int age) {
if(age>=18) {
	System.out.println("you can vote");
}else {
	System.out.println("you cannot  vote");
	
}

}
	public static void main(String args[]) {
Scanner sc = new Scanner(System.in);
System.out.println("Enter the Age");
int age=sc.nextInt();
canvote(age);

}
}
