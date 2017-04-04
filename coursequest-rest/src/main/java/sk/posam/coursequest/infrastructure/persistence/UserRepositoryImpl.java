package sk.posam.coursequest.infrastructure.persistence;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Repository;
import sk.posam.coursequest.domain.model.User;
import sk.posam.coursequest.domain.repository.UserRepository;

import javax.annotation.PostConstruct;

@Repository
public class UserRepositoryImpl implements UserRepository{
	private Collection<User> users = new ArrayList<>();

	@PostConstruct
	private void init(){
		users.add(new User("Jano"));
		users.add(new User("Fero"));
	}

	@Override
	public User get(final long userId) {
		User findUser = null;
		for (User u : users){
			if (u.getId() == userId){
				findUser= u;
			}
		}
		return findUser;
	}
}
