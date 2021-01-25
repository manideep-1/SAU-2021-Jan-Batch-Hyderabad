package com.accolite.restapi.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.restapi.entity.User;
import com.accolite.restapi.service.UserService;

//import com.accolite.restapi.entity.User;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userservice;

	@Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/signup")
	public User signUp(@RequestBody Map<String,String> userDetails) {
		System.out.println(userDetails);
		String emailId=userDetails.get("emailId");
		String password=userDetails.get("password");
		User u1=new User();
		u1.setEmailId(emailId);
		u1.setPassword(password);
		
		//send it to service
		userservice.addUser(u1);
		
		return u1;
	}
	@PutMapping("/put")
	public ResponseEntity<Object> saveOrUpdateuser(@RequestBody User user,@RequestHeader("password") String password) {
	
		User user1=userservice.getUserById(user.getId());
		if(bCryptPasswordEncoder.matches(password, user1.getPassword())) {
			userservice.updateUser(user);
	    }
		else
		{
			return ResponseEntity.ok("Invalid password");
		}
//		System.out.println(userDetails);
//		String emailId=userDetails.get("emailId");
//		String password=userDetails.get("password");
//		User u1=new User();
//		u1.setEmailId(emailId);
//		u1.setPassword(password);
		
		//send it to service
		
		
		
		return ResponseEntity.ok(user);
	}
//	@PutMapping("/changeemail")
//	public ResponseEntity<Object> ChangeEmail(@RequestBody Map<String,String> userDetails) {
////		System.out.println(userDetails);
//		String emailId=userDetails.get("email");
//		String password=userDetails.get("password");
////		System.out.println(userDetails.get("email")+" "+userDetails.get("password")+" "+userDetails.get("updateMail"));
//		User u1=new User();
//		u1.setEmailId(emailId);
//		u1.setPassword(password);
//		
//		User u2=userservice.getUserByEmailId(emailId);
//		System.out.println(u2.getEmailId()+" "+u2.getPassword());
//		
//		if(password.equals(u2.getPassword())) {
//	        return ResponseEntity.ok("Logic");
//	    }
//		else
//		{
//			System.out.println("Wrong password");
//			return ResponseEntity.ok("Wrong password");
//		}
//	}
	@GetMapping("/get/{id}")
    public User getUser(@PathVariable Integer id){
        return userservice.getUserById(id);
    }
	
	@DeleteMapping("delete/{id}")
	public String deleteUser(@PathVariable Integer id) {
		userservice.deleteUser(id);
		return "User deleted";
	}
	
}
