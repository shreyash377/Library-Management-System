package com.demo.Library_Management_System.entities;

//import java.awt.print.Book;
//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Library")
public class Library {
	@Id
	@Column(name ="LibraryName", length = 50)
	private String libraryname; 

	@Column(name = "LibraryAddress", length = 50)
	private String libraryaddress;

	@Column(name = "ContactNo", length = 50)
	private long contactno;
	
	
//	@OneToMany(mappedBy = "l")
//    List<Book> b = new ArrayList<Book>();
//
//    @OneToMany(mappedBy = "l")
//    List<Member> m = new ArrayList<Member>();
//
//    @ManyToOne
//    @JoinColumn(name = "AdminId")
//    Admin a;


	public String getLibraryname() {
		return libraryname;
	}

	public void setLibraryname(String libraryname) {
		this.libraryname = libraryname;
	}

	public String getLibraryaddress() {
		return libraryaddress;
	}

	public void setLibraryaddress(String libraryaddress) {
		this.libraryaddress = libraryaddress;
	}

	public long getContactno() {
		return contactno;
	}

	public void setContactno(long contactno) {
		this.contactno = contactno;
	}

	public Library(String libraryname, String libraryaddress, long contactno) {
		super();
		this.libraryname = libraryname;
		this.libraryaddress = libraryaddress;
		this.contactno = contactno;
	}

	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Library [libraryname=" + libraryname + ", libraryaddress=" + libraryaddress + ", contactno=" + contactno
				+ "]";
	}

//	public Long getId() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	


}
