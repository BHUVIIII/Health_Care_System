package com.HCS.HealthCareSystem.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HCS.HealthCareSystem.entity.Appointment;
import com.HCS.HealthCareSystem.repo.AppointmentRepository;


@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepository appointmentRepo;
	public Appointment addAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return appointmentRepo.save(appointment) ;
	}

	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		return appointmentRepo.findAll();
	}

	public Appointment deleteAppointment(int aid) {
		Optional<Appointment> appointmentContainer = appointmentRepo.findById(aid);
		if(appointmentContainer.isPresent()) {
			appointmentRepo.delete(appointmentContainer.get());
			return appointmentContainer.get();
		}
		return null;
	}

	public Appointment updateAppointment(Appointment appointment) {
		int aid=appointment.getAid();
		java.util.Optional<Appointment> appointmentContainer=appointmentRepo.findById(aid);
		if(appointmentContainer.isPresent()) {
			Appointment oldAppointment = appointmentContainer.get();
			oldAppointment.setAppointmentId(appointment.getAppointmentId());
			oldAppointment.setDatetime(appointment.getDatetime());
			oldAppointment.setUser(appointment.getUser());
			oldAppointment.setTest(appointment.getTest());
			
			return appointmentRepo.saveAndFlush(oldAppointment);
		}
		// TODO Auto-generated method stub
		return null;
	}
	

}
