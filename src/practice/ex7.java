package practice;
//level 2
//연속된 부분 수열의 합
//투 포인터 문제
import java.util.*;

class ex7 {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int len = 1000001;
        int[] answer = new int[2];
        while(true){
            if(sum >= k){
                sum -= sequence[left++];
            }else if(sum < k && right < sequence.length){
                sum += sequence[right++];
            }else if(right >= sequence.length) break;

            if(sum == k){
                if(right - left < len){
                    answer[0] = left;
                    answer[1] = right-1;
                    len = right - left;
                }
            }
        }





        return answer;
    }
}