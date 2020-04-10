package io.hikari.labs.gof23.structural.facade;

/**
 * Facade Pattern
 *
 * @author Noa Swartz
 * @date 2018-06-14
 */
public class FacadePattern {

    public static void main(String[] args) {
        new WordFacade().printWord();
    }

}

class WordFacade {

    private ChineseWord chineseWord;
    private EnglishWord englishWord;
    private JapaneseWord japaneseWord;

    public WordFacade() {
        chineseWord = new ChineseWord();
        englishWord = new EnglishWord();
        japaneseWord = new JapaneseWord();
    }

    public void printWord() {
        chineseWord.print();
        englishWord.print();
        japaneseWord.print();
    }

}

class ChineseWord {
    public void print() {
        System.err.println("Print ChineseWord");
    }
}

class EnglishWord {
    public void print() {
        System.err.println("Print EnglishWord");
    }
}

class JapaneseWord {
    public void print() {
        System.err.println("Print JapaneseWord");
    }
}
