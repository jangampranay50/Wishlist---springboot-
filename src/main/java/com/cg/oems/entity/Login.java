package com.cg.oems.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//login entity class
@Entity
@Table(name="login_tbl")
public class Login {

	@Id
	@Column(name="user_name",length=15)
	private String userName;
	
	@Column(name="user_pass",length=15)
	private String userPass;
	
	@Column(name="user_role",length=15)
	private String userRole;

	//parameterised constructor
	public Login(String userName, String userPass, String userRole) {
		super();
		this.userName = userName;
		this.userPass = userPass;
		this.userRole = userRole;
	}

	//default constructor
	public Login() {
		super();
	}

	//getters and setters
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
}
