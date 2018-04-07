package sk.posam.coursequest.infrastructure.persistence;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import sk.posam.coursequest.domain.repository.UserRepository;

/**
 * Created by macalaki on 08.04.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserRepositoryTest {
    @Autowired
    UserRepository testedRepository;

    @Test
    public void getAllUsers(){
        Assert.assertEquals(5, testedRepository.getAll().size());
    }
}
