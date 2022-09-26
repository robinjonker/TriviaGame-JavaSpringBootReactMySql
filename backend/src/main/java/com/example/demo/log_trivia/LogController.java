package com.example.demo.log_trivia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/log")
public class LogController {
    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping
    public List<Log> getLog() {
        return logService.getLog();
    }

    @GetMapping(path = "{studentId}")
    public List<Log> getLogStudent(@PathVariable("studentId") Long studentId) {
        return logService.getLogStudent(studentId);
    }

}
