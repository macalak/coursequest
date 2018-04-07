package sk.posam.coursequest.infrastructure.persistence;

import org.springframework.stereotype.Repository;
import sk.posam.coursequest.domain.model.DiscussionMessage;
import sk.posam.coursequest.domain.repository.DiscussionMessageRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by macalaki on 04.04.2017.
 */
@Repository
public class DiscussionMessageRepositoryImpl implements DiscussionMessageRepository {

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void create(DiscussionMessage discussionMessage) {
        entityManager.persist(discussionMessage);
    }

    @Override
    public DiscussionMessage read(long messageId) {
        return null;
    }
}
