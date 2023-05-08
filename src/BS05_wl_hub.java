import java.util.Arrays;
import java.util.Scanner;

/*
공유기 설치
 */
public class BS05_wl_hub {
    static int N , C;
    static int[] A;

    static Scanner sc = new Scanner(System.in);

    static StringBuilder sb = new StringBuilder();

    static void input(){
        N = sc.nextInt();
        C = sc.nextInt();
        A = new int[N + 1];
        for(int i = 1; i <= N; i++) A[i] = sc.nextInt();

    }

    static boolean decision(int D){

        int cnt = 1, last = A[1];
        for(int i = 1; i <= N; i++){
            if(A[i] - last < D) continue;
            last = A[i];
            cnt++;
        }

        return cnt >= C;

    }
    static void proCalc(){
        Arrays.sort(A, 1, N + 1);

        int L = 1, R = 1000000000, ans = 0; // 주택 좌표.

        while(L <= R) {
            int mid = (L + R) / 2;
            if(decision(mid)){
                ans  = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        System.out.println(ans);

    }



    public static void main(String[] args){
        input();
        proCalc();

    }

}
