package io.hikari.labs.gof23.structural.bridge;

/**
 * Bridge Pattern
 *
 * @author Noa Swartz
 * @date 2018-06-14
 */
public class BridgePattern {

    public static void main(String[] args) {
        Char[] chars = new Char[2];
        chars[0] = new Sentence(new ChineseWord());
        chars[1] = new Sentence(new EnglishWord());
        for (Char c : chars) {
            c.value();
        }
    }

}

/** Abstraction */
interface Char {
    void value();
}

/** Refined Abstraction */
class Sentence implements Char {
    private Word word;

    public Sentence(Word word) {
        this.word = word;
    }

    @Override
    public void value() {
        word.printValue();
    }

}

/** Implementor */
interface Word {
    void printValue();
}

/** ConcreteImplementor-1 */
class ChineseWord implements Word {
    @Override
    public void printValue() {
        System.err.println("Sentence in Chinese Word");
    }
}

/** ConcreteImplementor-2 */
class EnglishWord implements Word {
    @Override
    public void printValue() {
        System.err.println("Sentence in English Word");
    }
}
