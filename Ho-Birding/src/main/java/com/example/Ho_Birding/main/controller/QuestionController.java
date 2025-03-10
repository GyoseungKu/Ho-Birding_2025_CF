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
    public String loading2(@RequestParam String answer, Model model) {
        answers.add(answer);
        bird.setQ8(answer);

        if (bird.getMbti() == null) {
            String mbti = mbtiService.determineMBTI(answers);
            bird.setMbti(mbti);
            System.out.println("Determined MBTI: " + mbti);
        }

        birdRepository.save(bird);

        model.addAttribute("mbti", bird.getMbti());
        return "loading2";
    }

    @GetMapping("/result_{mbti}")
    public String resultByMBTI(@PathVariable String mbti, Model model) {
        System.out.println("Requested MBTI: " + mbti);
        List<Bird> birds = birdRepository.findByMbti(mbti);

        if (birds.isEmpty()) {
            System.out.println("No results found for MBTI: " + mbti);
            return "redirect:/error";
        }

        Bird bird = birds.get(0);
        String birdName = mbtiService.getBirdName(bird.getMbti());
        model.addAttribute("birdName", birdName);
        return "result_" + mbti;
    }


    @GetMapping("/result_INTJ")
    public String result_INTJ() {
        return "result_INTJ";
    }

    @GetMapping("/result_INTP")
    public String result_INTP() {
        return "result_INTP";
    }

    @GetMapping("/result_ENTJ")
    public String result_ENTJ() {
        return "result_ENTJ";
    }

    @GetMapping("/result_ENTP")
    public String result_ENTP() {
        return "result_ENTP";
    }

    @GetMapping("/result_INFJ")
    public String result_INFJ() {
        return "result_INFJ";
    }

    @GetMapping("/result_INFP")
    public String result_INFP() {
        return "result_INFP";
    }

    @GetMapping("/result_ENFJ")
    public String result_ENFJ() {
        return "result_ENFJ";
    }

    @GetMapping("/result_ENFP")
    public String result_ENFP() {
        return "result_ENFP";
    }

    @GetMapping("/result_ISTJ")
    public String result_ISTJ() {
        return "result_ISTJ";
    }

    @GetMapping("/result_ISFJ")
    public String result_ISFJ() {
        return "result_ISFJ";
    }

    @GetMapping("/result_ESTJ")
    public String result_ESTJ() {
        return "result_ESTJ";
    }

    @GetMapping("/result_ESFJ")
    public String result_ESFJ() {
        return "result_ESFJ";
    }

    @GetMapping("/result_ISTP")
    public String result_ISTP() {
        return "result_ISTP";
    }

    @GetMapping("/result_ISFP")
    public String result_ISFP() {
        return "result_ISFP";
    }

    @GetMapping("/result_ESTP")
    public String result_ESTP() {
        return "result_ESTP";
    }

    @GetMapping("/result_ESFP")
    public String result_ESFP() {
        return "result_ESFP";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}