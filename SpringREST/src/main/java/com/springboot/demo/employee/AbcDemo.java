package com.springboot.demo.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbcDemo {

	public static List<List<String>> Anagrams(String[] str) {
		List<List<String>> al = new ArrayList<>();

		String str_copy[] = str.clone();
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]+", ");
		}
		for (int i = 0; i < str.length; i++) {
			char str_char[] = str[i].toCharArray();
			Arrays.sort(str_char);
			str[i] = String.valueOf(str_char);
		}
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]+", ");
		}
		HashMap<String, ArrayList<String>> hs = new HashMap<>();

		for (int i = 0; i < str.length; i++) {
			if (hs.containsKey(str[i]) == false)
				hs.put(str[i], new ArrayList<>());

			hs.get(str[i]).add(str_copy[i]);
		}

		for (Map.Entry<String, ArrayList<String>> entry : hs.entrySet())
			al.add(entry.getValue());

		return al;
	}

	public static void main(String[] args) {
		String[] words = { "cat", "dog", "god", "act", "tac" };
		System.out.println(AbcDemo.Anagrams(words));
	}

}
