import java.util.ArrayList;
import java.util.Scanner;

/*

Tree & Query

 */
public class DP06_15681 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, R, Q;
    static ArrayList<Integer>[] con;
    static int[] Dy;

    static void input(){
        N = sc.nextInt();
        R = sc.nextInt();
        Q = sc.nextInt();
        con = new ArrayList[N + 1];
        for(int i= 1; i <= N; i++){
            con[i] = new ArrayList<>();
        }
        for(int i = 1; i < N; i++){
            int x = sc.nextInt(), y = sc.nextInt();
            con[x].add(y);
            con[y].add(x);
        }
    }

    static void dfs(int x, int prev){
        Dy[x] = 1;

        for(int y: con[x]){
            if(y == prev) continue;
            dfs(y, x);
            Dy[x] += Dy[y];
        }
    }

    static void proc(){
        Dy = new int[N + 1];

        dfs(R, -1);

        for(int i = 1; i <= Q; i++){
            int q = sc.nextInt();
            sb.append(Dy[q]).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args){
        input();
        proc();
    }

}
