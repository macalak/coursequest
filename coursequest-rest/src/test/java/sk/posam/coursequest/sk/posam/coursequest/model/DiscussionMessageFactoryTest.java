package sk.posam.coursequest.sk.posam.coursequest.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import sk.posam.coursequest.domain.model.*;

public class DiscussionMessageFactoryTest {
	private String questionName;
	private User user;
	private Course course ;
	private DiscussionMessage question;
	
	@Before
	public void setUp(){
		questionName = "Ak� bol vplyv Aristotela na osvietenstvo?";
		user = new User("Jano");
		course = CourseFactory.create("Filozofia", user);
		question = DiscussionMessageFactory.create(questionName, user, course);
	}

	@Test
	public void testNazvuOtazky() {
		assertEquals(questionName, question.getName());
	}

	@Test
	public void testNazvuInejOtazky() {
		assertEquals(questionName, question.getName());
	}
	
	@Test
	public void testVratiExistujucaOtazkaNovuOdpoved() {
		DiscussionMessage answer  = DiscussionMessageFactory.create(question, "Odpoved", user);
		assertEquals("Odpoved", question.getChilds().iterator().next().getName());
	}
	
	
}
