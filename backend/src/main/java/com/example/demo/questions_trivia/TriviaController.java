package com.example.demo.questions_trivia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/questions_trivia")
public class TriviaController {
    private final TriviaService triviaService;

    @Autowired
    public TriviaController(TriviaService triviaService) {
        this.triviaService = triviaService;
    }

    @GetMapping
    public List<Trivia> getTrivia() {
        return triviaService.getTrivia();
    }

    @GetMapping(path = "{triviaId}")
    public String getTriviaQuestion(@PathVariable("triviaId") Long triviaId) {
        return triviaService.getTriviaQuestion(triviaId);
    }

    @GetMapping(path = "random")
    public String getRandomQuestion() {
        return triviaService.getRandomQuestion();
    }

}
