import java.util.ArrayList;
import java.util.Scanner;

/*
단말 노트의 개수를 세는 법
 */
public class TREE02_1068 {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, root, removed; // 노드 수, 루트, 삭제 노드
    static ArrayList<Integer>[] child;
    static int[] leaf;


    static void input(){
        N = sc.nextInt();
        child = new ArrayList[N];
        leaf = new int[N];
        for(int i = 0; i < N; i++) child[i] = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int par = sc.nextInt();
            if(par == -1){
                root = i;
                continue;
            }
            child[par].add(i);
        }
        removed = sc.nextInt();
    }

    static void dfs(int x, int par){
        if(child[x].isEmpty()){
            leaf[x]++;
        }
        for(int y: child[x]){
            if(y == par) continue;
            dfs(y, x);
            leaf[x] += leaf[y];
        }
    }
    static void proc(){
        for(int i = 0; i < N; i++){
            if(child[i].contains(removed)){
                child[i].remove(child[i].indexOf(removed));
            }
        }

        if(root != removed) dfs(root, -1);

        System.out.println(leaf[root]);
    }
    public static void main(String[] args){
        input();

        proc();
    }
}
