package com.keepcoding.catalog;


import java.util.List;

public class GameList {

    private int port;
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

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
