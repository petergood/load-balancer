package pl.petergood.balancer.registry.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.petergood.balancer.registry.Registry;
import pl.petergood.balancer.registry.RegistryApplication;
import pl.petergood.balancer.registry.model.Label;
import pl.petergood.balancer.registry.service.HttpService;
import pl.petergood.balancer.registry.service.Service;

import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RegistryApplication.class)
@AutoConfigureMockMvc
public class ServiceRegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Registry serviceRegistry;

    @Test
    public void verifyServiceIsRegistered() throws Exception {
        // given
        String requestBody = "{\"name\": \"application\", \"address\":\"localhost\", \"labels\":[{\"key\":\"test\", \"value\":\"test app\"}]}";
        Service expectedService = new HttpService("application", Collections.singletonList(new Label("test", "test app")), "localhost");
        Set<Service> expectedServices = Collections.singleton(expectedService);

        // when
        mockMvc.perform(post("/register")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().json("{\"success\": true, \"message\": \"Service registered successfully.\"}"));

        // then
        assertEquals(expectedServices, serviceRegistry.getServices());
    }

    @Test
    public void verifyInvalidServiceRequestDoesNotRegisterService() throws Exception {
        // given
        String requestBody = "{\"name\": \"invalid application\", \"labels\":[{\"key\":\"test\", \"value\":\"test app\"}]}";

        // when
        mockMvc.perform(post("/register")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"success\": false, \"message\": \"Invalid registration request.\"}"));

        // then
        serviceRegistry.getServices().forEach((service) -> assertNotEquals("invalid application", service.getName()));
    }

}
