package practice;
//연습문제중 "달리기 경주" 문제
//level1
import java.util.*;
class ex1 {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] answer = players;
        for(int i=0;i<players.length;i++){
            map.put(players[i], i);
        }
        for(int i=0;i<callings.length;i++){
            int count = map.get(callings[i]);
            String prePlayer = answer[count-1];
            answer[count-1] = callings[i];
            answer[count] = prePlayer;
            map.put(callings[i], count-1);
            map.put(prePlayer, count);
        }
        return answer;
    }
}