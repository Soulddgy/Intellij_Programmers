package kakao2022blind;

import java.util.*;

//각 유저는 한 번에 한명의 유저 신고가능
//신고 횟수 제한x, 한 유저 계속 신고할 수 있지만 동일한 유저는 신고횟수 1회로 간주
//k번 이상 신고된 유저는 게시판 이용 정지 해당 유저 신고한 모든 유저에게 정지 사실을 메일로 발송

//report 띄워쓰기 기준으로 앞은 신고자 뒤는 신고당한 사람

//answer 는 각 유저별로 처리 결과 메일을 받은 횟수를 배열에 담아 return
class ex1 {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        HashMap<String, Integer> reported = new HashMap<>();
        for(int i=0;i<id_list.length;i++){
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            map.put(id_list[i],list);
        }
        //str[0] = 신고자 , [1] = 신고당한 사람
        for(int i=0;i<report.length;i++){
            StringTokenizer st = new StringTokenizer(report[i]);
            String[] str = new String[2];
            str[0] = st.nextToken();
            str[1] = st.nextToken();

            if(!map.get(str[0]).contains(str[1])){
                map.get(str[0]).add(str[1]);

                if(reported.containsKey(str[1])){
                    int newValue = reported.get(str[1])+1;
                    reported.put(str[1],newValue);
                }else{
                    reported.put(str[1],1);
                }
            }
        }
        //set으로 k이상인 신고당한자의 이름 넣기
        HashSet<String> check = new HashSet<>();
        for(int i=0; i<id_list.length;i++){
            if(reported.containsKey(id_list[i])){
                if(reported.get(id_list[i])>=k){
                    check.add(id_list[i]);
                }
            }
        }
        //iter를 통해 count 늘리기
        int[] answer = new int[id_list.length];
        for(int i=0;i<id_list.length;i++){
            Iterator iter = check.iterator();
            int count = 0;
            while(iter.hasNext()){
                if(map.get(id_list[i]).contains(iter.next())){
                    count++;
                }
            }
            answer[i] = count;
        }



        return answer;
    }
}