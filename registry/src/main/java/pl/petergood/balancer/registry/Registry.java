package pl.petergood.balancer.registry;

import pl.petergood.balancer.registry.service.Service;

import java.util.Collection;

public interface Registry {
    Collection<Service> getServices();
    void addService(Service service);
}
