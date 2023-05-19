import java.util.Scanner;

/*

오르막 수
 */
public class DP04_11057 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N; // 입력 수 길이
    static int[][]Dy; // 다이나믹 배열- 숫자 길이와 , 0 ~9 까지 사용한 수


    static void input(){
        N = sc.nextInt();
        Dy = new int[N + 1][10]; //
    }

    static void proc(){

        // 수작업 계산으로 초기값 설정
        for(int num = 0 ; num <= 9 ; num++){
            Dy[1][num] = 1; //
        }

        // 길이 2 ~ N , 길이별 오르막 수 계산
        for(int len = 2; len <= N; len++){
            for(int num = 0; num <= 9 ; num++){
                // Dy[len][num] 을 채운다.
                for(int prev = 0; prev <= num ; prev++){
                    // 직전 오르막 수을 다 더하면 현재 오르막 수.
                    Dy[len][num] += Dy[len - 1][prev];
                    Dy[len][num] %= 10007; // 지금 나누어서 저장해야 overflow 나지 않는다.
                }
            }
        }

        int ans = 0;
        for(int num = 0 ; num <= 9; num++){
            ans += Dy[N][num]; // N 번째 오르막 수 , 사용한 숫자별로 다 더한다.
            ans %= 10007;
        }

        System.out.println(ans);
    }

    public static void main(String[] args){
        input();
        proc();
    }
}
