package ru.netology.javaqa.javaqamvn.manager;

import ru.netology.javaqa.javaqamvn.domain.Player;
import ru.netology.javaqa.javaqamvn.exceptions.NotRegisteredException;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public Game() {
    }

    // список игроков
    List<Player> players = new ArrayList<>();

    /**
     * Метод регистрации игрока
     *
     * @param player Объект класса Player
     */
    public void register(Player player) {
        players.add(player);
    }

    /**
     * Метод поиска игрока по имени
     *
     * @param name имя игрока
     * @return Объект класса Player
     */
    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    /**
     * Метод рассчёта исхода раунда
     *
     * @param playerName1 имя игрока 1
     * @param playerName2 имя игрока 2
     * @return Исход игры
     */
    public int round(String playerName1, String playerName2) {

        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException(
                    "Player " + playerName1 + " not registered"
            );
        }

        if (player2 == null) {
            throw new NotRegisteredException(
                    "Player " + playerName2 + " not registered"
            );
        }

        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 0;
        }
    }
}
