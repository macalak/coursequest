package sk.posam.coursequest.sk.posam.coursequest.model;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import sk.posam.coursequest.domain.model.Course;
import sk.posam.coursequest.domain.model.CourseFactory;
import sk.posam.coursequest.domain.model.User;

public class CourseFactoryTest {

	@Test
	public void testCourseFactoryReturnsRightName() {
		User user = new User("Jano");
		Course course = CourseFactory.create("Filozofia", user);
		Assert.assertEquals("Filozofia", course.getName());
	}

	@Test
	public void testCourseFactoryAttendeeIsInCourse() {
		User user = new User("Jano");
		Course course = CourseFactory.create("Filozofia", user);
		Collection<User> attenadees = course.getAttendees();
		Assert.assertEquals(user, attenadees.iterator().next() );
	}
	@Test
	public void test() {
		User user = new User("Jano");
		Course course = CourseFactory.create("Filozofia", user);
		Collection<User> attenadees = course.getAttendees();
		Assert.assertEquals(user, attenadees.iterator().next() );
	}
	
}
