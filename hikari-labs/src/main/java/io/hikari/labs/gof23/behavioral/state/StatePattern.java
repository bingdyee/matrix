package io.hikari.labs.gof23.behavioral.state;

/**
 * @author Noa Swartz
 * @date 2018-06-15
 */
public class StatePattern {

    public static void main(String[] args) {
        State a = new StateA();
        State b = new StateB();
        StateContext sc = new StateContext(a);
        sc.doHandle();
        sc.setState(b);
        sc.doHandle();
    }

}

interface State {
    void handle();
}

class StateContext {

    private State state;

    public StateContext(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void doHandle() {
        state.handle();
    }

}

class StateA implements State {

    @Override
    public void handle() {
        System.err.println("State handle...".toUpperCase());
    }

}

class StateB implements State {

    @Override
    public void handle() {
        System.err.println("State handle...".toLowerCase());
    }

}
