import java.io.*;
import java.util.*;

public class Main {

    //pepCoding to PEPcOIDING
    public static String toggleCase(String str){
		StringBuilder sb = new StringBuilder(str);
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if(ch>='A' && ch<='Z'){
				char lc =(char)( ch+'a'-'A');
				sb.setCharAt(i,lc);
			}else{
				char uc =(char) (ch+'A'-'a');
				sb.setCharAt(i,uc);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
	}

}