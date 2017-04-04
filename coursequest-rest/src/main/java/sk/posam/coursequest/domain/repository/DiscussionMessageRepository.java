package sk.posam.coursequest.domain.repository;

import sk.posam.coursequest.domain.model.DiscussionMessage;

public interface DiscussionMessageRepository {
	void create(DiscussionMessage discussionMessage);
	DiscussionMessage read(long messageId);

}
