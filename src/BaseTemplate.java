import java.util.Scanner;

public class BaseTemplate {

    static int N, M; // Array Size
    static int[] A, B; // Array Object;
    static Scanner sc = new Scanner(System.in);
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N + 1];
        B = new int[M + 1];

        for(int i = 1; i <= N; i++) A[i] = sc.nextInt();
        for(int i = 1; i <= M; i++) B[i] = sc.nextInt();

    }

    static void procCalc(){

    }
}
