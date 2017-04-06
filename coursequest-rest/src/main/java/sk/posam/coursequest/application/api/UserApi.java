package sk.posam.coursequest.application.api;

import sk.posam.coursequest.application.dto.DTOCourse;
import sk.posam.coursequest.domain.model.User;

import java.util.Collection;

public interface UserApi {
	User getUser(long userId);
	Collection<User> getAll();
}
