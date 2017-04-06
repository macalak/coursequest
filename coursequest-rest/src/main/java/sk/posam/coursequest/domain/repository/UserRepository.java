package sk.posam.coursequest.domain.repository;

import sk.posam.coursequest.domain.model.User;

import java.util.Collection;

public interface UserRepository {
	User get(long userId);
	Collection<User> getAll();
}
