package com.accolite.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accolite.restapi.entity.PrivateMessage;

public interface PrivateMessageRepository extends JpaRepository<PrivateMessage,Integer> {

	public List<PrivateMessage> findByUserId(Integer userId);
}
