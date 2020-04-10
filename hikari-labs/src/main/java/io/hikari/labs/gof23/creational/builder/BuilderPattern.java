package io.hikari.labs.gof23.creational.builder;

/**
 * Builder Pattern
 *
 * @author Noa Swartz
 * @date 2018-06-13
 */
public class BuilderPattern {

    public static void main(String[] args) {
        SentenceBuilder builder = new HelloSentenceBuilder();
        SentenceDirector director = new SentenceDirector(builder);
        director.build();
        Sentence sentence = builder.getSentence();
        System.err.println(sentence);
    }

}

class Sentence {

    private StringBuilder content = new StringBuilder();

    public StringBuilder getContent() {
        return content;
    }

    public void setContent(StringBuilder content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content.toString();
    }

}

interface SentenceBuilder {

    /**
     * subject
     */
    void appendSubject();

    /**
     * verb
     */
    void appendVerb();

    /**
     * object
     */
    void appendObject();

    Sentence getSentence();

}

class SentenceDirector {

    private SentenceBuilder builder;

    public SentenceDirector(SentenceBuilder builder) {
        this.builder = builder;
    }

    public void build() {
        builder.appendSubject();
        builder.appendVerb();
        builder.appendObject();
    }

}

class HelloSentenceBuilder implements SentenceBuilder {

    private Sentence sentence = new Sentence();

    @Override
    public void appendSubject() {
        sentence.getContent().append("we ");
    }

    @Override
    public void appendVerb() {
        sentence.getContent().append("will rock ");
    }

    @Override
    public void appendObject() {
        sentence.getContent().append("you.");
    }

    @Override
    public Sentence getSentence() {
        return sentence;
    }

}
