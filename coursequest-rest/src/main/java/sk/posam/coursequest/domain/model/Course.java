package sk.posam.coursequest.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name="COURSE_TBL")
public class Course {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable = false)
	private String name;
	@ManyToMany(mappedBy = "courses")
	private Collection<User> attendees= new ArrayList<User>();
	@OneToMany(mappedBy = "course")
	private Collection<DiscussionMessage> messages= new ArrayList<DiscussionMessage>();

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
	//public Collection<User> getAttendees(){
	//	return Collections.unmodifiableCollection(attendees);
	//}


	public Collection<DiscussionMessage> getMessages() {
		return messages;
	}

	public void setMessages(Collection<DiscussionMessage> messages) {
		this.messages = messages;
	}

	public Collection<User> getAttendees() {
		return attendees;
	}

	@Override
	public String toString() {
		return "Course{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
