package com.accolite.au.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
@Entity
@Setter
@Getter
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	@Column
	private String Student_Name;
	@Column
	private String branch;	

}
