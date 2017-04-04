package sk.posam.coursequest.domain.model;

public class DiscussionMessageFactory {

	public static DiscussionMessage create(String questionName, User user, Course course) {
		
		return new DiscussionMessage(questionName, user, course, DiscussionMessageType.QUESTION);
	}

	public static DiscussionMessage create(DiscussionMessage question, String answerName, User user) {
		
		return new DiscussionMessage(question, answerName, user, DiscussionMessageType.ANSWER);
	}

}
