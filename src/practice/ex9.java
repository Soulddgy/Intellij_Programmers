package practice;

import java.util.*;

//리코쳇 로봇
//level 2
import java.util.*;

class ex9{
    int goalX = 0;
    int goalY = 0;
    int[] dx = new int[]{1,-1,0,0};
    int[] dy = new int[]{0,0,1,-1};
    boolean[][] visited;
    public int solution(String[] board){
        String[][] map = new String[board.length][board[0].length()];
        int startX = 0;
        int startY = 0;
        this.visited = new boolean[board.length][board[0].length()];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length();j++){
                map[i][j] = board[i].charAt(j) + "";
                if(map[i][j].equals("R")){
                    startX = i;
                    startY = j;
                }
                if(map[i][j].equals("G")){
                    goalX = i;
                    goalY = j;
                }
            }
        }

        int answer = bfs(map,startX,startY);

        return answer;
    }
    public int bfs(String[][] map, int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;


        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int count = now[2];

            if(nowX == goalX && nowY == goalY){
                return count;
            }

            for(int i=0;i<4;i++){
                int nextX = nowX;
                int nextY = nowY;
                while(true){
                    int tempX = nextX + dx[i];
                    int tempY = nextY + dy[i];
                    if(tempX<0 || tempX >= map.length || tempY <0 || tempY>=map[0].length){
                        break;
                    }
                    if(map[tempX][tempY].equals("D")){
                        break;
                    }
                    nextX = tempX;
                    nextY = tempY;
                }

                if(visited[nextX][nextY] == true) continue;
                visited[nextX][nextY] = true;
                queue.add(new int[]{nextX, nextY, count+1});
            }

        }


        return -1;
    }

}

