import java.util.Arrays;
import java.util.Scanner;

/*
 이분 탐색(Binary Search)
 */
public class BS01 {


    static int T; // Test Case Count;
    static int N, M;// 배열 갯수

    static int[] A, B;

    static Scanner sc = new Scanner(System.in);
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N + 1];
        B = new int[M + 1];
        for(int i = 1; i <= N; i++) A[i] = sc.nextInt();
        for(int i = 1; i <= M ;i++) B[i] = sc.nextInt();
    }

    static int lowerBound(int[] A, int L, int R, int X){
        int res = L - 1;
        while (L <= R){
            int mid = (L + R) / 2;  // 이분 탐색으로 시간을 줄인다.
            if(A[mid] < X){
                res = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return  res;
    }
    static void prosCalc(){
        Arrays.sort(B, 1, M + 1);

        int ans = 0;
        for(int i = 1; i <= N; i++){
            ans+= lowerBound(B, 1, M, A[i]);
        }

        System.out.println(ans);
    }
    public static void main(String[] args){
        T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            input();
            prosCalc();
        }
    }
}
