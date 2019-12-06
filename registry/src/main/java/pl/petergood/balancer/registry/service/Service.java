package pl.petergood.balancer.registry.service;

import pl.petergood.balancer.registry.model.Label;

import java.util.List;

/**
 * @author Peter Nicholson
 * @since 1.0
 * <p>Represents a generic Service available on a network</p>
 * <p>Services are described by names (which do not have to be unique) and key-value labels.</p>
 */
public interface Service {
    String getName();
    List<Label> getLabels();
    String getAddress();
}
