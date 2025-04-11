package com.orio.tools_practice.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class DateTimeToolsService {

    @Tool(name = "current_time", description = "Get the current time")
    public String getCurrentTime() {
        return java.time.LocalTime.now().toString();
    }

    @Tool(name = "current_date", description = "Get the current date")
    public String getCurrentDate() {
        return java.time.LocalDate.now().toString();
    }

}