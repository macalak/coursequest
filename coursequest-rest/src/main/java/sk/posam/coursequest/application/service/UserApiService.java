package sk.posam.coursequest.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.posam.coursequest.application.api.CourseApi;
import sk.posam.coursequest.application.api.UserApi;
import sk.posam.coursequest.application.dto.DTOCourse;
import sk.posam.coursequest.domain.model.Course;
import sk.posam.coursequest.domain.model.CourseFactory;
import sk.posam.coursequest.domain.model.User;
import sk.posam.coursequest.domain.repository.CourseRepository;
import sk.posam.coursequest.domain.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserApiService implements UserApi {

	@Autowired
	UserRepository userRepository;


	@Override
	public User getUser(long userId) {
		return userRepository.get(userId);
	}

	@Override
	public Collection<User> getAll() {
		return userRepository.getAll();
	}
}
