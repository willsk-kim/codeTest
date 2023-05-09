/*

N개중 M개 선택, 중복 선택 가능 by Will
Boj 15651

 */
import java.util.Scanner;

public class NM01_15651 {

    static int N,M;
    static int [] selected;

    static StringBuilder sb = new StringBuilder();

    static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        selected = new int[M + 1];
//        System.out.println("N: "+N +", M:" + M);
    }
    // N: 3, M:2
    static void recurCalc(int k){
        if(k == M+1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
//                System.out.println(selected[i]);
            }
//            System.out.println(sb.toString());
            sb.append('\n');
        } else {
            for(int sel=1; sel <= N; sel ++){
                selected[k] = sel;
                recurCalc(k +1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args){
        input();

        recurCalc(1);

        System.out.println(sb.toString());

    }




}
