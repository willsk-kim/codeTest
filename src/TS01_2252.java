import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/*
Topological Sort : 위상정렬
 */
public class TS01_2252 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, M;

    static ArrayList<Integer>[] adj;
    static int[] indeg;

    static void input(){
        N = sc.nextInt(); // 학생 수
        M = sc.nextInt();  // 키 비교 횟수
        adj = new ArrayList[N + 1]; // 인접 리스트 초기화
        indeg = new int[N +1]; // 위상 정렬 초기화, 들어오는 위상의 수 , 0 이면 맨 앞으로 정렬.
        for(int i = 1;i <= N; i++) adj[i]= new ArrayList<>();
        for(int i = 0;i < M ; i ++){
            int x = sc.nextInt(), y = sc.nextInt();
            adj[x].add(y);
            // x-> y : 두 학생의 키 비교를 간선으로 표시
            indeg[y]++;
        }

    }
    static void proc(){

        //double queue ; 앞/뒤로 데이터를 뺄 수 있다.
        Deque<Integer> queue = new LinkedList<>();

        // 위상 정렬을 위해 들어오는 정점이 0 인 것을 모두 큐에 담는다.
        for(int i = 1; i <= N; i++){
            if(indeg[i] == 0) queue.add(i);
        }
        // bfs 로 위상 정렬 수행
        while(!queue.isEmpty()){
            int x = queue.poll();
            sb.append(x).append(' ');
            for(int y: adj[x]){
                indeg[y]--;
                if(indeg[y] == 0) queue.add(y);
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args){
        input();

        proc();
    }
}
