package summer.winter2019;

//멀쩡한 사각형 문제
//내가 코딩한 것은 class ex1
//형식의 문제로 위의 코드로 대체해서 제출함

import java.util.*;
//class Solution {
//    public long solution(int w, int h) {
//        long answer = 0;
//        long x = (long)w;
//        long y = (long)h;
//
//        for(int i=1;i<w;i++){
//            answer += y*i/x ;
//        }
//
//        return answer*2;
//    }
//}
 class ex1 {
     public long solution(int w, int h) {
         long W = Long.valueOf(w);
         long H = Long.valueOf(h);
         long maxR = W*H;
         long minusR = 0;
         long answer = -1;
         int nowH = 1;
         double nowX = 0.0;
         double startX = 0.0;
         double inc = (double)w/h;
         while(nowH < h){
             startX = nowX;
             nowX = (inc)*(double)nowH;
             double startXofquo = Math.floor(startX); //이전 몫
             double nowXofquo = Math.floor(nowX); //현재 몫
             if(nowXofquo != startXofquo){
                 minusR += (long)(nowXofquo-startXofquo+1);
             }else{
                 minusR++;
             }
             nowH++;
             if(nowX % 1 == 0.0){
                 break;
             }

         }

         int qwer = h/nowH;
         long asdf = Long.valueOf(qwer);
         answer += maxR - asdf*minusR;
         return answer;
     }

 }