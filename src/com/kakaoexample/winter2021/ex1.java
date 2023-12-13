package com.kakaoexample.winter2021;
import java.util.*;

public class ex1 {
    public int solution(String s) {
        String[] numarr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < 10; i++) {
            s = s.replace(numarr[i], Integer.toString(i));
        }
        int answer = Integer.parseInt(s);
        return answer;
    }

}
