import java.util.Scanner;
/*

N 개중 M개 선택, 중복 선택 불가능 by Will
Boj 15649
 */

public class NM02_15649 {

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
            for (int sel = 1; sel <= N; sel++) {
                if (used[sel] == 1) continue;

                selected[k] = sel;   used[sel] = 1;
                recurCalc(k + 1);
                selected[k] = 0;     used[sel] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();

        recurCalc(1);

        System.out.println(sb.toString());

    }
}
