package practiceToBFSDFS;
//level 3
//여행 경로

import java.util.*;
class ex1 {
    static boolean[] visited;
    static ArrayList<String> answer = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        Arrays.sort(tickets, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2){
                if(o1[0].toString().contentEquals(o2[0].toString()))
                    return o1[1].toString().compareTo(o2[1].toString());
                else
                    return o1[0].toString().compareTo(o2[0].toString());
            }
        });
        answer.add("ICN");
        String start = "ICN";
        dfs(tickets, start);
        String[] answer1 = new String[answer.size()];
        for(int i=0;i<answer.size();i++){
            answer1[i] = answer.get(i);
        }
        return answer1;
    }
    public static void dfs(String[][] tickets, String start) {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start) && !visited[i]) {
                String end = tickets[i][1];
                visited[i] = true;
                answer.add(end);
                dfs(tickets, end);
                // 모든 티켓을 사용했으면 종료
                if (answer.size() == tickets.length + 1) {
                    return;
                }
                visited[i] = false;
                answer.remove(answer.size() - 1);
            }
        }
    }
}