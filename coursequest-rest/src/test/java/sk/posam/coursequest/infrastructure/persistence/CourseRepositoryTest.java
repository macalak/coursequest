package sk.posam.coursequest.infrastructure.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import sk.posam.coursequest.domain.model.Course;
import sk.posam.coursequest.domain.model.CourseFactory;
import sk.posam.coursequest.domain.model.User;
import sk.posam.coursequest.domain.repository.CourseRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by macalaki on 08.04.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CourseRepositoryTest {
    @Autowired
    CourseRepository testedComponent;
    Long id=0L;

    @Test @Transactional @Commit
    public void testCourseCreation(){
        Course course= new Course("Informatika");
        System.out.println(course);
        testedComponent.createCourse(course);
        System.out.println(course);
        Course justCreated = testedComponent.read(course.getId());
        System.out.println(justCreated);
        id=course.getId();

    }

    @Test
    public void readBack(){
        Course justCreated = testedComponent.read(7);
    }

}
