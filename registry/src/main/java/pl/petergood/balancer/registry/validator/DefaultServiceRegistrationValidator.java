package pl.petergood.balancer.registry.validator;

import org.springframework.stereotype.Component;
import pl.petergood.balancer.registry.model.ServiceRegistrationRequest;

@Component
public class DefaultServiceRegistrationValidator implements ServiceRegistrationValidator {
    @Override
    public boolean isValid(ServiceRegistrationRequest serviceRegistrationRequest) {
        return !(serviceRegistrationRequest.getName() == null
                || serviceRegistrationRequest.getAddress() == null);
    }
}
