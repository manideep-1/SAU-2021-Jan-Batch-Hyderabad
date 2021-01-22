package com.accolite.restapi.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accolite.restapi.entity.User;


public interface UserRepository extends JpaRepository<User,Integer> {
	public Optional<User> findByEmailId(String email);

}
