package sk.posam.coursequest.infrastructure.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.posam.coursequest.domain.model.Course;
import sk.posam.coursequest.domain.model.CourseFactory;
import sk.posam.coursequest.domain.model.User;
import sk.posam.coursequest.domain.repository.CourseRepository;
import sk.posam.coursequest.domain.repository.UserRepository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by macalaki on 04.04.2017.
 */
// TODO 12: This is repository
public class CourseRepositoryImpl implements CourseRepository {
    static Logger LOG = LoggerFactory.getLogger(CourseRepositoryImpl.class);

    // TODO 13: Inject EntityManager
    private EntityManager entityManager;

    @Override
    public Collection<Course> readByUser(long userId) {
       // TODO 14: Implementation
       return  null;
    }

    @Override
    public void createCourse(Course course) {
        // TODO 15: Implementation

    }

    @Override
    public Course read(long courseId) {
        // TODO 16: Implementation
        return null;
    }
}
