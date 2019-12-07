package pl.petergood.balancer.registry.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@EqualsAndHashCode
public class Label {
    @JsonProperty("key")
    @Getter
    @Setter
    private String key;

    @JsonProperty("value")
    @Getter
    @Setter
    private String value;
}
