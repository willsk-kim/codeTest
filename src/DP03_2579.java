import java.util.Scanner;

/*
계단 오르기
 */
public class DP03_2579 {
    static Scanner sc =new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] Dy;
    static int[] A;

    static void input(){
        N = sc.nextInt();
        A = new int[N + 1];
        Dy = new int[N + 1][2]; // 다이나믹 테이블 초기화
        for (int i = 1; i <= N; i++){
            A[i] = sc.nextInt();
        }
    }
    static void proc() {
        Dy[1][0] = 0; // i -1 을 빫지 않고 i 까지 점수 합께
        Dy[1][1] = A[1]; //  i -1 을 밟고 i 까지 점수 합계.


        // 수작업으로 계산한 값으로  초기값 설정
        if(N >= 2){
            Dy[2][0] = A[2];
            Dy[2][1] = A[1] + A[2];
        }

        // 점화식으로 Dy 배열 채우기
        for(int i = 3 ; i <= N ; i++){
            Dy[i][0] = Math.max(Dy[i - 2][0] + A[i], Dy[i - 2][1] + A[i]); // i - 2 일때, i - 1을 밟는 경우, 밟지 않는 경우 중 최대값 선택
            Dy[i][1] = Dy[i - 1][0] + A[i]; //  i - 1 인 경우 다시 Dy[i - 1][1] 은 연속 3개의 계산이므로 규칙 위반.
        }

        System.out.println(Math.max(Dy[N][0], Dy[N][1]));
    }
    public static void main(String[] args){
        input();

        proc();

    }

}
