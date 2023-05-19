import java.util.Scanner;

/*
파일 합치기
 */
public class DP05_11066 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int K, Q;
    static int[] num;
    static int[][]Dy, sum;

    static void input(){
        K = sc.nextInt();
        num = new int[K + 1];
        sum = new int[K + 1][K + 1];
        for(int i = 1; i <= K; i++){
            num[i] = sc.nextInt();
        }
    }

    static void preproc(){
        for(int i = 1; i <= K; i++){
            for(int j = i; j <= K; j++){
                sum[i][j] = sum[i][j - 1] + num[j];
            }
        }
    }
    static void proc(){
        preproc();
        Dy = new int[K + 1][K + 1];

        for (int len = 2; len <= K; len ++){
            for (int i = 1; i <= K - len + 1; i++){
                int j = i + len - 1;
                Dy[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++){
                    Dy[i][j] = Math.min(Dy[i][j], Dy[i][k] + Dy[k + 1][j] + sum[i][j]);
                }
            }
        }

        System.out.println(Dy[1][K]);
    }

    public static void main(String[] args){
        Q = sc.nextInt();
        for(int rep = 1; rep <= Q; rep++){
            input();
            proc();
        }
    }



}
