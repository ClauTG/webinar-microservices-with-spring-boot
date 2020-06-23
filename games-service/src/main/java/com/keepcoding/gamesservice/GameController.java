package com.keepcoding.gamesservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GameController {


    @GetMapping(value = "/games", produces = "application/json")
    public GameList getAllProducts() {
        return gameMockedList();
    }

    @GetMapping("/games/{id}")
    public Game getProduct(@PathVariable Long id) {
        return gameMockedList()
                .getGameList()
                .stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .get();
    }

    @GetMapping(value = "/games/category/{categoryId}", produces = "application/json")
    public List<Game> getProductsByCategory(@PathVariable Long categoryId) {

        return gameMockedList()
                .getGameList()
                .stream()
                .filter(game -> game.getCategory() == categoryId)
                .collect(Collectors.toList());
    }


    private GameList gameMockedList() {
        var result = new GameList();

        result.setGameList(Arrays.asList(
                new Game(1L, "God Of War", "Muerte y destrucción", BigDecimal.valueOf(100L), 1L),
                new Game(2L, "Final Fantasy VII: Remake", "Nostalgia japonesa", BigDecimal.valueOf(30L), 2L),
                new Game(3L, "The last of us", "Sangre, sudor y lagrimas", BigDecimal.valueOf(10L), 1L),
                new Game(4L, "Halo Infinite", "Piun! Piun! Piun", BigDecimal.valueOf(1L), 3L)));
        return result;
    }
}
