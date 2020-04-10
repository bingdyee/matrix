package io.hikari.labs.gof23.creational.singleton;

/**
 *
 *
 * @author Noa Swartz
 * @date 2018-06-13
 */
public class DCLSingleton {

    private static volatile DCLSingleton instance = null;

    private DCLSingleton() { }

    public static DCLSingleton getInstance() {
        if (null == instance) {
            synchronized (DCLSingleton.class) {
                if (null == instance) {
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
}
