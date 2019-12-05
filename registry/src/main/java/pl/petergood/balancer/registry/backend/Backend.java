package pl.petergood.balancer.registry.backend;

import java.util.concurrent.ExecutionException;

public interface Backend<K, V> {
    void put(K key, V value) throws ExecutionException, InterruptedException;
    V get(K key) throws Exception;
}
