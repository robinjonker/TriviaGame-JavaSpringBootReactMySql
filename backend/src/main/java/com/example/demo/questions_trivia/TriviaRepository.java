package com.example.demo.questions_trivia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TriviaRepository extends JpaRepository<Trivia, Long> {

    @Query("SELECT s FROM Trivia s WHERE s.id = ?1")
    Optional<Trivia> findTriviaById(Long id);
}
