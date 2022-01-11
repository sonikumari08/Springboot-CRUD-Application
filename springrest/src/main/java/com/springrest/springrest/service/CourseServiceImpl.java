package com.springrest.springrest.service;
 	
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseRepository;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.exception.ResourceNotFoundException;

@Service
public class CourseServiceImpl implements CourseService {

//	List<Course> list;
	
	@Autowired
	private CourseRepository courseRepository ;
	
	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(111, "JavaCore", "This course contain basic of java."));
//		list.add(new Course(112, "Spring", "This course contain basic of spring."));
	}

	@Override
	public List<Course> getCourses() {
		return courseRepository.findAll();
	}

	@Override
	public Course getCourse(int courseId) {
		Optional<Course> courseResponse = courseRepository.findById(courseId);
//		if(courseResponse == null) {
//			throw new RuntimeException("Id not found - "+courseId);
//		}	
		return courseResponse.orElseThrow(()->
			new ResourceNotFoundException("Course not found with id: "+courseId));
		
		
		
//		return courseRepository.findById(courseId).get();
	
	}

	@Override
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		return courseRepository.save(course);
		
	}

	@Override
	public void deleteCourse(int courseId) {
		Course entity= courseRepository.getById(courseId);
		courseRepository.delete(entity);
	}

}
