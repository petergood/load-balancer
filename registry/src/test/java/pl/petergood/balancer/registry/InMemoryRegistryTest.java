package pl.petergood.balancer.registry;

import org.junit.Test;
import pl.petergood.balancer.registry.service.Service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

public class InMemoryRegistryTest {

    @Test
    public void verifyStorageOfServices() {
        // given
        Registry registry = new InMemoryRegistry();
        Service service = mock(Service.class);
        when(service.getName()).thenReturn("application");

        // when
        registry.addService(service);

        // then
        assertEquals("application", registry.getServices().iterator().next().getName());
    }

}
