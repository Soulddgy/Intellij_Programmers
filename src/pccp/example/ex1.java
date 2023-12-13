package pccp.example;

import java.util.*;

// bandage [ 시전시간 t, 초당 회복량 x, 추가 회복량 y] 시전시간 t초 다 채우면 y추가 회복함
// attacks[i][공격 시간, 피해량]

class ex1 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int time = attacks[attacks.length-1][0]; // 총공격이 끝나는 타임
        int nowtime = 1;
        int nowhealth = health;
        Stack<Integer> stack = new Stack<>();

        while(nowtime<=time){
            boolean attacked = false;
            for(int i=0;i<attacks.length;i++){
                if(nowtime == attacks[i][0]){
                    nowhealth -= attacks[i][1];
                    attacked = true;
                    stack.clear();
                    break;
                }
            }
            if(!attacked){
                nowhealth += bandage[1];
                stack.push(1);
            }
            if(stack.size()==bandage[0]){
                nowhealth += bandage[2];
                stack.clear();
            }

            if(nowhealth >= health){
                nowhealth = health;
            }

            if(nowhealth<=0){
                answer = -1;
                break;
            }else{

                nowtime++;
            }
        }

        if( answer != -1){
            answer = nowhealth;
        }
        return answer;
    }
}