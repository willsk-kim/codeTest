import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
화살표 그리기
 */
public class Sort04 {

    static int N;
    static ArrayList<Integer>[] a;

    static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a = new ArrayList[N + 1];
        for(int color = 1; color <= N ; color++){
            a[color] = new ArrayList<Integer>();
        }
        for(int i = 1; i <= N ; i++){
            int coord, color;
            coord = sc.nextInt();
            color = sc.nextInt();
            a[color].add(coord);
        }
    }
    static int toLeft(int color, int idx){
        if(idx == 0){
            return Integer.MAX_VALUE;
        }
        return a[color].get(idx) - a[color].get(idx -1);
    }

    static int toRight(int color, int idx){
        if(idx + 1 == a[color].size()){
            return Integer.MAX_VALUE;
        }

        return a[color].get(idx + 1) - a[color].get(idx);
    }

    static void output(){
        for(int color = 1; color <= N ; color++){
            Collections.sort(a[color]);
        }

        int ans = 0;
        for(int color = 1; color <= N; color++){
            for(int i = 0 ; i < a[color].size(); i++){
                int leftDistance = toLeft(color, i);
                int rightDistance = toRight(color, i);
                ans += Math.min(leftDistance, rightDistance);
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args){
        input();
        output();
    }


}
