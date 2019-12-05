package pl.petergood.balancer.registry.configuration.etcd;

import io.etcd.jetcd.Client;
import io.etcd.jetcd.KV;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EtcdConfiguration {

    private final String endpoint;

    public EtcdConfiguration(@Value("${balancer.registry.etcd.endpoint}") String endpoint) {
        this.endpoint = endpoint;
    }

    @Bean
    public KV createEtcdClient() {
        return Client.builder().endpoints(endpoint).build()
                .getKVClient();
    }

}
