package kakao2023blind;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.*;

class ex1 {
//"2009.12.31", ["A 13"], ["2008.11.03 A"]
    public static void main(String[] args) {
        String today = "2009.12.31";
        String[] terms = {"A 13"};
        String[] privacies = {"2008.11.03 A"};

        int[] result = solution(today, terms, privacies);
        System.out.println("Result: " + Arrays.toString(result));
    }
    //오늘 날짜 today
    // 유효기간 terms[] , 개인정보 privacies[]
    // 파기해야할 개인정보의 번호 answer[]
    public static int[] solution(String today, String[] terms, String[] privacies) {
        StringBuilder sb = new StringBuilder();
        String Alpabet[] = new String[terms.length];
        int plusnum[] = new int[terms.length];
        // alpabet[], plusnum에 해당하는 알파벳과 유효기간 넘겨줌
        for(int i=0;i<terms.length;i++){
            StringTokenizer st = new StringTokenizer(terms[i]);
            Alpabet[i] = st.nextToken();
            plusnum[i] = Integer.parseInt(st.nextToken());
        }
        List<String> list = new ArrayList<String>();
        for(int i=0;i<privacies.length;i++){
            list.add(privacies[i]);
        }
        //정답 배열
        int[] datelist = new int[3];
        StringTokenizer st = new StringTokenizer(today, ".");
        //datelist 인덱스 0->year, 1->month, 2->day
        for(int i=0;i<3;i++){
            datelist[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<privacies.length;i++){
            for(int j=0;j<terms.length;j++){
                if(list.get(i).contains(Alpabet[j])){
                    String str = list.get(i);
                    StringTokenizer st1 = new StringTokenizer(str, ".");
                    int year = Integer.parseInt(st1.nextToken());
                    int month = Integer.parseInt(st1.nextToken());
                    month += plusnum[j];
                    if(month>12){
                        year++;
                        month = month-12;
                    }

                    try {
                        String str2 = st1.nextToken();
                        StringTokenizer st2 = new StringTokenizer(str2);
                        int day = Integer.parseInt(st2.nextToken());

                        // Debugging 출력 추가
                        System.out.println("Comparing: " + today + " vs " + year + "." + month + "." + day);

                        // today와 비교
                        if (datelist[0] > year || (datelist[0] == year && (datelist[1] > month || datelist[0] == year && (datelist[1] == month && datelist[2] > day)))) {
                            sb.append(Integer.toString(i+1));
                            break;
                        }
                    } catch (NoSuchElementException | NumberFormatException e){
                        // 예외 발생 시 처리
                        // Debugging 출력 추가
                        System.out.println("Error parsing date: " + e.getMessage());
                        // 여기서는 그냥 건너뜁니다.
                    }

                    break;
                }
            }
        }

        String resultString = sb.toString();
        int[] answer = new int[resultString.length()];
        for (int i = 0; i < resultString.length(); i++) {
            answer[i] = resultString.charAt(i) - '0';
        }
        // Debugging 출력 추가
        System.out.println("Result: " + Arrays.toString(answer));


        return answer;

    }
}