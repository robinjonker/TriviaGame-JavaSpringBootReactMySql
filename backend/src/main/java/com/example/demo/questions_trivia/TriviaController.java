package com.example.demo.questions_trivia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/questions_trivia")
@CrossOrigin("*") //not for production purposes
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

    @PostMapping
    public void addNewTriviaQuestion(@RequestBody Trivia trivia) {
        triviaService.addNewTriviaQuestion(trivia);
    }

    @DeleteMapping(path ="{triviaId}")
    public void deleteTriviaQuestion(@PathVariable("triviaId") Long triviaId){
        triviaService.deleteTriviaQuestion(triviaId);
    }

    @PutMapping(path ="{triviaId}")
    public void updateTriviaQuestion(@PathVariable("triviaId") Long triviaId,
                                @RequestParam(required = false) String category,
                                 @RequestParam(required = false) String topic,
                                 @RequestParam(required = false) String question,
                                 @RequestParam(required = false) String answer){
        triviaService.updateTriviaQuestion(triviaId, category, topic, question, answer);
    }

    @GetMapping(path = "random/{studentId}")
    public String getRandomQuestion(@PathVariable("studentId") Long studentId) { return triviaService.getRandomQuestion(studentId);}

}
