package sk.posam.coursequest.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name="COURSE_TBL")
@NamedQueries(value = {
		@NamedQuery(name="course.findAll", query="SELECT c FROM Course c"),
		@NamedQuery(name="course.findByUser", query="SELECT c FROM Course c, User u  where u.id=:USER_ID")
})
public class Course {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	private String name;
	@ManyToMany(mappedBy="courses")
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
	public Collection<User> getAttendees(){
		return Collections.unmodifiableCollection(attendees);
	}

}
