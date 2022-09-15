package gameDB.gameDB.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;

@Service
public class CreatorService {

    @Value("${rawg.api_key}")
    private String api_key;
    @Value("${rawg.base_path}")
    private String base_path;
    WebClient webClient = WebClient.create("https://api.rawg.io/api/");

    public HashMap<String, Object> getCreators() {
            return webClient.get()
                    .uri(uriBuilder -> uriBuilder.path("creators").queryParam("key", api_key).build())
                    .retrieve().bodyToMono(HashMap.class).block();
    }

    public HashMap<String, Object> getCreatorById(int id) {
        return webClient.get().uri(uriBuilder -> uriBuilder.path("creators/" + id).queryParam("key", api_key).build())
                .retrieve().bodyToMono(HashMap.class).block();
    }
}
