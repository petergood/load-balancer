package pl.petergood.balancer.registry.validator;

import pl.petergood.balancer.registry.model.ServiceRegistrationRequest;

public interface ServiceRegistrationValidator {
    boolean isValid(ServiceRegistrationRequest serviceRegistrationRequest);
}
