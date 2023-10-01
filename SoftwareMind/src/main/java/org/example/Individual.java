package org.example;

public class Individual {
    private String name;
    private int rate;

    public Individual(String name, int rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public int getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return name;
    }


}
