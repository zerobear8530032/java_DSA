package Day_21_video21;

import java.util.ArrayList;

public class prettyprinting {
public static void main(String[] args) {
	float num1=3.5357f;
//	so we can use format or printf to prinnt like we use c++:
	System.out.format("\nFormatted Number is : %.100f",num1);
	System.out.format("\nFormatted Number is : %.1f",num1);
	System.out.format("\nFormatted Number is : %.2f",num1);
	System.out.printf("\nFormatted Number is : %.100f",num1);
	System.out.printf("\nFormatted Number is : %.1f",num1);
	System.out.printf("\nFormatted Number is : %.2f",num1);
	
	System.out.printf("\n hello !%s , welcome to %s\n","saboor","java");
	
//	operator :
//	herer char conver to int
	
	System.out.println('a'+'b');
//	here 2 stirng concat
	
	System.out.println("a"+"b");
//	here string concat the char 
	System.out.println("a"+'b');
	
//	here string concat the int 
//	by convert the int to integer
	System.out.println("a"+1);
	
	ArrayList<Integer> test = new ArrayList();
	test.add(34);
	test.add(33);
//	here also test tostring method execute and added as a string to the strinfg a
//	here string concat the int 
//	by convert the int to integer
	System.out.println("a"+test);
// not possible: because we can do + on any 2 primitive or a single string 
	//	System.out.println('a'+test);
	
// not possible
	//	System.out.println(34+test);
	
// not possible: because we can do + on any 2 primitive or a single string 
		System.out.println('a'+""+test);
	
// not possible
		System.out.println(34+""+test);

	
	
}
}
