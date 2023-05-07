import java.util.Arrays;
import java.util.Scanner;

/*
 최빈 수 구하기
 */
public class Sort03 {

    static int N;
    static long[] a;

    static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a = new long[N + 1];
        for(int i = 1; i <= N; i++) a[i] = sc.nextLong();
    }
    static void output(){
        Arrays.sort(a, 1, N + 1);
        long mode = a[1];
        int modeCnt = 1, currCnt = 1;

        for(int i = 2; i <= N; i++){
            if(a[i] == a[i-1]){
                currCnt++;
            } else {
                currCnt = 1;
            }

            if(currCnt > modeCnt ){
                modeCnt = currCnt;
                mode = a[i];
            }
        }
        System.out.println(mode);
    }

    public static void main(String[] args){
        input();
        output();
    }
}
