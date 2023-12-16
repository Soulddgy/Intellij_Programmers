package practice;
//추억 점수
//level 1
import java.util.*;
class ex3{
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int numberOfPhoto = photo.length;
        int[] answer = new int[numberOfPhoto];
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<name.length;i++){
            map.put(name[i], yearning[i]);
        }
        int idx = 0;
        for(int i=0;i<numberOfPhoto;i++){
            int count = 0;
            for(String s : photo[i]){
                if(map.containsKey(s)){
                    count +=  map.get(s);
                }
            }
            answer[idx++]=count;

        }

        return answer;
    }
}
