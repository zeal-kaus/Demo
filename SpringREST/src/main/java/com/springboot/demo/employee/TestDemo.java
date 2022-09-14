package com.springboot.demo.employee;

import java.util.Arrays;
import java.util.List;

public class TestDemo {
static int revNum = 0;

public static int getReverse(int num) {
	if(num > 0) {
		revNum = (revNum * 10) + (num % 10);
		getReverse(num/10);
	}
	return revNum;
}
	
	
	public static void main(String[] args) {
		System.out.println("Reverse of 12345 is "+getReverse(12345));
		List a = Arrays.asList(3,3,4,7,8);
		
		/*
		 * String s1 = new String("Abc");
		 * System.out.println("S1 = "+System.identityHashCode(s1));
		 * System.out.println("S1 = "+s1.hashCode());
		 * System.out.println("S1 = "+Objects.hashCode(s1));
		 * 
		 * String s2 = "Abc"; System.out.println("S2 = "+System.identityHashCode(s2));
		 * System.out.println("S2 = "+s2.hashCode());
		 * System.out.println("S2 = "+Objects.hashCode(s2));
		 * 
		 * String s3 = new String(s2);
		 * System.out.println("S3 = "+System.identityHashCode(s3));
		 * System.out.println("S3 = "+s3.hashCode());
		 * System.out.println("S3 = "+Objects.hashCode(s3));
		 * 
		 * String s4 = "Abc"; System.out.println("S4 = "+System.identityHashCode(s4));
		 * System.out.println("S4 = "+s4.hashCode());
		 * System.out.println("S4 = "+Objects.hashCode(s4));
		 */
	}

}
