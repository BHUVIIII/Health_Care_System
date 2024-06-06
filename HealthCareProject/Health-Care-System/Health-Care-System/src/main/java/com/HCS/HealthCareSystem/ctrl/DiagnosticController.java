package com.HCS.HealthCareSystem.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.tools.Diagnostic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.HCS.HealthCareSystem.entity.DiagnosticCenter;
import com.HCS.HealthCareSystem.service.DiagnosticService;

@RestController
public class DiagnosticController {
	
	@Autowired

	DiagnosticService diagnosticService;
	
	
	@PostMapping("/diagnosticcenters")

	public DiagnosticCenter addDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticcenter) {

	return diagnosticService.addDiagnosticCenter(diagnosticcenter);

	}
	
	
	@GetMapping("/diagnosticcenters")

	public ResponseEntity<List<DiagnosticCenter>> getAllDiagnosticCenters(){

	List<DiagnosticCenter> diagnosticcenterList = diagnosticService.getAllDiagnosticCenters();

	if(null!=diagnosticcenterList&&diagnosticcenterList.size()>0) {

	return new ResponseEntity<List<DiagnosticCenter>>(diagnosticcenterList,HttpStatus.OK);

	}else {

	return new ResponseEntity<List<DiagnosticCenter>>(diagnosticcenterList,HttpStatus.NO_CONTENT);

	}

	}

	@PutMapping("/diagnosticcenters")

	public DiagnosticCenter updateDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticCenter) {

	return diagnosticService.updateDiagnosticCenter(diagnosticCenter);

	}

	
	@DeleteMapping("/diagnosticcenters/{cid}")

	public DiagnosticCenter deleteDiagnosticCenter(@PathVariable int cid) {

		return diagnosticService.deleteDiagnosticCenter(cid);

	
	}

	
	@ResponseStatus(HttpStatus.BAD_REQUEST)

	@ExceptionHandler(MethodArgumentNotValidException.class)

	public Map<String, String> handleValidationExceptions(

	  MethodArgumentNotValidException ex) {

	    Map<String, String> errors = new HashMap<>();

	    ex.getBindingResult().getAllErrors().forEach((error) -> {

	        String fieldName = ((FieldError) error).getField();

	        String errorMessage = error.getDefaultMessage();

	        errors.put(fieldName, errorMessage);

	    });

	    return errors;

	}

	 
}
