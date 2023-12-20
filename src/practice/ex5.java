package practice;
//level 2
//과제 진행하기
import java.util.*;
//선입후출 개념 -> stack
//plan [name, start, playtime]
//name 과제이름 중복 x , start 과제 시작 시간 겹침x, playtime
//배열은 시간순으로 정렬되어 있지않음
//return은 과제를 끝낸 순서대로
class ex5 {
    public String[] solution(String[][] plans) {
        Stack<String> stack = new Stack<>();
        String[][] newPlans = new String[plans.length][3];
        for(int i=0;i<plans.length;i++){
            newPlans[i][0] = plans[i][0];
            String time[] = plans[i][1].split(":");
            newPlans[i][1] = String.valueOf(Integer.parseInt(time[0])*60+Integer.parseInt(time[1]));
            newPlans[i][2] = plans[i][2];
        }
        Arrays.sort(newPlans, new Comparator<String[]>(){
            @Override
            public int compare (String[] o1, String[] o2){
                int O1 = Integer.parseInt(o1[1]);
                int O2 = Integer.parseInt(o2[1]);
                return O1 - O2;
            }
        });
        HashMap<String,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<newPlans.length;i++){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(Integer.parseInt(newPlans[i][1]));
            list.add(Integer.parseInt(newPlans[i][2]));
            map.put(newPlans[i][0], list);
        }
        String[] answer = new String[plans.length];
        int[] timeTonext = new int[newPlans.length+1];
        for(int i=0;i<newPlans.length;i++){
            timeTonext[i] = Integer.parseInt(newPlans[i][1]);
        }
        timeTonext[newPlans.length] = 1440;
        int answer_idx = 0;
        int idx =0;
        while(idx<plans.length){
            int nowTime = timeTonext[idx];
            int nextTime = timeTonext[idx+1];


            for(String key: map.keySet()){
                if(map.get(key).get(0)==nowTime){
                    stack.push(key);
                }
            }
            int leftTime = map.get(stack.peek()).get(1);
            leftTime -= nextTime-nowTime;
            if(leftTime >0){
                map.get(stack.peek()).set(1, leftTime);
            }else if(leftTime ==0){
                answer[answer_idx++]= stack.pop();
            }else{
                answer[answer_idx++]= stack.pop();
                leftTime = -leftTime;
                if(!stack.isEmpty()){
                    while(leftTime>0){
                        if(stack.isEmpty()) break;
                        int next = map.get(stack.peek()).get(1);
                        //next = next - leftTime;
                        next = next - leftTime;
                        if(next <=0){
                            answer[answer_idx++] = stack.pop();
                            leftTime = -next;
                        }else{
                            map.get(stack.peek()).set(1, next);
                            break;
                        }
                    }
                }
            }
            idx++;
        }

        if(!stack.isEmpty()){
            while(!stack.isEmpty()){
                answer[answer_idx++] = stack.pop();
            }
        }


        return answer;
    }

}