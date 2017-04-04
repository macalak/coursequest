package sk.posam.coursequest.infrastructure.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.posam.coursequest.domain.model.Course;
import sk.posam.coursequest.domain.model.CourseFactory;
import sk.posam.coursequest.domain.repository.CourseRepository;
import sk.posam.coursequest.domain.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by macalaki on 04.04.2017.
 */
@Repository
public class CourseRepositoryImpl implements CourseRepository {
    static Logger LOG = LoggerFactory.getLogger(CourseRepositoryImpl.class);
    private ConcurrentHashMap<Long,Collection<Course>> data = new ConcurrentHashMap<Long,Collection<Course>>();

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    private void init(){
        LOG.info("Initializing...");
        Collection<Course> coursesUser0=new ArrayList<Course>();
        Collection<Course> coursesUser1=new ArrayList<Course>();

        coursesUser0.add(CourseFactory.create("Course-A1",userRepository.get(0)));
        coursesUser0.add(CourseFactory.create("Course-B1",userRepository.get(0)));
        coursesUser1.add(CourseFactory.create("Course-A2",userRepository.get(1)));
        coursesUser1.add(CourseFactory.create("Course-B2",userRepository.get(1)));

        data.put(userRepository.get(0).getId(),coursesUser0);
        data.put(userRepository.get(1).getId(),coursesUser1);
    }

    @Override
    public Collection<Course> readByUser(long userId) {
        return data.get(userId);
    }

    @Override
    public void createCourse(Course course) {

    }

    @Override
    public Course read(long courseId) {
        return null;
    }
}
