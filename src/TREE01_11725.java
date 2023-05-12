import java.util.ArrayList;
import java.util.Scanner;

/*
 searching parents
 */
public class TREE01_11725 {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] parents;
    static ArrayList<Integer>[] adj;

    static void input(){
        N = sc.nextInt();
        parents = new int[N + 1];
        adj = new ArrayList[N + 1];
        for(int i= 1 ; i <= N; i++){
            adj[i] = new ArrayList<Integer>();
        }
        for(int i = 2; i <=N; i++){
            int x = sc.nextInt(), y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    static void dfs(int x, int par){
        for(int y: adj[x]){
            if(y == par) continue;

            parents[y] = x;
            dfs(y, x);

        }
    }
    static void pro(){
        dfs(1, -1);

        for(int i = 2; i <= N; i++){
            sb.append(parents[i]).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args){
        input();

        pro();
    }

}
