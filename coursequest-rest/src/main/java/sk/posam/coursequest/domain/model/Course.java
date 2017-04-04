package sk.posam.coursequest.domain.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Course {
	private String name;
	private long id;
	private Collection<User> attendees;
	
	public Course (String name){
		attendees = new ArrayList<User>();
		this.name= name;
	}
	public long getId() {
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
