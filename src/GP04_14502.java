import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 anti virus using dsf, bfs, 완전 탐색.
 */
public class GP04_14502 {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, M, B, ans; // 행 개수,열 개수, 빈공간 개수, 정답
    static int[][] A, blank; // 공간정보 담김, 빈공간만 담김
    static boolean[][] visit; // 방문 여부 체크
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 격자 탐색 설정

    static void input(){
        N = sc.nextInt(); // 행 개수
        M = sc.nextInt(); // 열 개수
        A = new int[N + 1][M + 1]; // 공간 정보 : 0: 빈공간, 1: 벽, 2: 바이러스 감염
        blank = new int[N * M + 1][2]; // 빈 공간 정보
        visit = new boolean[N + 1][M + 1]; // 방문 여부
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= M; j++)
                A[i][j] = sc.nextInt(); // 공간 정보 저장
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
        if(selected_cnt == 3){ // 빈공간 3개 선택, 벽을 3개만 세울 수 있다.
            bfs(); // 빈공간 탐색
            return;
        }
        if(idx > B) return; // 더이상 없으면 종료

        A[blank[idx][0]][blank[idx][1]] = 1;// 벽을 세움.
        dfs(idx +1, selected_cnt + 1);

        A[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx + 1, selected_cnt);

    }

    static void proCalc(){

        // 전체 빈공간 탐색
        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(A[i][j] == 0){ // 0은 빈 공간
                    B++;
                    blank[B][0] = i;
                    blank[B][1] = j;
                }
            }
        }
        dfs(1, 0); // 벽을 세울지 여부 탐색
        System.out.println(ans);
    }

    public static void main(String[] args){
        input();
        proCalc();
    }
}
