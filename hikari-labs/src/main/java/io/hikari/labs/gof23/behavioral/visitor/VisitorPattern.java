package io.hikari.labs.gof23.behavioral.visitor;

import java.util.Arrays;
import java.util.List;

/**
 * Visitor Pattern
 *
 * @author Noa Swartz
 * @date 2018-06-16
 */
public class VisitorPattern {

    public static void main(String[] args) {
        ObjectStructure structure = new ObjectStructure();
        Visitor a = new VisitorA();
        structure.accept(a);
        Visitor b = new VisitorB();
        structure.accept(b);
    }

}


interface Visitor {
    void visit(Element element);
}

interface Element {
    void accept(Visitor visitor);
}

class VisitorA implements Visitor {

    @Override
    public void visit(Element element) {
        System.err.println("Visitor-A visit " + element);
    }

}

class VisitorB implements Visitor {

    @Override
    public void visit(Element element) {
        System.err.println("Visitor-B visit " + element);
    }

}

class ElementA implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "ElementA";
    }

}

class ElementB implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "ElementB";
    }

}

class ObjectStructure {

    List<Element> list = Arrays.asList(new ElementA(), new ElementB());

    public void accept(Visitor visitor) {
        list.forEach(element -> element.accept(visitor));
    }

}