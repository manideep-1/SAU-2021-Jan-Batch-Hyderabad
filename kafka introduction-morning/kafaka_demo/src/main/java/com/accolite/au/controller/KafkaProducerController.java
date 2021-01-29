package com.accolite.au.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.au.dto.Student;
import com.accolite.au.dto.Success;
import com.accolite.au.dto.Teacher;
import com.accolite.au.service.KafkaService;
@RestController
public class KafkaProducerController {
	@Autowired
	private KafkaService kafkaService;
	
	@PostMapping(value = "/produce-message")
	public ResponseEntity<Object> produceMessage(@RequestBody String message) {
		kafkaService.sendKafkaMessage(message);
		Success response = new Success(201);
		response.setMessage("success");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	@PostMapping(value="/student")
	public ResponseEntity<Object> saveStudent(@RequestBody Student s){
		kafkaService.AddStudent(s);
		Success response = new Success(201);
		response.setMessage("success");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	@PostMapping(value="/teacher")
	public ResponseEntity<Object> saveTeacher(@RequestBody Teacher t){
		kafkaService.AddTeacher(t);
		Success response = new Success(201);
		response.setMessage("success");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
