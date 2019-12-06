package pl.petergood.balancer.registry.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Label {
    @JsonProperty("key")
    private String key;

    @JsonProperty("value")
    private String value;

    public Label(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return Objects.equals(key, label.key) &&
                Objects.equals(value, label.value);
    }
}
