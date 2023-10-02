package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TeamBalancer {
    public static void main(String[] args) throws BalancingException {
        List<Individual> individuals = new ArrayList<>();
        individuals.add(new Individual("Johny", 8));
        individuals.add(new Individual("Robbie", 5));
        individuals.add(new Individual("Juliet", 3));
        individuals.add(new Individual("Scarlet", 5));
        individuals.add(new Individual("Jude", 9));
        individuals.add(new Individual("Deborah", 6));
        
        int numberOfTeams = 3;
        List<Team> teams = balance(individuals, numberOfTeams);

        printTeams(teams);
    }

    public static void printTeams(List<Team> teams) {
        int teamNo = 1;
        for (Team team : teams) {
            System.out.println("Team no " + teamNo++ + " has " + team);
        }
        double standardDeviation = calculateDeviation(teams);
        String formattedStandardDeviation = String.format("%.2f", standardDeviation).replace(',', '.');
        System.out.println("Teams rate standard deviation: " + formattedStandardDeviation);
    }

    public static List<Team> balance(List<Individual> individuals, int numberOfTeams) throws BalancingException {
        if(individuals.isEmpty() || numberOfTeams < 1 || individuals.size() % numberOfTeams != 0)
            throw new BalancingException("Equal number of members in teams is not achievable");

        individuals.sort(Comparator.comparingDouble(Individual::getRate));

        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < numberOfTeams; i++) {
            teams.add(new Team());
        }

        int currentTeam = 0;
        int direction = 1;
        for (Individual individual : individuals) {
            teams.get(currentTeam).addMember(individual);
            currentTeam += direction;

            if(currentTeam >= numberOfTeams) {
                currentTeam = numberOfTeams - 1;
                direction = -1;
            } else if (currentTeam < 0) {
                currentTeam = 0;
                direction = 1;
            }
        }

        return teams;

    }

   public static double calculateDeviation(List<Team> teams) {
        double sum = 0;
        for (Team team : teams)
            sum += team.calculateAverageRate();

        double average = sum / teams.size();
        double secondSum = 0;

        for (Team team : teams)
            secondSum += (team.calculateAverageRate() - average) * (team.calculateAverageRate() - average);
        return Math.sqrt(secondSum / teams.size());
    }

}
