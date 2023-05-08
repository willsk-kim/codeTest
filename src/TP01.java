import java.util.Scanner;

/*

부분 합.
 */
public class TP01 {

    static int N, S;
    static int[] A;

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static void input(){
        N = sc.nextInt();
        S = sc.nextInt();
        A = new int[N + 1];
        for(int i = 1; i <= N; i++) A[i] = sc.nextInt();
    }

    static void proCalc(){
        int R = 0, sum = 0, ans = N + 1;
        for(int L = 1; L <= N; L++){
            sum -= A[L - 1];

            while(R + 1 <= N && sum < S){
                R++;
                sum += A[R];
            }

            if(sum >= S){
                ans = Math.min(ans, R - L + 1);
            }

        }
        if(ans == N + 1) ans = 0;

        System.out.println(ans);
    }

    public static void main(String[] args){
        input();
        proCalc();
    }

}
