package sk.posam.coursequest.application.api;

import sk.posam.coursequest.application.dto.DTOMessageTree;
import sk.posam.coursequest.application.dto.DTOQuestion;

public interface DiscussionApi {
	void createQuestion(DTOQuestion dtoQuestion);
	DTOMessageTree getMessageExpanded(long messageId);

}
