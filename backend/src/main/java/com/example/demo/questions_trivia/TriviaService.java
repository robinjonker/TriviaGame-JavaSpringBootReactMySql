package com.example.demo.questions_trivia;

import com.example.demo.log_trivia.Log;
import com.example.demo.log_trivia.LogService;
import com.example.demo.options_trivia.Options;
import com.example.demo.options_trivia.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

import static org.aspectj.runtime.internal.Conversions.intValue;

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
        Trivia trivia = triviaRepository.findTriviaById(triviaId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id: "+triviaId+" does not exist"));
        return trivia.getQuestion();
    }

    public void addNewTriviaQuestion(Trivia trivia) {
        triviaRepository.save(trivia);
    }

    public void deleteTriviaQuestion(Long triviaId) {
        boolean exists = triviaRepository.existsById(triviaId);
        if (!exists) {
            throw new IllegalStateException("student with id: "+triviaId+" does not exist");
        }
        triviaRepository.deleteById(triviaId);
    }


    @Transactional
    public void updateTriviaQuestion(Long triviaId,
                                     String category,
                                     String topic,
                                     String question,
                                     String answer) {
        Trivia trivia = triviaRepository.findById(triviaId)
                .orElseThrow(() -> new IllegalStateException(
                        "Trivia question with id: "+triviaId+" does not exist"));
        if (category != null && category.length() > 0 && !Objects.equals(trivia.getCategory(), category)) {
            trivia.setCategory(category);
        }
        if (topic != null && topic.length() > 0 && !Objects.equals(trivia.getTopic(), topic)) {
            trivia.setTopic(topic);
        }
        if (question != null && question.length() > 0 && !Objects.equals(trivia.getQuestion(), question)) {
            trivia.setQuestion(question);
        }
        if (answer != null && answer.length() > 0 && !Objects.equals(trivia.getAnswer(), answer)) {
            trivia.setAnswer(answer);
        }
    }

    public int getRandomWithExclusion(Random rnd, int start, int end, List<Integer> exclude) {
        int random = start + rnd.nextInt(end - start + 1 - exclude.size());
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }

    @Autowired
    private LogService logService;

    @Autowired
    private OptionsService optionsService;

    public String getRandomQuestion(Long studentId) {
        List<Log> log = logService.getLogStudent(studentId);
        List<Integer> ex = new ArrayList<>();
        int size = triviaRepository.findAll().size();
        if (log.toArray().length < size) {
            for (Log x : log) {
                Long vals = x.getQuestion_id();
                ex.add(intValue(vals));
            }
            Collections.sort(ex);
        }
        int val = getRandomWithExclusion(new Random(), 1, size, ex);
        Long id = (long) val;
        if (size > 0) {
            Trivia trivia = triviaRepository.findTriviaById(id)
                    .orElseThrow(() -> new IllegalStateException(
                            "question with id: "+id+" does not exist"));
            List options = optionsService.getOptionsQuestion(id);
            return "Q" + val + ": " + trivia.getQuestion() + " " + options + " " + trivia.getAnswer();
        }
        throw new IllegalStateException("no questions stored");
    }
}
