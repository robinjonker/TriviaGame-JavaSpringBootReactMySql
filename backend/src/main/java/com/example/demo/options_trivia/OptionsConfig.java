package com.example.demo.options_trivia;

import com.example.demo.questions_trivia.Trivia;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.OneToOne;
import java.util.List;

@Configuration
public class OptionsConfig {

    @OneToOne(mappedBy = "options")
    private Trivia trivia;

    @Bean
    CommandLineRunner commandLineRunnerOptions(OptionsRepository repository){

        return args -> {
            Options mostmens = new Options(
                    "1. Djokovic",
                    "2. Federer",
                    "3. Nadal",
                    "4. Sampras",
                    trivia
            );

            Options mostwoman = new Options(
                    "1. Venus Williams",
                    "2. Serena Williams",
                    "3. Steffi Graf",
                    "4. Chris Evert",
                    trivia
            );

            repository.saveAll(
                    List.of(mostmens, mostwoman)
            );
        };
    }
}
