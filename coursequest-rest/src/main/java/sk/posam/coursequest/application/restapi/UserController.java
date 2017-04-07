package sk.posam.coursequest.application.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sk.posam.coursequest.application.api.CourseApi;
import sk.posam.coursequest.application.api.UserApi;
import sk.posam.coursequest.application.dto.DTOCourse;
import sk.posam.coursequest.domain.model.User;

import java.util.Collection;
import java.util.List;

/**
 * Created by macalaki on 04.04.2017.
 */
// TODO 17: This is the REST controller
public class UserController {

    // TODO 18: Inject API implementation
    UserApi userApi;

    // TODO 19: Mark as REST handler of the GET
    public User user(@PathVariable long userId){
        return userApi.getUser(userId);
    }

    // TODO 20: Mark as REST handler of the GET
    public Collection<User> users(){
        return userApi.getAll();
    }
}
