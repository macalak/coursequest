package sk.posam.coursequest.application.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.posam.coursequest.application.api.CourseApi;
import sk.posam.coursequest.application.api.DiscussionApi;
import sk.posam.coursequest.application.dto.DTOCourse;
import sk.posam.coursequest.application.dto.DTOCreateCourse;
import sk.posam.coursequest.application.dto.DTOQuestion;

import java.util.Collection;

/**
 * Created by macalaki on 04.04.2017.
 */
@RestController
public class DiscussionController {

    @Autowired
    DiscussionApi discussionApi;

    //{"courseId":6, "userId":1, "name":"first one", "description":"question"}
    @PostMapping(value = "/questions", consumes = "application/json; charset=UTF-8")
    public void createQuestion(@RequestBody DTOQuestion dtoQuestion){
        discussionApi.createQuestion(dtoQuestion);
    }

}
