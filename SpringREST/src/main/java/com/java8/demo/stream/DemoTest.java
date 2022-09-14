package com.java8.demo.stream;

public class DemoTest {

	static String stringReverse() {
		
		return null;
	}
	
	public static void main(String[] args) {
		//LIRIL
		//AABBCD - > ABCBA
		//AABB 
		//AABB CCC DDD -> 
		String s = "LIRIL";
		StringBuilder sb = new StringBuilder(s);
		StringBuilder afterReverse = sb.reverse();
		String sr = new String(afterReverse);
		if(sr.equalsIgnoreCase(s)) {
			System.out.println("String is Palimdrome");
		}
		
	}

}
