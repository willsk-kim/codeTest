import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
숨바꼭질

 */
public class GP06_1697 {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, K;

    static int[] dist;
    static boolean[] visit;

    static void readInput(){
        N = sc.nextInt(); // 수빈이 위치
        K = sc.nextInt(); // 동생 위치
        visit = new boolean[100005];
        dist = new int[100005];
    }

    static void bfs(){

        Queue<Integer> Q  = new LinkedList<>();
        Q.add(N);
        visit[N] = true;
        dist[N] = 0;

        while(!Q.isEmpty()){ // 격자 방향 탐색
            int x = Q.poll();
            if(x - 1 >= 0 && !visit[x - 1]){  //
                visit[x - 1] = true;
                dist[x - 1] = dist[x] + 1;
                Q.add(x - 1);
            }
            if(x + 1 <= 100000 && !visit[x + 1]){
                visit[x + 1] = true;
                dist[x + 1] = dist[x] + 1;
                Q.add(x + 1);
            }
            if(x * 2 <= 100000 && !visit[x * 2]){
                visit[x * 2] = true;
                dist[x * 2] = dist[x] + 1;
                Q.add(x * 2);
            }
        }
    }
    static void calcOutput(){
        bfs();

        System.out.println(dist[K]);
    }

    public static void main(String[] args){
        readInput();

        calcOutput();

    }


}
