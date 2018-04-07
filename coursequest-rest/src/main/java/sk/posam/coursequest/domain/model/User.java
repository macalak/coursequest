package sk.posam.coursequest.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name="USER_TBL")
@NamedQueries(@NamedQuery(name="user.selectAll", query = "from User"))
public class User {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(length = 128, nullable = false)
	private String username;
	@Column(length = 64, nullable = false)
	@Enumerated(EnumType.STRING)
	private UserRole role;
	@ManyToMany
	@JoinTable(
			name="USER_COURSE_TBL",
			joinColumns=@JoinColumn(name="USER_ID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="COURSE_ID", referencedColumnName="ID"))
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
