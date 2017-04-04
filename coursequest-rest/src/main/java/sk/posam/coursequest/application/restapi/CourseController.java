package sk.posam.coursequest.application.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sk.posam.coursequest.application.api.CourseApi;
import sk.posam.coursequest.application.dto.DTOCourse;

import java.util.Collection;

/**
 * Created by macalaki on 04.04.2017.
 */
@RestController
public class CourseController {

    @Autowired
    CourseApi courseApi;

    @GetMapping(value = "/{userId}/courses", produces = "application/json; charset=UTF-8")
    public Collection<DTOCourse> courses(@PathVariable long userId){
        return courseApi.getList(userId);
    }

}
