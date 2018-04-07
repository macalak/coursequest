package sk.posam.coursequest.infrastructure.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import sk.posam.coursequest.domain.model.Course;
import sk.posam.coursequest.domain.model.DiscussionMessage;
import sk.posam.coursequest.domain.model.DiscussionMessageFactory;
import sk.posam.coursequest.domain.repository.CourseRepository;
import sk.posam.coursequest.domain.repository.DiscussionMessageRepository;
import sk.posam.coursequest.domain.repository.UserRepository;

/**
 * Created by macalaki on 08.04.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DiscussionRepositoryTest {
    @Autowired
    DiscussionMessageRepository testedComponent;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CourseRepository courseRepository;


    @Test @Transactional
    public void testCourseCreation(){
        Course course = courseRepository.read(6L);
        DiscussionMessage question = DiscussionMessageFactory.create("first", userRepository.get(1L),course);
        question.setDescription("Some interesting question?");
        course.getMessages().add(question);
        testedComponent.create(question);


    }
}
