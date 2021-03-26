package com.example.Muzix.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

  
    @Id
    private String userName;
    private String emailId;
    private String userPassword;
	private String phoneNo;
   // private byte[] photo;
    
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String emailId, String userPassword, String userName, String phoneNo) {
		super();
		this.emailId = emailId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.phoneNo = phoneNo;
	
	}
	public String getemailId() {
		return emailId;
	}
	public void setemailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	public String getphoneNo() {
		return phoneNo;
	}
	public void setphoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	 @Override
		public String toString() {
			return "User [emailId=" + emailId + ", userPassword=" + userPassword + ", userName=" + userName + ", phoneNo="
					+ phoneNo + "]";
		}
   


}
