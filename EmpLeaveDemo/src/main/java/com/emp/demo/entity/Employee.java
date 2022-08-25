package com.emp.demo.entity;

public class Employee {
  
  private static final long serialVersionUID = 1L;

	public int eId;
	public String name;
	public int leavesTaken;
	public int availableLeaves;

	public Employee() {
	  
	}
	
	public Employee(int eId, String name, int leavesTaken, int availableLeaves) {
		super();
		this.eId = eId;
		this.name = name;
		this.leavesTaken = leavesTaken;
		this.availableLeaves = availableLeaves;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLeavesTaken() {
		return leavesTaken;
	}

	public void setLeavesTaken(int leavesTaken) {
		this.leavesTaken = leavesTaken;
	}

	public int getAvailableLeaves() {
		return availableLeaves;
	}

	public void setAvailableLeaves(int availableLeaves) {
		this.availableLeaves = availableLeaves;
	}

  @Override
  public String toString() {
    return "Employee [Id=" + geteId() + ", Name=" + getName() + ", LeavesTaken=" + getLeavesTaken() + ", AvailableLeaves="
        + getAvailableLeaves() + "]";
  }
  
  
}
