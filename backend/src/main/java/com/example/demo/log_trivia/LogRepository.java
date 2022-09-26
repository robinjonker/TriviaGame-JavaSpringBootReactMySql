package com.example.demo.log_trivia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

    @Query("SELECT s FROM Log s WHERE s.id = ?1")
    Optional<Log> findLogById(Long id);
}
