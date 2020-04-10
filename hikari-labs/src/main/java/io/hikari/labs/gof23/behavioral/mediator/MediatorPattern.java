package io.hikari.labs.gof23.behavioral.mediator;

/**
 * Mediator Pattern
 *
 * @author Noa Swartz
 * @date 2018-06-15
 */
public class MediatorPattern {

    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Buyer buyer = new Buyer(mediator);
        Seller seller = new Seller(mediator);
        mediator.setBuyer(buyer);
        mediator.setSeller(seller);
        buyer.want();
    }

}

class Person {

    protected Mediator mediator;

    public Person(Mediator mediator) {
        this.mediator = mediator;
    }

}

class Buyer extends Person {

    public Buyer(Mediator mediator) {
        super(mediator);
    }

    public void want() {
        mediator.noticeSeller("I Want to buy a house.");
    }

    public void receive(String message) {
        System.err.println("【Received From Seller】Seller Said: " + message);
    }

}

class Seller extends Person {

    public Seller(Mediator mediator) {
        super(mediator);
    }

    public void receive(String message) {
        System.err.println("【Received From Buyer】Buyer Said: " + message);
        mediator.noticeBuyer("OK, Coming here.");
    }

}

class Mediator {

    private Buyer buyer;
    private Seller seller;

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public void noticeBuyer(String message) {
        buyer.receive(message);
    }

    public void noticeSeller(String message) {
        seller.receive(message);
    }

}


