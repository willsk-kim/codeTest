import java.util.Scanner;

/*
 BS cutting lanCable
 */
public class BS04_1654 {
    static int K , N;
    static int[] A;

    static Scanner sc = new Scanner(System.in);


    static void input(){
        K = sc.nextInt();
        N = sc.nextInt();
        A = new int[K + 1];
        for(int i = 1; i <= K; i++) A[i] = sc.nextInt();

    }

    static void proCalc(){
        long L = 1, R = Integer.MAX_VALUE, ans = 0;

        while(L <= R){
            long mid = (long)((L + R) / 2);
            if(decision(mid)){
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean decision(long len) {
        long sum = 0;

        for(int i = 1; i <= K; i++){
            sum += A[i] / len;
        }

        return sum >= N;
    }

    public static void main(String[] args){
        input();
        proCalc();
    }

}
