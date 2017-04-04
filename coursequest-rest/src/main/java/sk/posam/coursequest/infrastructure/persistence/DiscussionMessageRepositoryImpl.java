package sk.posam.coursequest.infrastructure.persistence;

import org.springframework.stereotype.Repository;
import sk.posam.coursequest.domain.model.DiscussionMessage;
import sk.posam.coursequest.domain.repository.DiscussionMessageRepository;

/**
 * Created by macalaki on 04.04.2017.
 */
@Repository
public class DiscussionMessageRepositoryImpl implements DiscussionMessageRepository {
    @Override
    public void create(DiscussionMessage discussionMessage) {

    }

    @Override
    public DiscussionMessage read(long messageId) {
        return null;
    }
}
