package pl.petergood.balancer.registry.service;

import org.junit.Test;
import pl.petergood.balancer.registry.model.Label;
import pl.petergood.balancer.registry.model.ServiceRegistrationRequest;

import java.util.Collections;
import static org.junit.Assert.*;

public class ServiceFactoryTest {

    @Test
    public void verifyServiceIsCreated() {
        // given
        ServiceRegistrationRequest serviceRegistrationRequest = new ServiceRegistrationRequest();
        serviceRegistrationRequest.setName("application");
        serviceRegistrationRequest.setLabels(Collections.singletonList(new Label("key", "value")));
        serviceRegistrationRequest.setAddress("localhost");

        // when
        Service service = ServiceFactory.createService(serviceRegistrationRequest);

        // then
        assertEquals("application", service.getName());
        assertEquals(Collections.singletonList(new Label("key", "value")), service.getLabels());
        assertEquals("localhost", service.getAddress());
    }

}
