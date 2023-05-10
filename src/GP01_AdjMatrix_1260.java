import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
  Graph Ajacent Matrix - dfs, bfs ; 인접 행렬
 */
public class GP01_AdjMatrix_1260 {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, M, V; // N:정점의 갯수, M:간선의 갯수, V:탐색시작 정점 번호
    static int[][] adj;

    static boolean[] visit;

    static void input(){
        N = sc.nextInt();
        adj = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        M = sc.nextInt();
        V = sc.nextInt();

        for (int i = 0; i < M ; i++ ){
           int x = sc.nextInt(), y = sc.nextInt();
           adj[x][y] = adj[y][x] = 1; // 양방향
        }
    }

    static void dfs(int x){
        visit[x] = true;
        sb.append(x).append(' ');

        for(int y = 1; y <= N; y++){
            if(adj[x][y] == 0) continue;

            if(visit[y]) continue;;

            dfs(y);
        }
    }

    static void bfs(int start) {
       Queue<Integer> que = new LinkedList<>();
       que.add(start);
       visit[start] = true;

       while(!que.isEmpty()){
           int x = que.poll();
           sb.append(x).append(' ');
           for(int y = 1; y <= N; y++){
               if(adj[x][y] == 0) continue;;
               if(visit[y]) continue;

               que.add(y);
               visit[y] = true;
           }
       }
    }
    static void proCalc(){
        dfs(V); // depth first search - 깊이 우선 탐색
        sb.append('\n');
        for(int i = 1; i <= N; i++) visit[i] = false;
        bfs(V); // breadth first search - 너비 우선 탐색
        System.out.println(sb);
    }

    public static void main(String[] args){
        input();
        proCalc();
    }

}
