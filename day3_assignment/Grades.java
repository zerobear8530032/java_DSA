package day3_assignment;

import java.util.Scanner;

public class Grades {
	static void grade(int marks) {
		
		if(marks>=91 && marks<=100) {
			System.out.println("Grade : AA");
		}else if(marks>=81 && marks<=90){
			System.out.println("Grade : AB");			
		}else if(marks>=71 && marks<=80){
			System.out.println("Grade : BB");
		}else if(marks>=61 && marks<=70){
			System.out.println("Grade : BC");
		}else if(marks>=51 && marks<=60){
			System.out.println("Grade : CD");
		}else if(marks>=41 && marks<=50){
			System.out.println("Grade : DD");
		}else if(marks>=0 && marks<=40) {
			System.out.println("Fail");
		}else {
			System.out.println("Invalid marks");	
		}
		
	}
	
	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Your Marks Out Of 100 : ");
	int marks=sc.nextInt();
	grade(marks);
	
}
}
