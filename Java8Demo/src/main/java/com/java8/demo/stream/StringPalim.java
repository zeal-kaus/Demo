package com.java8.demo.stream;

public class StringPalim {

	public static void main(String[] args) {
		String original = "radar";
		StringBuilder sb = new StringBuilder(original);
		sb = sb.reverse();
		System.out.println("String is Palimdrome "+original.equalsIgnoreCase(sb.toString()));
	}

}
