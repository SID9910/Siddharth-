import java.io.*;
import java.util.*;

public class Main {

   public static boolean isPalindrome(String str){
	   Boolean flag =true;

	   int left =0;
	   int right = str.length()-1;
	   while(left<right){
		   if(str.charAt(left)!=str.charAt(right)){
			   flag = false;
		   }
		   left++;
		   right--;
		   
	   }
	   return flag;
   }

	public static void solution(String str){
		for(int i=0;i<str.length();i++){
			for(int j=i+1;j<=str.length();j++){
				String jump =str.substring(i,j);
				if(isPalindrome(jump)==true){
					System.out.println(jump);
				}
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}