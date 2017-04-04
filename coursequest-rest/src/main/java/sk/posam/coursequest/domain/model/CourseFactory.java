package sk.posam.coursequest.domain.model;

public final class CourseFactory {
	
	public static Course create(String courseName, User user){
		Course course = new Course(courseName);
		course.addAttendee(user);
		return course;
	}

	private CourseFactory() {
		// no instances
	}
}
