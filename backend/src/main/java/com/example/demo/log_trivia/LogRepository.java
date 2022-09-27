package com.example.demo.log_trivia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

    @Query("SELECT s FROM Log s WHERE s.student_id = ?1")
    List<Log> findAllByStudent_id(Long student_id);
}
