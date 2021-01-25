package com.accolite.restapi.service.impl;

//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.accolite.restapi.entity.User;
import com.accolite.restapi.repository.UserRepository;
import com.accolite.restapi.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	@Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User addUser(User user) {
		
		//Encrypt password
		
		String plainPassword=user.getPassword();
		String encryptedPassword=getEncryptedPassword(plainPassword);
		user.setPassword(encryptedPassword);
		
		//Add to DB
		User savedUser=userRepository.save(user);
		return savedUser;
		
//		return null;
	}

	private String getEncryptedPassword(String plainPassword) {
        
		return bCryptPasswordEncoder.encode(plainPassword);
    }
	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		Optional<User> user=userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@Override
	public User getUserByEmailId(String email) {
		Optional<User> user= userRepository.findByEmailId(email);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
//		return user.get(0);
//		return null;
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		
	}

	
}
