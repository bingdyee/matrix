package io.hikari.spring.config.impl;

import io.hikari.spring.config.HikariInterface;

/**
 * @author Noa Swartz
 */
public class HikariA implements HikariInterface {
    @Override
    public void test() {
        System.err.println("HikariA test().");
    }
}
