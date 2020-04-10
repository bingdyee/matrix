package io.hikari.labs.gof23.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer Pattern
 *
 * @author Noa Swartz
 * @date 2018-06-15
 */
public class ObserverPattern {

    public static void main(String[] args) {
        Subject subject = new Subject();
        IObserver ob1 = new ObserverA();
        IObserver ob2 = new ObserverB();
        subject.register(ob1);
        subject.register(ob2);
        subject.setState("state1");
        subject.setState("state2");
        subject.unregister(ob1);
        subject.setState("state3");
    }

}

interface IObserver {
    void update(String state);
}

class ObserverA implements IObserver {

    @Override
    public void update(String state) {
        System.err.println("Observer-A has received update signal with new state: " + state);
    }

}

class ObserverB implements IObserver {

    @Override
    public void update(String state) {
        System.err.println("Observer-B has received update signal with new state: " + state);
    }

}

class Subject {
    private List<IObserver> observers = new ArrayList<>();

    private String state;

    public void register(IObserver observer) {
        observers.add(observer);
    }

    public void unregister(IObserver observer) {
        observers.remove(observer);
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    private void notifyObservers() {
        for(IObserver item : observers) {
            item.update(state);
        }
    }

}

