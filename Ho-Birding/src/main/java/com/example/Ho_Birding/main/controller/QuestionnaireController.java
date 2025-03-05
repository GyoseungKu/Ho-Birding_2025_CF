package com.example.Ho_Birding.main.controller;

import com.example.Ho_Birding.main.dto.QuestionnaireDTO;
import com.example.Ho_Birding.main.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
public class QuestionnaireController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitQuestionnaire(@RequestBody QuestionnaireDTO questionnaireDTO) {
        try {
            questionnaireService.saveQuestionnaire(questionnaireDTO);
            return ResponseEntity.ok("Questionnaire submitted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
    }
}