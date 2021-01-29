package com.accolite.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accolite.au.dto.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

}
