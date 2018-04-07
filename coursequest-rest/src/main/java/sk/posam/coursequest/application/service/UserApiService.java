package sk.posam.coursequest.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.posam.coursequest.application.api.CourseApi;
import sk.posam.coursequest.application.api.UserApi;
import sk.posam.coursequest.application.dto.DTOCourse;
import sk.posam.coursequest.application.dto.DTOUser;
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
	public DTOUser getUser(long userId) {

		User user = userRepository.get(userId);
		return mapToDTO(user);
	}

	@Override
	public Collection<DTOUser> getAll() {
		Collection<DTOUser> dtoUsers = new ArrayList<DTOUser>();
		userRepository.getAll().forEach(user -> {
			dtoUsers.add(mapToDTO(user));
		  }
		);
		return dtoUsers;
	}

	private DTOUser mapToDTO(User user){
		DTOUser dtoUser = new DTOUser();
		dtoUser.id=user.getId();
		dtoUser.username=user.getUsername();
		return  dtoUser;
	}
}
