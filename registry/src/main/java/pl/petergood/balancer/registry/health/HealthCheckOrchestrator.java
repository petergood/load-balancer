package pl.petergood.balancer.registry.health;

import org.springframework.stereotype.Component;
import pl.petergood.balancer.common.observer.Observer;
import pl.petergood.balancer.registry.service.Service;

@Component
public class HealthCheckOrchestrator implements Observer<Service> {
    @Override
    public void handleEvent(Service event) {
    }
}
