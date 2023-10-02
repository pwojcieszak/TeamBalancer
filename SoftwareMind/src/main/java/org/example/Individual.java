package org.example;

public class Individual {
    private String name;
    private double rate;

    public Individual(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return name;
    }


}
