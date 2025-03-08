package com.example.Ho_Birding.main.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MBTIService {
    private static final Map<List<String>, String> mbtiMap = new HashMap<>();
    private static final Map<String, String> birdNameMap = new HashMap<>();

    static {
        String[] mbtiTypes = {"ISTJ", "ISFJ", "INFJ", "INTJ", "ISTP", "ISFP", "INFP", "INTP",
                "ESTJ", "ESFJ", "ENFJ", "ENTJ", "ESTP", "ESFP", "ENFP", "ENTP"};

        int index = 0;
        for (int i = 0; i < 256; i++) {
            List<String> combination = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                combination.add(((i >> j) & 1) == 0 ? "A" : "B");
            }
            mbtiMap.put(combination, mbtiTypes[index % mbtiTypes.length]);
            index++;
        }

        birdNameMap.put("INTJ", "때까치");
        birdNameMap.put("INTP", "파랑새");
        birdNameMap.put("ENTJ", "흰꼬리수리");
        birdNameMap.put("ENTP", "까치");
        birdNameMap.put("INFJ", "솔부엉이");
        birdNameMap.put("INFP", "혹고니");
        birdNameMap.put("ENFJ", "장다리물떼새");
        birdNameMap.put("ENFP", "곤줄박이");
        birdNameMap.put("ISTJ", "오색딱다구리");
        birdNameMap.put("ISFJ", "제비");
        birdNameMap.put("ESTJ", "검독수리");
        birdNameMap.put("ESFJ", "참새");
        birdNameMap.put("ISTP", "흰수염바다오리");
        birdNameMap.put("ISFP", "멋쟁이새");
        birdNameMap.put("ESTP", "솔개");
        birdNameMap.put("ESFP", "붉은부리갈매기");
    }

    public String determineMBTI(List<String> answers) {
        String result = mbtiMap.getOrDefault(answers, "Unknown");
        System.out.println("determineMBTI 결과: " + result);
        return result;
    }


    public String getBirdName(String mbti) {
        return birdNameMap.getOrDefault(mbti, "Unknown");
    }
}