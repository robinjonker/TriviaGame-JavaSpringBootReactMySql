package com.example.demo.questions_trivia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TriviaConfig {

    @Bean
    CommandLineRunner commandLineRunnerTrivia(TriviaRepository repository){
        return args -> {
            Trivia mostmens = new Trivia(
                    "Sport",
                    "Tennis",
                    "Who has won the most men's grand slam titles in the open era?",
                    "1. Djokovic 2. Federer 3. Nadal 4. Sampras",
                    "3"
            );

            Trivia mostwoman = new Trivia(
                    "Sport",
                    "Tennis",
                    "Who has won the most men's grand slam titles in the open era?",
                    "1. Venus Williams 2. Serena Williams 3. Steffi Graf 4. Chris Evert",
                    "2"
            );

            repository.saveAll(
                    List.of(mostmens, mostwoman)
            );
        };
    }
}
