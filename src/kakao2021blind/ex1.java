package kakao2021blind;

import java.util.*;

// 신규 아이디 추천
// level 1

class Ex1 {
    public String ex1(String new_id) {

        String answer1 = "";
        new_id = new_id.toLowerCase();
        char[] charArr = new_id.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            if ((charArr[i] >= 'a' && charArr[i] <= 'z') || (charArr[i] >= '0' && charArr[i] <= '9') || charArr[i] == '-' || charArr[i] == '.' || charArr[i] == '_'){
                answer1 += charArr[i];
            }
        }
        String answer2 = "";
        for(int i=0;i<answer1.length();i++){
            if(answer1.charAt(i)== '.'){
                answer2 += '.';
                while(i+1<answer1.length() && answer1.charAt(i+1) == '.'){
                    i++;
                }
            }else{
                answer2 += answer1.charAt(i);
            }
        }

        if(!answer2.isEmpty() &&answer2.charAt(0) == '.'){
            answer2 = answer2.substring(1);
        }
        if(!answer2.isEmpty() &&answer2.charAt(answer2.length()-1) == '.'){
            answer2 = answer2.substring(0,answer2.length()-1);
        }
        if(answer2.equals("")){
            answer2 = "a";
        }
        if(answer2.length()>=16){
            answer2 = answer2.substring(0,15);
            if(answer2.charAt(answer2.length()-1) == '.'){
                answer2 = answer2.substring(0,answer2.length()-1);
            }
        }
        while(answer2.length() < 3){
            answer2 += answer2.charAt(answer2.length()-1);
        }


        System.out.print(answer2);
        return answer2;
    }


}
