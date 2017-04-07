package sk.posam.coursequest.infrastructure.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import sk.posam.coursequest.domain.model.User;
import sk.posam.coursequest.domain.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

// TODO 08: This is repository
public class UserRepositoryImpl implements UserRepository{
	static Logger LOG = LoggerFactory.getLogger(UserRepositoryImpl.class);

	// TODO 09: Inject EntityManager
	private EntityManager entityManager;

	@Override
	public User get(final long userId) {
		// TODO 10: Implementation
		return null;
	}

	@Override
	public Collection<User> getAll() {
		// TODO 11: Implementation
		return null;
	}
}
