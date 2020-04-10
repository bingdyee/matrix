package io.hikari.labs.gof23.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Memento Pattern
 *
 * @author Noa Swartz
 * @date 2018-06-15
 */
public class MementoPattern {

    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();

        originator.setState("State1");
        caretaker.addMemento(originator.store());

        originator.setState("State2");
        caretaker.addMemento(originator.store());

        originator.restore(caretaker.getMemento(0));
    }

}

class Originator {

    private String state;

    public void setState(String state) {
        System.err.println("Originator: Setting state to " + state);
        this.state = state;
    }

    public Memento store() {
        System.err.println("Originator: Saving to Memento.");
        return new Memento(state);
    }

    public void restore(Memento memento) {
        state = memento.getSaved();
        System.err.println("Originator: State after restoring from Memento: " + state);
    }

}

class Caretaker {
    private List<Memento> savedStates = new ArrayList<>();

    public void addMemento(Memento m) {
        savedStates.add(m);
    }

    public Memento getMemento(int index) {
        return savedStates.get(index);
    }

}

class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getSaved() {
        return state;
    }

}