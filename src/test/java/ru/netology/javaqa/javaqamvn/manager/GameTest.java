package ru.netology.javaqa.javaqamvn.manager;

import org.junit.jupiter.api.Test;
import ru.netology.javaqa.javaqamvn.domain.Player;
import ru.netology.javaqa.javaqamvn.exceptions.NotRegisteredException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    // тестовый объект класса
    Game game = new Game();

    // тестовые данные
    Player player1 = new Player(1, "winner", 100);
    Player player2 = new Player(2, "loser", 1);
    Player player3 = new Player(3, "draw1", 50);
    Player player4 = new Player(3, "draw2", 50);

    @Test
    public void shouldThrowExceptionIfFirstNotRegistered() {

        // подготовительные действия
        game.register(player1);

        // тестовые действия
        Exception exception = assertThrows(NotRegisteredException.class, () ->
                game.round("champion", "winner")
        );

        // ожидаемый результат
        String expected = "Player champion not registered";

        // фактический результат
        String actual = exception.getMessage();

        // проверка на соответствие
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionIfSecondNotRegistered() {

        // подготовительные действия
        game.register(player1);

        // тестовые действия
        Exception exception = assertThrows(NotRegisteredException.class, () ->
                game.round("winner", "champion")
        );

        // ожидаемый результат
        String expected = "Player champion not registered";

        // фактический результат
        String actual = exception.getMessage();

        // проверка на соответствие
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFirstPlayerWin() {

        // подготовительные действия
        game.register(player1);
        game.register(player2);

        // ожидаемый результат
        int expected = 1;

        // фактический результат
        int actual = game.round("winner", "loser");

        // проверка на соответствие
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSecondPlayerWin() {

        // подготовительные действия
        game.register(player1);
        game.register(player2);

        // ожидаемый результат
        int expected = 2;

        // фактический результат
        int actual = game.round("loser", "winner");

        // проверка на соответствие
        assertEquals(expected, actual);
    }

    @Test
    public void shouldDraw() {

        // подготовительные действия
        game.register(player3);
        game.register(player4);

        // ожидаемый результат
        int expected = 0;

        // фактический результат
        int actual = game.round("draw1", "draw2");

        // проверка на соответствие
        assertEquals(expected, actual);
    }
}
