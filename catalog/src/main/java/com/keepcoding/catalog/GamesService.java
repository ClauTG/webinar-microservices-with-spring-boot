package com.keepcoding.catalog;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GamesService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackProducts")
    public List<Game> getGames(final Long categoryId) {
        return restTemplate.getForObject("http://games-service/games/category/" + categoryId, List.class);
    }

    public GameList getFallbackGames(final Long categoryId) {
        return new GameList();
    }
}