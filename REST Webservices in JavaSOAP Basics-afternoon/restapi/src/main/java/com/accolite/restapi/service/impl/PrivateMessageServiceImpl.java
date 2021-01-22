package com.accolite.restapi.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.restapi.entity.PrivateMessage;
import com.accolite.restapi.repository.PrivateMessageRepository;
import com.accolite.restapi.service.PrivateMessageService;

@Service
public class PrivateMessageServiceImpl implements PrivateMessageService {

	@Autowired
	PrivateMessageRepository pmr;

	@Override
	public PrivateMessage add(PrivateMessage pm) {
		pm.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		
		return pmr.save(pm);
	}

	@Override
	public List<PrivateMessage> getMessages(Integer id) {
		return pmr.findByUserId(id);
	}
	
}
