package pl.petergood.balancer.common.observer;

public interface Observer<T> {
    void handleEvent(T event);
}
