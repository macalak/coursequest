package sk.posam.coursequest.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

// TODO 04: Make entity from this class
public class User {
	// TODO 05: Mark this as primary key
	private Long id;
	private String username;
	// TODO 06: Enumeration as string value
	private UserRole role;
	// TODO 07: Relation to Course
	private Collection<Course> courses = new ArrayList<Course>();;

	public User() {
	}

	public User(String name){
		this.username = name;
	}
	
	public Long getId(){
		return id;
	}
	
	public String getUsername(){
		return username;
	}

	public void addCourse(Course course){
		this.courses.add(course);
	}
	public Collection<Course> getCourses(){
		return Collections.unmodifiableCollection(courses);
	}
}
