package sk.posam.coursequest.application.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.posam.coursequest.application.api.CourseApi;
import sk.posam.coursequest.application.dto.DTOCourse;
import sk.posam.coursequest.application.dto.DTOCreateCourse;

import java.util.Collection;

/**
 * Created by macalaki on 04.04.2017.
 */
@RestController
public class CourseController {

    @Autowired
    CourseApi courseApi;

    // http://localhost:8080/api/1/courses
    @GetMapping(value = "/{userId}/courses", produces = "application/json; charset=UTF-8")
    public Collection<DTOCourse> coursesForUser(@PathVariable long userId){
        return courseApi.getList(userId);
    }

    // http://localhost:8080/api/courses?userid=1
    @GetMapping(value = "/courses", produces = "application/json; charset=UTF-8")
    public Collection<DTOCourse> coursesForUserWithQuery( @RequestParam("userid") long userId){
        return courseApi.getList(userId);
    }

    // {"name": "Informatika","userId": 1}
    // TODO 21: Mark as REST handler of POST
    public void course(@RequestBody DTOCreateCourse dtoCourse){
        courseApi.createCourse(dtoCourse);
    }

}
