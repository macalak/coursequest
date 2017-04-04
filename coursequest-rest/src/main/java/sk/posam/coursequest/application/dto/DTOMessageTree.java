package sk.posam.coursequest.application.dto;

import java.util.Date;
import java.util.List;

public class DTOMessageTree {
	public long id;
	public String name;
	public String description;
	public Date created;
	public String createdBy;
	public List<DTOMessageTree> reactions;

}
