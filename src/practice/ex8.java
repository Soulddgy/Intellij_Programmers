package practice;
//level 2
//미로 탈출
//bfs 문제
import java.util.*;

class ex8 {
    static String[][] miro;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1}; //좌 우 하 상
    public int solution(String[] maps) {
        int M = maps.length;
        int N = maps[0].length();
        miro = new String[M][N];
        int[] start = new int[2];
        int[] labor = new int[2];
        for(int i=0;i<M;i++){
            String tmp[] = maps[i].split("");
            for(int j=0;j<N;j++){
                miro[i][j] = tmp[j];

                if(miro[i][j].equals("S")){
                    start = new int[]{i, j};
                }if(miro[i][j].equals("L")){
                    labor = new int[]{i, j};
                }
            }
        }
        int result = bfs(start, "L");
        int result2 = bfs(labor, "E");


        if(result == -1 || result2 == -1){
            return -1;
        }
        return result + result2;
    }

    public int bfs(int[] start, String target){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0}); // start x,y 좌표 , 인덱스 2 = count

        boolean[][] visited = new boolean[miro.length][miro[0].length];
        while(!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            int count = queue.peek()[2];
            visited[x][y] = true;

            if(miro[x][y].equals(target)){
                return count;
            }
            queue.poll();
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny>=0 && nx<miro.length && ny<miro[0].length && !visited[nx][ny]){
                    if(!miro[nx][ny].equals("X")){
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, count+1});
                    }
                }

            }

        }
        return -1;
    }
}
