package pl.petergood.balancer.registry;

import pl.petergood.balancer.registry.service.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Peter Nicholson
 * @since 1.0
 * <p>A simple in-memory service registry, local to one Registry node</p>
 * <p>Usage meant for single node Registry setup and testing</p>
 */
public class InMemoryRegistry implements Registry {
    /**
     * The Set backing this registry
     */
    private Set<Service> services = Collections.synchronizedSet(new HashSet<>());

    @Override
    public Collection<Service> getServices() {
        return services;
    }

    @Override
    public void addService(Service service) {
        services.add(service);
    }
}
