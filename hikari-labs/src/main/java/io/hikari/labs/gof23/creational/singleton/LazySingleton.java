package io.hikari.labs.gof23.creational.singleton;

/**
 * @author Noa Swartz
 * @date 2018-06-13
 */
public class LazySingleton {

    private static LazySingleton instance = null;

    private LazySingleton() { }

    public static LazySingleton getInstance() {
        if (null == instance) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
