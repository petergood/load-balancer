package pl.petergood.balancer.common.observer;

import org.junit.Test;
import static org.junit.Assert.*;

public class ObservableTest {
    @Test
    public void shouldDispatchEventToObservers() {
        // given
        ObserverClass observer = new ObserverClass();
        Observable<String> observable = new Observable<>();
        observable.addObserver(observer);

        // when
        observable.dispatch("event");
        observable.dispatch("event 2");

        // then
        assertEquals(2, observer.getHandleCount());
    }

    private class ObserverClass implements Observer<String> {
        private int handleCount;

        @Override
        public void handleEvent(String event) {
            handleCount++;
        }

        public int getHandleCount() {
            return handleCount;
        }
    }
}
