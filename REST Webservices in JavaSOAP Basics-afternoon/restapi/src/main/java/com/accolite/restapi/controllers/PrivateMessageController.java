package com.accolite.restapi.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//import java.util.Map;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.restapi.entity.PrivateMessage;
import com.accolite.restapi.entity.User;
import com.accolite.restapi.service.PrivateMessageService;
import com.accolite.restapi.service.UserService;


@RestController
@RequestMapping("/api/message")
public class PrivateMessageController {

	@Autowired
	UserService userService;
	
	@Autowired
	PrivateMessageService privateMessageService;
	
	@Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
//	
	@PostMapping("/add/{userId}")
	public ResponseEntity<Object> postMessage(
			@RequestBody PrivateMessage pm,
			@PathVariable("userId") Integer userId) {
		
		User user=userService.getUserById(userId);
		if(user==null) {
			return ResponseEntity.notFound().build();
		}
		pm.setUserId(user.getId());
		System.out.println(userId+" "+pm);
		
		privateMessageService.add(pm);
		
		return ResponseEntity.ok(pm);
		
	}
//	@GetMapping("/get/{userId}")
//	public ResponseEntity<Object> getMesseges(
//			@PathVariable("userId") Integer userId,
//			@RequestHeader("password") String password) {
////	) {
//		User user = userService.getUserById(userId);
//		if (user == null) {
//		      return ResponseEntity.notFound().build();
//		}
////		List<PrivateMessage> pms= privateMessageService.getMessages(userId);
////		
////		for(PrivateMessage pm:pms)
////		{
////			System.out.println("messages"+pm);
////		}
////		if(pms==null) {
////			System.out.println("messages"+" Failed");
////			return ResponseEntity.notFound().build();
////		}
//		
////		System.out.println(userId+" "+pm);
//		
////		privateMessageService.getMessages(userId);
//		
//		if(bCryptPasswordEncoder.matches(password, user.getPassword())) {
////		if(user.getPassword().equals(password))
//	        return ResponseEntity.ok(privateMessageService.getMessages(userId));
//	    }
//	     return ResponseEntity.ok("Invalid login");
		
//	}
	@GetMapping("/get/{userId}")
	  public ResponseEntity<Object> getMessage(@PathVariable("userId") Integer userId,
	                                           @RequestHeader("password") String password) {
	    User user = userService.getUserById(userId);

//	    System.out.println(user.getPassword());
	    if (user == null) {
	      return ResponseEntity.notFound().build();
	    }
	    if(bCryptPasswordEncoder.matches(password, user.getPassword())) {
	        return ResponseEntity.ok(privateMessageService.getMessages(userId));
	    }
	     return ResponseEntity.ok("Invalid login");
	  }
}
