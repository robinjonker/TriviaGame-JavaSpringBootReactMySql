package com.example.demo.log_trivia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class LogConfig {

    @Bean
    CommandLineRunner commandLineRunnerLog(LogRepository repository){
        return args -> {
            Log one = new Log(
                    Long.valueOf(1),
                    Long.valueOf(1),
                    Boolean.FALSE,
                    LocalDate.now().toString(),
                    "2. Federer"
            );
            repository.saveAll(
                    List.of(one)
            );
        };
    }
}
