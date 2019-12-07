package pl.petergood.registry.client;

import org.junit.Test;
import pl.petergood.balancer.registry.model.ServiceRegistrationRequest;
import pl.petergood.registry.client.transport.HttpClient;

import java.net.URL;
import java.util.Collections;

import static org.mockito.Mockito.*;

public class DefaultRegistryClientTest {

    @Test
    public void verifyRegistrationEndpointIsCalled() throws Exception {
        // given
        HttpClient httpClient = mock(HttpClient.class);
        RegistryClient registryClient = new DefaultRegistryClient(new URL("http://localhost:8080"), httpClient);

        ServiceRegistrationRequest serviceRegistrationRequest = ServiceRegistrationRequest.builder()
                .name("application")
                .address("localhost:9200")
                .build();

        when(httpClient.postToURL(
                eq(new URL("http://localhost:8080/register")),
                eq(Collections.singletonMap("Content-Type", "application/json")),
                eq("{\"name\":\"application\",\"address\":\"localhost:9200\"}")
        )).thenReturn("{\"success\":true,\"message\":\"Service registered\"}");

        // then
        registryClient.registerService(serviceRegistrationRequest);
    }

    @Test(expected = ServiceRegistrationException.class)
    public void verifyExceptionIsThrownWhenCannotRegister() throws Exception {
        // given
        HttpClient httpClient = mock(HttpClient.class);
        RegistryClient registryClient = new DefaultRegistryClient(new URL("http://localhost:8080"), httpClient);

        ServiceRegistrationRequest serviceRegistrationRequest = ServiceRegistrationRequest.builder()
                .name("application")
                .address("localhost:9200")
                .build();

        when(httpClient.postToURL(
                eq(new URL("http://localhost:8080/register")),
                eq(Collections.singletonMap("Content-Type", "application/json")),
                eq("{\"name\":\"application\",\"address\":\"localhost:9200\"}")
        )).thenReturn("{\"success\":false,\"message\":\"Service not registered\"}");

        // then
        registryClient.registerService(serviceRegistrationRequest);
    }
}
