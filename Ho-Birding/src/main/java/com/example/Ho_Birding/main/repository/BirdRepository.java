package com.example.Ho_Birding.main.repository;

import com.example.Ho_Birding.main.entity.Bird;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirdRepository extends JpaRepository<Bird, Long> {
    Bird findByMbti(String mbti);
}