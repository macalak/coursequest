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
@Repository
public class CourseRepositoryImpl implements CourseRepository {
    static Logger LOG = LoggerFactory.getLogger(CourseRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collection<Course> readByUser(long userId) {
        String query = "SELECT  c.* " +
                       "FROM  USER_COURSE uc INNER JOIN " +
                       "USER_TBL u ON uc.user_id = u.id INNER JOIN " +
                       "COURSE_TBL c ON uc.course_id = c.id " +
                       "WHERE u.id = :USER_ID";
        Query nativeQuery = entityManager.createNativeQuery(query, Course.class);
        nativeQuery.setParameter("USER_ID",userId);
        List<Course> list = nativeQuery.getResultList();
        return list;
    }

    @Override
    public void createCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course read(long courseId) {
        return entityManager.find(Course.class, courseId);
    }
}
