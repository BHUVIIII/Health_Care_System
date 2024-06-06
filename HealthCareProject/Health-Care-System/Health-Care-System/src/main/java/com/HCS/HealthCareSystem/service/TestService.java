package com.HCS.HealthCareSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.HCS.HealthCareSystem.entity.Test;
import com.HCS.HealthCareSystem.repo.TestRepository;



@Service
public class TestService {
	
	@Autowired
	TestRepository testRepo;

	public Test addTest(@Validated Test test) {
		// TODO Auto-generated method stub
		return testRepo.save(test);
	}

	public List<Test> getAllTests() {
		// TODO Auto-generated method stub
		return testRepo.findAll();
	}

	public Test deleteTest(int tid) {
		Optional<Test> testContainer = testRepo.findById(tid);
		if(testContainer.isPresent()) {
			testRepo.delete(testContainer.get());
			return testContainer.get();
		}
		// TODO Auto-generated method stub
		return null;
	}

	
	public Test updateTest(Test test) {
		int tid=test.getTid();
		java.util.Optional<Test> testContainer=testRepo.findById(tid);
		if(testContainer.isPresent()) {
			Test oldTest = testContainer.get();
			oldTest.setTestId(test.getTestId());
			//oldTest.setCustomerId(test.getCustomerId());
			oldTest.setTestName(test.getTestName());
			
			
			return testRepo.saveAndFlush(oldTest);
		}
		// TODO Auto-generated method stub
		return null;
	}
	

}
