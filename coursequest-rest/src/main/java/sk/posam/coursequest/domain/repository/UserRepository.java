package sk.posam.coursequest.domain.repository;

import sk.posam.coursequest.domain.model.User;

public interface UserRepository {
	User get(long userId);
}
