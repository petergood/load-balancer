package pl.petergood.balancer.registry.configuration.registry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.petergood.balancer.registry.InMemoryRegistry;
import pl.petergood.balancer.registry.Registry;

@Configuration
public class ServiceRegistryConfiguration {

    @Bean
    public Registry getDefaultServiceRegistry() {
        return new InMemoryRegistry();
    }

}
