package com.accolite.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accolite.au.dto.Student;



public interface StudentRepository extends JpaRepository<Student,Integer> {

}
