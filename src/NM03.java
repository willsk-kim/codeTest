/*

 */

import java.util.Scanner;

public class NM03 {

    static int N, M;
    static int[] selected, used;

    static StringBuilder sb = new StringBuilder();

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        selected = new int[M + 1];
        used = new int[N+1];

    }

    // N: 3, M:2
    static void recurCalc(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append('\n');
        } else {
            int start = selected[k -1];
            if (start ==0) start = 1;
            for (int sel = start; sel <= N; sel++) {
                selected[k] = sel;
                recurCalc(k + 1);
                selected[k] = 0;

            }
        }
    }

    public static void main(String[] args) {
        input();

        recurCalc(1);

        System.out.println(sb.toString());

    }
}
