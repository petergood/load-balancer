package pl.petergood.balancer.registry.health;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import pl.petergood.balancer.registry.Registry;
import pl.petergood.balancer.registry.RegistryApplication;
import pl.petergood.balancer.registry.service.HttpService;
import pl.petergood.balancer.registry.service.Service;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {RegistryApplication.class, HealthCheckOrchestratorObserverTest.TestConfiguration.class})
@TestPropertySource("classpath:application.properties")
public class HealthCheckOrchestratorObserverTest {

    @Autowired
    private Registry registry;

    @Autowired
    private HealthCheckOrchestrator healthCheckOrchestratorMock;

    @Test
    public void verifyServiceCreationEventIsDispatched() {
        // given
        Service service = HttpService.builder()
                .name("test")
                .address("localhost:9200")
                .build();

        // when
        registry.addService(service);

        // then
        verify(healthCheckOrchestratorMock, times(1)).handleEvent(eq(service));
    }

    @Configuration
    public static class TestConfiguration {
        @Bean
        @Primary
        public HealthCheckOrchestrator mockHealthCheckOrchestrator() {
            return mock(HealthCheckOrchestrator.class);
        }
    }
}
