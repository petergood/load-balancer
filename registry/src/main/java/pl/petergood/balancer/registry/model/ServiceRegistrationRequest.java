package pl.petergood.balancer.registry.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

public class ServiceRegistrationRequest {
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("labels")
    private List<Label> labels;

    @JsonProperty(value = "address", required = true)
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Label> getLabels() {
        return labels == null ? Collections.emptyList() : labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
