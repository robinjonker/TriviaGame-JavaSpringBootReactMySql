package com.example.demo.questions_trivia;

import com.example.demo.options_trivia.Options;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.List;

@Configuration
public class TriviaConfig {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_options_id", referencedColumnName = "id")
    private Options options;

    @Bean
    CommandLineRunner commandLineRunnerTrivia(TriviaRepository repository){
        return args -> {
            Trivia mostmens = new Trivia(
                    "Sport",
                    "Tennis",
                    "Who has won the most men's grand slam titles in the open era?",
                    options,
                    "3"
            );

            Trivia mostwoman = new Trivia(
                    "Sport",
                    "Tennis",
                    "Who has won the most woman's grand slam titles in the open era?",
                    options,
                    "2"
            );

            repository.saveAll(
                    List.of(mostmens, mostwoman)
            );
        };
    }
}
