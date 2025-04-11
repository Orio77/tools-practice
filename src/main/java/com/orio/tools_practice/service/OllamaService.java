package com.orio.tools_practice.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class OllamaService {

    private final ChatModel chatModel;

    public String getTimeResponse() {
        String prompt = "Tell me what time it is";
        log.info("Prompt: {}", prompt);

        String resp = ChatClient.create(chatModel).prompt().user(prompt).tools(new DateTimeToolsService())
                .call().content();
        log.info("Response from chat client: {}", resp);
        return resp;
    }

    public String getDateResponse() {
        String prompt = "Tell me what date it is";
        log.info("Prompt: {}", prompt);

        String resp = ChatClient.create(chatModel).prompt().user(prompt).tools(new DateTimeToolsService())
                .call().content();
        log.info("Response from chat client: {}", resp);
        return resp;
    }

    public String getDateTimeResponse() {
        String prompt = "Tell me what date and time it is";
        log.info("Prompt: {}", prompt);

        String resp = ChatClient.create(chatModel).prompt().user(prompt).tools(new DateTimeToolsService())
                .call().content();
        log.info("Response from chat client: {}", resp);
        return resp;
    }

    @SuppressWarnings("unused")
    public String getProcessedTextResponse() {
        String prompt = "Search for a text on the following topic: 'thought', process it for q&a and return it to me. Provide the found text for reference. Note: correct the json format if needed.";
        String systemPrompt = """
                Respond in the following format:
                    {
                        "type": "object",
                        "properties": {
                            "question": {
                                "type": "string",
                                "description": "The question to be answered."
                            },
                            "answer": {
                                "type": "string",
                                "description": "The answer to the question."
                            },
                            "referenceText": {
                                "type": "string",
                                "description": "The text found for reference."
                            }
                        },
                        "required": ["question", "answer", "referenceText"]
                    }
                    """;
        String systemJsonPrompt = "Respond in json format";
        log.info("Prompt: {}", prompt);

        String resp = ChatClient.create(chatModel).prompt().system(systemJsonPrompt).user(prompt)
                .tools(new TextToolService())
                .call().content();
        log.info("Response from chat client: {}", resp);
        return resp;
    }
}
