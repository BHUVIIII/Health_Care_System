package com.HCS.HealthCareSystem.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HCS.HealthCareSystem.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test,Integer> {

	//Optional<Test> findById(int tid);

}
