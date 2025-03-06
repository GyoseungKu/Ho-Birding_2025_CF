package com.example.Ho_Birding.main.service;

import com.example.Ho_Birding.main.dto.QuestionnaireDTO;
import com.example.Ho_Birding.main.entity.Questionnaire;
import com.example.Ho_Birding.main.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class QuestionnaireService {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    public boolean isNameExists(String name) {
        return questionnaireRepository.existsByName(name);
    }

    public void saveQuestionnaire(QuestionnaireDTO questionnaireDTO) {
        if (questionnaireRepository.existsByName(questionnaireDTO.getName())) {
            throw new IllegalArgumentException("Name already exists");
        }
        questionnaireDTO.setMbti(calculateMBTI(questionnaireDTO));
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setName(questionnaireDTO.getName());
        questionnaire.setQ1(validateAndConvert(questionnaireDTO.getQ1()));
        questionnaire.setQ2(validateAndConvert(questionnaireDTO.getQ2()));
        questionnaire.setQ3(validateAndConvert(questionnaireDTO.getQ3()));
        questionnaire.setQ4(validateAndConvert(questionnaireDTO.getQ4()));
        questionnaire.setQ5(validateAndConvert(questionnaireDTO.getQ5()));
        questionnaire.setQ6(validateAndConvert(questionnaireDTO.getQ6()));
        questionnaire.setQ7(validateAndConvert(questionnaireDTO.getQ7()));
        questionnaire.setQ8(validateAndConvert(questionnaireDTO.getQ8()));
        questionnaire.setMbti(questionnaireDTO.getMbti());
        questionnaire.setTime(questionnaireDTO.getTime());
        questionnaireRepository.save(questionnaire);
    }

    private String validateAndConvert(Integer value) {
        if (value == null) {
            throw new IllegalArgumentException("Questionnaire answer cannot be null");
        }
        return String.valueOf(value);
    }

    private String calculateMBTI(QuestionnaireDTO questionnaireDTO) {
        String[] answers = {
                questionnaireDTO.getQ1() == 1 ? "A" : "B",
                questionnaireDTO.getQ2() == 1 ? "A" : "B",
                questionnaireDTO.getQ3() == 1 ? "A" : "B",
                questionnaireDTO.getQ4() == 1 ? "A" : "B",
                questionnaireDTO.getQ5() == 1 ? "A" : "B",
                questionnaireDTO.getQ6() == 1 ? "A" : "B",
                questionnaireDTO.getQ7() == 1 ? "A" : "B",
                questionnaireDTO.getQ8() == 1 ? "A" : "B"
        };

        String key = String.join("", answers);

        Map<String, String> mbtiMap = new HashMap<>();
        mbtiMap.put("AAAAAAAA", "ISTJ");
        mbtiMap.put("AAAAAAAB", "ISTP");
        mbtiMap.put("AAAAAABA", "ISFJ");
        mbtiMap.put("AAAAAABB", "ISFP");
        mbtiMap.put("AAAABAAA", "INTJ");
        mbtiMap.put("AAAABAAB", "INTP");
        mbtiMap.put("AAABAAAA", "INFJ");
        mbtiMap.put("AAABAAAB", "INFP");
        mbtiMap.put("AABAAAAA", "ESTJ");
        mbtiMap.put("AABAAAAB", "ESTP");
        mbtiMap.put("AABAABAA", "ENTJ");
        mbtiMap.put("AABAABAB", "ENTP");
        mbtiMap.put("AABBAAAA", "ENFJ");
        mbtiMap.put("AABBAAAB", "ENFP");
        mbtiMap.put("BAAAAAAA", "ISTJ");
        mbtiMap.put("BAAAAAAB", "ISTP");
        mbtiMap.put("BAAAABAA", "ISFJ");
        mbtiMap.put("BAAAABAB", "ISFP");
        mbtiMap.put("BAAAABBA", "INTJ");
        mbtiMap.put("BAAAABBB", "INTP");
        mbtiMap.put("BAABAAAA", "INFJ");
        mbtiMap.put("BAABAAAB", "INFP");
        mbtiMap.put("BBAAAAAA", "ESTJ");
        mbtiMap.put("BBAAAAAB", "ESTP");
        mbtiMap.put("BBAAABAA", "ENTJ");
        mbtiMap.put("BBAAABAB", "ENTP");
        mbtiMap.put("BBBAAAAA", "ENFJ");
        mbtiMap.put("BBBAAAAB", "ENFP");

        return mbtiMap.getOrDefault(key, "Unknown");
    }
}