package pl.java.scalatech;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.java.scalatech.config.RepositoryConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RepositoryConfig.class })
@ActiveProfiles(profiles="dev")
@Transactional
public class ConversionConfigTest {

    @Test
    public void shouldTest(){
                   
    }
    
}
