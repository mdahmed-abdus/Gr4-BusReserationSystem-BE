package com.lti.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="RegisteredUsers")
public class User {

	@Id
	private int user_Id;
	private String fname;
	private String lname;
	private String gender;
	private long phoneNo;
	private String address;
	private String mail;
	private String pwd;
	private double wallet;
	private String userType;
	private LocalDate dob;
	
	
//	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
//	List<Ticket> tickets;
	
	
	
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [user_Id=" + user_Id + ", fname=" + fname + ", lname=" + lname + ", gender=" + gender
				+ ", phoneNo=" + phoneNo + ", address=" + address + ", mail=" + mail + ", pwd=" + pwd + ", wallet="
				+ wallet + ", userType=" + userType + ", dob=" + dob + "]";
	}
	
	
	
	
	
	
}
	
	