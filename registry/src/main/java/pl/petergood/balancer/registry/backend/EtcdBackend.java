package pl.petergood.balancer.registry.backend;

import io.etcd.jetcd.ByteSequence;
import io.etcd.jetcd.KV;
import io.etcd.jetcd.KeyValue;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author Peter Nicholson
 * @since 1.0
 * An Etcd client for storing String keys and String values
 */
@Service
public class EtcdBackend implements Backend<String, String> {

    private final KV keyValueClient;

    public EtcdBackend(KV keyValueClient) {
        this.keyValueClient = keyValueClient;
    }

    @Override
    public void put(String key, String value) throws ExecutionException, InterruptedException {
        ByteSequence keyBytes = ByteSequence.from(key, Charset.defaultCharset());
        ByteSequence valueBytes = ByteSequence.from(value, Charset.defaultCharset());
        keyValueClient.put(keyBytes, valueBytes).get();
    }

    @Override
    public String get(String key) throws ExecutionException, InterruptedException {
        ByteSequence keyBytes = ByteSequence.from(key, Charset.defaultCharset());
        List<KeyValue> matchedEntries = keyValueClient.get(keyBytes).get().getKvs();

        if (matchedEntries.size() == 0) {
            throw new KeyNotFoundException();
        }

        ByteSequence value = matchedEntries.get(0).getValue();
        return value.toString(Charset.defaultCharset());
    }
}
