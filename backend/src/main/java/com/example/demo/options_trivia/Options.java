package com.example.demo.options_trivia;

import com.example.demo.questions_trivia.Trivia;

import javax.persistence.*;

@Entity
@Table
public class Options {
    @Id
    @SequenceGenerator(
            name = "options_sequence",
            sequenceName = "options_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "options_sequence"
    )
    private Long id;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    @OneToOne(mappedBy = "options")
    private Trivia trivia;

    public Options() {
    }

    public Options(Long id, String option1, String option2, String option3, String option4, Trivia trivia) {
        this.id = id;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.trivia = trivia;
    }

    public Options(String option1, String option2, String option3, String option4, Trivia trivia) {
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.trivia = trivia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public Trivia getTrivia() {
        return trivia;
    }

    public void setTrivia(Trivia trivia) {
        this.trivia = trivia;
    }

    @Override
    public String toString() {
        return "Options{" +
                "id=" + id +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", trivia=" + trivia +
                '}';
    }
}
