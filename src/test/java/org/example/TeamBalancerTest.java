package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TeamBalancerTest {
    @Test
    public void shouldThrowWhenListOfIndividualsIsEmpty() {
        int numberOfTeams = 4;
        List<Individual> individuals = new ArrayList<>();

        assertThrows(BalancingException.class, () -> TeamBalancer.balance(individuals, numberOfTeams));
    }

    @Test
    public void shouldThrowWhenNumberOfTeamsIsNotPositive() {
        int numberOfTeams = 0;
        List<Individual> individuals = new ArrayList<>();
        individuals.add(new Individual("Johny", 8));
        individuals.add(new Individual("Robbie", 5));

        assertThrows(BalancingException.class, () -> TeamBalancer.balance(individuals, numberOfTeams));
    }

    @Test
    public void shouldThrowWhenTeamsCannotBeEqual() {
        List<Individual> individuals = new ArrayList<>();
        individuals.add(new Individual("Johny", 8));
        individuals.add(new Individual("Robbie", 5));
        individuals.add(new Individual("Juliet", 3));
        individuals.add(new Individual("Scarlet", 5));
        individuals.add(new Individual("Jude", 9));
        individuals.add(new Individual("Deborah", 6));

        int numberOfTeams = 5;
        assertThrows(BalancingException.class, () -> TeamBalancer.balance(individuals, numberOfTeams));
    }

    @Test
    public void dividesInGivenNumberOfTeams() throws BalancingException {
        int numberOfTeams = 3;
        List<Individual> individuals = new ArrayList<>();
        individuals.add(new Individual("Johny", 8));
        individuals.add(new Individual("Robbie", 5));
        individuals.add(new Individual("Juliet", 3));

        List<Team> teams = TeamBalancer.balance(individuals, numberOfTeams);
        assertEquals(3, teams.size());
    }

    @Test
    public void testEqualityOfNumberOfMembersInTeams() throws BalancingException {
        List<Individual> individuals = new ArrayList<>();
        individuals.add(new Individual("Johny", 8));
        individuals.add(new Individual("Robbie", 5));
        individuals.add(new Individual("Juliet", 3));
        individuals.add(new Individual("Scarlet", 5));
        individuals.add(new Individual("Jude", 9));
        individuals.add(new Individual("Deborah", 6));

        int numberOfTeams = 3;
        List<Team> teams = TeamBalancer.balance(individuals, numberOfTeams);
        for (Team team : teams) {
            assertEquals(2, team.getMembers().size());
        }
    }

    @Test
    public void checksIfBalancedCorrectly() throws BalancingException {
        List<Individual> individuals = new ArrayList<>();
        individuals.add(new Individual("Johny", 8));
        individuals.add(new Individual("Robbie", 5));
        individuals.add(new Individual("Juliet", 3));
        individuals.add(new Individual("Scarlet", 5));
        individuals.add(new Individual("Jude", 9));
        individuals.add(new Individual("Deborah", 6));

        int numberOfTeams = 3;
        List<Team> teams = TeamBalancer.balance(individuals, numberOfTeams);

        Team team1 = new Team();
        Team team2 = new Team();
        Team team3 = new Team();

        team1.addMember(new Individual("Jude", 9));
        team1.addMember(new Individual("Juliet", 3));

        team2.addMember(new Individual("Johny", 8));
        team2.addMember(new Individual("Robbie", 5));

        team3.addMember(new Individual("Deborah", 6));
        team3.addMember(new Individual("Scarlet", 5));

        assertEquals(team1.toString(), teams.get(0).toString());
        assertEquals(team2.toString(), teams.get(1).toString());
        assertEquals(team3.toString(), teams.get(2).toString());
    }

    @Test
    public void testCalculateDeviation() {
        List<Team> teams = new ArrayList<>();
        Team team1 = new Team();
        Team team2 = new Team();
        Team team3 = new Team();

        team1.addMember(new Individual("Jude", 9));
        team1.addMember(new Individual("Juliet", 3));

        team2.addMember(new Individual("Johny", 8));
        team2.addMember(new Individual("Robbie", 5));

        team3.addMember(new Individual("Deborah", 6));
        team3.addMember(new Individual("Scarlet", 5));

        teams.add(team1);
        teams.add(team2);
        teams.add(team3);

        double deviation = TeamBalancer.calculateDeviation(teams);
        assertEquals(0.41, deviation, 0.01);
    }
}