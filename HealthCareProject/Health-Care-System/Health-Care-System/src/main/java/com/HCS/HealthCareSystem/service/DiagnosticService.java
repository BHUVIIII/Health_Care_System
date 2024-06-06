package com.HCS.HealthCareSystem.service;

import java.util.List;
import java.util.Optional;

import javax.tools.Diagnostic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.HCS.HealthCareSystem.entity.DiagnosticCenter;
import com.HCS.HealthCareSystem.repo.DiagnosticRepository;

@Service
public class DiagnosticService {

	@Autowired

	DiagnosticRepository diagnosticRepo;

	public DiagnosticCenter addDiagnosticCenter(@Validated DiagnosticCenter diagnosticcenter) {
		// TODO Auto-generated method stub
		return diagnosticRepo.save(diagnosticcenter);
				}

	public List<DiagnosticCenter> getAllDiagnosticCenters() {
		// TODO Auto-generated method stub
		return diagnosticRepo.findAll();
	}

	public DiagnosticCenter deleteDiagnosticCenter(int cid) {
		Optional<DiagnosticCenter> diagnosticContainer = diagnosticRepo.findById(cid);
		if(diagnosticContainer.isPresent()) {
			diagnosticRepo.delete(diagnosticContainer.get());
			return diagnosticContainer.get();
		}
		// TODO Auto-generated method stub
		return null;
	}

	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		int cid=diagnosticCenter.getCid();
		java.util.Optional<DiagnosticCenter> diagnosticCenterContainer=diagnosticRepo.findById(cid);
		if(diagnosticCenterContainer.isPresent()) {
			DiagnosticCenter oldDiagnosticCenter = diagnosticCenterContainer.get();
			oldDiagnosticCenter.setCenterId(diagnosticCenter.getCenterId());
			oldDiagnosticCenter.setCenterName(diagnosticCenter.getCenterName());
			oldDiagnosticCenter.setAppointmentList(diagnosticCenter.getAppointmentList());
			oldDiagnosticCenter.setListOfTests(oldDiagnosticCenter.getListOfTests());
			
			return diagnosticRepo.saveAndFlush(oldDiagnosticCenter);
		}
		// TODO Auto-generated method stub
		return null;
	}

	
	
	



}
