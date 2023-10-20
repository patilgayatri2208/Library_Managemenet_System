package com.main;

import java.util.Scanner;

import com.Book.Book;
import com.Book.BookManager;
import com.Person.Student;
import com.Person.StudentManager;
import com.Transcation.Book_TransactionManager;
import com.exception.BookNotFoundException;
import com.exception.StudentNotFoundException;

public class Main {

	@SuppressWarnings("null")
	public static void main(String[] args) throws StudentNotFoundException {

		int ch;
		
		Scanner sc = new Scanner(System.in);
		
		BookManager bm = new BookManager();
		StudentManager sm = new StudentManager();
		Book_TransactionManager btm = new Book_TransactionManager();
		
		do {
			System.out.println("1.Student \n"
							 + "2.Librarian \n"
				             + "3.Exit");
			ch = sc.nextInt();
			switch(ch){
			case 1:			// Student
				System.out.println("Enter your Roll No");
				int rollNo = sc.nextInt();
				try {
					Student s = sm.get(rollNo);
					if(s==null)
						throw new StudentNotFoundException();
					int stud_ch = 0;
					do {
						System.out.println("1. view All Books  \n"
										+ "	2. Search Book by ISBN  \n"
										+ "	3.List Book By Subject  \n"
								        + " 4.Issue a Book"
								        + "	5.Return a Book"
								        + " 99.Exit");
						stud_ch = sc.nextInt();
						switch(stud_ch) {
						case 1:
							System.out.println("All the book Record are");
							bm.viewAllBook();
							break;
						case 2:
							System.out.println("Enter ISBN to Search");
							int search_isbn = sc.nextInt();
							Book book = bm.searchBookByIsbn(search_isbn);
							if(book == null)
								System.out.println("No book with this ISBN");
							else
								System.out.println(book);
							break;
						case 3:
							System.out.println("Enter the Subject Search");
							sc.nextLine();
							String search_sub = sc.nextLine();
							bm.listBooksBySubject(search_sub);
							break;
						case 4:
							System.out.println("Enter the ISBN to issue a book");
							int issue_isbn = sc.nextInt();
							 book= bm.searchBookByIsbn(issue_isbn);
							try {
							if(book!=null) {
								throw new BookNotFoundException();
							 }
							if(book.getAval_quantity()>0) {
								if(btm.issueBook(rollNo, issue_isbn)) {
									book.setAval_quantity(book.getAval_quantity()-1);
									System.out.println("Book has been Issued");
								}
							}
							else {
								System.out.println("The book has not been isuued.....");
							}
							}catch (BookNotFoundException e) {
								System.out.println(e);
							}	
							
							break;
						case 5:
							System.out.println("Enter the ISBN to Return the Book");
							int return_isbn=sc.nextInt();
							book = bm.searchBookByIsbn(return_isbn);
							if(book != null) {
								if(btm.returnBook(rollNo, return_isbn)) {
									book.setAval_quantity(book.getAval_quantity()+1);
									System.out.println("Thank you for returning a book");
								}
								else
									System.out.println("Could not return a book");

									
							}
							else
								System.out.println("Book with this ISBN does not exsist");
							break;
						case 99:
							System.out.println("Thank you for using Library");
							break;
						default:
							System.out.println("Invalid Choice");
							
						}
					}while(stud_ch != 99);
				}
				catch(StudentNotFoundException snfe)
				{
					System.out.println(snfe);
				}
				break;
			case 2:				//Librarian
				int lib_ch = 0;
				do {
				System.out.println("\n \n 11.view all Students \n	"
								+ "12.print a student by roll no \n"
								+ " 13.Add a student \n"
								+ " 14.Update a Student \n"
								+ " 15. delete a Student \n"
								+ " 21.view all Books \n"
								+ " 22. Print a Book by ISBN \n"
								+ " 23.Add a new Book \n"
								+ " 24. Update a Book \n"
								+ " 25.Delete a Book \n"
								+ " 31.view all Transactions \n"
								+ " 99.Exit");
				lib_ch = sc.nextInt();
				switch (lib_ch) {
				case 11: // view all Student
					System.out.println("All Student Record");
					sm.viewAllStudent();
					break;
				case 12: // search a student based on roll no
					System.out.println("Enter the roll no to fetch record");
					int get_rollNo = sc.nextInt();
					Student stud = sm.get(get_rollNo);
					if(stud== null)					
						System.out.println("No Record Maches Roll No");
					else
						System.out.println(stud);
					break;
				case 13:
					System.out.println("Enter Students Details to add");
					String name,emailId,mobileNo,address,dob,branch,year;
					int rollNo1;
					sc.nextLine();
					System.out.println("Roll Number");
					rollNo1 = sc.nextInt();
					sc.nextLine();
					System.out.println("Name");
					name = sc.nextLine();
					System.out.println("EmailId");
					emailId = sc.nextLine();
					System.out.println("Mobile Number");
					mobileNo = sc.nextLine();
					System.out.println("Address ");
					address = sc.nextLine();
					System.out.println("Date of Birth");
					dob = sc.nextLine();
					System.out.println("Branch");
					branch = sc.nextLine();
					System.out.println("year ");
					year = sc.nextLine();
					Student student = new Student(name,emailId,mobileNo,address,dob,rollNo1,branch,year);
					sm.addAStudent(student);
					System.out.println("Student is added");
					break;
				case 14: // updating a student
					System.out.println("Enter th roll no to update");
					int modify_rollNo;
					modify_rollNo =sc.nextInt();
					student = sm.get(modify_rollNo);
					try {
						if(student == null)
							throw new StudentNotFoundException();
						
						sc.nextLine();
						System.out.println("Name");
						name = sc.nextLine();
						System.out.println("EmailId");
						emailId = sc.nextLine();
						System.out.println("Mobile Number");
						mobileNo = sc.nextLine();
						System.out.println("Address ");
						address = sc.nextLine();
						System.out.println("Date of Birth");
						dob = sc.nextLine();
						System.out.println("Branch");
						branch = sc.nextLine();
						System.out.println("year ");
						year = sc.nextLine();
											
						sm.updateStudent(modify_rollNo, name, emailId, mobileNo, address, dob, branch, year);
						System.out.println("Student Record is updated");
						
					}
					catch (StudentNotFoundException e) {
						System.out.println(e);
					}
					break;
				case 15: // to delete a student
					System.out.println("Enter th roll no to delete");
					int delete_rollNo;
					delete_rollNo =sc.nextInt();
					if(sm.deleteStudent(delete_rollNo))
						System.out.println("Student record is removed");
					else
						System.out.println("No record with given roll no exsist");					
					break;
				case 21: //  view all books
					bm.viewAllBook();
					break;
				case 22: // Search book by ISBN
					int search_isbn;
					System.out.println("Enter ISBN of the book to search");
					search_isbn = sc.nextInt();
					Book book = bm.searchBookByIsbn(search_isbn);
					if(book == null)
						System.out.println("No book with this ISBN");
					else
						System.out.println(book);
					break;
				case 23: // add book
					System.out.println("Enter book details to add a book");
					int isbn;
					 String title;
					 String author;
					 String publisher;
					 int edition;
				     String subject;
				    int aval_quantity;
				    
				    System.out.println("ISBN");
				    isbn = sc.nextInt();
				    sc.nextLine();
				    System.out.println("Title");
				    title = sc.nextLine();
				    System.out.println("Author");
				    author = sc.nextLine();
				    System.out.println("publisher");
				    publisher = sc.nextLine();
				    System.out.println("edition");
				    edition = sc.nextInt();
				    sc.nextLine();
				    System.out.println("subject");
				    subject = sc.nextLine();
				    System.out.println("available quantity");
				    aval_quantity = sc.nextInt();
				    
				    book= new Book(isbn, title, author, publisher, edition, subject, aval_quantity);
				    bm.addABook(book);
				    System.out.println("Book is Added in record");					
					break;
				case 24: // update a record
					System.out.println("Enter the ISBN to update a record");
					int update_isbn;
					update_isbn = sc.nextInt();
					try {
						book = bm.searchBookByIsbn(update_isbn);
						if(book == null)
							throw new BookNotFoundException();
						System.out.println("Enter book Details to modify");
						sc.nextLine();
					    System.out.println("Title");
					    title = sc.nextLine();
					    System.out.println("Author");
					    author = sc.nextLine();
					    System.out.println("publisher");
					    publisher = sc.nextLine();
					    System.out.println("edition");
					    edition = sc.nextInt();
					    sc.nextLine();
					    System.out.println("subject");
					    subject = sc.nextLine();
					    System.out.println("available quantity");
					    aval_quantity = sc.nextInt();
					    
					    bm.updateBook(update_isbn, title, author, publisher, edition, subject, aval_quantity);
					} catch (BookNotFoundException e) {
						System.out.println(e);
					}
					break;
				case 25: // delete a record of book
					System.out.println("Enter the ISBN to delete a record");
					int delete_isbn;
					delete_isbn = sc.nextInt();
					try {
						book = bm.searchBookByIsbn(delete_isbn);
						if(book == null)
							throw new BookNotFoundException();
						bm.deleteBook(delete_isbn);
						System.out.println("Book record is deleted");
					}
					catch (BookNotFoundException e) {
						System.out.println(e);
					}
					break;
				case 31://view all transactions
					System.out.println("All the Transactions are");
					btm.showAll();					
					break;
				case 99:
					System.out.println("Thank you for using Library");
					break;
				default:
					break;
				}
			 }while(lib_ch!=99);
				break;
			case 3:
				
				break;
			}
		}while(ch != 3);
		sm.writeToFile();
		bm.writeToFile();
		btm.writeToFile();
		sc.close();
	}

}
