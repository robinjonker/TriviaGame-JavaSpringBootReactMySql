package com.example.demo.options_trivia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}