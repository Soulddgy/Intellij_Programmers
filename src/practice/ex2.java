package practice;
//연습 문제중 "요격 시스템"
//level2
import java.util.*;
class ex2 {
    //a는 s,e 가로  / b는 세로 x좌표에 걸쳐잇는거 요격 (단, s와 e 포함 x)
// 요격에 필요한 최솟값 return
    public int solution(int[][] targets) {
        //배열 정렬
        Arrays.sort(targets, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        int answer = 1;
        int last = targets[0][1] -1;
        for(int i=1;i<targets.length;i++){
            if(last>=targets[i][0] && last <= targets[i][1]) continue;
            answer++;
            last = targets[i][1] -1;
        }



        return answer;
    }
}