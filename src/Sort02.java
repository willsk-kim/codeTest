import java.util.Arrays;
import java.util.Scanner;

/*
수열 정렬
 */
public class Sort02 {

    static int N;   // 배열의 길이
    static int[] P;  // A에 적용할 배열, P의 원소의 값이 B의 인덱스
    static Elem[] B;  // 비 내림 차순으로 정렬된 A의 배열

    static class Elem implements Comparable<Elem> {
        int num, idx; // num : A 원소 값, idx : A index

        @Override
        public int compareTo(Elem other) {
            //java object 은 tim 정렬이라 stable 성격을 갖는다.
            // 따라서 값이 같은 경우 이미 정렬되어 있으므로, 다시 정렬 할 필요가 없다.
            return num - other.num; // 내가 뒤에 있으면 내림 차순.
        }
    }

    static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        P = new int[N];
        B = new Elem[N];

        for(int i=0; i< N; i++){
            B[i] = new Elem();
            B[i].num = sc.nextInt();
            B[i].idx = i;
        }
    }
    static void pro(){
        Arrays.sort(B);
        for(int b_idx = 0 ; b_idx < N; b_idx++){
            P[B[b_idx].idx] = b_idx;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(P[i]).append(" ");
        }

        System.out.println(sb.toString());

    }

    public static void main(String[] args){
        input();
        pro();
    }

}
