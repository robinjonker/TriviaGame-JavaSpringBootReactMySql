package com.example.demo.log_trivia;

import com.example.demo.questions_trivia.Trivia;
import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class LogConfig {

    //Long
//    @OneToOne
//    private Student student_id;
//    @OneToOne
//    private Trivia question_id;
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
