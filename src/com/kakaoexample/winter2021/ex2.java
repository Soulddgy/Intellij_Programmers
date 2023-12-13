//package com.kakaoexample.winter2021;
//import java.util.*;
//public class ex2 {
//
//
//    static boolean[][] visited;
//    static int[] dx = {-1, 1, 0, 0};
//    static int[] dy = {0, 0, -1, 1};
//
//    public int[] solution(String[][] places) {
//        int[] answer = new int[5];
//        for (int i = 0; i < 5; i++) {
//            String[] place = places[i];
//            answer[i] = mapping(place); // 괜찮으면 1 아니면 0
//        }
//        return answer;
//    }
//
//    public int calMan(int[] a, int[] b) {
//        int sum = 0;
//        for (int i = 0; i < 2) {
//            sum += Math.abs(a[i] - b[i]);
//        }
//        return sum;
//    }
//
//    //mapping함수로 한방(place)을 map이라는 2차 배열로 나타냄
//    public int mapping(String[] place) {
//        String classify[] = {"P", "O", "X"};
//        for (int i = 0; i < 3; i++) {
//            place = place.replace(classify[i], Integer.toString(i));
//        }
//        int map[][] = new int[5][5];
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                map[i][j] = Integer.parseInt(String.valueOf(place[i].charAt(j)));
//            }
//        }
//
//
//        return 1; // or 0
//    }
//
//    public boolean bfs(int x, int y,  int map[][]) {
//        Queue<int[]> q = new LinkedList<>();
//        q.add(new int[]{x, y});
//
//        while (!q.isEmpty()) {
//            int now[] = q.poll();
//            int nowX = now[0];
//            int nowY = now[1];
//            for (int i = 0; i < 4; i++) {
//                int nextX = nowX + dx[i];
//                int nextY = nowY + dy[i];
//
//                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
//                    continue;
//                if (visited[nextX][nextY] || map[nextX][nextY] == 0)
//                    continue;
//
//                q.add(new int[]{nextX, nextY});
//                map[nextX][nextY] = map[nowX][nowY] + 1;
//                visited[nextX][nextY] = true;
//
//            }
//        }
//    }
//}
