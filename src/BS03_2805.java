import java.util.Scanner;

/*
 나무 자르기
 */
public class BS03_2805 {

    static int N ; // N :나무 수 = 1 <= N <= 1,000,000, H: 나무 길이 = 1 <= M <= 2,000,000,000
    static int M;  // 잘린 나무 길이
    static int[] T;

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static void input(){
        N = sc.nextInt(); // 나무 숫
        M = sc.nextInt();  //
        T = new int[N + 1];
        for(int i = 1; i <= N; i++) T[i] = sc.nextInt();

    }
    static void proCalc(){
        int L = 0, R= 2000000000, ans = 0;
        while(L <= R){
            int mid = (int)((L + R) / 2);
            if(decision(mid)){
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean decision(int H) {
        long sum = 0 ; // 잘린 나무길이 총 합은 int 범위를 넘어간다. 10^15(N * H)
        for (int i = 1; i <= N; i++ ){
            if(T[i] > H){
                sum+= (T[i] - H);
            }
        }

        return sum >= M;

    }

    public static void main(String[] args){
        input();
        proCalc();
    }

}
