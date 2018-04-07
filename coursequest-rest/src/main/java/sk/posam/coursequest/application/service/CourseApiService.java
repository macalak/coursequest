package sk.posam.coursequest.application.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.posam.coursequest.application.api.CourseApi;
import sk.posam.coursequest.application.dto.DTOCourse;
import sk.posam.coursequest.application.dto.DTOCreateCourse;
import sk.posam.coursequest.domain.model.Course;
import sk.posam.coursequest.domain.model.CourseFactory;
import sk.posam.coursequest.domain.model.User;
import sk.posam.coursequest.domain.repository.CourseRepository;
import sk.posam.coursequest.domain.repository.UserRepository;
import sk.posam.coursequest.infrastructure.persistence.CourseRepositoryImpl;

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
		courses.forEach(course ->{
			result.add(mapToDTO(course));
		});

		return result;
	}

	@Override
	@Transactional
	public void createCourse(DTOCreateCourse dtoCreateCourse) {

	    // create object course
		User user = userRepository.get(dtoCreateCourse.userId);
		Course course = CourseFactory.create(dtoCreateCourse.name, user);
		course.addAttendee(user);
		user.addCourse(course);

		// add course to Repository
		courseRepository.createCourse(course);
		
	}

	private DTOCourse mapToDTO(Course course){
		DTOCourse dtoCourse  = new DTOCourse();
		dtoCourse.courseId = course.getId();
		dtoCourse.name = course.getName();
		return dtoCourse;
	}

}
