package pl.petergood.balancer.registry.backend;

import io.etcd.jetcd.Client;
import io.etcd.jetcd.KV;
import io.etcd.jetcd.launcher.junit4.EtcdClusterResource;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/*
 * This test requires DOCKER_HOST environment variable to be set
 * See testcontainers documentation for more details
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { EtcdBackend.class, EtcdBackendTest.TestContext.class})
@Ignore("Cannot create Docker container during CI process.")
public class EtcdBackendTest {
    @ClassRule
    public static final EtcdClusterResource etcd = new EtcdClusterResource("etcd", 1);

    @Autowired
    private EtcdBackend etcdBackend;

    @Test
    public void shouldAddAndRetrieveValuesFromEtdc() throws Exception {
        // given
        String key = "test";
        String value = "value";

        // when
        etcdBackend.put(key, value);
        String retrievedValue = etcdBackend.get(key);

        // then
        assertEquals(value, retrievedValue);
    }

    @Test(expected = KeyNotFoundException.class)
    public void shouldThrowExceptionWhenKeyIsNotFound() throws Exception {
        // given
        String key = "test";

        // when
        // then
        etcdBackend.get(key);
    }

    @Configuration
    public static class TestContext {
        @Bean
        public KV createEtcdClient() {
            return Client.builder().endpoints(etcd.getClientEndpoints()).build()
                    .getKVClient();
        }
    }
}
