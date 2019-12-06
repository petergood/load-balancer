package pl.petergood.balancer.registry.validator;

import org.junit.Test;
import pl.petergood.balancer.registry.model.ServiceRegistrationRequest;
import static org.junit.Assert.*;

public class DefaultServiceRegistrationValidatorTest {

    private ServiceRegistrationValidator validator = new DefaultServiceRegistrationValidator();

    @Test
    public void shouldValidateValidRegistrationRequest() {
        // given
        ServiceRegistrationRequest serviceRegistrationRequest = ServiceRegistrationRequest.builder()
                .name("application")
                .address("localhost")
                .build();

        // when
        boolean validationResult = validator.isValid(serviceRegistrationRequest);

        // then
        assertTrue(validationResult);
    }

    @Test
    public void shouldValidateInvalidRegistrationRequest() {
        // given
        ServiceRegistrationRequest serviceRegistrationRequest = ServiceRegistrationRequest.builder()
                .build();

        // when
        boolean validationResult = validator.isValid(serviceRegistrationRequest);

        // then
        assertFalse(validationResult);
    }

}
