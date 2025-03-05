package com.example.Ho_Birding.main.dto;

import java.time.LocalDateTime;

public class QuestionnaireDTO {
    private String name;
    private String q1;
    private String q2;
    private String q3;
    private String q4;
    private String q5;
    private String q6;
    private String q7;
    private String mbti;
    private LocalDateTime time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

    public String getQ4() {
        return q4;
    }

    public void setQ4(String q4) {
        this.q4 = q4;
    }

    public String getQ5() {
        return q5;
    }

    public void setQ5(String q5) {
        this.q5 = q5;
    }

    public String getQ6() {
        return q6;
    }

    public void setQ6(String q6) {
        this.q6 = q6;
    }

    public String getQ7() {
        return q7;
    }

    public void setQ7(String q7) {
        this.q7 = q7;
    }

    public String getBmti() {
        return mbti;
    }

    public void setMbti(String mbti) {
        this.mbti = mbti;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}