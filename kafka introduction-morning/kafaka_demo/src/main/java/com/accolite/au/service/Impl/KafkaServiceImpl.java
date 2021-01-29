package com.accolite.au.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.accolite.au.dto.Student;
import com.accolite.au.dto.Teacher;
import com.accolite.au.repository.StudentRepository;
import com.accolite.au.repository.TeacherRepository;
import com.accolite.au.service.KafkaService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaServiceImpl implements KafkaService {
	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;

	@Autowired
	StudentRepository sr;
	@Autowired
	TeacherRepository tr;
	
	@Override
	public String sendKafkaMessage(String message) {
		kafkaTemplate.send("firsttopic", message)
        .addCallback(getCallbackObject("Demo", message));
		return null;
	}
	  private ListenableFutureCallback<Object> getCallbackObject(String eventName, String event) {
		    return new ListenableFutureCallback<Object>() {
		      @Override
		      public void onSuccess(Object result) {
		        log.info("Kafka message has been sent successfully for {}", eventName);
		      }

		      @Override
		      public void onFailure(Throwable ex) {
		        log.info("Kafka message has not been sent for {}. Exception= {}", event, ex.getMessage());
		      }
		    };
	  }
	@Override
	public String AddStudent(Student student) {
		sr.save(student);
		kafkaTemplate.send("firsttopic", student)
        .addCallback(getCallbackObject("Student Saved successfully", "Saving student"));

		return "Student Saved successfully";
	}
	@Override
	public String AddTeacher(Teacher t) {
		tr.save(t);
		kafkaTemplate.send("firsttopic", t)
        .addCallback(getCallbackObject("Teacher Saved successfully", "Saving Teacher"));
		return "Teacher Saved successfully";
		
	}

}
