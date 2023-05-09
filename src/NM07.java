import java.util.Scanner;

public class NM07 {

    static int N, S, ans;
    static int[] nums;

    static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        nums = new int[N + 1];

        for(int i=1;i <=N; i++) nums[i] = sc.nextInt();
    }

    static void recurCalc(int k, int value){
        System.out.println("k:" + k +", num["+ k+"], value :" + value );
        if(k == N + 1){
          if(S == value)  ans++;

         System.out.println("ans : " + ans);
        } else {

            recurCalc(k + 1, value + nums[k]);

            recurCalc(k + 1, value);

        }
    }
    public static void main(String[] args){
        input();
        recurCalc(1, 0);
        if(S == 0){
            ans--;
        }

        System.out.println(ans);
    }
}
