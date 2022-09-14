package com.java8.demo.stream;

public class TestDemo {

	static String reverseString(String s) {
		String newRevereseString = new String();
		for (int i = s.length() - 1; i >= 0; i--) {
			newRevereseString = newRevereseString + s.charAt(i);
		}
		return newRevereseString;
	}

	static String getResult(String input) {
		
		String finalResult = "";
			for(int i=0;i<input.length(); i++) {
				if(input.charAt(i) == '_') {
					input.replace("_", "");
					//input.
				}
				String tempString = Character.toString(input.charAt(i));
				if(tempString.equalsIgnoreCase("_")) {
					tempString = Character.toString(input.charAt(++i));
					finalResult += tempString.toUpperCase();	
				} else {
					finalResult += tempString;
				}	
			}
			return finalResult;
		}

	
	public static void main(String[] args) {

		 String s = "123";
	        for(int i =0; i< s.length(); i++){
	            char a = s.charAt(i);
	            int d = a;
	            System.out.println(d);
	        }
		
		//System.out.println(reverseString("ABCDE"));
		//System.out.println(getResult("find_me_in_list"));
		 //new Thread(() -> System.out.println("New thread created")).start();
	}

}
