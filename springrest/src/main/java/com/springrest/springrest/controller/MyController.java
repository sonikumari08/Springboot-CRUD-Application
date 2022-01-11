package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.service.CourseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Course Mangement", description = "Provides course management API's.")
@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	/*
	 * Get courses
	 */
	@ApiOperation(value = "Retrieving all the courses.")
	@GetMapping("/courses")
	public List<Course> getCourses() {
		return courseService.getCourses();	
	}
	
	@ApiOperation(value = "Retrieve course of given id.")
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable int courseId) {
		Course response = courseService.getCourse(courseId);
		return response;
	}
	
	@ApiOperation(value = "Save the course.")
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);	
	}
	
	@ApiOperation(value = "Update the course.")
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return courseService.updateCourse(course);	
	}
	
	@ApiOperation(value = "Delete the course of given id.")
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable int courseId) {
		try {
			courseService.deleteCourse(courseId);	
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
