package utili.usefullib;

import java.util.StringTokenizer;

public class Tokenizer {
	public static void main(String[] args){
		String express1 = "x=100*(300+200)/2";
		String express2 = "100,20,30,40,50";
		
		StringTokenizer st = new StringTokenizer(express1, "+=*/()");
		printTokenizer(st);
		
		st = new StringTokenizer(express2, ",");
		printTokenizer(st);
	}
	
	public static void printTokenizer(StringTokenizer st){
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}
	}
}
