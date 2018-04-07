package sk.posam.coursequest.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.posam.coursequest.application.dto.DTOMessageTree;
import sk.posam.coursequest.application.api.DiscussionApi;
import sk.posam.coursequest.application.dto.DTOQuestion;
import sk.posam.coursequest.domain.model.Course;
import sk.posam.coursequest.domain.repository.CourseRepository;
import sk.posam.coursequest.domain.model.DiscussionMessage;
import sk.posam.coursequest.domain.model.DiscussionMessageFactory;
import sk.posam.coursequest.domain.repository.DiscussionMessageRepository;
import sk.posam.coursequest.domain.model.User;
import sk.posam.coursequest.domain.repository.UserRepository;

@Service
@Transactional
public class DiscussionApiService implements DiscussionApi {
	@Autowired
	UserRepository userRepository;
	@Autowired
	DiscussionMessageRepository discussionMessageRepository;
	@Autowired
	CourseRepository courseRepository;

	@Override
	public void createQuestion(DTOQuestion dtoQuestion) {

		User user = userRepository.get(dtoQuestion.userId);
		Course course = courseRepository.read(dtoQuestion.courseId);
		DiscussionMessage question = DiscussionMessageFactory.create(dtoQuestion.name, user, course);
		question.setDescription(dtoQuestion.description);
		course.getMessages().add(question);
		discussionMessageRepository.create(question);
	}

	@Override
	public DTOMessageTree getMessageExpanded(long messageId) {

		DiscussionMessage discussionMessage =  discussionMessageRepository.read(messageId);
		
		return toDTO(discussionMessage);
	}
	
	private DTOMessageTree toDTO (DiscussionMessage discussionMessage){
		DTOMessageTree result = new DTOMessageTree();
		result.id = discussionMessage.getId();
		result.name = discussionMessage.getName();
		result.description = discussionMessage.getDescription();
		result.created = discussionMessage.getCreate();
		result.createdBy = discussionMessage.getUser().getUsername();

		for (DiscussionMessage dm : discussionMessage.getChilds()){
			result.reactions.add(toDTO(dm));
		}
		return result;
	}

}
