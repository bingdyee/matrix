package io.hikari.labs.gof23.creational.factory;

/**
 * Abstract Factory Pattern
 *
 * @author Noa Swartz
 * @date 2018-06-13
 */
public class AbstractFactory {

    interface Char {

        /**
         *  print value !!!
         */
        void value();

    }

    interface Word {

        /**
         *  print value
         */
        void value();

    }

    static class ChineseChar implements Char {

        @Override
        public void value() {
            System.err.println("Chinese Char.");
        }

    }

    static class EnglishChar implements Char {

        @Override
        public void value() {
            System.err.println("English Char.");
        }

    }

    static class ChineseWord implements Word {

        @Override
        public void value() {
            System.err.println("Chinese Word.");
        }

    }

    static class EnglishWord implements Word {

        @Override
        public void value() {
            System.err.println("English Word.");
        }

    }


    interface Factory {

        Char getChar();

        Word getWord();

    }


    static class ChineseFactory implements Factory {

        @Override
        public Char getChar() {
            return new ChineseChar();
        }

        @Override
        public Word getWord() {
            return new ChineseWord();
        }

    }

    static class EnglishFactory implements Factory {

        @Override
        public Char getChar() {
            return new EnglishChar();
        }

        @Override
        public Word getWord() {
            return new EnglishWord();
        }

    }


    public static void main(String[] args) {
        EnglishFactory englishFactory = new EnglishFactory();
        Char englishChar= englishFactory.getChar();
        Word englishWord = englishFactory.getWord();
        englishChar.value();
        englishWord.value();

        ChineseFactory chineseFactory = new ChineseFactory();
        Char chineseChar = chineseFactory.getChar();
        Word chineseWord = chineseFactory.getWord();
        chineseChar.value();
        chineseWord.value();
    }


}
