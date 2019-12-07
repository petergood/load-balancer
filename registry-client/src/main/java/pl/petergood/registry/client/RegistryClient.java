package pl.petergood.registry.client;

import pl.petergood.balancer.registry.model.ServiceRegistrationRequest;

public interface RegistryClient {
    void registerService(ServiceRegistrationRequest serviceRegistrationRequest) throws ServiceRegistrationException;
}
