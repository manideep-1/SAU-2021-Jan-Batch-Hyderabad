package com.accolite.au.service;

import com.accolite.au.dto.Student;
import com.accolite.au.dto.Teacher;

public interface KafkaService {
	public String sendKafkaMessage(String message);
	public String AddStudent(Student student);
	public String AddTeacher(Teacher t);
}
