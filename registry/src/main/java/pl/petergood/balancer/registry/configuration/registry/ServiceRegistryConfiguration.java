package pl.petergood.balancer.registry.configuration.registry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.petergood.balancer.registry.InMemoryRegistry;
import pl.petergood.balancer.registry.Registry;
import pl.petergood.balancer.registry.health.HealthCheckOrchestrator;

@Configuration
public class ServiceRegistryConfiguration {

    @Autowired
    private HealthCheckOrchestrator healthCheckOrchestrator;

    @Bean
    public Registry getDefaultServiceRegistry() {
        InMemoryRegistry inMemoryRegistry = new InMemoryRegistry();
        inMemoryRegistry.addObserver(healthCheckOrchestrator);

        return inMemoryRegistry;
    }

}
