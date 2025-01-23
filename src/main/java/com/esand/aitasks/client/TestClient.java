// src/main/java/com/esand/aitasks/client/TestClient.java
package com.esand.aitasks.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Configuration
public class TestClient {

    private final WebClient webClient;

    private final String apiKey;

    public TestClient(
            WebClient.Builder builder,
            @Value("${gemini.api-key}") String apiKey
    ) {
        this.apiKey = apiKey;
        this.webClient = builder
                .baseUrl("https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent")
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    public Flux<String> getResponse(String text) {
        return webClient.post()
                .uri(uriBuilder -> uriBuilder.queryParam("key", apiKey).build())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(
                        new GoogleRequest(
                                List.of(new GoogleRequest.Parts(
                                        List.of(new GoogleRequest.Text(text))
                                ))
                        )
                )
                .retrieve()
                .bodyToFlux(String.class);
    }
}