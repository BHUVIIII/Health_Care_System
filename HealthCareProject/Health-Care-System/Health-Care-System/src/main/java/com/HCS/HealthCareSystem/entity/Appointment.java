package com.HCS.HealthCareSystem.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Table(name="Appointment_TB")
public class Appointment {
	
	@Id

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int aid;
	@Column(name="Appointment_ID")	
	private BigInteger appointmentId;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name = "userId")
	private User user ;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name = "testId")
	private Test test;
	
	
	@Column(name="Date_Time")	
	private Date datetime;
	
	@Column(name="Approved")	
	private boolean approved;

	
	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public BigInteger getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(BigInteger appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
	

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	public Appointment()
	{
		super();
	}
	

	public Appointment(int aid,BigInteger appointmentId,  User user, Test test,Date datetime, boolean approved) {
		super();
		this.aid=aid;
		this.appointmentId = appointmentId;
		this.user = user;
		this.test = test;
		this.datetime = datetime;
		this.approved = approved;
	}

	


}
