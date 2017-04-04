package sk.posam.coursequest.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.posam.coursequest.application.dto.DTOMessageTree;
import sk.posam.coursequest.application.api.DiscussionApi;
import sk.posam.coursequest.domain.model.Course;
import sk.posam.coursequest.domain.repository.CourseRepository;
import sk.posam.coursequest.domain.model.DiscussionMessage;
import sk.posam.coursequest.domain.model.DiscussionMessageFactory;
import sk.posam.coursequest.domain.repository.DiscussionMessageRepository;
import sk.posam.coursequest.domain.model.User;
import sk.posam.coursequest.domain.repository.UserRepository;

@Service
public class DiscussionApiService implements DiscussionApi {
	@Autowired
	UserRepository userRepository;
	@Autowired
	DiscussionMessageRepository discussionMessageRepository;
	@Autowired
	CourseRepository courseRepository;

	@Override
	public void createQuestion(long courseId, String name, String description, long userId) {

		User user = userRepository.get(userId);
		Course course = courseRepository.read(courseId);
		DiscussionMessage question = DiscussionMessageFactory.create(name, user, course);
		question.setDescription(description);

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
		result.createdBy = discussionMessage.getUser().getName();

		for (DiscussionMessage dm : discussionMessage.getChilds()){
			result.reactions.add(toDTO(dm));
		}
		return result;
	}

}
