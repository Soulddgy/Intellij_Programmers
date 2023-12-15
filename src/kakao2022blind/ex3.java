package kakao2022blind;
//주차 요금 계산 문제 level.2
import java.util.*;

// fee{기본시간(분), 시본 요금(원), 단위 시간(분), 단위요금(원)}
// 위의 [] 식 사이는 [a] 보다 작지 안은 최소의 정수를 의미 == 올림0
//리턴은 차량 번호가 작은 자동차 부터 주차 요금 return
//입차된후 출차된 내역 없으면 23:59에 출차된 것

class ex3 {
    public int[] solution(int[] fees, String[] records) {
        TreeMap<String, ArrayList<String>> map = new TreeMap<>();

        //car[0] = 차번호, car[1] = 출입
        for(int i=0; i<records.length;i++){
            StringTokenizer st = new StringTokenizer(records[i]);
            String time = st.nextToken();
            String[] car = new String[2];
            car[0] = st.nextToken();
            car[1] = st.nextToken();
            String[] timeToMin = time.split(":");
            //sumMin 은 시간을 분으로 나타낸것
            String sumMin = String.valueOf(Integer.parseInt(timeToMin[0])*60 + Integer.parseInt(timeToMin[1]));
            ArrayList<String> list = new ArrayList<>();

            if(!map.containsKey(car[0])){
                list.add(sumMin);
                list.add("IN");
                map.put(car[0], list);
            }
            else if(car[1].equals("OUT")) {
                if(map.get(car[0]).size()>2){
                    String calTime = String.valueOf(Integer.parseInt(map.get(car[0]).get(0))+Integer.parseInt(sumMin)-Integer.parseInt(map.get(car[0]).get(2)));
                    list.add(calTime);
                    list.add("OUT");
                    // map.get(car[0]).remove(2);
                    map.put(car[0], list);
                }else{
                    String calTime = String.valueOf(Integer.parseInt(sumMin)-Integer.parseInt(map.get(car[0]).get(0)));
                    list.add(calTime);
                    list.add("OUT");
                    map.put(car[0], list);

                }

            }
            else if(map.containsKey(car[0]) && car[1].equals("IN") && map.get(car[0]).get(1).equals("OUT")){
                // String calTime = String.valueOf(Integer.parseInt(sumMin)-Integer.parseInt(map.get(car[0]).get(0)));
                // list.set(0, calTime);
                list.add(map.get(car[0]).get(0));
                list.add("IN");
                //들어온 시간 추가로 넣음
                list.add(sumMin);
                map.put(car[0], list);
            }

        }

        // if(map.containsValue("IN")){
        // ArrayList<String> inarr = new ArrayList<>();
        for(String keyTofind : map.keySet()){
            if(map.get(keyTofind).contains("IN")){

                if(map.get(keyTofind).size()>2){
                    String cal_Time = String.valueOf(1439-Integer.parseInt(map.get(keyTofind).get(2))+Integer.parseInt(map.get(keyTofind).get(0)));
                    map.get(keyTofind).set(0, cal_Time);
                    map.get(keyTofind).set(1, "OUT");
                    map.get(keyTofind).remove(2);

                }else{
                    String cal_Time = String.valueOf(1439-Integer.parseInt(map.get(keyTofind).get(0)));
                    map.get(keyTofind).set(0, cal_Time);
                    map.get(keyTofind).set(1, "OUT");
                }
            }
            // inarr.add(keyTofind);
        }
        // for(int i=0;i<inarr.size();i++){
        //     String cal_Time = String.valueOf(1439- Integer.parseInt(map.get(inarr[i]).get(0)));
        //     map.put(inarr[i]).set(0, cal_Time);
        //     map.put(inarr[i]).set(1, "OUT");
        // }
        // }

        // 그럼이제 map 에 모든 것의 정보가 다있음
        // key: 차 번호(string)
        // value: 누적 주차 분(string) , 출입("OUT")
        int[] answer = new int[map.size()];
        int index = 0;

        for (String key : map.keySet()) {
            int keyToInt = Integer.parseInt(key);

            int parkingTime = Integer.parseInt(map.get(key).get(0));
            int totalFee;

            if (parkingTime <= fees[0]) {
                totalFee = fees[1];
            } else {
                int calToFee = (parkingTime - fees[0]) % fees[2];
                if ( calToFee == 0){
                    totalFee = fees[1] + ((parkingTime-fees[0])/fees[2])*fees[3];
                }else{
                    totalFee = fees[1] + (((parkingTime-fees[0])/fees[2])+1)*fees[3];
                }
            }

            answer[index++] = totalFee;
        }

        return answer;
    }

}