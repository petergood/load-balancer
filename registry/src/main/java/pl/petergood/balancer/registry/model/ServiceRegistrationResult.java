package pl.petergood.balancer.registry.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ServiceRegistrationResult {
    @JsonProperty("success")
    @Getter
    @Setter
    private boolean success;

    @JsonProperty("message")
    @Getter
    @Setter
    private String message;
}
