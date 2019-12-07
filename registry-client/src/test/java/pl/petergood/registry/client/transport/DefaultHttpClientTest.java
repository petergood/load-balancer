package pl.petergood.registry.client.transport;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import okhttp3.OkHttpClient;
import org.junit.Rule;
import org.junit.Test;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class DefaultHttpClientTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8000);

    private OkHttpClient okHttpClientMock = new OkHttpClient();
    private HttpClient httpClient = new DefaultHttpClient(okHttpClientMock);

    @Test
    public void verifyPostRequestIsSent() throws Exception {
        // given
        URL requestURL = new URL("http://localhost:8000/endpoint");
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Basic somebase64");
        String body = "{\"field\":\"value\"}";

        stubFor(post("/endpoint")
            .withHeader("Content-Type", equalTo("application/json; charset=UTF-8"))
            .withRequestBody(equalToJson(body)).willReturn(
                   aResponse()
                   .withStatus(200)
                   .withHeader("Content-Type", "application/json")
                   .withHeader("Authorization", "Basic somebase64")
                   .withBody("{\"message\":\"hello\"}")));

        // when
        String responseBody = httpClient.postToURL(requestURL, headers, body);

        // then
        assertEquals("{\"message\":\"hello\"}", responseBody);
    }


}
