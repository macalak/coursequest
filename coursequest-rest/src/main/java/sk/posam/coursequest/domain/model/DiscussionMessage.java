package sk.posam.coursequest.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;

// TODO 22: Mark this class as JPA entity

public class DiscussionMessage {
	// TODO 23: Primary key
	private long id;
	private String name;        // DiscussionMessage contain
	private String description; // It's not used
	// TODO 24: Timestamp
	private Date created;
	// TODO 25: Relation to course
	private Course course;
	// TODO 26: Relation to user
	private User user;
	// TODO 27: Relation to itself
	private Collection<DiscussionMessage> childs;
	// TODO 28: Relation to itself
	private DiscussionMessage parent;
	// TODO 29: Enumeration as string
	private DiscussionMessageType type;

	DiscussionMessage(String name, User user, Course course, DiscussionMessageType type) {
		this.name = Objects.requireNonNull(name);
		this.user = Objects.requireNonNull(user);
		this.course = Objects.requireNonNull(course);
		this.type = Objects.requireNonNull(type);
		this.childs = new ArrayList<>();
		this.parent = null;
	}

	DiscussionMessage(DiscussionMessage question, String answerName, User user, DiscussionMessageType type) {
		this.name = Objects.requireNonNull(answerName);
		this.user = Objects.requireNonNull(user);
		this.course = question.getCourse();
		this.type = Objects.requireNonNull(type);
		this.childs = new ArrayList<>();
		question.addChild(this);
	}

	public String getName() {
		return name;
	}

	public Course getCourse() {
		return course;
	}
	
	public DiscussionMessage getParent (){
		return parent;
	}
	
	public Collection<DiscussionMessage> getChilds() {
		return Collections.unmodifiableCollection(childs);
	}
	
	private void addChild(DiscussionMessage discussionMessage){
		childs.add(discussionMessage);
		discussionMessage.parent= this; 
	}

	public void setDescription(String description) {
		// TODO Auto-generated method stub
		this.description = description;
	}

	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	public Date getCreate() {
		// TODO Auto-generated method stub
		return created;
	}

	public User getUser() {
		// TODO Auto-generated method stub
		return user;
	}

}
