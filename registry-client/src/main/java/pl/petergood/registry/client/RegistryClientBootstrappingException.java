package pl.petergood.registry.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RegistryClientBootstrappingException extends RuntimeException {
    String message;
}
