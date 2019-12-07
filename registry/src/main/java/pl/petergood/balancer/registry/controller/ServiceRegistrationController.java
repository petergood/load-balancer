package pl.petergood.balancer.registry.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.petergood.balancer.registry.Registry;
import pl.petergood.balancer.registry.model.ServiceRegistrationRequest;
import pl.petergood.balancer.registry.model.ServiceRegistrationResult;
import pl.petergood.balancer.registry.service.ServiceFactory;
import pl.petergood.balancer.registry.validator.ServiceRegistrationValidator;

import java.util.List;

/**
 * @author Peter Nicholson
 * @since 1.0
 * Controller handling Service registration.
 * <p>Services register upon startup or after receiving the REGISTRY_AVAILABLE event</p>
 */
@RestController
public class ServiceRegistrationController {

    /**
     * Service validators to run after receiving a registration request
     */
    private List<ServiceRegistrationValidator> serviceRegistrationValidators;

    /**
     * Service registry backing this node
     */
    private Registry registry;

    public ServiceRegistrationController(List<ServiceRegistrationValidator> serviceRegistrationValidators,
                                         Registry registry) {
        this.serviceRegistrationValidators = serviceRegistrationValidators;
        this.registry = registry;
    }

    @PostMapping("/register")
    public ServiceRegistrationResult register(@RequestBody ServiceRegistrationRequest serviceRegistrationRequest) {
        for (ServiceRegistrationValidator serviceRegistrationValidator : serviceRegistrationValidators) {
            if (!serviceRegistrationValidator.isValid(serviceRegistrationRequest)) {
                return new ServiceRegistrationResult(false, "Invalid registration request.");
            }
        }

        registry.addService(ServiceFactory.createService(serviceRegistrationRequest));
        return new ServiceRegistrationResult(true, "Service registered successfully.");
    }

}
