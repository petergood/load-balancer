package pl.petergood.balancer.registry.service;

import pl.petergood.balancer.registry.model.Label;

import java.util.List;
import java.util.Objects;

/**
 * @author Peter Nicholson
 * @since 1.0
 * Represents an HTTP server to which requests may be sent
 */
public class HttpService implements Service {

    private String name;
    private List<Label> labels;
    private String address;

    public HttpService(String name, List<Label> labels, String address) {
        this.name = name;
        this.labels = labels;
        this.address = address;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Label> getLabels() {
        return labels;
    }

    @Override
    public String getAddress() {
        return address;
    }

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
