package practice;
//덧칠하기
//level 1

import java.util.*;
class ex4 {
    public int solution(int n, int m, int[] section) {
        // n은 총 벽 수
        // m은 룰러 길이 n-k+1
        boolean[] check = new boolean[n];
        Arrays.fill(check,true);
        int last = section[section.length-1]-1;
        for(int i : section){
            check[i-1] = false;
        }
        int count = 0;
        int temp=0;
        while(!check[last]){
            int start = section[temp]-1;
            if(!check[start]){
                int cleaned = start+m;
                if(cleaned > n-1){
                    count++;
                    break;
                }else{
                    for(int i=start;i<cleaned;i++){
                        if(!check[i]) check[i] = true;
                    }
                    count++;
                }
            }else{
                temp++;
                continue;
            }
        }
        return count;
    }
}
