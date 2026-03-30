package aventure.solo.moteur.adapteur;

import aventure.solo.port.WordProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WordProviderRestAdapter implements WordProvider {
    private final WebClient webClient;

    public WordProviderRestAdapter(WebClient.Builder builder, @Value("$(generateur.mot.url}") String baseUrl) {
        this.webClient=builder.baseUrl(baseUrl).build();
    }
    @Override
    public String genererMot(String category) {
        return webClient.get().uri(uriBuilder -> uriBuilder
                .path("/api/words")
                .queryParam("category",category)
                .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
