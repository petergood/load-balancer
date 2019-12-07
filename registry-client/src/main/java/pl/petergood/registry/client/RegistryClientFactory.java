package pl.petergood.registry.client;

import pl.petergood.registry.client.transport.HttpClientFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class RegistryClientFactory {

    public static RegistryClient getRegistryClient() {
        String registryURLRaw = System.getProperty("registry.client.url");
        if (registryURLRaw == null) {
            throw new RegistryClientBootstrappingException("registry.client.url property not found.");
        }

        try {
            return getRegistryClient(new URL(registryURLRaw));
        } catch (MalformedURLException e) {
            throw new RegistryClientBootstrappingException("registry.client.url url is malformed: " + e.getMessage());
        }
    }

    public static RegistryClient getRegistryClient(URL registryURL) {
        try {
            return new DefaultRegistryClient(registryURL, HttpClientFactory.getHttpClient());
        } catch (MalformedURLException e) {
            throw new RegistryClientBootstrappingException("Registry url is malformed: " + e.getMessage());
        }
    }

}
