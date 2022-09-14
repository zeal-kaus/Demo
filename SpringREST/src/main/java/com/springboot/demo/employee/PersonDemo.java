package com.springboot.demo.employee;

class Person {

	void display() throws ClassNotFoundException {
		System.out.println("In Person Display");
	}

	void displayPerson() {
		System.out.println("In Person DisplayPerson");
	}
}

class Staff extends Person {

	void display() throws ClassNotFoundException {
		System.out.println("In Staff Display");
	}

	void displayStaff() {
		System.out.println("In Staff DisplayStaff");
	}
}

class TempStaff extends Staff {

	void display() throws ClassNotFoundException {
		System.out.println("In TempStaff Display");
		throw new ClassNotFoundException();
	}

	void displayTempStaff() {
		System.out.println("In TempStaff DisplayTempStaff");
	}
}

public class PersonDemo {

	public static final void main(String[] args) throws ClassNotFoundException {
		Staff p // Staff's -> Non overridden methods + Parent Methods
			= new TempStaff(); // TempStaff's -> overridden methods only 
		p.display();
		p.displayStaff();
	}
	
	public static void main(String[] args, int q) {
		
	}

}
