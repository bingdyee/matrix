package io.hikari.labs.gof23.structural.adapter;


/**
 * Adapter Pattern
 *
 * @author Noa Swartz
 * @date 2018-06-14
 */
public class AdapterPattern {

    public static void main(String[] args) {
        Target target = new TargetAdapter();
        target.request();
    }

}

interface Target {
    void request();
}

class Adaptee {
    public void specificRequest() {
        System.err.println("Specific Request");
    }
}

class TargetAdapter extends Adaptee implements Target {

    @Override
    public void request() {
        specificRequest();
    }

}