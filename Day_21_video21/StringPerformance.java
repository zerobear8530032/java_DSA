package Day_21_video21;
public class StringPerformance {
public static void main(String[] args) {
//	this way of doing   it is very inefficient : why?
	
	String series ="";
	for ( int i =0;i<26;i++) {
		char ch = (char)('a'+i);
		System.out.println("ch:"+ch);
//		here when we do series+=ch every time it append a new char it creates a new string which means
//		every time a new string is allocated in string pool for new string generated and the prevous object are not even required 
		
		series+=ch;
	}
	System.out.println("Series "+series);
}
}
