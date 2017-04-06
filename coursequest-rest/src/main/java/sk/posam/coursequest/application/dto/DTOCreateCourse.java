package sk.posam.coursequest.application.dto;

public final class DTOCreateCourse {
	public String name;
	public Long userId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
