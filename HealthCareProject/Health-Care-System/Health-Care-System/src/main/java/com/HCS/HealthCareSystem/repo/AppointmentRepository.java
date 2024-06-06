package com.HCS.HealthCareSystem.repo;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HCS.HealthCareSystem.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

	//Optional<Appointment> findById(int aid);

}
