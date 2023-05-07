/*

N 개중 M개 선택, 중복 선택 불가능 by Will

 */
import java.util.Scanner;

public class Main {

    static int N,M;
    static int [] selected, used;

    static StringBuilder sb = new StringBuilder();

    static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        selected = new int[M + 1];

    }

    static void recurCalc(int k){
        if(k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append('\n');
        } else {
            for(int sel=1; sel <= N; sel ++){
                if(used[sel] == 1) continue;

                selected[k] = sel; used[sel] = 1;
                recurCalc(k +1);
                selected[k] = 0; used[sel] = 0;
            }
        }
    }

    public static void main(String[] args){
        input();

        recurCalc(1);

        System.out.println(sb.toString());

    }




}
