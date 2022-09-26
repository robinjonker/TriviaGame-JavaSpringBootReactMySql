package com.example.demo.questions_trivia;

import com.example.demo.log_trivia.LogRepository;
import com.example.demo.log_trivia.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class TriviaService {

    @Autowired
    private LogService logService;

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

    public int getRandomWithExclusion(Random rnd, int start, int end, int... exclude) {
        int random = start + rnd.nextInt(end - start + 1 - exclude.length);
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }

    public String getRandomQuestion(Long studentId) {
        System.out.println("Something was printed "+logService.getLogStudent(studentId));
        int[] ex = { 0 }; // id's of questions attempted by student previously
        int size = triviaRepository.findAll().size();
        if (ex.length == size) {
            ex = new int[0];
        }
        int val = getRandomWithExclusion(new Random(), 0, size, ex);
        Long id = Long.valueOf(val);
        if (size > 0) {
            Trivia trivia = triviaRepository.findById(id)
                    .orElseThrow(() -> new IllegalStateException(
                            "student with id: "+id+" does not exist"));
            return trivia.getQuestion();
        }
        throw new IllegalStateException("no questions stored");
    }

}
