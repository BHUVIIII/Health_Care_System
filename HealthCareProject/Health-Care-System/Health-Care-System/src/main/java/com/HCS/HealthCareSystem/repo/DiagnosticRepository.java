package com.HCS.HealthCareSystem.repo;

import java.util.List;
import java.util.Optional;

import javax.tools.Diagnostic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HCS.HealthCareSystem.entity.DiagnosticCenter;


@Repository
public interface DiagnosticRepository extends JpaRepository<DiagnosticCenter,Integer> {

	//Optional<DiagnosticCenter> findById(int cid);
	


	

	


}
