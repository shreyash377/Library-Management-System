package com.demo.Library_Management_System.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;


@Entity
@Table(name="Library")
public class Books {
	@Id
	@Column(name ="BookId", length = 50)
	private int bookid;
	
	@Column(name ="BookName", length = 50)
	private String bookname;
	
	@Column(name ="BookPrice", length = 50)
	private int bookprice;
	
	@Column(name ="BookStatus", length = 50)
	private String bookstatus;
	
//	@ManyToOne
//    @JoinColumn(name = "MemberId")
//    Member m;
//	
//
//	@ManyToOne
//    @JoinColumn(name = "LibraryId")
//    Library l;
//
//    @ManyToOne
//    @JoinColumn(name = "AdminId")
//    Admin a;

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public int getBookprice() {
		return bookprice;
	}

	public void setBookprice(int bookprice) {
		this.bookprice = bookprice;
	}

	public String getBookstatus() {
		return bookstatus;
	}

	public void setBookstatus(String bookstatus) {
		this.bookstatus = bookstatus;
	}

	public Books(int bookid, String bookname, int bookprice, String bookstatus) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.bookprice = bookprice;
		this.bookstatus = bookstatus;
	}

	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Books [bookid=" + bookid + ", bookname=" + bookname + ", bookprice=" + bookprice + ", bookstatus="
				+ bookstatus + "]";
	}


}
