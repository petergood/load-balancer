package pl.petergood.balancer.registry.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import pl.petergood.balancer.registry.model.Label;

import java.util.List;

/**
 * @author Peter Nicholson
 * @since 1.0
 * Represents an HTTP server to which requests may be sent
 */
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class HttpService implements Service {

    @Getter
    private String name;

    @Getter
    private List<Label> labels;

    @Getter
    private String address;
}
