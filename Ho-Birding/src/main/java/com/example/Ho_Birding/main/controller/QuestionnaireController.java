package com.example.Ho_Birding.main.controller;

import com.example.Ho_Birding.main.dto.QuestionnaireDTO;
import com.example.Ho_Birding.main.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@Controller
@SessionAttributes("questionnaireDTO")
public class QuestionnaireController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @GetMapping("/checkName")
    public ResponseEntity<Boolean> checkName(@RequestParam String name) {
        boolean exists = questionnaireService.isNameExists(name);
        return ResponseEntity.ok(exists);
    }

    @ModelAttribute("questionnaireDTO")
    public QuestionnaireDTO questionnaireDTO() {
        return new QuestionnaireDTO();
    }

    @GetMapping("/questionnaire")
    public String showQuestionnaire(@RequestParam String name, Model model) {
        if (questionnaireService.isNameExists(name)) {
            model.addAttribute("error", "이미 존재하는 닉네임입니다.");
            return "index";
        }
        model.addAttribute("name", name);
        return "question1";
    }

    @PostMapping("/question1")
    public String submitQuestion1(@RequestParam Map<String, String> params, @ModelAttribute QuestionnaireDTO questionnaireDTO) {
        String q1 = params.get("q1");
        if (q1 != null) {
            questionnaireDTO.setQ1(Integer.parseInt(q1));
        }
        return "redirect:/question2";
    }

    @GetMapping("/question2")
    public String showQuestion2() {
        return "question2";
    }

    @PostMapping("/question2")
    public String submitQuestion2(@RequestParam Map<String, String> params, @ModelAttribute QuestionnaireDTO questionnaireDTO) {
        String q2 = params.get("q2");
        if (q2 != null) {
            questionnaireDTO.setQ2(Integer.parseInt(q2));
        }
        return "redirect:/question3";
    }

    @GetMapping("/question3")
    public String showQuestion3() {
        return "question3";
    }

    @PostMapping("/question3")
    public String submitQuestion3(@RequestParam Map<String, String> params, @ModelAttribute QuestionnaireDTO questionnaireDTO) {
        String q3 = params.get("q3");
        if (q3 != null) {
            questionnaireDTO.setQ3(Integer.parseInt(q3));
        }
        return "redirect:/question4";
    }

    @GetMapping("/question4")
    public String showQuestion4() {
        return "question4";
    }

    @PostMapping("/question4")
    public String submitQuestion4(@RequestParam Map<String, String> params, @ModelAttribute QuestionnaireDTO questionnaireDTO) {
        String q4 = params.get("q4");
        if (q4 != null) {
            questionnaireDTO.setQ4(Integer.parseInt(q4));
        }
        return "redirect:/question5";
    }

    @GetMapping("/question5")
    public String showQuestion5() {
        return "question5";
    }

    @PostMapping("/question5")
    public String submitQuestion5(@RequestParam Map<String, String> params, @ModelAttribute QuestionnaireDTO questionnaireDTO) {
        String q5 = params.get("q5");
        if (q5 != null) {
            questionnaireDTO.setQ5(Integer.parseInt(q5));
        }
        return "redirect:/question6";
    }

    @GetMapping("/question6")
    public String showQuestion6() {
        return "question6";
    }

    @PostMapping("/question6")
    public String submitQuestion6(@RequestParam Map<String, String> params, @ModelAttribute QuestionnaireDTO questionnaireDTO) {
        String q6 = params.get("q6");
        if (q6 != null) {
            questionnaireDTO.setQ6(Integer.parseInt(q6));
        }
        return "redirect:/question7";
    }

    @GetMapping("/question7")
    public String showQuestion7() {
        return "question7";
    }

    @PostMapping("/question7")
    public String submitQuestion7(@RequestParam Map<String, String> params, @ModelAttribute QuestionnaireDTO questionnaireDTO) {
        String q7 = params.get("q7");
        if (q7 != null) {
            questionnaireDTO.setQ7(Integer.parseInt(q7));
        }
        return "redirect:/question8";
    }

    @GetMapping("/question8")
    public String showQuestion8() {
        return "question8";
    }

    @PostMapping("/question8")
    public String submitQuestion8(@RequestParam Map<String, String> params, @ModelAttribute QuestionnaireDTO questionnaireDTO) {
        String q8 = params.get("q8");
        if (q8 != null) {
            questionnaireDTO.setQ8(Integer.parseInt(q8));
        }
        questionnaireDTO.setTime(LocalDateTime.now());
        questionnaireService.saveQuestionnaire(questionnaireDTO);
        return "redirect:/result";
    }

    @GetMapping("/result")
    public String showResult(@ModelAttribute QuestionnaireDTO questionnaireDTO, Model model) {
        model.addAttribute("name", questionnaireDTO.getName());
        model.addAttribute("mbti", questionnaireDTO.getMbti());
        return "result";
    }
}