package pl.petergood.registry.client.transport;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

public interface HttpClient {
    String postToURL(URL url, Map<String, String> headers, String requestBody) throws IOException;
}
