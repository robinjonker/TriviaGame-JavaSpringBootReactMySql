package com.example.demo.questions_trivia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TriviaService {
    private final TriviaRepository triviaRepository;

    @Autowired
    public TriviaService(TriviaRepository triviaRepository) {
        this.triviaRepository = triviaRepository;
    }

    public List<Trivia> getTrivia() {
        return triviaRepository.findAll();
    }
}
