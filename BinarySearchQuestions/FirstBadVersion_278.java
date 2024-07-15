//278. First Bad Version
//Solved
//Easy
//Topics
//Companies
//You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
//
//Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
//
//You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
//Example 1:
//Input: n = 5, bad = 4
//Output: 4
//Explanation:
//call isBadVersion(3) -> false
//call isBadVersion(5) -> true
//call isBadVersion(4) -> true
//Then 4 is the first bad version.
//Example 2:
//Input: n = 1, bad = 1
//Output: 1

//Constraints:
//
//1 <= bad <= n <= 231 - 1

package BinarySearchQuestions;
//***********************************************************************
//note this is created 'VersionControl' for demonstration purposes only
//***********************************************************************
class VersionControl{
	static int version ;
	
	public VersionControl() {
		
	}
	
	public VersionControl(int v) {
		version=v;
	}
	
	public static boolean isBadVersion(int x) {
		if(x<version) {
			return false;
		}else {
			return true;
		}
	}
	
}
public class FirstBadVersion_278 extends VersionControl{
	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */
// given : their a input which is the upper limit of a range which is the last version which is bad we have to find
//	the first bad version and its given if a single bad version is found then all the next version will be bad 
//	so it is very similar to binary search as all good version are one side and all bad version will be on other side
//	so we can apply a simple binary seach  from 0 till last version n
//	case 1:and if(isBadVersion(mid)==true){e=mid-1}: means we are in the right side array where bad versions are 
//	and we need to search the first bad version so that will be on the left side
//	
//	case 2:and if(isBadVersion(mid)==false){s=mid+1}: means we are in the left side array where only good versions are 
//	and we need to search the first bad version so that will be on the right side
	
//	at last our binary seach will terminate where s>e and because the bad version will be on the right side we will return the bigger one btw s,e which is s
  public static int firstBadVersion(int n) {
	  int s =0;
      int e =n;
      while(s<=e){
          int mid =s+(e-s)/2;
          if(isBadVersion(mid)){
        	  e=mid-1;
          }else{
        	  s=mid+1;
          }
      }
      return s;
  
  }
  
  public static void main(String[] args) {
	//Example 1:
	  VersionControl version ;
	  int n1 = 5, output1= 4;
	  version= new VersionControl(output1);
	//Explanation:
	//call isBadVersion(3) -> false
	//call isBadVersion(5) -> true
	//call isBadVersion(4) -> true
	//Then 4 is the first bad version.
	  if(output1==firstBadVersion(n1)) {
		  
		  System.out.println("Case 1 Passed");
	  }else {
		  System.out.println("Case 1 Failed");		  
	  }
	  
	  
	  //Example 2:
	  int n2 = 1, output2= 1;
	  version= new VersionControl(output2);
	  
	  if(output2==firstBadVersion(n2)) {
		  System.out.println("Case 2 Passed");
	  }else {
		  System.out.println("Case 2 Failed");		  
	  }

	  
	
}
}

