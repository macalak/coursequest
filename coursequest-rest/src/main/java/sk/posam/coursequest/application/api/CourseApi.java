package sk.posam.coursequest.application.api;

import sk.posam.coursequest.application.dto.DTOCourse;

import java.util.Collection;

public interface CourseApi {
	Collection<DTOCourse> getList(long userId);
	void createCourse (String courseName, long userId);

}
