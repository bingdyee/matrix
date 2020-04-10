package io.hikari.labs.gof23.creational.singleton;

/**
 * @author Noa Swartz
 * @date 2018-06-13
 */
public class EagerSingleton {

    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() { }

    public static EagerSingleton getInstance() {
        return instance;
    }

}
