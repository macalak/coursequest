package sk.posam.coursequest.domain.repository;

import sk.posam.coursequest.domain.model.Course;

import java.util.Collection;

public interface CourseRepository {
	Collection<Course> readByUser (long userId);
	void createCourse (Course course);
	Course read(long courseId);

}
