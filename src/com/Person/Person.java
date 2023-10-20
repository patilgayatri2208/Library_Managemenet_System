package com.Person;

import java.io.Serializable;

abstract public class Person implements Serializable{

	protected String name;
	protected String emailId;
	protected String mobileNo;
	protected String address;
	protected String dob;
	public Person() {
		super();
	}
	public Person(String name, String emailId, String mobileNo, String address, String dob) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.address = address;
		this.dob = dob;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", address=" + address
				+ ", dob=" + dob + "]";
	}
	
	
	}
