package pl.petergood.balancer.registry.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceRegistrationResult {
    @JsonProperty("success")
    private boolean success;

    @JsonProperty("message")
    private String message;

    public ServiceRegistrationResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
