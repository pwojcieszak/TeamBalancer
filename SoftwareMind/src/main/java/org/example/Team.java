package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Team {
    private final List<Individual> members = new ArrayList<>();

    public List<Individual> getMembers() {
        return members;
    }

    public boolean addMember(Individual individual) {
        return members.add(individual);
    }

    public double calculateAverageRate() {
        double totalRate = 0.0;
        for (Individual member : members) {
            totalRate += member.getRate();
        }
        return totalRate / members.size();
    }

    @Override
    public String toString() {
        members.sort(Comparator.comparing(Individual::getName));
        return members.size() +
                " players (" + members.toString().replaceAll("[\\[\\]]", "") +
                "). Average rate: " + calculateAverageRate();
    }
}
