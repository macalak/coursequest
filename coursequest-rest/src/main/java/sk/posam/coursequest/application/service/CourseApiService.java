package sk.posam.coursequest.application.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.posam.coursequest.application.api.CourseApi;
import sk.posam.coursequest.application.dto.DTOCourse;
import sk.posam.coursequest.domain.model.Course;
import sk.posam.coursequest.domain.model.CourseFactory;
import sk.posam.coursequest.domain.model.User;
import sk.posam.coursequest.domain.repository.CourseRepository;
import sk.posam.coursequest.domain.repository.UserRepository;

@Service
public class CourseApiService implements CourseApi {

	@Autowired
	CourseRepository courseRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public Collection<DTOCourse> getList(long userId) {
		Collection<Course> courses = courseRepository.readByUser(userId);
		
		Collection<DTOCourse> result = new ArrayList<>();
		
		for (Course course : courses){
			DTOCourse next  = new DTOCourse();
			
			next.courseId = course.getId();
			next.name = course.getName();
			
			result.add(next);
		}
		return result;
	}

	@Override
	public void createCourse(String courseName, long userId) {

	    // create object course
		User user = userRepository.get(userId);
		Course course = CourseFactory.create(courseName, user);
		
		
		// add course to Repository
		courseRepository.createCourse(course);
		
	}

}
