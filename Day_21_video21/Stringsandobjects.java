package Day_21_video21;

public class Stringsandobjects {
	public static void main(String[] args) {
// here a is a simple primitive data types :a it store integer
//	here both a , b are 2 different objects where a is inside a stack pointing to 234 
//		and b is also in the stack and pointing to the 234 which is different object inside the heap memeory 
	
	int a =234;
	int b =234;
	System.out.println(a);
	System.out.println(b);
	
//	here  both arr 1 and arr 2 are different reference point to different object 
	int [] arr1 = {2,5,2};
	System.out.println("Address"+arr1);
	int [] arr2 = {2,5,2};
	System.out.println("Address"+arr2);
//	but here the arr3 and arr1 are having 2 reference pointing to same object in the memory [2,5,2]
	int[] arr3=arr1;
	System.out.println("Address"+arr3);
//	we can see both arr 1 and arr 3 have same address while arr 2 have different
//	in case of array we can make change from both reference variables and change will get refect to the both arrays 
//	 but this case got chnaged when we talk about strings
	
	
//	this is a type of string variable which can store mutiple character and denotes by double quotes:
	
//	here both n1 , n2 are 2 reference of same object "abdul saboor"
	String n1="abdul saboor";
	String n2="abdul saboor";
	
	
	
//	how this works is :
//	when we create any new variable the name of variable called referce or pointer like int a =34
//	herer a is the reference and 34 is the value which is store in the heap which took 32 bit space there because of type int
//	but when we talk about the string these thing changes a bit 
//	 1 > strings are immutable in java means we cannot change them :  why >? for security 
//	 2 > the string are not change at all every time we try to apply a function on string we get a new string in return 
//	 now how it works :
	
//	this works with the help of a term string pool . it is a location or should i say a space in heap memory which 
//	store the strings
//	but why do we required string pools :
//	the sttring pool is a data structure that store the string when ever we create  a string if that string 
//  already exists we does not need to reallocate it a new one instead the pointer points to the available string
//	this help is making the program more optimize it does not required to allocate new memeory 
	
//	here also both n1,n2 are same reference of one object so if we change from one reference the change should reflect on other  right????
//	in string these are immutable so if wetry to make changes a new object will get allocated
//	the the previous one remain there it can get removed during garbage collection but  it wont changes
	
	
	System.out.println(n1);
	System.out.println(n2);
	
//	if we assign n1 then the prevoius object will remain in string pool untill garbage collection hits
	n1 = "saboor";
// and a anew object will allocate in the string pool "saboor" where the n1 will point and the prevoius string will remain until garbage collection hits	
	
//	now we created a new object with new keyword inside string pool now n1 is pointing to prevoius one 
//	and n2 have its own new object 
	n2 = new String("saboor");
	System.out.println(n2);
	
	
	
	}

}
