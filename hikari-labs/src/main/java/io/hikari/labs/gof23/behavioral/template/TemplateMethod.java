package io.hikari.labs.gof23.behavioral.template;

/**
 * Template Method
 *
 * @author Noa Swartz
 * @date 2018-06-16
 */
public class TemplateMethod {

    public static void main(String[] args) {
        AbstractClass clazz = new ConcreteClasses();
        clazz.operationB();
    }

}

abstract class AbstractClass {

    abstract void operationA();

    public void operationB() {
        operationA();
        System.err.println("Operation-B");
    }

}

class ConcreteClasses extends AbstractClass {

    @Override
    public void operationA() {
        System.err.print("Do Operation: ");
    }

}
