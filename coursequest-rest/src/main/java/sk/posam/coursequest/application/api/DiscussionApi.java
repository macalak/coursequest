package sk.posam.coursequest.application.api;

import sk.posam.coursequest.application.dto.DTOMessageTree;

public interface DiscussionApi {
	void createQuestion(long courseId, String name, String description, long userId);
	DTOMessageTree getMessageExpanded(long messageId);

}
