package pl.petergood.balancer.registry.service;

import pl.petergood.balancer.registry.model.ServiceRegistrationRequest;

public class ServiceFactory {

    public static Service createService(ServiceRegistrationRequest serviceRegistrationRequest) {
        return new HttpService(serviceRegistrationRequest.getName(),
                serviceRegistrationRequest.getLabels(),
                serviceRegistrationRequest.getAddress());
    }

}
