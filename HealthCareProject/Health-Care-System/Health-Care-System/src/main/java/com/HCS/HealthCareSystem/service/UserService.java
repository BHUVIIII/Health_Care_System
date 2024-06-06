package com.HCS.HealthCareSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HCS.HealthCareSystem.entity.User;
import com.HCS.HealthCareSystem.entity.User;
import com.HCS.HealthCareSystem.repo.UserRepository;

@Service

public class UserService {
	
@Autowired
UserRepository userRepo;

	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	public User deleteUser(int id) {
		Optional<User> userContainer = userRepo.findById(id);
		if(userContainer.isPresent()) {
			userRepo.delete(userContainer.get());
			return userContainer.get();
		}
		// TODO Auto-generated method stub
		return null;
	}


	public User updateUser(User user) {
		int id=user.getId();
		java.util.Optional<User> userContainer=userRepo.findById(id);
		if(userContainer.isPresent()) {
			User oldUser = userContainer.get();
			oldUser.setUserId(user.getUserId());
			//oldUser.setCustomerId(user.getCustomerId());
			oldUser.setUserName(user.getUserName());
			oldUser.setContactNo(user.getContactNo());
			oldUser.setCenterList(user.getCenterList());
			oldUser.setUserPassword(user.getUserPassword());
			oldUser.setUserRole(user.getUserRole());
			oldUser.setEmailId(user.getEmailId());
			
			return userRepo.saveAndFlush(oldUser);
		}
		// TODO Auto-generated method stub
		return null;
	}

}
