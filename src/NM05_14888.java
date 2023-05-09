
import java.util.Scanner;


/*
 연산자 끼워 넣기
 Boj 14888
 */
public class NM05_14888 {

    static int N , max, min; // N 개의 숫자
    static int[] nums, operators; // 연산자는 N-1 개

    static StringBuilder sb = new StringBuilder();

    static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N + 1];
        operators = new int [5];
        for (int i =1; i<= N; i++) nums[i] = sc.nextInt();
        for (int i =1; i<= 4; i++) operators[i] = sc.nextInt();

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    static int calculator(int operand1, int operator, int operand2){
        if(operator == 1){// plus
            return operand1 + operand2;
        } else if(operator == 2) { // minus //
            return operand1 - operand2;
        } else if(operator == 3) { // mutiple
            return operand1 * operand2;
        } else { //divide
            return operand1 / operand2;
        }
    }

    static void recurCalc(int k, int value){
        if(k == N){
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int cand = 1; cand <= 4; cand++){
                if(operators[cand] >=  1) {
                    operators[cand]--;
                    recurCalc(k + 1, calculator(value, cand, nums[k + 1]));
                    operators[cand]++;
                }
            }
        }

    }

    public static void main(String[] args){
        input();
        recurCalc(1, nums[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }



}

