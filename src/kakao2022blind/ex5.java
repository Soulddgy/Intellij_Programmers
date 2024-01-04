package kakao2022blind;
//양과 늑대
//level 3
//못풀었음

import java.util.*;
// 0-1-8-7-9-4-6-5
class ex5 {
    int sheep = 1;
    int wolf = 0;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] info;

    public int solution(int[] info, int[][] edges) {
        this.info = info;
        graph = new ArrayList<>();
        visited = new boolean[info.length];
        for(int i=0; i<info.length;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            putEdge(graph, edges[i][0], edges[i][1]);
        }

        dfs(0, info.length);

        int answer = sheep;
        return answer;
    }
    public void putEdge(ArrayList<ArrayList<Integer>> graph, int x, int y){
        graph.get(x).add(y);
    }
    public void dfs(int node, int length){
        visited[node] = true;
        boolean flag = false;
        int n = graph.get(node).size();
        if(wolf==sheep){
            for(int i=0;i<length;i++){

            }
            return;
        }

        for(int i=0;i<length;++i){
            if(!visited[i]&&!graph.get(node).isEmpty()&&info[i]==0){
                flag = true;
                System.out.println("양있음");
                break;
            }
        }
        if(flag){
            for(int next=0;next<length;++next){
                if(!visited[next]&&graph.get(node).contains(next)&&info[next]==0){
                    sheep += 1;
                    System.out.println("node:"+next);
                    dfs(next, length);
                    break;
                }
            }
            for(int next=0;next<length;++next){
                if(!visited[next]&&graph.get(node).contains(next)&&info[next]==1&&!graph.get(next).isEmpty()){
                    wolf+=1;
                    System.out.println("node:"+next);
                    dfs(next, length);
                }
            }
        }



    }
}