package com.orio.tools_practice.tools;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.orio.tools_practice.service.OllamaService;

@SpringBootTest
public class OllamaServiceTest {

    @Autowired
    private OllamaService ollamaService;

    @Test
    public void getTimeTest() {
        String response = ollamaService.getTimeResponse();
        System.out.println("Response: " + response);
    }

    @Test
    public void getDateTest() {
        String response = ollamaService.getDateResponse();
        System.out.println("Response: " + response);
    }

    @Test
    public void getDateAndTimeTest() {
        String response = ollamaService.getDateTimeResponse();
        System.out.println("Response: " + response);
    }

    @Test
    public void getProcessedTextTest() {
        String response = ollamaService.getProcessedTextResponse();
        System.out.println("Response: " + response);
    }

    @Test
    public void testDataSetRetrieval() {
        String response = ollamaService.getAnswerBasedOnDataSet();
        System.out.println("Response: " + response);
    }

}
