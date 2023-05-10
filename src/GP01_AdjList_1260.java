import java.util.*;

/*
Graph Adjacent List - dfs, bfs ; 인접 리스트
 */
public class GP01_AdjList_1260 {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, M, V ; // 정점 개수, 간선 개수, 탐색 시작 정점

    static boolean[] visit;
    static ArrayList<Integer>[] adj;


    static void input(){
        N = sc.nextInt();// 정점 개수
        M = sc.nextInt(); // 간선 개수
        V = sc.nextInt(); // 탐색 시작 정점
        visit = new boolean[N + 1]; // 방문 여부 체크

        adj = new ArrayList[N + 1]; // 인접 리스트
        for(int i = 1 ; i <= N; i++) adj[i] = new ArrayList<>();

        for(int i = 0 ; i < M; i++){ // 인접 리스트 셋업
            int x = sc.nextInt(), y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x); // 양방향
        }

        for(int i = 1; i <= N; i++){ // 순차 출력을 위해 정렬
            Collections.sort(adj[i]); // 정렬, 작은 수 부터 출력을 위해 <- 문제 조건
        }
    }

    static void dfs(int x){ // 깊이 우선 탐색 - depth first search
        visit[x] = true;  // x 에 방문 체크
        sb.append(x).append(' '); // 출력 설정

        for(int y: adj[x]){  // 인접 리스트 순회
            if(visit[y]) continue; // 이미 방문 했으면 통과

            dfs(y); // 재귀 호출 탐색
        }
    }

    static void bfs(int start) { // 너비 우선 탐색 - breadth first search
        Queue<Integer> que = new LinkedList<>(); // queue 생성 using LinkedList<>()
        que.add(start); // 탐색 시작 정점 추가
        visit[start] = true; // 방문 체크

        while(!que.isEmpty()){ // queue 가 빌 때까지.
            int x = que.poll(); // que 에서 하나 꺼내서,
            sb.append(x).append(' '); // 출력 세팅
            for(int y: adj[x]){ // 대상 정점에 해당하는 인접 리스트 가져온다.
                if(visit[y]) continue; // 이미 방문 했으면 통과.

                que.add(y); // que 에 추가
                visit[y] = true; // 방문 체크
            }
        }

    }
    static void proCalc(){
        dfs(V);
        sb.append('\n');
        for(int i = 1; i <= N; i++) visit[i] = false;
        bfs(V);

        System.out.println(sb);
    }

    public static void main(String[] args){
        input();
        proCalc();
    }

}
