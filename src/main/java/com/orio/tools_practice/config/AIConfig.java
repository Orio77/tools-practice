package com.orio.tools_practice.config;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIConfig {

    @Value("${ollama.text.model}")
    private String model;

    @Value("${ollama.text.numCTX.default}")
    private int numCTX;

    @Value("${ollama.text.temperature}")
    private double temperature;

    @Bean
    OllamaApi getOllamaApi() {
        return new OllamaApi();
    }

    @Bean
    OllamaOptions getOllamaOptions() {
        return OllamaOptions.builder().model(this.model).numCtx(this.numCTX)
                .temperature(this.temperature)
                .build();
    }

    @Bean
    OllamaChatModel getOllamaChatModel() {
        return OllamaChatModel.builder().ollamaApi(getOllamaApi()).defaultOptions(getOllamaOptions()).build();
    }
}
