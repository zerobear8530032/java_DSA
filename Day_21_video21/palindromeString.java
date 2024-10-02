package Day_21_video21;

public class palindromeString {
	public static boolean ispalindrome(String str) {
		if(str==null || str.length()==0) {return true;}
		str= str.toLowerCase();
		int start =0;
		int end = str.length()-1;
		while(start<=end) {
			if(str.charAt(start)!=str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
public static void main(String[] args) {
	String str1 = "aaaaazxdaaaaa";
	String str2 = "aaaabbbbaaaa";
	System.out.println(ispalindrome(str1));
	System.out.println(ispalindrome(str2));
	System.out.println(ispalindrome(null));
}
}
