package practice;
//leve 2
//양궁 대회
//backtracking을 이용한 문제 풀이 좀더 이해할 필요가 있음.

import java.util.*;
//가장 큰 점수 차이를 우승하기 위한 배열
//우승할수없는경우 -1
//가장 낮은 점수를 더 많이 맞힌 경우를 return해라
class ex6 {
    static boolean win[] = new boolean[11];
    static int maxDiff = 0;
    static int[] apeach = new int[11];
    static int[] lion = new int[11];
    static int[] answer = new int[11];
    public int[] solution(int n, int[] info) {
        apeach = info;
        dfs(0, 0, n);
        if(maxDiff ==0){
            int[] answer1 = {-1};
            return answer1;
        }else{
            return answer;
        }
    }

    static void dfs(int start, int depth, int n){
        if(depth == n){
            int a_score = 0;
            int l_score = 0;
            for( int i=0;i<11;i++){
                if(apeach[i]==0 && lion[i]==0) continue;
                if(lion[i] > apeach[i]){
                    l_score += 10-i;
                }else{
                    a_score += 10-i;
                }
            }
            int cntScore = l_score - a_score;

            if(l_score>a_score){
                if(cntScore>maxDiff){
                    maxDiff = cntScore;
                    answer = lion.clone();
                }else if(cntScore == maxDiff){
                    for(int i=10;i>=0;i--){
                        if(lion[i] > answer[i]){
                            answer = lion.clone();
                        }else if(lion[i] < answer[i]){
                            break;
                        }
                    }
                }
            }
        }

        for(int i=start;i<11;i++){
            if(lion[i] > apeach[i]) continue;
            lion[i]++;
            dfs(i,depth+1,n);
            lion[i]--;
        }

    }


}