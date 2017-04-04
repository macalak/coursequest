package sk.posam.coursequest.domain.model;

public class User {
	private String name;
	private UserRole role;
	private long id;
	
	static long idGen = 0;
	
	public User(String name){
		this.name = name;
		id = idGen++;
	}
	
	public long getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}

}
