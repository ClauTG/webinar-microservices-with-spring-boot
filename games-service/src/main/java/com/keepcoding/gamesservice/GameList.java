package com.keepcoding.gamesservice;


import java.util.List;

public class GameList {

    private List<Game> gameList;

    public GameList() {
    }

    public GameList(List<Game> gameList) {
        this.gameList = gameList;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }
}
