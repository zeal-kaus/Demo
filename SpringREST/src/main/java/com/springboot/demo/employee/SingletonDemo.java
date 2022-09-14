package com.springboot.demo.employee;

class MySingleton {

	private static MySingleton singleInstance = null;
	private static int i = 0;

	private MySingleton() {
		System.out.println("Singleton Objected created " + ++i);
	}

	public static MySingleton getSingletonInstance() {
		if (singleInstance == null) {
			singleInstance = new MySingleton();
		}
		return singleInstance;
	}
}

public class SingletonDemo {

	public static void main(String[] args) {
		MySingleton mySingleton = null;
		for (int i = 0; i < 10; i++) {
			mySingleton = MySingleton.getSingletonInstance();
			System.out.println(mySingleton + " : " + System.identityHashCode(mySingleton));
		}
	}
}
