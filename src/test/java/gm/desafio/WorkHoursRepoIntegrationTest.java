package gm.desafio;

import gm.desafio.repository.WorkHoursRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WorkHoursRepoIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private WorkHoursRepository workHoursRepository;

    @Test
    public void test() {



    }
}
