package com.accolite.restapi.service;

import java.util.List;

import com.accolite.restapi.entity.PrivateMessage;

public interface PrivateMessageService {

	public PrivateMessage add(PrivateMessage pm);
	public List<PrivateMessage>getMessages(Integer id);
}
