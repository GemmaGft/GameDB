package gameDB.gameDB.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;

@Service
public class GenreService {

    @Value("${rawg.base_path}")
    private String base_path;

    @Value("${rawg.api_key}")
    private String api_key;

    WebClient webClient = WebClient.create("https://api.rawg.io/api/");

    @Cacheable("genres")
    public HashMap<String, Object> getAllGenres() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("genres")
                        .queryParam("key",api_key)
                        .build()
                )
                .retrieve()
                .bodyToMono(HashMap.class)
                .block();
    }

}
