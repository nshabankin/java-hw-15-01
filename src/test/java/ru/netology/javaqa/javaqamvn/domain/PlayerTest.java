package ru.netology.javaqa.javaqamvn.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    Player player = new Player(0, "new_player", 0);

    @Test
    public void shouldGetId() {
        int expected = 0;
        int actual = player.getId();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetId() {
        player.setId(1);
        int expected = 1;
        int actual = player.getId();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetName() {
        String expected = "new_player";
        String actual = player.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetName() {
        player.setName("champion");
        String expected = "champion";
        String actual = player.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetStrength() {
        int expected = 0;
        int actual = player.getStrength();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetStrength() {
        player.setStrength(1);
        int expected = 1;
        int actual = player.getStrength();
        assertEquals(expected, actual);
    }
}