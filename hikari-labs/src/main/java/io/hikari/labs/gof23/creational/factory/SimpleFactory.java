package io.hikari.labs.gof23.creational.factory;


/**
 * Factory Pattern
 *
 * @author Noa Swartz
 * @date 2018-06-13
 */
public class SimpleFactory {

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

    static class CharFactory {

        public static Char getChar(Class<? extends Char> clazz) {
            if (clazz.isAssignableFrom(A.class)) {
                return new A();
            } else if (clazz.isAssignableFrom(B.class)) {
                return new B();
            }
            throw new RuntimeException("Not Supported!");
        }

    }


    public static void main(String[] args) {
        Char a = CharFactory.getChar(A.class);
        Char b = CharFactory.getChar(B.class);
        a.value();
        b.value();
    }

}
