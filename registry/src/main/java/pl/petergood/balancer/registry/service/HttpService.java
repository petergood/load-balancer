package pl.petergood.balancer.registry.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import pl.petergood.balancer.registry.model.Label;

import java.util.List;
import java.util.Objects;

/**
 * @author Peter Nicholson
 * @since 1.0
 * Represents an HTTP server to which requests may be sent
 */
@AllArgsConstructor
@Builder
public class HttpService implements Service {

    @Getter
    private String name;

    @Getter
    private List<Label> labels;

    @Getter
    private String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HttpService that = (HttpService) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(labels, that.labels) &&
                Objects.equals(address, that.address);
    }
}
