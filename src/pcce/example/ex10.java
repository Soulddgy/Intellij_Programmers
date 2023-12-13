package pcce.example;

import java.util.*;

class ex10 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        //ext = 어떤 데이터를 뽑아낼건지, val_ext = 기준값 보다 적은, sort_by  = 정렬할 기준의 문자열(적은순서)
        int n = data.length;
        ArrayList<int[]> arrList = new ArrayList<>();

        switch(ext) {
            case "code" :
                for(int i=0;i<n;i++){
                    if (data[i][0] <= val_ext){
                        arrList.add(data[i]);
                    }
                }
                break;
            case "date" :
                for(int i=0; i<n; i++){
                    if (data[i][1] <= val_ext){
                        arrList.add(data[i]);
                    }
                }
                break;
            case "maximum" :
                for(int i=0; i<n; i++){
                    if (data[i][2] <= val_ext){
                        arrList.add(data[i]);
                    }
                }
                break;
            case "remain" :
                for(int i=0;i<n;i++){
                    if (data[i][3] <= val_ext){
                        arrList.add(data[i]);
                    }
                }
                break;
        }

        //sort_by : 정렬할 기준의 문자열
        switch (sort_by){
            case "code" :
                Collections.sort(arrList, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] s1, int[] s2) {
                        return s1[0] - s2[0];
                    }
                });

                break;
            case "date" :
                Collections.sort(arrList, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] s1, int[] s2) {
                        return s1[1] - s2[1];
                    }
                });

                break;
            case "maximum" :
                Collections.sort(arrList, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] s1, int[] s2) {
                        return s1[2] - s2[2];
                    }
                });
                break;
            case "remain" :
                Collections.sort(arrList, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] s1, int[] s2) {
                        return s1[3] - s2[3];
                    }
                });
                break;
        }

        int answer[][] = new int[arrList.size()][4];

        for(int i=0;i<arrList.size();i++){
            answer[i] = arrList.get(i);
        }

        return  answer;
    }


}