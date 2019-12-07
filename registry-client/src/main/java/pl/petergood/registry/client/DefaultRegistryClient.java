package pl.petergood.registry.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.Http;
import okhttp3.*;
import pl.petergood.balancer.registry.model.ServiceRegistrationRequest;
import pl.petergood.balancer.registry.model.ServiceRegistrationResult;
import pl.petergood.registry.client.transport.HttpClient;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Map;

/**
 * @author Peter Nicholson
 * @since 1.0
 * Default HTTP-based service registry client
 */
public class DefaultRegistryClient implements RegistryClient {
    private final HttpClient httpClient;
    private ObjectMapper objectMapper = new ObjectMapper();

    private final URL registryURL;
    private final URL registerServiceURL;

    public DefaultRegistryClient(URL registryURL,
                                 HttpClient httpClient) throws MalformedURLException {
        this.registryURL = registryURL;
        this.registerServiceURL = new URL(this.registryURL, "register");
        this.httpClient = httpClient;
    }

    @Override
    public void registerService(ServiceRegistrationRequest serviceRegistrationRequest) throws ServiceRegistrationException {
        try {
            String jsonPayload = objectMapper.writeValueAsString(serviceRegistrationRequest);
            String response = httpClient.postToURL(registerServiceURL, Collections.singletonMap("Content-Type", "application/json"), jsonPayload);

            ServiceRegistrationResult result = objectMapper.readValue(response, ServiceRegistrationResult.class);
            if (!result.isSuccess()) {
                throw new ServiceRegistrationException(result.getMessage());
            }
        } catch (Exception e) {
            throw new ServiceRegistrationException();
        }
    }
}
