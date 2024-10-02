package Day_21_video21;

public class Comparision {
	public static void main(String[] args) {
//		how to check wheter the s1 and s2 are the same object or not :
		String s1 ="saboor";
		String s2 ="saboor";
//		the equal operator in java checks the values and the object location in the string pool to check compare object
		System.out.println(s1==s2);
		s2="abdul";
		System.out.println(s1==s2);
		s1="abdul";
		System.out.println(s1==s2);		
//		here we allocate a new object with new keyword for the s1 this is now not the same object which was pointed by two
//		but instead its a new object which is allocated out side the string pool and this object is created by user explicitly
		s1= new String("abdul");
		System.out.println(s1==s2);
//		now both  s1,s2 are different object so how to compare the two strings we can use the .equals():
//		this function does not check the reference it only checks the values of the string 
		
		System.out.println(s1.equals(s2));
//		now both are different strings but same character so we can use .equalsIgnorecase
		s1="saboor";
		s2="Saboor";
		System.out.println(s1.equals(s2));
		System.out.println(s1.equalsIgnoreCase(s2));

//		
		
		
		
	}

}
