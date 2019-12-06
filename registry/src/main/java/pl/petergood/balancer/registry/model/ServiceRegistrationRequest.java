package pl.petergood.balancer.registry.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
public class ServiceRegistrationRequest {
    @JsonProperty(value = "name", required = true)
    @Getter
    @Setter
    private String name;

    @JsonProperty("labels")
    @Getter
    @Setter
    private List<Label> labels;

    @JsonProperty(value = "address", required = true)
    @Getter
    @Setter
    private String address;
}
