import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
Shortest path - dijkstra algorithm
 */
public class SP01_1916 {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        public int to, weight;

        public Edge(int _to, int _weight){
            this.to = _to;
            this.weight = _weight;
        }
    }

    static class Info {
        public int idx, dist;

        public Info(){

        }
        public Info(int _idx, int _dist){
            this.idx = _idx;
            this.dist = _dist;
        }
    }
    static int N, M, start, end;
    static ArrayList<Edge>[] edges; // 인접 리스트
    static int[] dist;

    static void input(){
        N = sc.nextInt(); // 도시 수 : 1 <= N <= 1,000
        M = sc.nextInt(); // 버스 수 : 1 <= M <= 100,000
        dist = new int[N + 1]; // 비용
        edges = new ArrayList[N + 1]; // 도시 번호, 비용
        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<Edge>();
        for (int i = 1; i <= M; i++){
            int from = sc.nextInt(), to = sc.nextInt(), weight = sc.nextInt();
            edges[from].add(new Edge(to, weight));
        }
        // 정답 변수 초기화
        start = sc.nextInt();
        end = sc.nextInt();
    }

    static void dijstra(int start){

        // 도시별 이동 비용 초기화
        for(int i = 1; i <= N ; i++){
            dist[i] = Integer.MAX_VALUE; // 공간 복잡도에 의해 long 등으로 변경해야 한다.
        }

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        pq.add(new Info(start, 0)); // 시작 도시, 비용 설정
        dist[start] = 0; // 시작 비용 설정

        while(!pq.isEmpty()){
            Info info = pq.poll();

            if(dist[info.idx] != info.dist) continue;

            for(Edge e : edges[info.idx]){
                if(dist[info.idx] + e.weight >= dist[e.to]) continue;

                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }
    }

    static void proc(){
        dijstra(start); // 시작점 입력
        System.out.println(dist[end]);
    }

    public static void main(String[] args){
        input();

        proc();
    }
}
