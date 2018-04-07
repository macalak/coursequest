package sk.posam.coursequest.infrastructure.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import sk.posam.coursequest.domain.model.User;
import sk.posam.coursequest.domain.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public class UserRepositoryImpl implements UserRepository{
	static Logger LOG = LoggerFactory.getLogger(UserRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User get(final long userId) {
		return entityManager.find(User.class,userId);
	}

	@Override
	public Collection<User> getAll() {

		//return entityManager.createQuery("from User",User.class).getResultList();
		//return entityManager.createNativeQuery("select * from USER_TBL",User.class).getResultList();
		return entityManager.createNamedQuery("user.selectAll",User.class).getResultList();

	}
}
