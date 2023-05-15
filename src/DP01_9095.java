import java.util.Scanner;

/*

Dynamic programming 1,2,3 더하기
 */
public class DP01_9095 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int n;

    static int[] Dy;

    static void input(){
        int n = sc.nextInt();


    }

    static void preproc(){
        Dy = new int[15];
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 4;

        for(int i = 4; i <= 11; i++){
            Dy[i] = Dy[i - 1] + Dy[i - 2] + Dy[i - 3];
        }
    }

    static void proc() {
        int T = sc.nextInt();
        for(int tt = 1; tt <= T ; tt++){
            int N = sc.nextInt();
            sb.append(Dy[N]).append('\n');
        }
        System.out.println(sb);
    }


    public static void main(String[] args){
        preproc();;

        proc();

    }
}
