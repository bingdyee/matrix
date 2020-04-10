package io.hikari.labs.gof23.structural.decorator;

/**
 * Decorator Pattern
 *
 * @author Noa Swartz
 * @date 2018-06-14
 */
public class DecoratorPattern {

    public static void main(String[] args) {
        Word word = new Sentence();
        word.print();
        word = new Paragraph(word);
        word.print();
    }

}

interface Word {

    void print();

}

class Sentence implements Word {

    @Override
    public void print() {
        System.out.println("Sentence.");
    }

}

class SentenceDecorator implements Word {

    private Word word;

    public SentenceDecorator(Word word) {
        this.word = word;
    }

    @Override
    public void print() {
        word.print();
    }

}

class Paragraph extends SentenceDecorator {

    public Paragraph(Word word) {
        super(word);
    }

    @Override
    public void print() {
        super.print();
        System.err.println("Paragraph.");
    }

}