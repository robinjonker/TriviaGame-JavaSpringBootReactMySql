package com.example.demo.log_trivia;

import com.example.demo.questions_trivia.Trivia;
import com.example.demo.student.Student;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Log {
    @Id
    @SequenceGenerator(
            name = "log_sequence",
            sequenceName = "log_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "log_sequence"
    )

    private Long id;

    //commented out due to input as null so cant test other stuff with that error
//    @OneToOne
//    private Student student_id;
    private Long student_id;
//    @OneToOne
    private Long question_id;
    private Boolean answer_result;
    private LocalDate date;
    private String result;
    public Log() {
    }

    //Long
    public Log(Long id, Long student_id, Long question_id, Boolean answer_result, LocalDate date, String result) {
        this.id = id;
        this.student_id = student_id;
        this.question_id = question_id;
        this.answer_result = answer_result;
        this.date = date;
        this.result = result;
    }

    //Long
    public Log(Long student_id, Long question_id, Boolean answer_result, LocalDate date, String result) {
        this.student_id = student_id;
        this.question_id = question_id;
        this.answer_result = answer_result;
        this.date = date;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //Long
    public Long getStudent_id() {
        return student_id;
    }
    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Long question_id) {
        this.question_id = question_id;
    }

    public Boolean getAnswer_result() {
        return answer_result;
    }

    public void setAnswer_result(Boolean answer_result) {
        this.answer_result = answer_result;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", student_id=" + student_id +
                ", question_id=" + question_id +
                ", answer_result=" + answer_result +
                ", date=" + date +
                ", result='" + result + '\'' +
                '}';
    }
}
