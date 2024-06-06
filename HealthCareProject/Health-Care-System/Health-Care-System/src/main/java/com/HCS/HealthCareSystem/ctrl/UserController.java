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

import com.HCS.HealthCareSystem.entity.User;
import com.HCS.HealthCareSystem.service.UserService;


@RestController
public class UserController {
	
	@Autowired

	UserService userService;
	
	@PostMapping("/users")

	public User addUser(@RequestBody User user) {

	return userService.addUser(user);

	}
	
	
	@GetMapping("/users")

	public ResponseEntity<List<User>> getAllUsers(){

	List<User> userList = userService.getAllUsers();

	if(null!=userList&&userList.size()>0) {

	return new ResponseEntity<List<User>>(userList,HttpStatus.OK);

	}else {

	return new ResponseEntity<List<User>>(userList,HttpStatus.NO_CONTENT);

	}

	}
	
	
	@PutMapping("/users")

	public User updateUser(@RequestBody User user) {

	return userService.updateUser(user);

	}

	
	@DeleteMapping("/users/{id}")

	public User deleteUser(@PathVariable int id) {

		return userService.deleteUser(id);

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
