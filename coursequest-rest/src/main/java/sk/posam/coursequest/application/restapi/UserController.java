package sk.posam.coursequest.application.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sk.posam.coursequest.application.api.CourseApi;
import sk.posam.coursequest.application.api.UserApi;
import sk.posam.coursequest.application.dto.DTOCourse;
import sk.posam.coursequest.application.dto.DTOUser;
import sk.posam.coursequest.domain.model.User;

import java.util.Collection;
import java.util.List;

/**
 * Created by macalaki on 04.04.2017.
 */

@RestController
public class UserController {

    @Autowired
    UserApi userApi;

    @GetMapping(value = "/users/{userId}", produces = "application/json; charset=UTF-8")
    public DTOUser user(@PathVariable long userId){
        return userApi.getUser(userId);
    }

    @GetMapping(value = "/users", produces = "application/json; charset=UTF-8")
    public Collection<DTOUser> users(){
        return userApi.getAll();
    }
}
