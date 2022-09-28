package com.example.demo.log_trivia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/log")
@CrossOrigin("*") //not for production purposes
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

    @PostMapping
    public void registerNewLog(@RequestBody Log log) {
        logService.addNewLog(log);
    }

}
