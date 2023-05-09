import java.util.Arrays;
import java.util.Scanner;

/*

 */
public class TP02_BS02_2470 {

    static int N;
    static int[] A;
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static void input(){
        N = sc.nextInt();
        A = new int[N + 1];
        for(int i = 1; i <= N; i++) A[i] = sc.nextInt();
    }
    static void proCalc() {
        Arrays.sort(A, 1, N + 1);
        int bestSum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;
        int L = 1, R = N;
        while(L < R) {
           int sum = A[L] + A[R];
           if(Math.abs(sum) < bestSum) { // 0에 더 가까운 수
               bestSum = Math.abs(sum);
               v1 = A[L];
               v2 = A[R];
           }

           if(sum > 0)
               R--;
           else
               L++;

        }

        sb.append(v1).append(" ").append(v2);
        System.out.println(sb);


    }
    public static void main(String[] args){
        input();
        proCalc();
    }
}
