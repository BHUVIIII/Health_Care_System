package com.HCS.HealthCareSystem.ctrl;


import java.math.BigInteger;
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

import com.HCS.HealthCareSystem.entity.Appointment;
import com.HCS.HealthCareSystem.service.AppointmentService;


@RestController
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentService;
	
	@PostMapping("/appointments")

	public Appointment addAppointment(@RequestBody Appointment appointment) {

	return appointmentService.addAppointment(appointment);

	}
	
	
	@GetMapping("/appointments")

	public ResponseEntity<List<Appointment>> getAllAppointments(){

	List<Appointment> appointmentList = appointmentService.getAllAppointments();

	if(null!=appointmentList&&appointmentList.size()>0) {

	return new ResponseEntity<List<Appointment>>(appointmentList,HttpStatus.OK);

	}else {

	return new ResponseEntity<List<Appointment>>(appointmentList,HttpStatus.NO_CONTENT);

	}

	}
	
	
	@PutMapping("/appointments")

	public Appointment updateCart(@RequestBody Appointment appointment) {

	return appointmentService.updateAppointment(appointment);

	}
	

	
	@DeleteMapping("/appointments/{aid}")

	public Appointment deleteAppointment(@PathVariable int aid) {

		return appointmentService.deleteAppointment(aid);

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



