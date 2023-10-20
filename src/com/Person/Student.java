package com.Person;

public class Student extends Person {
	
	private int rollNo;
	private String name;
	private String Branch;
	private String year;
	public Student() {
		super();
	}
	public Student(String name, String emailId, String mobileNo, String address, String dob,int rollNo,String branch,String year) {
		super(name, emailId, mobileNo, address, dob);
		this.rollNo = rollNo;
		Branch = branch;
		this.year = year;
	}

	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", Branch=" + Branch + ", year=" + year + ", emailId="
				+ emailId + ", mobileNo=" + mobileNo + ", address=" + address + ", dob=" + dob + "]";
	}
	
	
	
}
