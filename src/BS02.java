import java.util.Arrays;
import java.util.Scanner;

/*
 이분 탐색 2 - 두 용액 합치기
 */
public class BS02 {

    static int N;
    static int[] A;
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static void input(){
        N = sc.nextInt();
        A = new int[N + 1];
        for(int i = 1; i <= N; i++) A[i] = sc.nextInt();
    }

    static int lowBound(int[] A, int L, int R, int X){
        //A[L..,R] 에서 X 이상의 수 중 제일 왼쪽 인덱스를 return 하는 함수
        // 그런게 없다면 R + 1 을 return
        int res = R + 1;
        while(L <= R){
            int mid = (L + R) / 2;
            if(A[mid] >= X){
                res = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return res;
    }
    static void proCalc() {
        Arrays.sort(A, 1, N + 1);
        int bestSum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;
        for(int left = 1; left <= N - 1; left++){
            int res = lowBound(A,left + 1, N, -A[left]); // 이분 탐색 x 이상의 원소중 가장 왼쪽

//            if(left < res -1 && Math.abs(A[left] + A[res -1]) < bestSum){
//                bestSum = Math.abs(A[left] + A[res - 1]);
//                v1 = A[left];
//                v2 = A[res - 1];
//            }
//            if(res <= N && Math.abs(A[left] + A[res]) < bestSum){
//                bestSum = Math.abs(A[left] + A[res]);
//                v1 = A[left];
//                v2 = A[res];
//            }

            if(left + 1 <= res -1 && res - 1 <= N && Math.abs(A[left] + A[res - 1]) < bestSum){
                bestSum = Math.abs(A[left] + A[res - 1]);
                v1 = A[left];
                v2 = A[res - 1];
            }
            if(left + 1 <= res && res <= N && Math.abs(A[left] + A[res]) < bestSum){
                bestSum = Math.abs(A[left] + A[res]);
                v1 = A[left];
                v2 = A[res];
            }

        }
        sb.append(v1).append(" ").append(v2);
        System.out.println(sb);


    }
    public static void main(String[] args){
        input();
        proCalc();
    }

}
