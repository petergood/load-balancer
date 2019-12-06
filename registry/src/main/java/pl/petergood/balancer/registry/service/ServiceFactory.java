package pl.petergood.balancer.registry.service;

import pl.petergood.balancer.registry.model.ServiceRegistrationRequest;

public class ServiceFactory {

    public static Service createService(ServiceRegistrationRequest serviceRegistrationRequest) {
        return HttpService.builder()
                .name(serviceRegistrationRequest.getName())
                .address(serviceRegistrationRequest.getAddress())
                .labels(serviceRegistrationRequest.getLabels())
                .build();
    }

}
