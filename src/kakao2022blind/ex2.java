package kakao2022blind;
//k진수에서 소수 개수 구하기
//level 2
import java.util.*;

class ex2 {
    public int solution(int n, int k) {
        String stringNum = Integer.toString(n, k);
        StringTokenizer st = new StringTokenizer(stringNum, "0");
        Stack<Long> stack = new Stack<>();
        while(st.hasMoreTokens()){
            String str = st.nextToken();
            long num = Long.parseLong(str);
            stack.push(num);
        }
        int count = 0;

        while(!stack.isEmpty()){
            Long now = stack.pop();
            System.out.println("스택 pop:" +now);
            if(isPrime(now)==1) count++;
        }

        return count;
    }

    public int isPrime(Long num){
        if (num==1) return 0;
        for(int i=2; i<=(int)Math.sqrt(num); i++){
            if(num%i==0){
                return 0;
            }
        }
        return 1;
    }
}
