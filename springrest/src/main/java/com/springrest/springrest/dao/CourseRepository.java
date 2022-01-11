package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	// no need to write the code or implementation class :
	// we can use directly all method in service impl class
}
