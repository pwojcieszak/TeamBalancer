package org.example;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private final List<Individual> members = new ArrayList<>();

    public boolean addMember(Individual individual) {
        return members.add(individual);
    }

    public double calculateAverageRate() {
        double totalRate = 0.0;
        for (Individual member : members) {
            totalRate += member.rate();
        }
        return totalRate / members.size();
    }

    @Override
    public String toString() {
        return members.size() +
                " players (" + members +
                "). Average rate:" + calculateAverageRate();
    }
}
