import java.util.Arrays;
import java.util.Scanner;

/*
좋다. boj 1253
 */
public class TP03_1253 {

    static int N;
    static int[] A;

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static void input(){
        N = sc.nextInt();
        A = new int[N + 1];
        for(int i = 1; i <= N; i++) A[i] = sc.nextInt();
    }

    static boolean decision(int target_idx){
        int L = 1, R = N ;
        int target = A[target_idx];
        while (L < R){
            if(L == target_idx) L++;
            else if(R == target_idx) R--;
            else {
                if (A[L] + A[R] > target) R--;
                else if (A[L] + A[R] == target) return true;
                else L++;
            }
        }
        return  false;
     }

    static void proCalc(){
        Arrays.sort(A, 1, N + 1);
        int ans = 0;

        for(int i = 1; i <= N; i++){
            if(decision(i)){
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args){
        input();
        proCalc();
    }

}
