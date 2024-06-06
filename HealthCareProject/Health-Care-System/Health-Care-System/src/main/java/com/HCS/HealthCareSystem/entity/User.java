package com.HCS.HealthCareSystem.entity;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="User_TB")
public class User {
	
	@Id

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	
	@Column(name="User_ID")	
	private String userId;
	
	@Column(name="Center_List")	
	@OneToMany(cascade=CascadeType.ALL)
	private List<DiagnosticCenter> centerList;
	
	@Column(name="User_Password")
	@Size(min=8,max=14,message="Invalid Password format")
	@Pattern(regexp="^(?=.*[0-9])(?=*[a-z])(?=.*[A-Z])(?=.*[!@#&()-[{}]:;',?/*~$^+=<>]).{8,14}$")
	private String userPassword;
	
	@Column(name="User_Name")
	@NotNull
	@Pattern(regexp="[A-Z]{1}[A-Za-z]*",message="Invalid User name, Use the Standard Name format")
	private String userName;
	
	@Column(name="Contact_No")
	@Size(min=10,max=10,message="Invalid Contact Number format")
	private BigInteger contactNo;
	
	@Column(name="User_Role")
	private String userRole;
	
	@Column(name="Email_Id")
	private String emailId;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<DiagnosticCenter> getCenterList() {
		return centerList;
	}

	public void setCenterList(List<DiagnosticCenter> centerList) {
		this.centerList = centerList;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BigInteger getContactNo() {
		return contactNo;
	}

	public void setContactNo(BigInteger contactNo) {
		this.contactNo = contactNo;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	public User()
	{
		super();
	}

	public User(int id,String userId, List<DiagnosticCenter> centerList, String userPassword, String userName,
			BigInteger contactNo, String userRole, String emailId) {
		super();
		this.id = id;
		this.userId = userId;
		this.centerList = centerList;
		this.userPassword = userPassword;
		this.userName = userName;
		this.contactNo = contactNo;
		this.userRole = userRole;
		this.emailId = emailId;
	}
	
	


}