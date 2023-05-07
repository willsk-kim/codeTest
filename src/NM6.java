import java.util.Scanner;

public class NM6 {

    static int N, ans;
    static int[] cols;

    static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // N * N check layout 1<= N < 15; max : 14 * 14
        cols = new int [N + 1];

    }

    static boolean attackable(int r1, int c1, int r2, int c2) {
        if(c1 == c2) return true;
        if(r1 - c1 == r2 - c2) return true; // reverse cross
        if(r1 + c1 == r2 + c2) return true; // cross
        return  false;
    }
    static void recurCalc(int row){
        if(row == N + 1){
            ans++;
        } else {
            for(int c = 1; c <= N; c++ ){
                boolean possible = true;

                for(int i=1; i <= row -1;i++){
                    // i, cols[i]
                    if(attackable(row, c, i, cols[i])){
                        possible = false;
                        break;
                    }
                }
                if(possible){
                    cols[row] = c;
                    recurCalc(row + 1);
                    cols[row] = 0;
                }
            }
        }

    }
    public static void main(String[] args){
        input();
        recurCalc(1);

        System.out.println(ans);

    }
}
