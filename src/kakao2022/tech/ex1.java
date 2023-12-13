package kakao2022.tech;

import java.util.*;
// survey 원소는 rt tr fc cf mj jm an na 중하나
// choices는 1-> 앞에꺼 +3점 , 4->둘다 0 점, 7-> 뒤에꺼 +3점
// 만약 둘의 점수가 똑같다면 사전순으로 빠른것을 선택한다.

class ex1 {
    int T_score = 0;
    int R_score = 0;
    int C_score = 0;
    int F_score = 0;
    int J_score = 0;
    int M_score = 0;
    int A_score = 0;
    int N_score = 0;

    public String solution(String[] survey, int[] choices) {
        int survey_length = survey.length;
        for(int i=0;i<survey_length;i++){
            calculate(i, survey[i], choices[i]);
        }

        String[] answer = new String[4];

        if(T_score>R_score){
            answer[0] = "T";
        }else{
            answer[0] = "R";
        }
        if(F_score>C_score){
            answer[1] = "F";
        }else{
            answer[1] = "C";
        }
        if(M_score>J_score){
            answer[2] = "M";
        }else{
            answer[2] = "J";
        }
        if(N_score>A_score){
            answer[3] = "N";
        }else{
            answer[3] = "A";
        }

        String str = "";
        for(int i=0;i<4;i++){
            str += answer[i];
        }
        return str;
    }

    public void calculate(int i, String survey, int choices){
        int score = 0;
        switch(survey){
            case "RT":
                score = choices-4;
                if(score <= -1){
                    R_score -= score;
                }else{
                    T_score += score;
                }
                break;
            case "TR":
                score = choices-4;
                if(score <= -1){
                    T_score -= score;
                }else{
                    R_score += score;
                }
                break;
            case "FC":
                score = choices-4;
                if(score <= -1){
                    F_score -= score;
                }else{
                    C_score += score;
                }
                break;
            case "CF":
                score = choices-4;
                if(score <= -1){
                    C_score -= score;
                }else{
                    F_score += score;
                }
                break;
            case "MJ":
                score = choices-4;
                if(score <= -1){
                    M_score -= score;
                }else{
                    J_score += score;
                }
                break;
            case "JM":
                score = choices-4;
                if(score <= -1){
                    J_score -= score;
                }else{
                    M_score += score;
                }
                break;
            case "AN":
                score = choices-4;
                if(score <= -1){
                    A_score -= score;
                }else{
                    N_score += score;
                }
                break;
            case "NA":
                score = choices-4;
                if(score <= -1){
                    N_score -= score;
                }else{
                    A_score += score;
                }
                break;
        }


    }

}