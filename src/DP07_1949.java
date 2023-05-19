import java.util.ArrayList;
import java.util.Scanner;

/*
우수 마을
 */
public class DP07_1949 {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] num;
    static ArrayList<Integer>[] con;
    static int[][] Dy;
    static void input(){
        N = sc.nextInt();
        num = new int[N + 1];
        con = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            num[i] = sc.nextInt();
            con[i] = new ArrayList<>();
        }
        for(int i = 1; i < N; i++){
            int x = sc.nextInt(), y = sc.nextInt();
            con[x].add(y);
            con[y].add(x);
        }
    }

    static void dfs(int x, int prev){
        Dy[x][1] = num[x];
        for(int y : con[x]){
            if(y == prev) continue;
            dfs(y, x);
            Dy[x][0] += Math.max(Dy[y][0], Dy[y][1]);
            Dy[x][1] += Dy[y][0];

        }
    }


    static void proc(){
        Dy = new int[N + 1][2];
        dfs(1, -1);

        System.out.println(Math.max(Dy[1][0], Dy[1][1]));

    }

    public static void main(String[] args){
        input();
        proc();
    }
}
