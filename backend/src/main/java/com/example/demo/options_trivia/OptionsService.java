package com.example.demo.options_trivia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OptionsService {
    private final OptionsRepository optionsRepository;

    @Autowired
    public OptionsService(OptionsRepository optionsRepository) {
        this.optionsRepository = optionsRepository;
    }

    public List<Options> getOptions() {
        return optionsRepository.findAll();
    }

    public List<String> getOptionsQuestion(Long triviaId) {
        Options options = optionsRepository.findOptionsById(triviaId)
                .orElseThrow(() -> new IllegalStateException(
                        "question options with id: "+triviaId+" does not exist"));
        List<String> list = new ArrayList<>();
        if (options.getOption1() != null) {
            list.add(options.getOption1());
        }
        if (options.getOption2() != null) {
            list.add(options.getOption2());
        }
        if (options.getOption3() != null) {
            list.add(options.getOption3());
        }
        if (options.getOption4() != null) {
            list.add(options.getOption4());
        }
        return list;
    }
}