package com.example.demo.options_trivia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OptionsRepository extends JpaRepository<Options, Long> {

    @Query("SELECT s FROM Options s WHERE s.id = ?1")
    Optional<Options> findOptionsById(Long id);
}