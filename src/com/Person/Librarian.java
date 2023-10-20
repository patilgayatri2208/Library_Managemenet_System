package com.Person;

public class Librarian extends Person {

	private int id;
	private String doj;
	public Librarian() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Librarian(String name, String emailId, String mobileNo, String address, String dob) {
		super(name, emailId, mobileNo, address, dob);
		// TODO Auto-generated constructor stub
	}
	public Librarian(int id, String doj) {
		super();
		this.id = id;
		this.doj = doj;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	@Override
	public String toString() {
		return "Librarian [id=" + id + ", doj=" + doj + ", name=" + name + ", emailId=" + emailId + ", mobileNo="
				+ mobileNo + ", address=" + address + ", dob=" + dob + "]";
	}
	
}
