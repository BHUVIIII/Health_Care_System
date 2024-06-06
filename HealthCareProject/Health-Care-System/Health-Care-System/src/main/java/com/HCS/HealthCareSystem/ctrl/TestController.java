package com.HCS.HealthCareSystem.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.HCS.HealthCareSystem.entity.Test;
import com.HCS.HealthCareSystem.service.TestService;


@RestController
public class TestController {
	
	@Autowired
	TestService testService;
		
	@PostMapping("/tests")

	public Test addTest(@RequestBody Test test) {

	return testService.addTest(test);

	}
	
	
	@GetMapping("/tests")

	public ResponseEntity<List<Test>> getAllTests(){

	List<Test> testList = testService.getAllTests();

	if(null!=testList&&testList.size()>0) {

	return new ResponseEntity<List<Test>>(testList,HttpStatus.OK);

	}else {

	return new ResponseEntity<List<Test>>(testList,HttpStatus.NO_CONTENT);

	}

	}
	
	@PutMapping("/tests")

	public Test updateTest(@RequestBody Test test) {

	return testService.updateTest(test);

	}
	

	
	@DeleteMapping("/tests/{tid}")

	public Test deleteTest(@PathVariable int tid) {

		return testService.deleteTest(tid);
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
