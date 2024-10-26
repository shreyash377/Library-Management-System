package com.demo.Library_Management_System.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {
	@Id
	@Column(name = "AdminId", length = 50)
	private long aadminid;

	@Column(name = "AdminName", length = 50)
	private String adminname;

	@Column(name = "ContactNo", length = 50)
	private long contactno;

	@Column(name = "EmailId", length = 50)
	private String emailid;

	public long getAadminid() {
		return aadminid;
	}

	public void setAadminid(long aadminid) {
		this.aadminid = aadminid;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public long getContactno() {
		return contactno;
	}

	public void setContactno(long contactno) {
		this.contactno = contactno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public Admin(long aadminid, String adminname, long contactno, String emailid) {
		super();
		this.aadminid = aadminid;
		this.adminname = adminname;
		this.contactno = contactno;
		this.emailid = emailid;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Admin [aadminid=" + aadminid + ", adminname=" + adminname + ", contactno=" + contactno + ", emailid="
				+ emailid + "]";
	}

//	@ManyToOne
//    @JoinColumn(name = "LibraryName")
//    Library l;
//
//    @OneToMany(mappedBy = "a")
//    List<Member> m = new ArrayList<Member>();
//
//    @OneToMany(mappedBy = "a")
//    List<Book> b = new ArrayList<Book>();

	
}
