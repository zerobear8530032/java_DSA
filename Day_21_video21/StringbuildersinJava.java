package Day_21_video21;

import java.util.Arrays;

public class StringbuildersinJava {
//	this is a string builder class which allow tp changes the actual object and it is mutables
//	in string because it was immutable it required way extra space for each changes maded to string 
//	here string builder allow us to chaneg the string without making actually a new 
//	string instead changing existing ones 
public static void main(String[] args) {
	StringBuilder str1 = new StringBuilder();
	StringBuilder str2=str1;
	for(int i =0;i<26;i++) {
		char ch=(char)(i+'a');
		str1.append(ch);
	}
	
	System.out.println(str1);
	System.out.println(str2);
	String str="saboor";
	char ch []=str.toCharArray();
	
	str1.trimToSize();
	System.out.println(str1);
	System.out.println(Arrays.toString(ch));
	
} 
}
