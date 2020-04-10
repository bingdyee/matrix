package io.hikari.labs.gof23.behavioral.iterator;

import java.util.Iterator;

/**
 * Iterator Pattern
 *
 * @author Noa Swartz
 * @date 2018-06-15
 */
public class IteratorPattern {

    public static void main(String[] args) {
        Word word = new Word("IteratorPattern");
        while (word.hasNext()) {
            System.err.println(word.next());
        }
    }

}
class Word implements Iterator<Character> {

    private String word;
    private int index = 0;

    public Word(String word) {
        this.word = word;
    }

    @Override
    public boolean hasNext() {
        return index < word.length();
    }

    @Override
    public Character next() {
        return word.charAt(index++);
    }

}