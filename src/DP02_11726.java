import java.util.Scanner;

/*
Dynamic programming - 2 * N tiling
 */
public class DP02_11726 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] Dy;

    static void input(){
        N = sc.nextInt();
    }

    static void proc(){

        Dy = new int[1005];
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 3;
        Dy[4] = 5;

        for(int i = 5 ; i <= N; i++){
            Dy[i] = (Dy[i - 1] + Dy[i -2]) % 10007;
        }
        System.out.println(Dy[N]);
    }
    static public void main(String[] args){
        input();

        proc();
    }
}
