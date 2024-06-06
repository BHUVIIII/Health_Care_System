package com.HCS.HealthCareSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Test_TB")
public class Test {
	
	@Id

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int tid;

	@Column(name="Test_ID")
	private String testId;
	
	@Column(name="Test_Name")
	//@Enumerated(EnumType.STRING)
	private String testName;

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String  getTestName() {
		return testName;
	}

	public void setTestName(String  testName) {
		this.testName = testName;
	}
	
	
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public Test()
	{
		super();
	}

	public Test(int tid,String testId, String testName) {
		super();
		this.tid = tid;
		this.testId = testId;
		this.testName = testName;
	}

	

}
