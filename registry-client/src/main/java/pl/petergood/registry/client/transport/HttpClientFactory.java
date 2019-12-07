package pl.petergood.registry.client.transport;

import okhttp3.OkHttpClient;

public class HttpClientFactory {

    public static HttpClient getHttpClient() {
        return new DefaultHttpClient(new OkHttpClient());
    }

}
