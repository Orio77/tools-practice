package com.orio.tools_practice.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import com.orio.tools_practice.config.TextProviderConfig;

@Service
public class TextToolService {

    private String processedInvalidJsonQA = """
            {
            "question": "What is the difference between Aristotelianism and Platonism regarding universals?",
            "answer": "Unlike Platonism, Aristotelianism states that universals only exist to the extent that they are instantiated and not as changeless forms in an intelligible world."
            """;

    private String processedCorrectedJsonQA = """
            {
            "question": "What is the difference between Aristotelianism and Platonism regarding universals?",
            "answer": "Unlike Platonism, Aristotelianism states that universals only exist to the extent that they are instantiated and not as changeless forms in an intelligible world."
            }
            """;

    @Tool(name = "search_for_text", description = "Search for a specific text based on a topic")
    public String searchForText(@ToolParam String topic) {
        return TextProviderConfig.THOUGHT_TEXT;
    }

    @Tool(name = "process_given_text_for_q&a", description = "Process the given text for Q&A")
    public String processForQA(@ToolParam String text) {
        return processedInvalidJsonQA;
    }

    @Tool(name = "correct_json_format", description = "Correct the JSON format of the given text")
    public String correctJsonFormat(@ToolParam String text) {
        return processedCorrectedJsonQA;
    }
}
