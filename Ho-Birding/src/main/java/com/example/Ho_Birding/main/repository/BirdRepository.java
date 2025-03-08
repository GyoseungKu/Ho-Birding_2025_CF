package com.example.Ho_Birding.main.repository;

import com.example.Ho_Birding.main.entity.Bird;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BirdRepository extends JpaRepository<Bird, Long> {
    List<Bird> findByMbti(String mbti);
}