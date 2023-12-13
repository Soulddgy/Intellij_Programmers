package kakao2022.tech;

import java.util.*;
//각 큐의 원소합이 같아지게 만들어야함
//1pop && 1add 가 count+1
//최솟값 구하기
//같게 만들수 없는 경우 -1
class ex2 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum = 0;
        int count = 0;
        long sumOfq1 = 0;
        long sumOfq2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i=0;i<queue1.length;i++){
            sum += queue1[i]+queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sumOfq1 += queue1[i];
            sumOfq2 += queue2[i];
        }


        if(sum%2!=0){
            answer = -1;
        }else{
            while(sumOfq1 != sumOfq2){
                if(sumOfq1 > sumOfq2){
                    sumOfq2 += q1.peek();
                    sumOfq1 -= q1.peek();
                    q2.add(q1.poll());

                }else{
                    sumOfq1 += q2.peek();
                    sumOfq2 -= q2.peek();
                    q1.add(q2.poll());

                }
                if(count>queue1.length*3){
                    count=-1;
                    break;
                }

                count++;

            }
            answer = count;
        }

        return answer;
    }
}
