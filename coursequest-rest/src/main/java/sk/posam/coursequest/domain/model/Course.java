package sk.posam.coursequest.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

// TODO 01: Make entity from this class
public class Course {
	// TODO 02: Mark this as primary key
	private Long id;
	private String name;
	// TODO 03: Course is related to User
	private Collection<User> attendees= new ArrayList<User>();
	// TODO 30: Course is related to DiscussionMessage


	public Course() {
	}

	public Course (String name){
		this.name= name;
	}

	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void addAttendee(User user){
		this.attendees.add(user);
	}
	public Collection<User> getAttendees(){
		return Collections.unmodifiableCollection(attendees);
	}

}
