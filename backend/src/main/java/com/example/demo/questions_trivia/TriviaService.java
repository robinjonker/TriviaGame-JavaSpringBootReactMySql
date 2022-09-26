package com.example.demo.questions_trivia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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

    public String getTriviaQuestion(Long triviaId) {
        Trivia trivia = triviaRepository.findById(triviaId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id: "+triviaId+" does not exist"));
        return trivia.getQuestion() + trivia.getOptions();
    }

    public String getRandomQuestion() {
        int size = triviaRepository.findAll().size();
        if (size > 0) {
            Random random = new Random();
            Long id = random.nextLong(size)+1;
            Trivia trivia = triviaRepository.findById(id)
                    .orElseThrow(() -> new IllegalStateException(
                            "student with id: "+id+" does not exist"));
            return trivia.getQuestion();
        }
        throw new IllegalStateException("no questions stored");
    }

}
