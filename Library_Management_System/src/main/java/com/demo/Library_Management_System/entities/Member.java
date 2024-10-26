package com.demo.Library_Management_System.entities;

//import java.awt.print.Book;
//import java.util.ArrayList;
//import java.util.List;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Member")
public class Member {
	@Id
	@Column(name = "MemeberId", length = 50)
	private int memberId;

	@Column(name = "Name", length = 50)
	private String name;

	@Column(name = "Address", length = 50)
	private String address;

	@Column(name = "Gender", length = 20)
	private String gender;

	@Column(name = "ContactNo", length = 50)
	private int contactno;

	@Column(name = "Email", length = 50)
	private String email;
	
	
//	@ManyToOne
//    @JoinColumn(name = "LibraryName")
//    Library l;
//
//	@OneToMany(mappedBy = "m")
//    List<Book> b = new ArrayList<Book>();
//	
//	 @ManyToOne
//	    @JoinColumn(name = "AdminId")
//	    Admin a;
	
	
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getContactno() {
		return contactno;
	}

	public void setContactno(int contactno) {
		this.contactno = contactno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Member(int memberId, String name, String address, String gender, int contactno, String email) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.contactno = contactno;
		this.email = email;
	}

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", address=" + address + ", gender=" + gender
				+ ", contactno=" + contactno + ", email=" + email + "]";
	}
	
	



	}