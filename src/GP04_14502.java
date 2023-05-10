import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 anti virus using dsf, bfs
 */
public class GP04_14502 {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, M, B, ans;
    static int[][] A, blank;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N + 1][M + 1];
        blank = new int[N * M + 1][2];
        visit = new boolean[N + 1][M + 1];
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= M; j++)
                A[i][j] = sc.nextInt();
    }

    static void bfs(){
        Queue<Integer> Q = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                visit[i][j] = false;
                if(A[i][j] == 2){
                    Q.add(i);
                    Q.add(j);
                    visit[i][j] = true;
                }
            }
        }

        while(!Q.isEmpty()){
            int x = Q.poll(), y = Q.poll();
            for(int k = 0; k < 4; k++){
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if(nx < 1 || ny < 1 || nx > N || ny > M ) continue;
                if(A[nx][ny] != 0) continue;
                if(visit[nx][ny]) continue;
                visit[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);
            }
        }

        int cnt = 0;
        for(int i = 1; i <= N; i++) for(int j = 1; j <= M; j++) if(A[i][j] == 0 && !visit[i][j]) cnt++;
        ans = Math.max(ans, cnt);

    }
    static void dfs(int idx,  int selected_cnt){
        if(selected_cnt == 3){
            bfs();
            return;
        }
        if(idx > B) return;

        A[blank[idx][0]][blank[idx][1]] = 1;
        dfs(idx +1, selected_cnt + 1);

        A[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx + 1, selected_cnt);

    }

    static void proCalc(){
        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(A[i][j] == 0){
                    B++;
                    blank[B][0] = i;
                    blank[B][1] = j;
                }
            }
        }
        dfs(1, 0);
        System.out.println(ans);
    }

    public static void main(String[] args){
        input();
        proCalc();
    }
}
