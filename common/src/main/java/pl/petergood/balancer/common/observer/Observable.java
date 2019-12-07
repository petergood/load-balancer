package pl.petergood.balancer.common.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable<T> {
    private List<Observer<T>> observers = new ArrayList<>();

    public void addObserver(Observer<T> observer) {
        observers.add(observer);
    }

    public void dispatch(T event) {
        observers.forEach((observer) -> observer.handleEvent(event));
    }
}
