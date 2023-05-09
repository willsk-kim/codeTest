import java.util.Scanner;

/*
boj cat
 */
public class TP05_16472 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, kind;
    static String A;

    static int[] cnt;

    static void input() {
        N = sc.nextInt();
        A = sc.nextLine(); // 1 <= len(A) <= 100,000
        cnt = new int[26];
    }

    static void add(char x){
        cnt[x - 'a']++;
        if(cnt[x - 'a'] == 1){
            kind++;
        }
    }

    static void erase(char x) {
        cnt[x - 'a']--;
        if(cnt[x - 'a'] == 0){
            kind--;
        }
    }

    static void proCalc(){
        int len = A.length(), ans = 0;
        for(int L = 0, R = 0; R < len; R++){
            add(A.charAt(R));

            while(kind > N){
                erase(A.charAt(L++));
            }

            ans = Math.max(ans, R - L + 1);
        }

        System.out.println(ans);
    }

}
