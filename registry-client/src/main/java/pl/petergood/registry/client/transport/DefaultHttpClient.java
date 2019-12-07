package pl.petergood.registry.client.transport;

import okhttp3.*;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class DefaultHttpClient implements HttpClient {
    private final OkHttpClient httpClient;
    private final MediaType defaultMediaType = MediaType.get("application/json");

    public DefaultHttpClient(OkHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public String postToURL(URL url, Map<String, String> headers, String requestBodyRaw) throws IOException {
        String requestContentType = headers.get("Content-Type");
        RequestBody requestBody = RequestBody.create(requestBodyRaw,
                requestContentType == null ? defaultMediaType : MediaType.get(requestContentType));

        Headers requestHeaders = Headers.of(headers);
        Request httpRequest = new Request.Builder()
                .url(url)
                .post(requestBody)
                .headers(requestHeaders)
                .build();

        try (Response response = httpClient.newCall(httpRequest).execute()) {
            if (response.body() == null) {
                throw new IOException("Response body cannot be null.");
            }

            return response.body().string();
        }
    }
}
