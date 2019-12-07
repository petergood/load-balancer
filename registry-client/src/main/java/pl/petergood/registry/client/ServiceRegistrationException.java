package pl.petergood.registry.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ServiceRegistrationException extends RuntimeException {
    private String message;
}
