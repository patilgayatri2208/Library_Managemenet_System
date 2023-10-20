package com.Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;

public class StudentManager {

	ObjectOutputStream oos_student = null;
	ObjectInputStream ois_student=null;
	
	File student_file= new File("student.dat");
	ArrayList<Student> student_list = null;
	
	@SuppressWarnings("unchecked")
	public StudentManager() {
		student_list=new ArrayList<Student>();
		if(student_file.exists())
		{
			try {
				ois_student = new ObjectInputStream(new FileInputStream(student_file));
				student_list=(ArrayList<Student>) ois_student.readObject();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void addAStudent(Student student)
	{
		student_list.add(student);
	}
	
	public Student get(int rollNo)
	{
		for(Student student:student_list) {
			if(student.getRollNo()==rollNo)
				return student;
		}
		return null;
	}
	public void viewAllStudent()
	{
		for(Student student1:student_list)
			System.out.println(student1);
	}
	
	public boolean deleteStudent(int delete_rollNo)
	{
		ListIterator<Student> stud_iterator = (ListIterator<Student>) student_list.listIterator();
		while (stud_iterator.hasNext()) {
			Student student = stud_iterator.next();
			if (student.getRollNo()==delete_rollNo) {
				student_list.remove(student);
				return true;
			}
		}
		return false;
	}
	
	public boolean updateStudent(int update_rollNo,String name, String emailId, String mobileNo, String address, String dob,String branch,String year) {
		ListIterator<Student> stud_iterator = (ListIterator<Student>) student_list.listIterator();
		while (stud_iterator.hasNext()) {
			Student student = stud_iterator.next();
			if (student.getRollNo()==update_rollNo) {
				student.setAddress(address);
				student.setBranch(branch);
				student.setDob(dob);
				student.setEmailId(emailId);
				student.setMobileNo(mobileNo);
				student.setName(name);
				student.setYear(year);
				return true;
			}		
	}
		return false;
	}
	
	public void writeToFile() {
		try {
			oos_student = new ObjectOutputStream(new FileOutputStream(student_file));
		    oos_student.writeObject(student_list);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
