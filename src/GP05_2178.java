import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
미로 탈출, 경로 거리 계산 using bfs
 */
public class GP05_2178 {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, M; //

    static String[] A;
    static int[][] dir = {{1, 0},{0, 1},{-1, 0},{0, -1}};

    static int[][] dist;
    static boolean[][] visit ;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        A = new String[N];
        for (int i = 0; i < N; i++) A[i] = sc.next();
        visit = new boolean [N][M];
        dist = new int[N][M];

    }

    static void bfs(int x, int y){
        for(int i = 0; i < N; i++) for(int j = 0; j < M ; j++) dist[i][j] = -1;

        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        dist[x][y] = 1;
        visit[x][y] = true;

        while(!Q.isEmpty()){
            x = Q.poll();
            y= Q.poll();
            for(int k = 0 ; k < 4 ; k++){
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(A[nx].charAt(ny) == '0') continue;
                if(visit[nx][ny]) continue;
                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }

    }
    static void proCalc(){
        bfs(0, 0);

        System.out.println(dist[N -1][M - 1]);
    }

    public static void main(String[] args){
        input();
        proCalc();
    }

}
