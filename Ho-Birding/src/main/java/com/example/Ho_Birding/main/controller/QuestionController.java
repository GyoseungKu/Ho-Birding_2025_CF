package com.example.Ho_Birding.main.controller;

import com.example.Ho_Birding.main.entity.Bird;
import com.example.Ho_Birding.main.repository.BirdRepository;
import com.example.Ho_Birding.main.service.MBTIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private MBTIService mbtiService;

    @Autowired
    private BirdRepository birdRepository;

    private List<String> answers;
    private Bird bird;

    @GetMapping("/question1")
    public String question1() {
        answers = new ArrayList<>();
        bird = new Bird();
        return "question1";
    }

    @GetMapping("/question2")
    public String question2(@RequestParam String answer) {
        answers.add(answer);
        bird.setQ1(answer);
        return "question2";
    }

    @GetMapping("/question3")
    public String question3(@RequestParam String answer) {
        answers.add(answer);
        bird.setQ2(answer);
        return "question3";
    }

    @GetMapping("/question4")
    public String question4(@RequestParam String answer) {
        answers.add(answer);
        bird.setQ3(answer);
        return "question4";
    }

    @GetMapping("/question5")
    public String question5(@RequestParam String answer) {
        answers.add(answer);
        bird.setQ4(answer);
        return "question5";
    }

    @GetMapping("/question6")
    public String question6(@RequestParam String answer) {
        answers.add(answer);
        bird.setQ5(answer);
        return "question6";
    }

    @GetMapping("/question7")
    public String question7(@RequestParam String answer) {
        answers.add(answer);
        bird.setQ6(answer);
        return "question7";
    }

    @GetMapping("/question8")
    public String question8(@RequestParam String answer) {
        answers.add(answer);
        bird.setQ7(answer);
        return "question8";
    }

    @GetMapping("/loading1")
    public String loading1() {
        return "loading1";
    }

    @GetMapping("/loading2")
    public String loading2(@RequestParam String answer) {
        answers.add(answer);
        bird.setQ8(answer);
        return "loading2";
    }

    @GetMapping("/result_{mbti}")
    public String resultByMBTI(@PathVariable String mbti, Model model) {
        Bird bird = birdRepository.findByMbti(mbti);
        if (bird != null) {
            String birdName = mbtiService.getBirdName(bird.getMbti());
            model.addAttribute("birdName", birdName);
            return mbti; // Return the MBTI type directly
        } else {
            model.addAttribute("birdName", "Unknown");
            return "Unknown";
        }
    }

    @GetMapping("/result_INTJ")
    public String result_INTJ() {
        return "result_INTJ";
    }

}