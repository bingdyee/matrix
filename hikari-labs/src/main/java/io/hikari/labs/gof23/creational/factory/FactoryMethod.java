package io.hikari.labs.gof23.creational.factory;

/**
 * Factory Pattern
 *
 * @author Noa Swartz
 * @date 2018-06-13
 */
public class FactoryMethod {

    interface Char {

        /**
         *  print value
         */
        void value();

    }

    static class A implements Char {

        @Override
        public void value() {
            System.err.println('A');
        }

    }

    static class B implements Char {

        @Override
        public void value() {
            System.err.println('B');
        }

    }

    interface CharFactory {

        Char getChar();

    }

    static class ACharFactory implements CharFactory {

        @Override
        public Char getChar() {
            return new A();
        }

    }

    static class BCharFactory implements CharFactory {

        @Override
        public Char getChar() {
            return new B();
        }

    }

    public static void main(String[] args) {
        ACharFactory aCharFactory = new ACharFactory();
        BCharFactory bCharFactory = new BCharFactory();

        Char noa = aCharFactory.getChar();
        Char legend = bCharFactory.getChar();

        noa.value();
        legend.value();
    }


}
