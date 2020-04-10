package io.hikari.labs.gof23.behavioral.rchain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Chain-of-responsibility Pattern
 *
 * @author Noa Swartz
 * @date 2018-06-15
 */
public class ChainOfResponsibilityPattern {

    public static void main(String[] args) {
        FilterChain chain = new FilterChain();
        chain.addFilter(new FirstFilter());
        chain.addFilter(new SecondFilter());
        System.err.println("------Begin Round 1------");
        chain.doFilter();
        System.err.println("-------End Round 1-------");
        System.err.println();
        System.err.println("------Begin Round 2------");
        chain.doFilter();
        System.err.println("-------End Round 2-------");
    }

}

interface Filter {
    void doFilter(FilterChain chain);
}

class FilterChain {
    private Iterator<Filter> iter;
    private List<Filter> filters = new ArrayList<>();

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void doFilter() {
        if (null == iter) {
            iter = filters.iterator();
        }
        if (iter.hasNext()) {
            iter.next().doFilter(this);
        }
        iter = null;
    }

}

class FirstFilter implements Filter {

    @Override
    public void doFilter(FilterChain chain) {
        System.err.println("First Filter...");
        chain.doFilter();
    }

}

class SecondFilter implements Filter {

    @Override
    public void doFilter(FilterChain chain) {
        System.err.println("Second Filter...");
        chain.doFilter();
    }

}