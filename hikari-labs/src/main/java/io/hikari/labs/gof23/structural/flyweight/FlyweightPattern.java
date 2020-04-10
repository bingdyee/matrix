package io.hikari.labs.gof23.structural.flyweight;

/**
 * Flyweight Pattern
 *
 * @author Noa Swartz
 * @date 2018-06-14
 */
public class FlyweightPattern {

    public static void main(String[] args) {
        GazillionFactory factory = new GazillionFactory(6);
        for (int i=0; i < 6; ++i) {
            for (int j=0; j < 10; ++j) {
                factory.getGazillion(i).report(j);
            }
            System.out.println();
        }
    }

}

class Gazillion {
    private int row;
    public Gazillion(int row) {
        this.row = row;
        System.err.println();
    }
    void report(int col) {
        System.err.print(" " + row + col + " ");
    }
}

class GazillionFactory {
    private Gazillion[] pool;
    public GazillionFactory(int maxRows) {
        pool = new Gazillion[maxRows];
    }
    public Gazillion getGazillion(int row) {
        if (pool[row] == null) {
            pool[row] = new Gazillion(row);
        }
        return pool[row];
    }

}


