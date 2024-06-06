package com.HCS.HealthCareSystem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DiagnosticCenter_TB")
public class DiagnosticCenter {
	
	@Id

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int cid;
	
	@Column(name="Center_ID")
	private String centerId;
	
	@Column(name="Center_Name")
	private String centerName;
	
	@Column(name="List_of_Test")
	@OneToMany(cascade=CascadeType.ALL)
	private List<Test> listOfTests;
	
	@Column(name="Appointment_List")
	@OneToMany(cascade=CascadeType.ALL)
	private List<Appointment> appointmentList;

	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCenterId() {
		return centerId;
	}

	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public List<Test> getListOfTests() {
		return listOfTests;
	}

	public void setListOfTests(List<Test> listOfTests) {
		this.listOfTests = listOfTests;
	}

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	public DiagnosticCenter()
	{
		super();
	}
	
	public DiagnosticCenter(int cid,String centerId, String centerName, List<Test> listOfTests,
			List<Appointment> appointmentList) {
		super();
		this.cid=cid;
		this.centerId = centerId;
		this.centerName = centerName;
		this.listOfTests = listOfTests;
		this.appointmentList = appointmentList;
	}



	 
	


}
