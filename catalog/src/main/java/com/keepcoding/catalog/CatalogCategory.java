package com.keepcoding.catalog;

import java.util.List;

public class CatalogCategory {
    private String category;
    private List<Game> gamesList;

    public CatalogCategory() {
    }

    public CatalogCategory(String category, List<Game> gamesList) {
        this.category = category;
        this.gamesList = gamesList;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Game> getGamesList() {
        return gamesList;
    }

    public void setGamesList(List<Game> gamesList) {
        this.gamesList = gamesList;
    }
}
