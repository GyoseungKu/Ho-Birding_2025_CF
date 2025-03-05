package com.example.Ho_Birding.main.service;

import com.example.Ho_Birding.main.dto.QuestionnaireDTO;
import com.example.Ho_Birding.main.entity.Questionnaire;
import com.example.Ho_Birding.main.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireService {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    public void saveQuestionnaire(QuestionnaireDTO questionnaireDTO) {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setName(questionnaireDTO.getName());
        questionnaire.setQ1(questionnaireDTO.getQ1());
        questionnaire.setQ2(questionnaireDTO.getQ2());
        questionnaire.setQ3(questionnaireDTO.getQ3());
        questionnaire.setQ4(questionnaireDTO.getQ4());
        questionnaire.setQ5(questionnaireDTO.getQ5());
        questionnaire.setQ6(questionnaireDTO.getQ6());
        questionnaire.setQ7(questionnaireDTO.getQ7());
        questionnaire.setMbti(questionnaireDTO.getBmti());
        questionnaire.setTime(questionnaireDTO.getTime());
        questionnaireRepository.save(questionnaire);
    }
}