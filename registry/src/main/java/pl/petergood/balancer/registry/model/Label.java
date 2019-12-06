package pl.petergood.balancer.registry.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
public class Label {
    @JsonProperty("key")
    @Getter
    @Setter
    private String key;

    @JsonProperty("value")
    @Getter
    @Setter
    private String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return Objects.equals(key, label.key) &&
                Objects.equals(value, label.value);
    }
}
