package com.accolite.restapi.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String emailId;
	
	@Column
	private String password;
	
	@OneToMany(mappedBy="userId",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<PrivateMessage> privateMessages;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<PrivateMessage> getPrivateMessages() {
		return privateMessages;
	}

	public void setPrivateMessages(Set<PrivateMessage> privateMessages) {
		this.privateMessages = privateMessages;
	}
	
	
}
