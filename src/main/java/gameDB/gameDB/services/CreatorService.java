package gameDB.gameDB.services;

import org.openapitools.client.ApiClient;
import org.openapitools.client.api.CreatorsApi;
import org.openapitools.client.auth.ApiKeyAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CreatorService {
    private final CreatorsApi apiInstance;
    public CreatorService(
            @Value("${rawg.base_path}") String base_url,
            @Value("${rawg.api_key}") String my_api_key
    ) {
        ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath(base_url);
        ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("key");
        api_key.setApiKey(my_api_key);
        this.apiInstance = new CreatorsApi(defaultClient);
    }
    public CreatorsApi getApiInstance() {
        return apiInstance;
    }
}
