package pl.petergood.balancer.registry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { RegistryApplication.class })
@TestPropertySource(locations = "classpath:application.properties")
public class RegistryApplicationTest {
    @Test
    public void contextLoads() {
    }
}
