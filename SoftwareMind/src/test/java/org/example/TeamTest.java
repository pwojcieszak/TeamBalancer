package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeamTest {
    @Test
    public void shouldAddMember() {
        Team team = new Team();
        assertTrue(team.addMember(new Individual("Piotr", 5)));
    }

    @Test
    public void calculatesCorrectAverageRate() {
        Team team = new Team();

        team.addMember(new Individual("Piotr", 5));
        team.addMember(new Individual("Adam", 7.3));
        team.addMember(new Individual("Szymon", 0));

        assertEquals(4.1, team.calculateAverageRate(), 0.001);
    }

    @Test
    public void testToString() {
        Team team = new Team();
        Individual individual1 = new Individual("Piotr", 5);
        Individual individual2 = new Individual("Adam", 1);

        team.addMember(individual1);
        team.addMember(individual2);

        assertEquals("2 players (Adam, Piotr). Average rate: 3.0", team.toString());
    }
}