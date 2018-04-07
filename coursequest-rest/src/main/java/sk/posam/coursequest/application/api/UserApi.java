package sk.posam.coursequest.application.api;

import sk.posam.coursequest.application.dto.DTOCourse;
import sk.posam.coursequest.application.dto.DTOUser;
import sk.posam.coursequest.domain.model.User;

import java.util.Collection;

public interface UserApi {
	DTOUser getUser(long userId);
	Collection<DTOUser> getAll();
}
