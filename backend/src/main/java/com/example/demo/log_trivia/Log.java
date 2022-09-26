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

    @OneToOne
    private Student student_id;
    @OneToOne
    private Trivia question_id;
    private Boolean answer_result;
    private LocalDate date;

    public Log() {
    }

    public Log(Long id, Student student_id, Trivia question_id, Boolean answer_result, LocalDate date) {
        this.id = id;
        this.student_id = student_id;
        this.question_id = question_id;
        this.answer_result = answer_result;
        this.date = date;
    }

    public Log(Student student_id, Trivia question_id, Boolean answer_result, LocalDate date) {
        this.student_id = student_id;
        this.question_id = question_id;
        this.answer_result = answer_result;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Student student_id) {
        this.student_id = student_id;
    }

    public Trivia getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Trivia question_id) {
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

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", student_id=" + student_id +
                ", question_id=" + question_id +
                ", answer_result=" + answer_result +
                ", date=" + date +
                '}';
    }
}
