package ru.netology.javaqa.javaqamvn.manager;

import ru.netology.javaqa.javaqamvn.domain.Player;
import ru.netology.javaqa.javaqamvn.exceptions.NotRegisteredException;

import java.util.HashMap;
import java.util.Map;

public class Game {

    public Game() {
    }

    // мапа игроков
    private Map<String, Player> players = new HashMap<>();

    /**
     * Метод регистрации игрока
     *
     * @param player Объект класса Player
     */
    public void register(Player player) {
        players.put(player.getName(), player);
    }


    /**
     * Метод рассчёта исхода раунда
     *
     * @param playerName1 имя игрока 1
     * @param playerName2 имя игрока 2
     * @return Исход игры
     */
    public int round(String playerName1, String playerName2) {

        String[] playerNames = {playerName1, playerName2};

        for (String playerName : playerNames) {
            if (players.get(playerName) == null) {
                throw new NotRegisteredException(
                        "Player " + playerName + " not registered"
                );
            }
        }

        if (players.get(playerName1).getStrength() < players.get(playerName2).getStrength()) {
            return 2;
        } else if (players.get(playerName1).getStrength() > players.get(playerName2).getStrength()) {
            return 1;
        } else {
            return 0;
        }
    }
}
